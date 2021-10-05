package io.changsoft.emwalimu.schoolmis.domain;

import io.changsoft.emwalimu.schoolmis.model.Parameter;
import java.time.LocalDateTime;
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
public class FeePayment {

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
    private LocalDateTime txnDate;

    @Column(nullable = false)
    private Double txnAmount;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Parameter txnMode;

    @OneToMany(mappedBy = "feePayment")
    private Set<FeePaymentDetail> feePaymentFeePaymentDetails;

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

    public LocalDateTime getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(final LocalDateTime txnDate) {
        this.txnDate = txnDate;
    }

    public Double getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(final Double txnAmount) {
        this.txnAmount = txnAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(final Double balance) {
        this.balance = balance;
    }

    public Parameter getTxnMode() {
        return txnMode;
    }

    public void setTxnMode(final Parameter txnMode) {
        this.txnMode = txnMode;
    }

    public Set<FeePaymentDetail> getFeePaymentFeePaymentDetails() {
        return feePaymentFeePaymentDetails;
    }

    public void setFeePaymentFeePaymentDetails(
            final Set<FeePaymentDetail> feePaymentFeePaymentDetails) {
        this.feePaymentFeePaymentDetails = feePaymentFeePaymentDetails;
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
