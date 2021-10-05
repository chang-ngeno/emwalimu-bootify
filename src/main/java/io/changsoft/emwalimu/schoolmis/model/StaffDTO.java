package io.changsoft.emwalimu.schoolmis.model;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class StaffDTO {

    private Long id;

    @NotNull
    @Size(max = 30)
    private String staffNumber;

    private List<Long> departments;

    private Long user;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(final String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public List<Long> getDepartments() {
        return departments;
    }

    public void setDepartments(final List<Long> departments) {
        this.departments = departments;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(final Long user) {
        this.user = user;
    }

}
