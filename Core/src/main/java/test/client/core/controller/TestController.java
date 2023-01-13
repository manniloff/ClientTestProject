package test.client.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.client.core.feign.SystemProxy;

@Controller
@RequestMapping("/core")
@RequiredArgsConstructor
public class TestController {
    private final SystemProxy systemProxy;

    @GetMapping(value = {"","/"}, produces = "application/json")
    public ResponseEntity<?> testConnection() {
        return ResponseEntity.ok("Core Connected");
    }

    @GetMapping(value = "/system", produces = "application/json")
    ResponseEntity<?> testSystemConnection() {
        return systemProxy.testConnection();
    }
}
