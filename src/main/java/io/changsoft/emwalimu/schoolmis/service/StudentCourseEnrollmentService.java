package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.StudentCourseEnrollment;
import io.changsoft.emwalimu.schoolmis.domain.StudentEnrollment;
import io.changsoft.emwalimu.schoolmis.model.StudentCourseEnrollmentDTO;
import io.changsoft.emwalimu.schoolmis.repos.StudentCourseEnrollmentRepository;
import io.changsoft.emwalimu.schoolmis.repos.StudentEnrollmentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class StudentCourseEnrollmentService {

    private final StudentCourseEnrollmentRepository studentCourseEnrollmentRepository;
    private final StudentEnrollmentRepository studentEnrollmentRepository;

    public StudentCourseEnrollmentService(
            final StudentCourseEnrollmentRepository studentCourseEnrollmentRepository,
            final StudentEnrollmentRepository studentEnrollmentRepository) {
        this.studentCourseEnrollmentRepository = studentCourseEnrollmentRepository;
        this.studentEnrollmentRepository = studentEnrollmentRepository;
    }

    public List<StudentCourseEnrollmentDTO> findAll() {
        return studentCourseEnrollmentRepository.findAll()
                .stream()
                .map(studentCourseEnrollment -> mapToDTO(studentCourseEnrollment, new StudentCourseEnrollmentDTO()))
                .collect(Collectors.toList());
    }

    public StudentCourseEnrollmentDTO get(final Long id) {
        return studentCourseEnrollmentRepository.findById(id)
                .map(studentCourseEnrollment -> mapToDTO(studentCourseEnrollment, new StudentCourseEnrollmentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final StudentCourseEnrollmentDTO studentCourseEnrollmentDTO) {
        final StudentCourseEnrollment studentCourseEnrollment = new StudentCourseEnrollment();
        mapToEntity(studentCourseEnrollmentDTO, studentCourseEnrollment);
        return studentCourseEnrollmentRepository.save(studentCourseEnrollment).getId();
    }

    public void update(final Long id, final StudentCourseEnrollmentDTO studentCourseEnrollmentDTO) {
        final StudentCourseEnrollment studentCourseEnrollment = studentCourseEnrollmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(studentCourseEnrollmentDTO, studentCourseEnrollment);
        studentCourseEnrollmentRepository.save(studentCourseEnrollment);
    }

    public void delete(final Long id) {
        studentCourseEnrollmentRepository.deleteById(id);
    }

    private StudentCourseEnrollmentDTO mapToDTO(
            final StudentCourseEnrollment studentCourseEnrollment,
            final StudentCourseEnrollmentDTO studentCourseEnrollmentDTO) {
        studentCourseEnrollmentDTO.setId(studentCourseEnrollment.getId());
        studentCourseEnrollmentDTO.setCourseSubject(studentCourseEnrollment.getCourseSubject());
        studentCourseEnrollmentDTO.setStudentCourseSubject(studentCourseEnrollment.getStudentCourseSubject() == null ? null : studentCourseEnrollment.getStudentCourseSubject().getId());
        return studentCourseEnrollmentDTO;
    }

    private StudentCourseEnrollment mapToEntity(
            final StudentCourseEnrollmentDTO studentCourseEnrollmentDTO,
            final StudentCourseEnrollment studentCourseEnrollment) {
        studentCourseEnrollment.setCourseSubject(studentCourseEnrollmentDTO.getCourseSubject());
        if (studentCourseEnrollmentDTO.getStudentCourseSubject() != null && (studentCourseEnrollment.getStudentCourseSubject() == null || !studentCourseEnrollment.getStudentCourseSubject().getId().equals(studentCourseEnrollmentDTO.getStudentCourseSubject()))) {
            final StudentEnrollment studentCourseSubject = studentEnrollmentRepository.findById(studentCourseEnrollmentDTO.getStudentCourseSubject())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "studentCourseSubject not found"));
            studentCourseEnrollment.setStudentCourseSubject(studentCourseSubject);
        }
        return studentCourseEnrollment;
    }

}
