package com.feddon.mmykserviceuser.service;

import com.feddon.mmykserviceuser.entity.Site;
import com.feddon.mmykserviceuser.param.*;
import org.springframework.data.domain.Page;

public interface SiteService {

    Long createSite(CreateSiteParam param);

    void updateSite(UpdateSiteParam param);

    void deleteSite(DeleteSiteParam param);

    Site getSite(GetSiteParam param);

    Page<Site> listSite(ListSiteParam param);

}
