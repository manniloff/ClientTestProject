package test.client.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping(value = {"", "/"}, produces = "application/json")
    public ResponseEntity<?> testConnection() {
        return ResponseEntity.ok("Core Connected");
    }
}
