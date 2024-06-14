package com.cht.admin.catalogo.application.video.media.upload;

import com.cht.admin.catalogo.domain.video.VideoResource;

public record UploadMediaCommand(
        String videoId,
        VideoResource videoResource
) {
    public static UploadMediaCommand with(final String anId, final VideoResource resource){
        return new UploadMediaCommand(anId, resource);
    }
}
