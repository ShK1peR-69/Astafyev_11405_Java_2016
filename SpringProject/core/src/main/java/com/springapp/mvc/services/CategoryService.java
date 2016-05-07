package com.springapp.mvc.services;

import com.springapp.mvc.common.Category;
import com.springapp.mvc.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author Astafyev Igor
 *         11-405
 *         for DZ-labs
 */

@Service
public class CategoryService {

    @Qualifier("category")
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public Category getCategoryByID(long id) {
        return categoryRepository.getCategoryByID(id);
    }
}