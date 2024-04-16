package com.cht.admin.catalogo.application.delete;

import com.cht.admin.catalogo.domain.Genre.GenreGateway;
import com.cht.admin.catalogo.domain.Genre.GenreID;

import java.util.Objects;

public class DefaultDeleteGenreUseCase extends DeleteGenreUseCase{

    private final GenreGateway genreGateway;
    public DefaultDeleteGenreUseCase(final GenreGateway genreGateway) {
        this.genreGateway = Objects.requireNonNull(genreGateway);
    }

    @Override
    public void execute(final String anIn) {
        this.genreGateway.deleteById(GenreID.from(anIn));
    }
}
