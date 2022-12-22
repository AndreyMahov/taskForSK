package com.mahov.superkassa.test.domain.exception;

import com.mahov.superkassa.test.domain.enums.ExceptionMessage;

public class ObjectNotFound extends RuntimeException {

    public ObjectNotFound(String id) {
        super(String.format(ExceptionMessage.OBJECT_NOT_FOUND.getMessage(), id));
    }
}
