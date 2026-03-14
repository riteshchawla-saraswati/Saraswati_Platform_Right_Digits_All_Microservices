package kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RightDigitsKafkaProducerMicroService {

    public static void main(String[] args) {

    //    SFTPClient.callSFTPServer();

        SpringApplication.run(RightDigitsKafkaProducerMicroService.class, args);
    }

}
