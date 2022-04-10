package com.feddon.mmykserviceuser.param;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetSiteParam {

    @NotNull
    private Long id;

}
