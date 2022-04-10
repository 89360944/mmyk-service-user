package com.feddon.mmykserviceuser.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateSiteParam {

    @NotBlank
    private String name;

    private String url;

    private String description;

}
