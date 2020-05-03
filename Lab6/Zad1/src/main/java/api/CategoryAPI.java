package api;

import model.Category;

import java.util.List;

public interface CategoryAPI {
    List<Category> getAllCategories();
    void addCategory(Category category);
    void deleteCategory(int id);
    void updateCategory(int id, Category category);
    Category findCategory(int id);
}
