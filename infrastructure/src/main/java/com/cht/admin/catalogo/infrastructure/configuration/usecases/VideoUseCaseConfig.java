package com.cht.admin.catalogo.infrastructure.configuration.usecases;

import com.cht.admin.catalogo.application.video.media.update.DefaultUpdateMediaStatusUseCase;
import com.cht.admin.catalogo.application.video.media.update.UpdateMediaStatusUseCase;
import com.cht.admin.catalogo.domain.video.VideoGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
public class VideoUseCaseConfig {
    private final VideoGateway videoGateway;

    public VideoUseCaseConfig(final VideoGateway videoGateway) {
        this.videoGateway = Objects.requireNonNull(videoGateway);
    }

    @Bean
    public UpdateMediaStatusUseCase updateMediaStatusUseCase() {
        return new DefaultUpdateMediaStatusUseCase(videoGateway);
    }
}
