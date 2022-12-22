package com.mahov.superkassa.test.domain.enums;

import lombok.Getter;

@Getter
public enum ExceptionMessage {
    OBJECT_NOT_FOUND("обьект с id %s  не найден");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
