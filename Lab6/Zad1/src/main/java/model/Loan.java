package model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Loader;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
// Soft delete annotations
@SQLDelete(sql ="UPDATE loan SET deleted = true WHERE loan_id = ?")
@Loader(namedQuery = "findByIdLoan")
@NamedQueries({
        @NamedQuery(name = "findByIdLoan", query = "SELECT l FROM Loan l WHERE l.loan_id = ?1 AND l.deleted = false"),
        @NamedQuery(name = "LoanGetAllLoans", query = "SELECT l FROM Loan l ORDER BY l.loan_start_date")
})
@Where(clause = "deleted = false")
public class Loan {
    @Id
    @GeneratedValue
    private int loan_id;

    @ManyToOne
    private Specimen loan_specimen;

    @ManyToOne
    private Reader loan_reader;

    @Temporal(TemporalType.DATE)
    private Date loan_start_date;

    @Temporal(TemporalType.DATE)
    private Date loan_end_date;

    boolean deleted = false;

}
