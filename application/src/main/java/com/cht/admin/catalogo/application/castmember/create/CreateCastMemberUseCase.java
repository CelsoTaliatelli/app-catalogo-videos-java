package com.cht.admin.catalogo.application.castmember.create;

import com.cht.admin.catalogo.application.UseCase;

public sealed abstract class CreateCastMemberUseCase
extends UseCase<CreateCastMemberCommand, CreateCastMemberOutput>
permits DefaultCreateCastMemberUseCase {
}
