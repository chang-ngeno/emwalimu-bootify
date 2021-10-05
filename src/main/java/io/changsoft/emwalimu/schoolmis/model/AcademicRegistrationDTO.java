package io.changsoft.emwalimu.schoolmis.model;

import javax.validation.constraints.NotNull;


public class AcademicRegistrationDTO {

    private Long id;

    @NotNull
    private Academic calender;

    @NotNull
    private Academic termSemester;

    private Parameter classGroup;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Academic getCalender() {
        return calender;
    }

    public void setCalender(final Academic calender) {
        this.calender = calender;
    }

    public Academic getTermSemester() {
        return termSemester;
    }

    public void setTermSemester(final Academic termSemester) {
        this.termSemester = termSemester;
    }

    public Parameter getClassGroup() {
        return classGroup;
    }

    public void setClassGroup(final Parameter classGroup) {
        this.classGroup = classGroup;
    }

}
