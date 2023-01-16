package test.client.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableFeignClients("test.client.core")
@EnableSwagger2
public class Core {
    public static void main(String[] args) {
        SpringApplication.run(Core.class);
    }
}
