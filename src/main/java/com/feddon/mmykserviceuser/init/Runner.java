package com.feddon.mmykserviceuser.init;

import com.feddon.mmykserviceuser.param.CreateSiteParam;
import com.feddon.mmykserviceuser.service.SiteService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

	@Autowired
	private SiteService siteService;

	@Override
	public void run(ApplicationArguments args) {

		CreateSiteParam createSiteParam = new CreateSiteParam();
		createSiteParam.setName(RandomStringUtils.random(20));
		createSiteParam.setDescription(RandomStringUtils.random(20));
		createSiteParam.setUrl(RandomStringUtils.random(20));
		Long siteId = siteService.createSite(createSiteParam);

	}

}
