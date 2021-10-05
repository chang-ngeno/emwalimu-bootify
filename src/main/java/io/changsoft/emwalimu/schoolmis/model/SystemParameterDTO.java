package io.changsoft.emwalimu.schoolmis.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class SystemParameterDTO {

    private Long id;

    @NotNull
    private Parameter paramType;

    @NotNull
    @Size(max = 20)
    private String code;

    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Parameter getParamType() {
        return paramType;
    }

    public void setParamType(final Parameter paramType) {
        this.paramType = paramType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
