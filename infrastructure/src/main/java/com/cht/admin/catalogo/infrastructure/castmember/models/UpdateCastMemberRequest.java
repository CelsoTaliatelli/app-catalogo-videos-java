package com.cht.admin.catalogo.infrastructure.castmember.models;

import com.cht.admin.catalogo.domain.castmember.CastMemberType;

public record UpdateCastMemberRequest(String name, CastMemberType type) {
}
