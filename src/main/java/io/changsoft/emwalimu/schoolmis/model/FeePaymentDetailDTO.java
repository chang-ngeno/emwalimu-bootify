package io.changsoft.emwalimu.schoolmis.model;

import javax.validation.constraints.NotNull;


public class FeePaymentDetailDTO {

    private Long id;

    @NotNull
    private Double amount;

    @NotNull
    private Long feePayment;

    @NotNull
    private Long feeInvoiceDetail;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(final Double amount) {
        this.amount = amount;
    }

    public Long getFeePayment() {
        return feePayment;
    }

    public void setFeePayment(final Long feePayment) {
        this.feePayment = feePayment;
    }

    public Long getFeeInvoiceDetail() {
        return feeInvoiceDetail;
    }

    public void setFeeInvoiceDetail(final Long feeInvoiceDetail) {
        this.feeInvoiceDetail = feeInvoiceDetail;
    }

}
