package com.cht.admin.catalogo.infrastructure.api.controllers;

import com.cht.admin.catalogo.application.category.create.CreateCategoryCommand;
import com.cht.admin.catalogo.application.category.create.CreateCategoryOutput;
import com.cht.admin.catalogo.application.category.create.CreateCategoryUseCase;
import com.cht.admin.catalogo.application.category.delete.DeleteCategoryUseCase;
import com.cht.admin.catalogo.application.category.retrieve.get.GetCategoryByIdUseCase;
import com.cht.admin.catalogo.application.category.retrieve.list.ListCategoriesUseCase;
import com.cht.admin.catalogo.application.category.update.UpdateCategoryCommand;
import com.cht.admin.catalogo.application.category.update.UpdateCategoryOutput;
import com.cht.admin.catalogo.application.category.update.UpdateCategoryUseCase;
import com.cht.admin.catalogo.domain.pagination.SearchQuery;
import com.cht.admin.catalogo.domain.pagination.Pagination;
import com.cht.admin.catalogo.domain.validation.handler.Notification;
import com.cht.admin.catalogo.infrastructure.api.CategoryAPI;
import com.cht.admin.catalogo.infrastructure.category.models.CategoryListResponse;
import com.cht.admin.catalogo.infrastructure.category.models.CategoryResponse;
import com.cht.admin.catalogo.infrastructure.category.models.CreateCategoryRequest;
import com.cht.admin.catalogo.infrastructure.category.models.UpdateCategoryRequest;
import com.cht.admin.catalogo.infrastructure.category.presenters.CategoryApiPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Objects;
import java.util.function.Function;

@RestController
public class CategoryController implements CategoryAPI {

    private final CreateCategoryUseCase createCategoryUseCase;
    private final GetCategoryByIdUseCase getCategoryByIdUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;

    private final ListCategoriesUseCase listCategoriesUseCase;

    public CategoryController(
            CreateCategoryUseCase createCategoryUseCase,
            GetCategoryByIdUseCase getCategoryByIdUseCase,
            UpdateCategoryUseCase updateCategoryUseCase, DeleteCategoryUseCase deleteCategoryUseCase, ListCategoriesUseCase listCategoriesUseCase) {
        this.createCategoryUseCase = Objects.requireNonNull(createCategoryUseCase);
        this.getCategoryByIdUseCase = Objects.requireNonNull(getCategoryByIdUseCase);
        this.updateCategoryUseCase = Objects.requireNonNull(updateCategoryUseCase);
        this.deleteCategoryUseCase = Objects.requireNonNull(deleteCategoryUseCase);
        this.listCategoriesUseCase = Objects.requireNonNull(listCategoriesUseCase);
    }

    @Override
    public ResponseEntity<?> createCategory(final CreateCategoryRequest input) {
        final var aCommand = CreateCategoryCommand.with(
                input.name(),
                input.description(),
                input.active() != null ? input.active(): true
        );
        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<CreateCategoryOutput, ResponseEntity<?>> onSuccess = output ->
                ResponseEntity.created(URI.create("/categories/" + output.id())).body(output);

        return this.createCategoryUseCase.execute(aCommand)
                .fold(onError,onSuccess);
    }

    @Override
    public CategoryResponse getById(String id) {
        return CategoryApiPresenter.present(getCategoryByIdUseCase.execute(id));
    }

    @Override
    public Pagination<CategoryListResponse> listCategories(String search, int page, int perPage, String sort, String direction) {
        return this.listCategoriesUseCase.execute(new SearchQuery(page, perPage, search, sort, direction))
                .map(CategoryApiPresenter::present);
    }

    @Override
    public ResponseEntity<?> updateById(String id, UpdateCategoryRequest input) {
        final var aCommand = UpdateCategoryCommand.with(
                id,
                input.name(),
                input.description(),
                input.active()
                );

        final Function<Notification, ResponseEntity<?>> onError = notification ->
                ResponseEntity.unprocessableEntity().body(notification);

        final Function<UpdateCategoryOutput, ResponseEntity<?>> onSuccess =
                ResponseEntity::ok;

        return this.updateCategoryUseCase.execute(aCommand)
                .fold(onError,onSuccess);
    }


    @Override
    public void deleteById(String id) {
        this.deleteCategoryUseCase.execute(id);
    }
}
