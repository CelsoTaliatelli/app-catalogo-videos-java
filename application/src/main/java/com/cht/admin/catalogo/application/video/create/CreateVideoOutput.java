package com.cht.admin.catalogo.application.video.create;

import com.cht.admin.catalogo.domain.video.Video;

public record CreateVideoOutput(String id) {
    public static CreateVideoOutput from(final Video aVideo) {
        return new CreateVideoOutput(aVideo.getId().getValue());
    }
}
