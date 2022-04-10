package com.feddon.mmykserviceuser.param;

import lombok.Data;

@Data
public class PageParam {

    private Integer pageNum = 1;

    private Integer pageSize = 10;

    private String sortOrder = "DESC";

    private String sortField = "id";

}
