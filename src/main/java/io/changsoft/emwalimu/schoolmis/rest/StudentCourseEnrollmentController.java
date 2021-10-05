package io.changsoft.emwalimu.schoolmis.rest;

import io.changsoft.emwalimu.schoolmis.model.StudentCourseEnrollmentDTO;
import io.changsoft.emwalimu.schoolmis.service.StudentCourseEnrollmentService;
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
@RequestMapping(value = "/api/studentCourseEnrollments", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentCourseEnrollmentController {

    private final StudentCourseEnrollmentService studentCourseEnrollmentService;

    public StudentCourseEnrollmentController(
            final StudentCourseEnrollmentService studentCourseEnrollmentService) {
        this.studentCourseEnrollmentService = studentCourseEnrollmentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentCourseEnrollmentDTO>> getAllStudentCourseEnrollments() {
        return ResponseEntity.ok(studentCourseEnrollmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourseEnrollmentDTO> getStudentCourseEnrollment(
            @PathVariable final Long id) {
        return ResponseEntity.ok(studentCourseEnrollmentService.get(id));
    }

    @PostMapping
    public ResponseEntity<Long> createStudentCourseEnrollment(
            @RequestBody @Valid final StudentCourseEnrollmentDTO studentCourseEnrollmentDTO) {
        return new ResponseEntity<>(studentCourseEnrollmentService.create(studentCourseEnrollmentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateStudentCourseEnrollment(@PathVariable final Long id,
            @RequestBody @Valid final StudentCourseEnrollmentDTO studentCourseEnrollmentDTO) {
        studentCourseEnrollmentService.update(id, studentCourseEnrollmentDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentCourseEnrollment(@PathVariable final Long id) {
        studentCourseEnrollmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
