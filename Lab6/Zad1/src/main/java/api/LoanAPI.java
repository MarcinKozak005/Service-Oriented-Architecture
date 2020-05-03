package api;

import database.InvalidDateOrderException;
import model.Loan;
import model.Reader;

import java.util.List;

public interface LoanAPI {
    List<Loan> getAllLoans();
    void addLoan(Loan loan);
    void deleteLoan(int id);
    void updateLoan(int id, Loan loan) throws InvalidDateOrderException;
    List<Loan> getLoansForReader(Reader reader);
}
