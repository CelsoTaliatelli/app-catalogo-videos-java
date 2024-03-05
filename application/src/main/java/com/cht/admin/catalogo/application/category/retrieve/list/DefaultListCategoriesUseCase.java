package com.cht.admin.catalogo.application.category.retrieve.list;

import com.cht.admin.catalogo.domain.category.CategoryGateway;
import com.cht.admin.catalogo.domain.pagination.Pagination;
import com.cht.admin.catalogo.domain.category.CategorySearchQuery;

import java.util.Objects;

public class DefaultListCategoriesUseCase extends ListCategoriesUseCase{

    private final CategoryGateway categoryGateway;

    public DefaultListCategoriesUseCase(CategoryGateway categoryGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
    }

    @Override
    public Pagination<CategoryListOutput> execute(CategorySearchQuery aQuery) {
        return this.categoryGateway.findAll(aQuery)
                .map(CategoryListOutput::from);
    }
}
