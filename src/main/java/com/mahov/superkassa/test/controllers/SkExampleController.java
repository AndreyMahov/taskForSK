package com.mahov.superkassa.test.controllers;

import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface SkExampleController {

    ResponseDto modify(@RequestBody RequestDto requestDto);
}
