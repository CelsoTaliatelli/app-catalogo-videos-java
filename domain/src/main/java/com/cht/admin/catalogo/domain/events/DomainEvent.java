package com.cht.admin.catalogo.domain.events;

import java.io.Serializable;
import java.time.Instant;

public interface DomainEvent extends Serializable {
    Instant occurrendOn();
}
