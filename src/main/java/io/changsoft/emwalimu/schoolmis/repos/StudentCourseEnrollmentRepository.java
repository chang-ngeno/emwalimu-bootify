package io.changsoft.emwalimu.schoolmis.repos;

import io.changsoft.emwalimu.schoolmis.domain.StudentCourseEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentCourseEnrollmentRepository extends JpaRepository<StudentCourseEnrollment, Long> {
}
