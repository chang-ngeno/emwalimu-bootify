package io.changsoft.emwalimu.schoolmis.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;


public class FeeInvoiceDetailDTO {

    private Long id;

    @NotNull
    private Parameter voteHead;

    @NotNull
    private LocalDate dateFrom;

    private LocalDate dateTo;

    @NotNull
    private Parameter periodcity;

    @NotNull
    private Double totalAmount;

    @NotNull
    private Double govtCapitation;

    @NotNull
    private Double parentGuardianSponsor;

    @NotNull
    private Long feeInvoice;

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

    public Long getFeeInvoice() {
        return feeInvoice;
    }

    public void setFeeInvoice(final Long feeInvoice) {
        this.feeInvoice = feeInvoice;
    }

}
