package net.aht.internship.demo.application.service.impl;

import lombok.AllArgsConstructor;
import net.aht.internship.demo.application.repository.ICategoryRepository;
import net.aht.internship.demo.application.service.ICategoryService;
import net.aht.internship.demo.domain.dto.UserSearchDTO;
import net.aht.internship.demo.domain.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements ICategoryService {

    private ICategoryRepository categoryRepository;
    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return null;
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return null;
    }

    @Override
    public void addCategory(Category newCategory) {

    }

    @Override
    public void updateCategory(Category updatedCategory) {

    }

    @Override
    public void deleteCategory(Long categoryId) {

    }

    @Override
    public void setCategoryActiveFlag(Long categoryId, boolean activeFlag) {

    }

    @Override
    public Page<Category> searchCategories(UserSearchDTO userSearchDTO, Pageable pageable) {
        return null;
    }
}
