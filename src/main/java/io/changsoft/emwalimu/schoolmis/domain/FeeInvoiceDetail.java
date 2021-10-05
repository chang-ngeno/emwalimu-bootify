package io.changsoft.emwalimu.schoolmis.domain;

import io.changsoft.emwalimu.schoolmis.model.Parameter;
import java.time.LocalDate;
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
public class FeeInvoiceDetail {

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
    private Parameter voteHead;

    @Column(nullable = false)
    private LocalDate dateFrom;

    @Column
    private LocalDate dateTo;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Parameter periodcity;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private Double govtCapitation;

    @Column(nullable = false)
    private Double parentGuardianSponsor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fee_invoice_id", nullable = false)
    private FeeInvoice feeInvoice;

    @OneToMany(mappedBy = "feeInvoiceDetail")
    private Set<FeePaymentDetail> feeInvoiceDetailFeePaymentDetails;

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

    public Parameter getVoteHead() {
        return voteHead;
    }

    public void setVoteHead(final Parameter voteHead) {
        this.voteHead = voteHead;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(final LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(final LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Parameter getPeriodcity() {
        return periodcity;
    }

    public void setPeriodcity(final Parameter periodcity) {
        this.periodcity = periodcity;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(final Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getGovtCapitation() {
        return govtCapitation;
    }

    public void setGovtCapitation(final Double govtCapitation) {
        this.govtCapitation = govtCapitation;
    }

    public Double getParentGuardianSponsor() {
        return parentGuardianSponsor;
    }

    public void setParentGuardianSponsor(final Double parentGuardianSponsor) {
        this.parentGuardianSponsor = parentGuardianSponsor;
    }

    public FeeInvoice getFeeInvoice() {
        return feeInvoice;
    }

    public void setFeeInvoice(final FeeInvoice feeInvoice) {
        this.feeInvoice = feeInvoice;
    }

    public Set<FeePaymentDetail> getFeeInvoiceDetailFeePaymentDetails() {
        return feeInvoiceDetailFeePaymentDetails;
    }

    public void setFeeInvoiceDetailFeePaymentDetails(
            final Set<FeePaymentDetail> feeInvoiceDetailFeePaymentDetails) {
        this.feeInvoiceDetailFeePaymentDetails = feeInvoiceDetailFeePaymentDetails;
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
