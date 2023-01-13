package test.client.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "system-service")
public interface SystemProxy {
    @GetMapping(value = "/system")
    ResponseEntity<String> testConnection();
}
