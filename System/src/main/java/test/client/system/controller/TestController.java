package test.client.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.client.system.feign.CoreProxy;

@Controller
@RequestMapping("/system")
@RequiredArgsConstructor
public class TestController {
    private final CoreProxy coreProxy;

    @GetMapping(value = {"","/"}, produces = "application/json")
    ResponseEntity<?> testConnection() {
        return ResponseEntity.ok("System Connected");
    }

    @GetMapping(value = "/core", produces = "application/json")
    ResponseEntity<?> testCoreConnection() {
        return ResponseEntity.ok(coreProxy.testConnection());
    }
}
