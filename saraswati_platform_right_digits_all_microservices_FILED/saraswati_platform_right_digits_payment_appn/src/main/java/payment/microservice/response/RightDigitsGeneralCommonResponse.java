package payment.microservice.response;

import java.net.http.HttpResponse;

public class RightDigitsGeneralCommonResponse {

    private String responseBodyString;

    private String responseDataString;

    private Class<?> responseEntityClazz;

    private HttpResponse<RightDigitsGeneralResponseDTO> httpResponse;

    private int responseCode;

    private String responseMessage;

}
