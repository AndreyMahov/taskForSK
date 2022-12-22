package com.mahov.superkassa.test.controllers.impl;

import com.mahov.superkassa.test.controllers.SkExampleController;
import com.mahov.superkassa.test.domain.dto.RequestDto;
import com.mahov.superkassa.test.domain.dto.ResponseDto;
import com.mahov.superkassa.test.services.impl.SkExampleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class SkExampleControllerImpl implements SkExampleController {

    private final SkExampleServiceImpl skExampleServiceImpl;

    @PostMapping("/modify")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto modify(@RequestBody RequestDto requestDto){
        return skExampleServiceImpl.modify(requestDto);
    }
}
