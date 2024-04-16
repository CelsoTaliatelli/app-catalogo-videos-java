package com.cht.admin.catalogo.application.genre.update;

import com.cht.admin.catalogo.domain.Genre.Genre;

public record UpdateGenreOutput(String id) {

    public static UpdateGenreOutput from(final Genre aGenre) {
        return new UpdateGenreOutput(aGenre.getId().getValue());
    }
}
