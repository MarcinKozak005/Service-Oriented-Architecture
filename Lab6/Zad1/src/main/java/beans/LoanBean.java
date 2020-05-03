package beans;

import api.LoanAPI;
import api.ReaderAPI;
import api.SpecimenAPI;
import database.InvalidDateOrderException;
import lombok.Getter;
import lombok.Setter;
import model.Loan;
import model.Reader;
import model.Specimen;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "LoanBean")
@ViewScoped
@Getter
@Setter
public class LoanBean {

    @EJB
    LoanAPI loanAPI;
    @EJB
    SpecimenAPI specimenAPI;
    @EJB
    ReaderAPI readerAPI;

    int loanId;
    int specimenId;
    int readerId;
    Date startDate;
    Date endDate;

    List<Loan> filteredValues;

    public List<Loan> getAllLoans(){ return loanAPI.getAllLoans();}

    public List<Loan> getLoansForReader(){
        Reader reader = (Reader) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userObj");
        return loanAPI.getLoansForReader(reader);
    }

    public void returnBook(Loan loan) throws InvalidDateOrderException {
        loan.setLoan_end_date(new Date());
        loanAPI.updateLoan(loan.getLoan_id(),loan);

        Specimen specimen = loan.getLoan_specimen();
        specimen.setFree(true);
        specimenAPI.updateSpecimen(specimen.getSpecimen_id(), specimen);
    }

    public void addLoan()
    {
        Specimen specimen = specimenAPI.getSpecimen(this.specimenId);
        if(specimen.isFree()) {
            Loan loan = new Loan();
            loan.setLoan_reader(readerAPI.getReader(this.readerId));
            loan.setLoan_specimen(specimen);
            loan.setLoan_start_date(this.startDate);
            loan.setLoan_end_date(this.endDate);
            loanAPI.addLoan(loan);
            if (endDate == null) {
                specimen.setFree(false);
                specimenAPI.updateSpecimen(specimen.getSpecimen_id(), specimen);
            }
        }
    }

    public void deleteLoan()
    {
        loanAPI.deleteLoan(this.loanId);
    }
    public void updateLoan()
    {
        Loan loan = new Loan();
        // nulls are checked before updating in DB
        loan.setLoan_reader(readerAPI.getReader(this.readerId));
        loan.setLoan_specimen(specimenAPI.getSpecimen(this.specimenId));
        loan.setLoan_start_date(this.startDate);
        loan.setLoan_end_date(this.endDate);
        try {
            loanAPI.updateLoan(loanId, loan);
        } catch (InvalidDateOrderException e) {
            FacesContext.getCurrentInstance().addMessage("updateForm:idUpdate", new FacesMessage("Date Error occurred"));
        }
    }
}
