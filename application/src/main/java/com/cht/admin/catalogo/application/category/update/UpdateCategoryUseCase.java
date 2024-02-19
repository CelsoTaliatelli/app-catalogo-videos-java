package com.cht.admin.catalogo.application.category.update;

import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.domain.validation.handler.Notification;
import io.vavr.control.Either;

public abstract class UpdateCategoryUseCase extends UseCase<UpdateCategoryCommand, Either<Notification,UpdateCategoryOutput>> {
}
