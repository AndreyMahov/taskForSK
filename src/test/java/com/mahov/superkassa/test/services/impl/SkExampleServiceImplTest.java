package com.mahov.superkassa.test.services.impl;

import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import com.mahov.superkassa.test.domain.entity.SkExample;
import com.mahov.superkassa.test.repositories.SkExampleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigInteger;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SkExampleServiceImplTest {

    @Mock
    private SkExampleRepository skExampleRepository;

    @InjectMocks
    private SkExampleServiceImpl skExampleService;

    private RequestDto requestDto;

    private ResponseDto responseDto;

    private SkExample skExample;


    @BeforeEach
    void setUp() {
        requestDto = new RequestDto();
        requestDto.setId(1L);
        requestDto.setAdd(BigInteger.valueOf(10));

        responseDto = new ResponseDto(BigInteger.valueOf(20));
        skExample = new SkExample();
        skExample.setId(1L);
        skExample.setResponseDto(responseDto);
    }

    @Test
    void modifySuccess() {
        when(skExampleRepository.findById(any())).thenReturn(Optional.ofNullable(skExample));
        ResponseDto expectedResponseDto = skExampleService.modify(requestDto);

        assertEquals(expectedResponseDto.getCurrent(), responseDto.getCurrent());

        verify(skExampleRepository, times(1)).findById(any());

    }
}