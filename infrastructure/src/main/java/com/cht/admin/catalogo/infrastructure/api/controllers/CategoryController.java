package com.cht.admin.catalogo.infrastructure.api.controllers;

import com.cht.admin.catalogo.infrastructure.api.CategoryAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryAPI {

    @Override
    public ResponseEntity<?> createCategory(CreateCategoryRequest input) {
        return null;
    }

    @Override
    public Pagination<CategoryListResponse> listCategories(String search, int page, int perPage, String sort, String direction) {
        return null;
    }

    @Override
    public CategoryResponse getById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateById(String id, UpdateCategoryRequest input) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
