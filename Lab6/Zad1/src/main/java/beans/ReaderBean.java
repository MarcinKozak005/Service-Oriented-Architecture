package beans;

import api.ReaderAPI;
import lombok.Getter;
import lombok.Setter;
import model.Reader;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "ReaderBean")
@ViewScoped
@Getter
@Setter
public class ReaderBean implements Serializable
{
    String name;
    String surname;

    List<Reader> filteredValues;

    int id;

    @EJB
    ReaderAPI readerAPI;

    public List<Reader> getFilteredValues() {
        return filteredValues;
    }

    public void setFilteredValues(List<Reader> filteredValues) {
        this.filteredValues = filteredValues;
    }

    public List<Reader> getAllReaders(){ return readerAPI.getAllReaders();}
    public void addReader()
    {
        Reader reader = new Reader();
        reader.setReader_name(this.name);
        reader.setReader_surname(this.surname);
        readerAPI.addReader(reader);
    }
    public void deleteReader()
    {
        readerAPI.deleteReader(this.id);
    }
    public void updateReader()
    {
        Reader reader = new Reader();
        // nulls are checked before updating in DB
        reader.setReader_name(this.name);
        reader.setReader_surname(this.surname);
        readerAPI.updateReader(id, reader);
    }
}
