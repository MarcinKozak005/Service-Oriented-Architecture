package beans;

import api.LoanAPI;
import api.SpecimenAPI;
import lombok.Getter;
import lombok.Setter;
import model.Loan;
import model.Reader;
import model.Specimen;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "MakeLoanBean")
@Getter
@Setter
@ViewScoped
public class MakeLoanBean {

    @EJB
    SpecimenAPI specimenAPI;

    @EJB
    LoanAPI loanAPI;

    int id;


    public List<Object[]> getSpecimensForLoan()
    {
        return specimenAPI.getSpecimensForLoan();
    }
    public void loanSpecimen(Specimen specimen)
    {
        System.err.println("Adding for sb... Spec: "+specimen.getSpecimen_id());
        Loan loan = new Loan();
        Reader reader = (Reader) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userObj");
        specimen.setFree(false);
        specimenAPI.updateSpecimen(specimen.getSpecimen_id(),specimen);
        loan.setLoan_specimen(specimen);
        loan.setLoan_reader(reader);
        loan.setLoan_start_date(new Date());
        loan.setLoan_end_date(null);
        loanAPI.addLoan(loan);
        System.err.println("Added for:"+reader.getReader_name());
    }
}
