package test.client.system.converter;

import test.client.system.dto.StudentDto;
import test.client.system.model.Student;

import java.util.function.Function;

public class StudentConverter {
    public static Function<Student, StudentDto> toStudentDto =
            student -> StudentDto.builder()
                    .firstName(student.getFirstName())
                    .lastName(student.getLastName())
                    .email(student.getEmail())
                    .created(student.getCreated())
                    .build();
}
