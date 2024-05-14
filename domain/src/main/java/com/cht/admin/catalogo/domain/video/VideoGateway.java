package com.cht.admin.catalogo.domain.video;

import com.cht.admin.catalogo.domain.pagination.Pagination;

import java.util.Optional;

public interface VideoGateway {
    Video create(Video aVideo);

    void deleteById(VideoID anId);

    Optional<Video> findById(VideoID anId);

    Video update(Video aVideo);

    Pagination<Video> findAll(VideoSearchQuery aQuery);
}
