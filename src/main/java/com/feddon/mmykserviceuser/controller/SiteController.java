package com.feddon.mmykserviceuser.controller;

import com.feddon.mmykserviceuser.entity.Site;
import com.feddon.mmykserviceuser.param.*;
import com.feddon.mmykserviceuser.service.SiteService;
import com.feddon.mmykserviceuser.vo.ResponseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "站点--Site")
@RestController
public class SiteController {

    @Autowired
    private SiteService siteService;

    @GetMapping("/test")
    public String test(HttpServletRequest request){
        return "t hello world, uri:" + request.getRequestURI();
    }

    @GetMapping("/user-service/test")
    public String test2(HttpServletRequest request){
        return "uto hello world, uri:" + request.getRequestURI();
    }

    @Operation(summary = "创建站点")
    @PostMapping(value = "/createSite")
    public ResponseVO prod(@Validated @RequestBody CreateSiteParam param) {
        siteService.createSite(param);
        return ResponseVO.ok();
    }

    @Operation(summary = "更新站点")
    @PostMapping(value = "/updateSite")
    public ResponseVO prod(@Validated @RequestBody UpdateSiteParam param) {
        siteService.updateSite(param);
        return ResponseVO.ok();
    }

    @Operation(summary = "删除站点")
    @PostMapping(value = "/deleteSite")
    public ResponseVO prod(@Validated @RequestBody DeleteSiteParam param) {
        siteService.deleteSite(param);
        return ResponseVO.ok();
    }

    @Operation(summary = "获取站点详情")
    @PostMapping(value = "/getSite")
    public ResponseVO<Site> prod(@Validated @RequestBody GetSiteParam param) {
        Site site = siteService.getSite(param);
        return ResponseVO.ok(site);
    }

    @Operation(summary = "获取站点列表")
    @PostMapping(value = "/listSite")
    public ResponseVO<Page<Site>> prod(@Validated @RequestBody ListSiteParam param) {
        Page<Site> page = siteService.listSite(param);
        return ResponseVO.ok(page);
    }

}
