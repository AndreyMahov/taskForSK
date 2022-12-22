package com.mahov.superkassa.test.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class ResponseDto implements Serializable {

    @Serial
    private final static long serialVersionUID = 2053L;
    private BigInteger current;

    public ResponseDto(BigInteger current) {
        this.current = current;
    }
}
