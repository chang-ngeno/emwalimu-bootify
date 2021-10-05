package io.changsoft.emwalimu.schoolmis.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class ParentDTO {

    private Long id;

    @NotNull
    @Size(max = 100)
    private String relationship;

    private Long user;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(final String relationship) {
        this.relationship = relationship;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(final Long user) {
        this.user = user;
    }

}
