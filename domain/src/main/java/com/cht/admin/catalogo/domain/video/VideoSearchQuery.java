package com.cht.admin.catalogo.domain.video;

import com.cht.admin.catalogo.domain.Genre.GenreID;
import com.cht.admin.catalogo.domain.castmember.CastMemberID;
import com.cht.admin.catalogo.domain.category.CategoryID;

import java.util.Set;

public record VideoSearchQuery(
        int page,
        int perPage,
        String terms,
        String sort,
        String direction,
        Set<CastMemberID> castMembers,
        Set<CategoryID> categories,
        Set<GenreID> genres
) {

}
