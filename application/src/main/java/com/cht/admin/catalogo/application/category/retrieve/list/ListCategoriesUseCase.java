package com.cht.admin.catalogo.application.category.retrieve.list;

import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.domain.category.CategorySearchQuery;
import com.cht.admin.catalogo.domain.pagination.Pagination;

public abstract class ListCategoriesUseCase extends UseCase<CategorySearchQuery, Pagination<CategoryListOutput>> {
}
