package com.cht.admin.catalogo.application.genre.update;

import com.cht.admin.catalogo.domain.Genre.Genre;
import com.cht.admin.catalogo.domain.Genre.GenreGateway;
import com.cht.admin.catalogo.domain.Genre.GenreID;
import com.cht.admin.catalogo.domain.Identifier;
import com.cht.admin.catalogo.domain.category.CategoryGateway;
import com.cht.admin.catalogo.domain.category.CategoryID;
import com.cht.admin.catalogo.domain.exceptions.DomainException;
import com.cht.admin.catalogo.domain.exceptions.NotFoundException;
import com.cht.admin.catalogo.domain.exceptions.NotificationException;
import com.cht.admin.catalogo.domain.validation.Error;
import com.cht.admin.catalogo.domain.validation.ValidationHandler;
import com.cht.admin.catalogo.domain.validation.handler.Notification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class DefaultUpdateGenreUseCase extends UpdateGenreUseCase {

    private final CategoryGateway categoryGateway;
    private final GenreGateway genreGateway;

    public DefaultUpdateGenreUseCase(CategoryGateway categoryGateway, GenreGateway genreGateway) {
        this.categoryGateway = Objects.requireNonNull(categoryGateway);
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    public UpdateGenreOutput execute(final UpdateGenreCommand aCommand) {
        final var anId = GenreID.from(aCommand.id());
        final var aName = aCommand.name();
        final var isActive = aCommand.isActive();
        final var categories = toCategoryId(aCommand.categories());

        final var aGenre = this.genreGateway.findById(anId)
                .orElseThrow(notFound(anId));

        final var notification = Notification.create();
        notification.append(validateCategories(categories));
        notification.validate(() -> aGenre.update(aName, isActive, categories));

        if (notification.hasError()) {
            throw new NotificationException(
                    "Could not update Aggregate Genre %s".formatted(aCommand.id()), notification
            );
        }

        return UpdateGenreOutput.from(this.genreGateway.update(aGenre));
    }

    private ValidationHandler validateCategories(List<CategoryID> ids){
        final var notification = Notification.create();
        if (ids == null || ids.isEmpty()){
            return notification;
        }

        final var retriviedIds = categoryGateway.existsByIds(ids);

        if(ids.size() != retriviedIds.size()) {
            final var missingIds = new ArrayList<>(ids);
            missingIds.removeAll(retriviedIds);

            final var missingIdsMessage = missingIds.stream()
                    .map(CategoryID::getValue)
                    .collect(Collectors.joining(", "));

            notification.append(new Error("Some categories could not be found: %s".formatted(missingIdsMessage)));
        }
        return notification;

    }

    private Supplier<DomainException> notFound(final Identifier anId) {
        return () -> NotFoundException.with(Genre.class,anId);
    }

    private List<CategoryID> toCategoryId(final List<String> categories) {
        return categories.stream()
                .map(CategoryID::from)
                .toList();
    }
}
