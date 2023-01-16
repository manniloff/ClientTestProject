package test.client.core.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.client.core.feign.dto.StudentDto;

@FeignClient(name = "system-service")
public interface SystemProxy {

    @GetMapping(value = "/system")
    ResponseEntity<?> getAll();

    @GetMapping(value = "/system/firstName/{firstName}")
    ResponseEntity<?> getByFirstName(@PathVariable String firstName);

    @GetMapping(value = "/system/lastName/{lastName}")
    ResponseEntity<?> getByLastName(@PathVariable String lastName);

    @GetMapping(value = "/system/email/{email}")
    ResponseEntity<?> getByEmail(@PathVariable String email);

    @PostMapping(value = "/system")
    ResponseEntity<?> create(@RequestBody StudentDto student);

    @PutMapping(value = "/system/{email}")
    ResponseEntity<?> update(@RequestBody StudentDto studentDto, @PathVariable String email);

    @DeleteMapping(value = "/system/{email}")
    ResponseEntity<String> delete(@PathVariable String email);
}
