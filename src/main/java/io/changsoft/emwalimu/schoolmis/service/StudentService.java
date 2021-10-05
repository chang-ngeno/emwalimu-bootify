package io.changsoft.emwalimu.schoolmis.service;

import io.changsoft.emwalimu.schoolmis.domain.FeeInvoice;
import io.changsoft.emwalimu.schoolmis.domain.Student;
import io.changsoft.emwalimu.schoolmis.domain.User;
import io.changsoft.emwalimu.schoolmis.model.StudentDTO;
import io.changsoft.emwalimu.schoolmis.repos.FeeInvoiceRepository;
import io.changsoft.emwalimu.schoolmis.repos.StudentRepository;
import io.changsoft.emwalimu.schoolmis.repos.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final FeeInvoiceRepository feeInvoiceRepository;

    public StudentService(final StudentRepository studentRepository,
            final UserRepository userRepository, final FeeInvoiceRepository feeInvoiceRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.feeInvoiceRepository = feeInvoiceRepository;
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream()
                .map(student -> mapToDTO(student, new StudentDTO()))
                .collect(Collectors.toList());
    }

    public StudentDTO get(final Long id) {
        return studentRepository.findById(id)
                .map(student -> mapToDTO(student, new StudentDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final StudentDTO studentDTO) {
        final Student student = new Student();
        mapToEntity(studentDTO, student);
        return studentRepository.save(student).getId();
    }

    public void update(final Long id, final StudentDTO studentDTO) {
        final Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(studentDTO, student);
        studentRepository.save(student);
    }

    public void delete(final Long id) {
        studentRepository.deleteById(id);
    }

    private StudentDTO mapToDTO(final Student student, final StudentDTO studentDTO) {
        studentDTO.setId(student.getId());
        studentDTO.setJoinDate(student.getJoinDate());
        studentDTO.setAdmissionNumber(student.getAdmissionNumber());
        studentDTO.setUser(student.getUser() == null ? null : student.getUser().getId());
        studentDTO.setFeeInvoice(student.getFeeInvoice() == null ? null : student.getFeeInvoice().getId());
        return studentDTO;
    }

    private Student mapToEntity(final StudentDTO studentDTO, final Student student) {
        student.setJoinDate(studentDTO.getJoinDate());
        student.setAdmissionNumber(studentDTO.getAdmissionNumber());
        if (studentDTO.getUser() != null && (student.getUser() == null || !student.getUser().getId().equals(studentDTO.getUser()))) {
            final User user = userRepository.findById(studentDTO.getUser())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
            student.setUser(user);
        }
        if (studentDTO.getFeeInvoice() != null && (student.getFeeInvoice() == null || !student.getFeeInvoice().getId().equals(studentDTO.getFeeInvoice()))) {
            final FeeInvoice feeInvoice = feeInvoiceRepository.findById(studentDTO.getFeeInvoice())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "feeInvoice not found"));
            student.setFeeInvoice(feeInvoice);
        }
        return student;
    }

}
