package com.cht.admin.catalogo.application.castmember.delete;

import com.cht.admin.catalogo.application.UnitUseCase;

public sealed abstract class DeleteCastMemberUseCase
        extends UnitUseCase<String>
        permits DefaultDeleteCastMemberUseCase {
}