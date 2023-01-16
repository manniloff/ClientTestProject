package test.client.system.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "core-service")
public interface CoreProxy {

    @GetMapping(value = "/core")
    ResponseEntity<String> testConnection();
}
