package database;

import api.LoanAPI;
import model.Loan;
import model.Reader;
import org.hibernate.HibernateException;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
@Local(LoanAPI.class)
public class LoanDB implements LoanAPI {

    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;


    public List<Loan> getAllLoans() {
        TypedQuery<Loan> typedQuery = (TypedQuery<Loan>) em.createNamedQuery("LoanGetAllLoans");
        return typedQuery.getResultList();
    }

    public void addLoan(Loan loan) {
        try {
            em.persist(loan);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Add Loan: " + e);
        }
    }

    public void deleteLoan(int id) {
        try {
            Loan loan = em.find(Loan.class,id);
            em.remove(loan);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Delete Loan: " + e);
        }
    }

    public void updateLoan(int id, Loan loan) throws InvalidDateOrderException{
        try
        {
            Loan loanFromDB = em.find(Loan.class,id);
            if(loan.getLoan_reader()!=null) loanFromDB.setLoan_reader(loan.getLoan_reader());
            if(loan.getLoan_specimen()!=null) loanFromDB.setLoan_specimen(loan.getLoan_specimen());

            if(loan.getLoan_start_date()!=null && loan.getLoan_end_date()!=null)
            {
                loanFromDB.setLoan_start_date(loan.getLoan_start_date());
                loanFromDB.setLoan_end_date(loan.getLoan_end_date());
            }
            else if(loan.getLoan_start_date()!=null && loan.getLoan_start_date().before(loanFromDB.getLoan_end_date()))
                loanFromDB.setLoan_start_date(loan.getLoan_start_date());
            else if(loan.getLoan_end_date()!=null && loan.getLoan_end_date().after(loanFromDB.getLoan_start_date()))
                loanFromDB.setLoan_end_date(loan.getLoan_end_date());
            else
                throw new InvalidDateOrderException();
            em.persist(loanFromDB);
        }
        catch (HibernateException e)
        {
            System.err.println("EXCEPTION Update Loan: " + e);
        }
    }

    public List<Loan> getLoansForReader(Reader reader) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Loan> criteriaQuery = criteriaBuilder.createQuery(Loan.class);

        Root<Loan> loanRoot = criteriaQuery.from(Loan.class);
        Join<Loan,Reader> readerJoin = loanRoot.join("loan_reader");

        criteriaQuery.select(loanRoot)
                .where(criteriaBuilder.and(
                        criteriaBuilder.equal(readerJoin.get("reader_name"),reader.getReader_name()),
                        criteriaBuilder.equal(readerJoin.get("reader_surname"),reader.getReader_surname()),
                        criteriaBuilder.isNull(loanRoot.get("loan_end_date"))));

        TypedQuery<Loan> typedQuery = em.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}