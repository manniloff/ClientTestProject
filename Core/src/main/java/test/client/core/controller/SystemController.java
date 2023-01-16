package test.client.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.client.core.feign.SystemProxy;
import test.client.core.feign.dto.StudentDto;

import java.util.List;

@Controller
@RequestMapping("/module/system")
@RequiredArgsConstructor
public class SystemController {
    private final SystemProxy systemProxy;

    @GetMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<List<StudentDto>> getAll() {
        return systemProxy.getAll();
    }

    @GetMapping(value = "/firstName/{firstName}", produces = "application/json")
    ResponseEntity<StudentDto> getByFirstName(@PathVariable String firstName) {
        return systemProxy.getByFirstName(firstName);
    }

    @GetMapping(value = "/lastName/{lastName}", produces = "application/json")
    ResponseEntity<StudentDto> getByLastName(@PathVariable String lastName) {
        return systemProxy.getByLastName(lastName);
    }

    @GetMapping(value = "/email/{email}", produces = "application/json")
    ResponseEntity<StudentDto> getByEmail(@PathVariable String email) {
        return systemProxy.getByEmail(email);
    }

    @PostMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
        return systemProxy.create(studentDto);
    }

    @PutMapping(value = "/{email}", produces = "application/json")
    ResponseEntity<String> update(@RequestBody StudentDto studentDto, @PathVariable String email) {
        return systemProxy.update(studentDto, email);
    }

    @DeleteMapping(value = "/{email}", produces = "application/json")
    ResponseEntity<String> delete(@PathVariable String email) {
        try {
            return systemProxy.delete(email);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.noContent().build();
        }
    }
}
