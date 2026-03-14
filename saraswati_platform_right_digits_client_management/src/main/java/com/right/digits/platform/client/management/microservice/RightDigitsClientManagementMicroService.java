package com.right.digits.platform.api.gateway.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RightDigitsClientManagementMicroService {

    public static void main(String[] args) {

    //    SFTPClient.callSFTPServer();

        SpringApplication.run(RightDigitsClientManagementMicroService.class, args);
    }

}
