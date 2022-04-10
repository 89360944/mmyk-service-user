package com.feddon.mmykserviceuser.service.impl;

import com.feddon.mmykserviceuser.entity.Site;
import com.feddon.mmykserviceuser.exception.MyException;
import com.feddon.mmykserviceuser.param.*;
import com.feddon.mmykserviceuser.repository.SiteRepository;
import com.feddon.mmykserviceuser.service.SiteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Override
    public Long createSite(CreateSiteParam param) {
        Site site = new Site();
        BeanUtils.copyProperties(param, site);
        siteRepository.save(site);
        return site.getId();
    }

    @Override
    public void updateSite(UpdateSiteParam param) {
        Site site = new Site();
        site.setId(param.getId());
        site = siteRepository.findOne(Example.of(site)).orElseThrow(() -> new MyException("站点未找到"));
        BeanUtils.copyProperties(param, site);
        siteRepository.save(site);
    }

    @Override
    public void deleteSite(DeleteSiteParam param) {
        if (param.getIds().size() > 0) {
            siteRepository.deleteAllByIdInBatch(param.getIds());
        }
    }

    @Override
    public Site getSite(GetSiteParam param) {
        Site site = new Site();
        if (param.getId() != null) {
            site.setId(param.getId());
        }
        site = siteRepository.findOne(Example.of(site)).orElseThrow(() -> new MyException("站点未找到"));
        return site;
    }

    @Override
    public Page<Site> listSite(ListSiteParam param) {
        Pageable pageable = PageRequest.of(param.getPageNum() - 1, param.getPageSize(), Sort.by(Sort.Direction.valueOf(param.getSortOrder()), param.getSortField()));
        Page<Site> page = siteRepository.findAll((root, criteriaQuery, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.isNotBlank(param.getName())) {
                predicateList.add(cb.like(root.get("name"), "%" + param.getName() + "%"));
            }

            Predicate[] pre = new Predicate[predicateList.size()];
            return cb.and(predicateList.toArray(pre));
        }, pageable);
        return page;
    }

}
