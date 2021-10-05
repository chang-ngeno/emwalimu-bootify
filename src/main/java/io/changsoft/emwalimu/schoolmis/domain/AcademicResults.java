package io.changsoft.emwalimu.schoolmis.domain;

import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;


@Entity
public class AcademicResults {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private Double score;

    @Column(nullable = false)
    private Double ratingFactor;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "exam_type",
            joinColumns = @JoinColumn(name = "academic_results_id"),
            inverseJoinColumns = @JoinColumn(name = "system_parameter_id")
    )
    private Set<SystemParameter> examTypeSystemParameters;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_course_subject_result_id", nullable = false)
    private StudentCourseEnrollment studentCourseSubjectResult;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

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

    public Set<SystemParameter> getExamTypeSystemParameters() {
        return examTypeSystemParameters;
    }

    public void setExamTypeSystemParameters(final Set<SystemParameter> examTypeSystemParameters) {
        this.examTypeSystemParameters = examTypeSystemParameters;
    }

    public StudentCourseEnrollment getStudentCourseSubjectResult() {
        return studentCourseSubjectResult;
    }

    public void setStudentCourseSubjectResult(
            final StudentCourseEnrollment studentCourseSubjectResult) {
        this.studentCourseSubjectResult = studentCourseSubjectResult;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
