package user.microservice;

import org.springframework.boot.SpringApplication;

public class TestRightDigitsJavaFunctionalPgmgMicroServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(RightDigitsUserMicroservice::main).with(TestcontainersConfiguration.class).run(args);
    }

}
