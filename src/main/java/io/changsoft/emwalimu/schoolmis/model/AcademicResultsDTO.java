package io.changsoft.emwalimu.schoolmis.model;

import java.util.List;
import javax.validation.constraints.NotNull;


public class AcademicResultsDTO {

    private Long id;

    @NotNull
    private Double score;

    @NotNull
    private Double ratingFactor;

    private List<Long> examTypes;

    @NotNull
    private Long studentCourseSubjectResult;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(final Double score) {
        this.score = score;
    }

    public Double getRatingFactor() {
        return ratingFactor;
    }

    public void setRatingFactor(final Double ratingFactor) {
        this.ratingFactor = ratingFactor;
    }

    public List<Long> getExamTypes() {
        return examTypes;
    }

    public void setExamTypes(final List<Long> examTypes) {
        this.examTypes = examTypes;
    }

    public Long getStudentCourseSubjectResult() {
        return studentCourseSubjectResult;
    }

    public void setStudentCourseSubjectResult(final Long studentCourseSubjectResult) {
        this.studentCourseSubjectResult = studentCourseSubjectResult;
    }

}
