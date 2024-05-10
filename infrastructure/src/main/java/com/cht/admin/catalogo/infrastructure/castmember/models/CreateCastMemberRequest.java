package com.cht.admin.catalogo.infrastructure.castmember.models;

import com.cht.admin.catalogo.domain.castmember.CastMemberType;

public record CreateCastMemberRequest (String name, CastMemberType type){
}
