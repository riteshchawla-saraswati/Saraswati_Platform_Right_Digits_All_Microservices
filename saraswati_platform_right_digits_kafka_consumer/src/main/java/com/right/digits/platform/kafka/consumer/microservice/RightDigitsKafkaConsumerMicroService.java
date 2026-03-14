package com.right.digits.platform.kafka.consumer.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RightDigitsKafkaConsumerMicroService {

    public static void main(String[] args) {

    //    SFTPClient.callSFTPServer();

        SpringApplication.run(RightDigitsKafkaConsumerMicroService.class, args);
    }

}
