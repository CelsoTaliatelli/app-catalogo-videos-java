package com.cht.admin.catalogo.domain.castmember;

import com.cht.admin.catalogo.domain.Genre.GenreID;
import com.cht.admin.catalogo.domain.pagination.Pagination;
import com.cht.admin.catalogo.domain.pagination.SearchQuery;

import java.util.List;
import java.util.Optional;

public interface CastMemberGateway {
    CastMember create(CastMember aCastMember);
    void deleteById(CastMemberID anId);
    Optional<CastMember> findById(CastMemberID anId);
    CastMember update(CastMember aCastMember);
    Pagination<CastMember> findAll(SearchQuery aQuery);
    List<CastMemberID> existsByIds(Iterable<CastMemberID> ids);
}
