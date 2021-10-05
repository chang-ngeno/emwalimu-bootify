package io.changsoft.emwalimu.schoolmis.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;


public class StudentEnrollmentDTO {

    private Long id;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private Long student;

    @NotNull
    private Long studentAcademicRegistration;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getStudent() {
        return student;
    }

    public void setStudent(final Long student) {
        this.student = student;
    }

    public Long getStudentAcademicRegistration() {
        return studentAcademicRegistration;
    }

    public void setStudentAcademicRegistration(final Long studentAcademicRegistration) {
        this.studentAcademicRegistration = studentAcademicRegistration;
    }

}
