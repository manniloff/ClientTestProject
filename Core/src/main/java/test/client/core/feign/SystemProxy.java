package test.client.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.client.core.feign.dto.StudentDto;

import java.util.List;

@FeignClient(name = "system-service")
public interface SystemProxy {

    @GetMapping(value = "/system")
    ResponseEntity<List<StudentDto>> getAll();

    @GetMapping(value = "/system/firstName/{firstName}")
    ResponseEntity<StudentDto> getByFirstName(@PathVariable String firstName);

    @GetMapping(value = "/system/lastName/{lastName}")
    ResponseEntity<StudentDto> getByLastName(@PathVariable String lastName);

    @GetMapping(value = "/system/email/{email}")
    ResponseEntity<StudentDto> getByEmail(@PathVariable String email);

    @PostMapping(value = "/system")
    ResponseEntity<StudentDto> create(@RequestBody StudentDto student);

    @PutMapping(value = "/system/{email}")
    ResponseEntity<String> update(@RequestBody StudentDto studentDto, @PathVariable String email);

    @DeleteMapping(value = "/system/{email}")
    ResponseEntity<String> delete(@PathVariable String email);
}
