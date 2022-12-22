package com.mahov.superkassa.test.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class RequestDto {

    private long id;
    private BigInteger add;
}
