package test.client.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("test.client.core")
public class Core {
    public static void main(String[] args) {
        SpringApplication.run(Core.class);
    }
}
