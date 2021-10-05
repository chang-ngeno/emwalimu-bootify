package io.changsoft.emwalimu.schoolmis.repos;

import io.changsoft.emwalimu.schoolmis.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {
}
