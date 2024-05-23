package com.cht.admin.catalogo.domain.category;

import com.cht.admin.catalogo.domain.Identifier;
import com.cht.admin.catalogo.domain.utils.IdUtils;

import java.util.Objects;
import java.util.UUID;

public class CategoryID extends Identifier {

    private final String value;

    private CategoryID(final String value) {
        this.value = Objects.requireNonNull(value);
    }

    public static CategoryID unique(){
        return new CategoryID(IdUtils.uuid());
    }

    public static CategoryID from(final String anID) {
        return new CategoryID(anID);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final CategoryID that = (CategoryID) o;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
