package database;

import api.CategoryAPI;
import model.Category;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@Local(CategoryAPI.class)
public class CategoryDB implements CategoryAPI {
    @PersistenceContext(name = "PersistenceName1")
    EntityManager em;

    public List<Category> getAllCategories() {
        TypedQuery<Category> categoryQuery = (TypedQuery<Category>) em.createNamedQuery("CategoryGetAllCategories");
        return categoryQuery.getResultList();
    }

    public void addCategory(Category category) {
        try {
            em.persist(category);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Add Category: " + e);
        }
    }

    public void deleteCategory(int id) {
        try {
            Category category = em.find(Category.class,id);
            em.remove(category);
        }
        catch(Exception e) {
            System.err.println("EXCEPTION Delete Category: " + e);
        }
    }

    public void updateCategory(int id, Category category) {
        try
        {
            Category categoryFromDB = em.find(Category.class,id);
            if(!category.getCategory_name().equals("")) categoryFromDB.setCategory_name(category.getCategory_name());
            em.persist(categoryFromDB);
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Category: " + e);
        }
    }

    public Category findCategory(int id) {
        try
        {
            Category categoryFromDB = em.find(Category.class,id);
            return categoryFromDB;
        }
        catch (Exception e)
        {
            System.err.println("EXCEPTION Update Category: " + e);
        }
        return null;
    }
}
