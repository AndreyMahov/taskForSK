package com.mahov.superkassa.test.controllers.impl;

import com.google.gson.Gson;
import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import com.mahov.superkassa.test.services.SkExampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SkExampleControllerImpl.class)
@AutoConfigureMockMvc
class SkExampleControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private SkExampleService skExampleService;

    private RequestDto requestDto;

    private ResponseDto responseDto;

    private  Gson gson;

    @BeforeEach
    void setUp() {
        requestDto = new RequestDto();
        requestDto.setId(1L);
        requestDto.setAdd(BigInteger.valueOf(10));

        responseDto = new ResponseDto(BigInteger.valueOf(10));
        gson = new Gson();

    }

    @Test
    void modifySuccess() throws Exception {
        when(skExampleService.modify(any())).thenReturn(responseDto);

        mockMvc.perform(post("/modify")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(requestDto))
                ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(gson.toJson(responseDto)));
        verify(skExampleService,times(1)).modify(any());
    }

}