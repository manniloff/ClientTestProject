package test.client.system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.client.system.converter.StudentConverter;
import test.client.system.dto.StudentDto;
import test.client.system.model.Student;
import test.client.system.repository.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/system")
@RequiredArgsConstructor
public class StudentController {
    private final StudentRepository studentRepository;

    @GetMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(studentRepository.findAll()
                .stream()
                .map(StudentConverter.toStudentDto)
                .collect(Collectors.toList()));
    }

    @GetMapping(value = "/firstName/{firstName}", produces = "application/json")
    ResponseEntity<StudentDto> getByFirstName(@PathVariable String firstName) {
        return ResponseEntity.ok(StudentConverter.toStudentDto
                .apply(studentRepository.findAllByFirstName(firstName)));
    }

    @GetMapping(value = "/lastName/{lastName}", produces = "application/json")
    ResponseEntity<StudentDto> getByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(StudentConverter.toStudentDto
                .apply(studentRepository.findAllByLastName(lastName)));
    }

    @GetMapping(value = "/email/{email}", produces = "application/json")
    ResponseEntity<StudentDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(StudentConverter.toStudentDto
                .apply(studentRepository.findByEmail(email)));
    }

    @PostMapping(value = {"", "/"}, produces = "application/json")
    ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setEmail(studentDto.getEmail());
        student.setCreated(LocalDateTime.now().withNano(0));
        return ResponseEntity.ok(StudentConverter.toStudentDto
                .apply(studentRepository.save(student)));
    }

    @PutMapping(value = "/{email}", produces = "application/json")
    ResponseEntity<String> update(@RequestBody StudentDto studentDto, @PathVariable String email) {

        Student student = checkStudent(email);
        if (Optional.ofNullable(student).isPresent()) {
            Student updateStudent = new Student();
            updateStudent.setId(student.getId());
            updateStudent.setFirstName(studentDto.getFirstName());
            updateStudent.setLastName(studentDto.getLastName());
            updateStudent.setEmail(studentDto.getEmail());
            updateStudent.setCreated(LocalDateTime.now().withNano(0));

            studentRepository.saveAndFlush(updateStudent);

            return ResponseEntity.ok("Student with email - " + email + ", was updated");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping(value = "/{email}", produces = "application/json")
    ResponseEntity<String> delete(@PathVariable String email) {
        Student student = studentRepository.findByEmail(email);
        if (Optional.ofNullable(student).isPresent()) {
            studentRepository.deleteById(student.getId());
            String result = email + ", was deleted";
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    private Student checkStudent(String email) {
        return studentRepository.findByEmail(email);
    }
}
