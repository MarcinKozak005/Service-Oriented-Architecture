package beans;

import api.AuthorAPI;
import lombok.Getter;
import lombok.Setter;
import model.Author;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "AuthorBean")
@ViewScoped
@Getter
@Setter
public class AuthorBean {

    @EJB
    AuthorAPI authorAPI;

    int id;
    String name;
    String surname;

    List<Author> filteredValues;

    public List<Author> getAllAuthors(){ return authorAPI.getAllAuthors();}
    public void addAuthor()
    {
        Author author = new Author();
        author.setAuthor_name(this.name);
        author.setAuthor_surname(this.surname);
        authorAPI.addAuthor(author);
    }
    public void deleteAuthor()
    {
        authorAPI.deleteAuthor(this.id);
    }
    public void updateAuthor()
    {
        Author author = new Author();
        author.setAuthor_name(this.name);
        author.setAuthor_surname(this.surname);
        authorAPI.updateAuthor(id, author);
    }
}
