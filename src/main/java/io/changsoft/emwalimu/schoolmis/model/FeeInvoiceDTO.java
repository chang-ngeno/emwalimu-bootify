package io.changsoft.emwalimu.schoolmis.model;

import javax.validation.constraints.NotNull;


public class FeeInvoiceDTO {

    private Long id;

    @NotNull
    private Double grandTotal;

    @NotNull
    private Double subTotal;

    private Long academicRegistration;

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

    public Long getAcademicRegistration() {
        return academicRegistration;
    }

    public void setAcademicRegistration(final Long academicRegistration) {
        this.academicRegistration = academicRegistration;
    }

}
