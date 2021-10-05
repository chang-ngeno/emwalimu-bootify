package io.changsoft.emwalimu.schoolmis.model;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class StudentDTO {

    private Long id;

    @NotNull
    private LocalDate joinDate;

    @NotNull
    @Size(max = 30)
    private String admissionNumber;

    private Long user;

    @NotNull
    private Long feeInvoice;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(final LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getAdmissionNumber() {
        return admissionNumber;
    }

    public void setAdmissionNumber(final String admissionNumber) {
        this.admissionNumber = admissionNumber;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(final Long user) {
        this.user = user;
    }

    public Long getFeeInvoice() {
        return feeInvoice;
    }

    public void setFeeInvoice(final Long feeInvoice) {
        this.feeInvoice = feeInvoice;
    }

}
