package com.mahov.superkassa.test.controllers.impl;

import com.mahov.superkassa.test.controllers.SkExampleController;
import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import com.mahov.superkassa.test.services.SkExampleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SkExampleControllerImpl implements SkExampleController {

    private final SkExampleService skExampleService;

    @PostMapping(value = "/modify")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto modify(@RequestBody RequestDto requestDto) {
        return skExampleService.modify(requestDto);
    }
}
