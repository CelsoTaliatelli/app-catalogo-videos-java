package com.cht.admin.catalogo;

import com.cht.admin.catalogo.infrastructure.castmember.persistence.CastMemberRepository;
import com.cht.admin.catalogo.infrastructure.category.persistence.CategoryRepository;
import com.cht.admin.catalogo.infrastructure.genre.persistence.GenreRepository;
import com.cht.admin.catalogo.infrastructure.video.persistence.VideoRepository;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.List;

public class CleanUpExtension implements BeforeEachCallback{

        @Override
        public void beforeEach(final ExtensionContext context) {
            final var appContext = SpringExtension.getApplicationContext(context);

            cleanUp(List.of(
                    appContext.getBean(VideoRepository.class),
                    appContext.getBean(GenreRepository.class),
                    appContext.getBean(CategoryRepository.class),
                    appContext.getBean(CastMemberRepository.class)
            ));
        }

        private void cleanUp(final Collection<CrudRepository> repositories) {
            repositories.forEach(CrudRepository::deleteAll);
        }
}
