package com.cht.admin.catalogo.application.category.create;

import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class CreateCategoryUseCase
        extends UseCase<CreateCategoryCommand, Either<Notification, CreateCategoryOutput>> {
}
