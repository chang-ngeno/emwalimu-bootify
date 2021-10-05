package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.AcademicRegistration;
import io.changsoft.emwalimu.schoolmis.domain.Student;
import io.changsoft.emwalimu.schoolmis.domain.StudentEnrollment;
import io.changsoft.emwalimu.schoolmis.model.StudentEnrollmentDTO;
import io.changsoft.emwalimu.schoolmis.repos.AcademicRegistrationRepository;
import io.changsoft.emwalimu.schoolmis.repos.StudentEnrollmentRepository;
import io.changsoft.emwalimu.schoolmis.repos.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class StudentEnrollmentService {

    private final StudentEnrollmentRepository studentEnrollmentRepository;
    private final StudentRepository studentRepository;
    private final AcademicRegistrationRepository academicRegistrationRepository;

    public StudentEnrollmentService(final StudentEnrollmentRepository studentEnrollmentRepository,
            final StudentRepository studentRepository,
            final AcademicRegistrationRepository academicRegistrationRepository) {
        this.studentEnrollmentRepository = studentEnrollmentRepository;
        this.studentRepository = studentRepository;
        this.academicRegistrationRepository = academicRegistrationRepository;
    }

    public List<StudentEnrollmentDTO> findAll() {
        return studentEnrollmentRepository.findAll()
                .stream()
                .map(studentEnrollment -> mapToDTO(studentEnrollment, new StudentEnrollmentDTO()))
                .collect(Collectors.toList());
    }

    public StudentEnrollmentDTO get(final Long id) {
        return studentEnrollmentRepository.findById(id)
                .map(studentEnrollment -> mapToDTO(studentEnrollment, new StudentEnrollmentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final StudentEnrollmentDTO studentEnrollmentDTO) {
        final StudentEnrollment studentEnrollment = new StudentEnrollment();
        mapToEntity(studentEnrollmentDTO, studentEnrollment);
        return studentEnrollmentRepository.save(studentEnrollment).getId();
    }

    public void update(final Long id, final StudentEnrollmentDTO studentEnrollmentDTO) {
        final StudentEnrollment studentEnrollment = studentEnrollmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(studentEnrollmentDTO, studentEnrollment);
        studentEnrollmentRepository.save(studentEnrollment);
    }

    public void delete(final Long id) {
        studentEnrollmentRepository.deleteById(id);
    }

    private StudentEnrollmentDTO mapToDTO(final StudentEnrollment studentEnrollment,
            final StudentEnrollmentDTO studentEnrollmentDTO) {
        studentEnrollmentDTO.setId(studentEnrollment.getId());
        studentEnrollmentDTO.setStartDate(studentEnrollment.getStartDate());
        studentEnrollmentDTO.setEndDate(studentEnrollment.getEndDate());
        studentEnrollmentDTO.setStudent(studentEnrollment.getStudent() == null ? null : studentEnrollment.getStudent().getId());
        studentEnrollmentDTO.setStudentAcademicRegistration(studentEnrollment.getStudentAcademicRegistration() == null ? null : studentEnrollment.getStudentAcademicRegistration().getId());
        return studentEnrollmentDTO;
    }

    private StudentEnrollment mapToEntity(final StudentEnrollmentDTO studentEnrollmentDTO,
            final StudentEnrollment studentEnrollment) {
        studentEnrollment.setStartDate(studentEnrollmentDTO.getStartDate());
        studentEnrollment.setEndDate(studentEnrollmentDTO.getEndDate());
        if (studentEnrollmentDTO.getStudent() != null && (studentEnrollment.getStudent() == null || !studentEnrollment.getStudent().getId().equals(studentEnrollmentDTO.getStudent()))) {
            final Student student = studentRepository.findById(studentEnrollmentDTO.getStudent())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "student not found"));
            studentEnrollment.setStudent(student);
        }
        if (studentEnrollmentDTO.getStudentAcademicRegistration() != null && (studentEnrollment.getStudentAcademicRegistration() == null || !studentEnrollment.getStudentAcademicRegistration().getId().equals(studentEnrollmentDTO.getStudentAcademicRegistration()))) {
            final AcademicRegistration studentAcademicRegistration = academicRegistrationRepository.findById(studentEnrollmentDTO.getStudentAcademicRegistration())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "studentAcademicRegistration not found"));
            studentEnrollment.setStudentAcademicRegistration(studentAcademicRegistration);
        }
        return studentEnrollment;
    }

}
