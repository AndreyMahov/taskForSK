package com.mahov.superkassa.test.services.impl;

import com.mahov.superkassa.test.domain.entity.SkExample;
import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
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

    @Transactional
    public ResponseDto modify(RequestDto requestDto){
        long id = requestDto.getId();
        log.info("Метод modify(RequestDto requestDto) класса SkExampleServiceImpl начал работу. id параметра {}",id);
        SkExample skExample = skExampleRepository.findById(id)
                .orElseThrow(()->new ObjectNotFound(id));

        BigInteger current = skExample.getResponseDto().getCurrent();
        BigInteger result = current.add(requestDto.getAdd());
        skExample.getResponseDto().setCurrent(result);
        return new ResponseDto(result);
    }

}
