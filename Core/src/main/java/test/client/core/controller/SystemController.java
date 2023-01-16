package test.client.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.client.core.feign.SystemProxy;
import test.client.core.feign.dto.StudentDto;

@Controller
@RequestMapping("/module/system")
@RequiredArgsConstructor
public class SystemController {
    private final SystemProxy systemProxy;

    @GetMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<?> getAll() {
        return systemProxy.getAll();
    }

    @GetMapping(value = "/firstName/{firstName}", produces = "application/json")
    ResponseEntity<?> getByFirstName(@PathVariable String firstName) {
        return systemProxy.getByFirstName(firstName);
    }

    @GetMapping(value = "/lastName/{lastName}", produces = "application/json")
    ResponseEntity<?> getByLastName(@PathVariable String lastName) {
        return systemProxy.getByLastName(lastName);
    }

    @GetMapping(value = "/email/{email}", produces = "application/json")
    ResponseEntity<?> getByEmail(@PathVariable String email) {
        return systemProxy.getByEmail(email);
    }

    @PostMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<?> create(@RequestBody StudentDto studentDto) {
        return systemProxy.create(studentDto);
    }

    @PutMapping(value = "/{email}", produces = "application/json")
    ResponseEntity<?> update(@RequestBody StudentDto studentDto, @PathVariable String email) {
        return systemProxy.update(studentDto, email);
    }

    @DeleteMapping(value = "/{email}", produces = "application/json")
    ResponseEntity<?> delete(@PathVariable String email) {
        try {
            return systemProxy.delete(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }
}
