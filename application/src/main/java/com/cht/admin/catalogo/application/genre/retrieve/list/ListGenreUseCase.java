package com.cht.admin.catalogo.application.genre.retrieve.list;

import com.cht.admin.catalogo.application.UseCase;
import com.cht.admin.catalogo.domain.pagination.Pagination;
import com.cht.admin.catalogo.domain.pagination.SearchQuery;

public abstract class ListGenreUseCase extends UseCase<SearchQuery, Pagination<GenreListOutput>> {
}
