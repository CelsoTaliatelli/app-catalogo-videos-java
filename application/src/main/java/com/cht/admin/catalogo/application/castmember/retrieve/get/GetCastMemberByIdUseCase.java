package com.cht.admin.catalogo.application.castmember.retrieve.get;

import com.cht.admin.catalogo.application.UseCase;

public abstract sealed class GetCastMemberByIdUseCase
        extends UseCase<String, CastMemberOutput>
        permits DefaultGetCastMemberByIdUseCase {
}
