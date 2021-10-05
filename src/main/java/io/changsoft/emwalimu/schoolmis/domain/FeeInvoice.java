package io.changsoft.emwalimu.schoolmis.domain;

import java.time.OffsetDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
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
public class FeeInvoice {

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
    private Double grandTotal;

    @Column(nullable = false)
    private Double subTotal;

    @OneToMany(mappedBy = "feeInvoice")
    private Set<Student> feeInvoiceStudents;

    @OneToMany(mappedBy = "feeInvoice")
    private Set<FeeInvoiceDetail> feeInvoiceFeeInvoiceDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academic_registration_id")
    private AcademicRegistration academicRegistration;

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

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(final Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(final Double subTotal) {
        this.subTotal = subTotal;
    }

    public Set<Student> getFeeInvoiceStudents() {
        return feeInvoiceStudents;
    }

    public void setFeeInvoiceStudents(final Set<Student> feeInvoiceStudents) {
        this.feeInvoiceStudents = feeInvoiceStudents;
    }

    public Set<FeeInvoiceDetail> getFeeInvoiceFeeInvoiceDetails() {
        return feeInvoiceFeeInvoiceDetails;
    }

    public void setFeeInvoiceFeeInvoiceDetails(
            final Set<FeeInvoiceDetail> feeInvoiceFeeInvoiceDetails) {
        this.feeInvoiceFeeInvoiceDetails = feeInvoiceFeeInvoiceDetails;
    }

    public AcademicRegistration getAcademicRegistration() {
        return academicRegistration;
    }

    public void setAcademicRegistration(final AcademicRegistration academicRegistration) {
        this.academicRegistration = academicRegistration;
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
