package test.client.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("test.client.system")
public class System {
    public static void main(String[] args) {
        SpringApplication.run(System.class);
    }
}
