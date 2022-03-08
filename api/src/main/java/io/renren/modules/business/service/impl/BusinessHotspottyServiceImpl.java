package io.renren.modules.business.service.impl;

import io.renren.common.gitUtils.ObjectUtils;
import io.renren.modules.helium.domain.Device;
import org.springframework.stereotype.Service;

import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.business.dao.BusinessHotspottyDao;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.service.BusinessHotspottyService;


@Service("businessHotspottyService")
public class BusinessHotspottyServiceImpl extends ServiceImpl<BusinessHotspottyDao, BusinessHotspottyEntity> implements BusinessHotspottyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinessHotspottyEntity> page = this.page(
                new Query<BusinessHotspottyEntity>().getPage(params),
                new QueryWrapper<BusinessHotspottyEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void addHotsPotty(Device device) {
        System.out.println(device.getAddress());
        Long id = baseMapper.findHotspottyIdByAddress(device.getAddress());
        BusinessHotspottyEntity businessHotspotty = new BusinessHotspottyEntity();

        if (ObjectUtils.notIsEmpty(id)) {
            System.out.println("修改");
            businessHotspotty.setUpdateDevice(id, device);
            updateById(businessHotspotty);
        } else {
            System.out.println("新增");
            businessHotspotty.setAddDevice(device);
            businessHotspotty.setHotspottyId(null);
            baseMapper.insertSelective(businessHotspotty);
        }
    }

}
