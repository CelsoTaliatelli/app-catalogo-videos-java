package com.cht.admin.catalogo.application.category.create;

import com.cht.admin.catalogo.domain.category.Category;
import com.cht.admin.catalogo.domain.category.CategoryID;

public record CreateCategoryOutput(
        CategoryID id
) {
    public static CreateCategoryOutput from(final Category aCategory) {
        return new CreateCategoryOutput(aCategory.getId());
    }
}
