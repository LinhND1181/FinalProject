package net.aht.internship.demo.application.service;

import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    Page<Category> getAllCategories(Pageable pageable);

    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category getCategoryByName(String categoryName);

    void addCategory(Category newCategory);

    void updateCategory(Category updatedCategory);

    void deleteCategory(Long categoryId);

    void setCategoryActiveFlag(Long categoryId, boolean activeFlag);

    Page<Category> searchCategories(UserSearchDTO userSearchDTO, Pageable pageable);

}
