package com.cht.admin.catalogo.domain.exceptions;

public class NoStacktraceExpection extends RuntimeException {
    public NoStacktraceExpection(final String message) {
        this(message, null);
    }

    public NoStacktraceExpection(final String message, final Throwable cause) {
        super(message, cause, true, false);
    }
}
