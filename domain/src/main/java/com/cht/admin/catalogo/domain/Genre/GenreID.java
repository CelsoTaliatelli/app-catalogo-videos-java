package com.cht.admin.catalogo.domain.Genre;

import com.cht.admin.catalogo.domain.Identifier;
import com.cht.admin.catalogo.domain.category.CategoryID;
import com.cht.admin.catalogo.domain.utils.IdUtils;

import java.util.Objects;
import java.util.UUID;

public class GenreID extends Identifier {

    private final String value;

    private GenreID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static GenreID unique(){
        return new GenreID(IdUtils.uuid());
    }

    public static GenreID from(final String anID) {
        return new GenreID(anID);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final GenreID that = (GenreID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
