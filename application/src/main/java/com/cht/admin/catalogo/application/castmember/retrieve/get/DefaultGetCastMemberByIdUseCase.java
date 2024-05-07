package com.cht.admin.catalogo.application.castmember.retrieve.get;

import com.cht.admin.catalogo.domain.castmember.CastMember;
import com.cht.admin.catalogo.domain.castmember.CastMemberGateway;
import com.cht.admin.catalogo.domain.castmember.CastMemberID;
import com.cht.admin.catalogo.domain.exceptions.NotFoundException;

import java.util.Objects;

public final class DefaultGetCastMemberByIdUseCase extends GetCastMemberByIdUseCase {
    private final CastMemberGateway castMemberGateway;

    public DefaultGetCastMemberByIdUseCase(final CastMemberGateway castMemberGateway) {
        this.castMemberGateway = Objects.requireNonNull(castMemberGateway);
    }

    @Override
    public CastMemberOutput execute(final String anIn) {
        final var aMemberId = CastMemberID.from(anIn);
        return this.castMemberGateway.findById(aMemberId)
                .map(CastMemberOutput::from)
                .orElseThrow(() -> NotFoundException.with(CastMember.class, aMemberId));
    }
}