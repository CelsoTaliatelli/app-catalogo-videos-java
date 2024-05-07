package com.cht.admin.catalogo.application.castmember.update;

import com.cht.admin.catalogo.application.UseCase;

public abstract sealed class UpdateCastMemberUseCase
extends UseCase<UpdateCastMemberCommand,UpdateCastMemberOutput>
permits DefaultUpdateCastMemberUseCase {

}
