package beans;

import api.CategoryAPI;
import lombok.Getter;
import lombok.Setter;
import model.Category;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "CategoryBean")
@ViewScoped
@Getter
@Setter
public class CategoryBean {

    @EJB
    CategoryAPI categoryAPI;

    int id;
    String name;

    List<Category> filteredValues;

    public List<Category> getAllCategories(){ return categoryAPI.getAllCategories();}
    public void addCategory()
    {
//        System.out.println("COJ JEST nIE TAs");
        Category category = new Category();
        category.setCategory_name(this.name);
        categoryAPI.addCategory(category);
    }
    public void deleteCategory()
    {
        categoryAPI.deleteCategory(this.id);
    }
    public void updateCategory()
    {
        Category category = new Category();
        category.setCategory_name(this.name);
        categoryAPI.updateCategory(id, category);
    }
    
}
