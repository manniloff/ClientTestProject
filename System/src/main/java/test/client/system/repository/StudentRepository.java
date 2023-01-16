package test.client.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.client.system.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query
    Student findAllByFirstName(String firstName);
    @Query
    Student findAllByLastName(String lastName);
    @Query
    Student findByEmail(String email);
}
