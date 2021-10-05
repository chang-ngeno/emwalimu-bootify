package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.StudentEnrollmentDTO;
import io.changsoft.emwalimu.schoolmis.service.StudentEnrollmentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/studentEnrollments", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentEnrollmentController {

    private final StudentEnrollmentService studentEnrollmentService;

    public StudentEnrollmentController(final StudentEnrollmentService studentEnrollmentService) {
        this.studentEnrollmentService = studentEnrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentEnrollmentDTO>> getAllStudentEnrollments() {
        return ResponseEntity.ok(studentEnrollmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEnrollmentDTO> getStudentEnrollment(@PathVariable final Long id) {
        return ResponseEntity.ok(studentEnrollmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createStudentEnrollment(
            @RequestBody @Valid final StudentEnrollmentDTO studentEnrollmentDTO) {
        return new ResponseEntity<>(studentEnrollmentService.create(studentEnrollmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudentEnrollment(@PathVariable final Long id,
            @RequestBody @Valid final StudentEnrollmentDTO studentEnrollmentDTO) {
        studentEnrollmentService.update(id, studentEnrollmentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentEnrollment(@PathVariable final Long id) {
        studentEnrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
