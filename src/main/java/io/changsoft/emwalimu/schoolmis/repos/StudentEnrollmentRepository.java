package io.changsoft.emwalimu.schoolmis.repos;

import io.changsoft.emwalimu.schoolmis.domain.StudentEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrollment, Long> {
}
