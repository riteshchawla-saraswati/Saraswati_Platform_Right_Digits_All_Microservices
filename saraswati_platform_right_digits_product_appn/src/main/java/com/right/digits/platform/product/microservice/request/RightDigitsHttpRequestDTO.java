package com.right.digits.platform.product.microservice.request;

import com.right.digits.platform.product.microservice.dtos.RightDigitsGeneralUniversalDTO;
import io.netty.util.internal.StringUtil;

import java.util.Date;

public class RightDigitsHttpRequestDTO extends RightDigitsCommonBaseRequest {

    private String requestDataString;

    private Class<?> requestEntityClazz;

    private  RightDigitsGeneralUniversalDTO requestDto =
            new RightDigitsGeneralUniversalDTO();

    public RightDigitsHttpRequestDTO() {
        super();
        requestDto = new RightDigitsGeneralUniversalDTO();
        this.initializeRequest(requestDto);
    }

    public void initializeRequest(RightDigitsGeneralUniversalDTO httpRequestDto) {
        requestDto.initializeDateDTO(new Date(), false, false, false);
        requestDto.initializeStringDTO(StringUtil.EMPTY_STRING, false, false, false);
        requestDto.initializeObjectDTO(StringUtil.EMPTY_STRING, false, false, false);
        requestDto.initializeLongDTO(0L, false, false, false);
        requestDto.initializeDoubleDTO(0.0d, false, false, false);
    }


}
