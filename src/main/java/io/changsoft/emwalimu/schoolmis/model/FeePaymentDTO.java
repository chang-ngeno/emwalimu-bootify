package io.changsoft.emwalimu.schoolmis.model;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;


public class FeePaymentDTO {

    private Long id;

    @NotNull
    private LocalDateTime txnDate;

    @NotNull
    private Double txnAmount;

    @NotNull
    private Double balance;

    @NotNull
    private Parameter txnMode;

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

}
