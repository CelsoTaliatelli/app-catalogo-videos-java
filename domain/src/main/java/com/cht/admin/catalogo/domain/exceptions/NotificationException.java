package com.cht.admin.catalogo.domain.exceptions;

import com.cht.admin.catalogo.domain.validation.Error;
import com.cht.admin.catalogo.domain.validation.handler.Notification;

import java.util.List;

public class NotificationException extends DomainException{
    public NotificationException(String aMessage, final Notification notification) {
        super(aMessage,notification.getErrors());
    }
}
