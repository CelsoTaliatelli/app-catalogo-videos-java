package com.cht.admin.catalogo.application.video.retrieve.list;

import com.cht.admin.catalogo.domain.pagination.Pagination;
import com.cht.admin.catalogo.domain.video.VideoGateway;
import com.cht.admin.catalogo.domain.video.VideoSearchQuery;

import java.util.Objects;

public class DefaultListVideosUseCase  extends ListVideosUseCase{

    private final VideoGateway videoGateway;

    public DefaultListVideosUseCase(final VideoGateway videoGateway) {
        this.videoGateway = Objects.requireNonNull(videoGateway);
    }

    @Override
    public Pagination<VideoListOutput> execute(final VideoSearchQuery aQuery) {
        return this.videoGateway.findAll(aQuery)
                .map(VideoListOutput::from);
    }
}
