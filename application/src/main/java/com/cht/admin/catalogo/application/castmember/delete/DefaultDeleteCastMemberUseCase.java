package com.cht.admin.catalogo.application.castmember.delete;

import com.cht.admin.catalogo.domain.castmember.CastMemberGateway;
import com.cht.admin.catalogo.domain.castmember.CastMemberID;

import java.util.Objects;

public non-sealed class DefaultDeleteCastMemberUseCase extends DeleteCastMemberUseCase{

    private final CastMemberGateway castMemberGateway;

    public DefaultDeleteCastMemberUseCase(final CastMemberGateway castMemberGateway) {
        this.castMemberGateway = Objects.requireNonNull(castMemberGateway);
    }

    @Override
    public void execute(final String anIn) {
        this.castMemberGateway.deleteById(CastMemberID.from(anIn));
    }
}
