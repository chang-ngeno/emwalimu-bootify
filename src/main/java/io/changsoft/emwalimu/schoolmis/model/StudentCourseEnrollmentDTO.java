package io.changsoft.emwalimu.schoolmis.model;

import javax.validation.constraints.NotNull;


public class StudentCourseEnrollmentDTO {

    private Long id;

    @NotNull
    private Parameter courseSubject;

    @NotNull
    private Long studentCourseSubject;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Parameter getCourseSubject() {
        return courseSubject;
    }

    public void setCourseSubject(final Parameter courseSubject) {
        this.courseSubject = courseSubject;
    }

    public Long getStudentCourseSubject() {
        return studentCourseSubject;
    }

    public void setStudentCourseSubject(final Long studentCourseSubject) {
        this.studentCourseSubject = studentCourseSubject;
    }

}
