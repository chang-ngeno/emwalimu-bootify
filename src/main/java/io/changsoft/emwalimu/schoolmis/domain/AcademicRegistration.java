package io.changsoft.emwalimu.schoolmis.domain;

import io.changsoft.emwalimu.schoolmis.model.Academic;
import io.changsoft.emwalimu.schoolmis.model.Parameter;
import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;


@Entity
public class AcademicRegistration {

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
    private Academic calender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Academic termSemester;

    @Column
    @Enumerated(EnumType.STRING)
    private Parameter classGroup;

    @OneToMany(mappedBy = "studentAcademicRegistration")
    private Set<StudentEnrollment> studentAcademicRegistrationStudentEnrollments;

    @OneToMany(mappedBy = "academicRegistration")
    private Set<FeeInvoice> academicRegistrationFeeInvoices;

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

    public Academic getCalender() {
        return calender;
    }

    public void setCalender(final Academic calender) {
        this.calender = calender;
    }

    public Academic getTermSemester() {
        return termSemester;
    }

    public void setTermSemester(final Academic termSemester) {
        this.termSemester = termSemester;
    }

    public Parameter getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(final Parameter classGroup) {
        this.classGroup = classGroup;
    }

    public Set<StudentEnrollment> getStudentAcademicRegistrationStudentEnrollments() {
        return studentAcademicRegistrationStudentEnrollments;
    }

    public void setStudentAcademicRegistrationStudentEnrollments(
            final Set<StudentEnrollment> studentAcademicRegistrationStudentEnrollments) {
        this.studentAcademicRegistrationStudentEnrollments = studentAcademicRegistrationStudentEnrollments;
    }

    public Set<FeeInvoice> getAcademicRegistrationFeeInvoices() {
        return academicRegistrationFeeInvoices;
    }

    public void setAcademicRegistrationFeeInvoices(
            final Set<FeeInvoice> academicRegistrationFeeInvoices) {
        this.academicRegistrationFeeInvoices = academicRegistrationFeeInvoices;
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
