package com.mahov.superkassa.test.services.impl;

import com.mahov.superkassa.test.domain.entity.SkExample;
import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import com.mahov.superkassa.test.domain.enums.ExceptionMessage;
import com.mahov.superkassa.test.domain.exception.ObjectNotFound;
import com.mahov.superkassa.test.repositories.SkExampleRepository;
import com.mahov.superkassa.test.services.SkExampleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;

@Service
@Slf4j
@AllArgsConstructor
public class SkExampleServiceImpl implements SkExampleService {
    private final SkExampleRepository skExampleRepository;

    @Transactional()
    public ResponseDto modify(RequestDto requestDto){
        SkExample skExample = skExampleRepository.findById(requestDto.getId())
                .orElseThrow(()->new ObjectNotFound(ExceptionMessage.OBJECT_NOT_FOUND.getMessage()));

        BigInteger current = skExample.getResponseDto().getCurrent();
        BigInteger result = current.add(requestDto.getAdd());
        skExample.getResponseDto().setCurrent(result);
        return new ResponseDto(result);
    }

}
