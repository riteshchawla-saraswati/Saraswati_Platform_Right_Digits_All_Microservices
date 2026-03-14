package payment.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RightDigitsPaymentMicroService {

    public static void main(String[] args) {

    //    SFTPClient.callSFTPServer();

        SpringApplication.run(RightDigitsPaymentMicroService.class, args);
    }

}
