package io.changsoft.emwalimu.schoolmis.domain;

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
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;


@Entity
public class SystemParameter {

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
    private Parameter paramType;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Column(nullable = false, columnDefinition = "clob")
    private String description;

    @ManyToMany(mappedBy = "userRoleSystemParameters")
    private Set<User> userRoleUsers;

    @ManyToMany(mappedBy = "departmentSystemParameters")
    private Set<Staff> departmentStaffs;

    @ManyToMany(mappedBy = "examTypeSystemParameters")
    private Set<AcademicResults> examTypeAcademicResultss;

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

    public Parameter getParamType() {
        return paramType;
    }

    public void setParamType(final Parameter paramType) {
        this.paramType = paramType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Set<User> getUserRoleUsers() {
        return userRoleUsers;
    }

    public void setUserRoleUsers(final Set<User> userRoleUsers) {
        this.userRoleUsers = userRoleUsers;
    }

    public Set<Staff> getDepartmentStaffs() {
        return departmentStaffs;
    }

    public void setDepartmentStaffs(final Set<Staff> departmentStaffs) {
        this.departmentStaffs = departmentStaffs;
    }

    public Set<AcademicResults> getExamTypeAcademicResultss() {
        return examTypeAcademicResultss;
    }

    public void setExamTypeAcademicResultss(final Set<AcademicResults> examTypeAcademicResultss) {
        this.examTypeAcademicResultss = examTypeAcademicResultss;
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
