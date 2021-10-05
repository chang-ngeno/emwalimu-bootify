package io.changsoft.emwalimu.schoolmis.domain;

import io.changsoft.emwalimu.schoolmis.model.Parameter;
import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;


@Entity
public class StudentCourseEnrollment {

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
    @Enumerated(EnumType.STRING)
    private Parameter courseSubject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_course_subject_id", nullable = false)
    private StudentEnrollment studentCourseSubject;

    @OneToMany(mappedBy = "studentCourseSubjectResult")
    private Set<AcademicResults> studentCourseSubjectResultAcademicResultss;

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

    public Parameter getCourseSubject() {
        return courseSubject;
    }

    public void setCourseSubject(final Parameter courseSubject) {
        this.courseSubject = courseSubject;
    }

    public StudentEnrollment getStudentCourseSubject() {
        return studentCourseSubject;
    }

    public void setStudentCourseSubject(final StudentEnrollment studentCourseSubject) {
        this.studentCourseSubject = studentCourseSubject;
    }

    public Set<AcademicResults> getStudentCourseSubjectResultAcademicResultss() {
        return studentCourseSubjectResultAcademicResultss;
    }

    public void setStudentCourseSubjectResultAcademicResultss(
            final Set<AcademicResults> studentCourseSubjectResultAcademicResultss) {
        this.studentCourseSubjectResultAcademicResultss = studentCourseSubjectResultAcademicResultss;
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
