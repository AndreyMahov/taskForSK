package com.mahov.superkassa.test.domain.util;


import com.google.gson.Gson;
import com.mahov.superkassa.test.domain.dto.ResponseDto;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ConverterJson implements AttributeConverter<ResponseDto, String> {

    private final static Gson GSON = new Gson();

    @Override
    public String convertToDatabaseColumn(ResponseDto responseDto) {
        return GSON.toJson(responseDto);
    }

    @Override
    public ResponseDto convertToEntityAttribute(String dbData) {
        return GSON.fromJson(dbData, ResponseDto.class);
    }
}

