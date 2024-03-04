package com.cht.admin.catalogo.infrastructure.category;

import com.cht.admin.catalogo.domain.category.Category;
import com.cht.admin.catalogo.domain.category.CategoryGateway;
import com.cht.admin.catalogo.domain.category.CategoryID;
import com.cht.admin.catalogo.domain.pagination.Pagination;
import com.cht.admin.catalogo.domain.pagination.SearchQuery;
import com.cht.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryMySQLGateway implements CategoryGateway {

    private final CategoryRepository repository;


    public CategoryMySQLGateway(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Category create(Category aCategory) {
        return null;
    }

    @Override
    public void deleteById(CategoryID anId) {

    }

    @Override
    public Optional<Category> findById(CategoryID anId) {
        return Optional.empty();
    }

    @Override
    public Category update(Category aCategory) {
        return null;
    }

    @Override
    public Pagination<Category> findAll(SearchQuery aQuery) {
        return null;
    }

    @Override
    public List<CategoryID> existsByIds(Iterable<CategoryID> ids) {
        return null;
    }
}
