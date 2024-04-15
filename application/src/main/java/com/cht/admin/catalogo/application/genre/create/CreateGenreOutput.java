package com.cht.admin.catalogo.application.genre.create;

import com.cht.admin.catalogo.domain.Genre.Genre;

public record CreateGenreOutput(
        String id
) {
    public static CreateGenreOutput from(final String anId) {
        return new CreateGenreOutput(anId);
    }

    public static CreateGenreOutput from(final Genre aGenre) {
        return new CreateGenreOutput(aGenre.getId().getValue());
    }
}
