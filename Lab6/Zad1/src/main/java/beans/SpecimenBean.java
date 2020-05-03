package beans;

import api.BookAPI;
import api.SpecimenAPI;
import lombok.Getter;
import lombok.Setter;
import model.Book;
import model.Specimen;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "SpecimenBean")
@SessionScoped
@Getter
@Setter
public class SpecimenBean {
    
    @EJB
    SpecimenAPI specimenAPI;
    @EJB
    BookAPI bookAPI;
    
    int specimenId;
    int bookId;
    int quantity;
    boolean available = true;

    List<Specimen> filteredValues;

    public List<Specimen> getAllSpecimens(){ return specimenAPI.getAllSpecimens();}
    public void addSpecimen()
    {
        Book book = bookAPI.getBook(this.bookId);
        for (int i=0; i<this.quantity;i++) {
            Specimen specimen = new Specimen();
            specimen.setSpecimen_book(book);
            specimen.setFree(this.available);
            specimenAPI.addSpecimen(specimen);
        }
    }

    public void deleteSpecimen()
    {
        specimenAPI.deleteSpecimen(this.specimenId);
    }
    public void updateSpecimen()
    {
        Specimen specimen = new Specimen();
        // nulls are checked before updating in DB
        specimen.setSpecimen_book(bookAPI.getBook(this.bookId));
        specimen.setFree(this.available);
        specimenAPI.updateSpecimen(specimenId, specimen);
    }
    
}
