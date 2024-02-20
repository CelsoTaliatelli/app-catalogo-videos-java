package com.cht.admin.catalogo.application.category.update;

import com.cht.admin.catalogo.domain.category.Category;
import com.cht.admin.catalogo.domain.category.CategoryID;

public record UpdateCategoryOutput(
        String id
) {
    public static UpdateCategoryOutput from(final String anId){
        return new UpdateCategoryOutput(anId);
    }
    public static UpdateCategoryOutput from(final Category aCategory) {
        return new UpdateCategoryOutput(aCategory.getId().getValue());
    }
}
