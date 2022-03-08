package io.renren.modules.business.service.impl;

import com.alibaba.fastjson.JSON;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.modules.business.service.BusinessHotspottyService;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.business.dao.BusinessWalletDao;
import io.renren.modules.business.entity.BusinessWalletEntity;
import io.renren.modules.business.service.BusinessWalletService;


@Service("businessWalletService")
public class BusinessWalletServiceImpl extends ServiceImpl<BusinessWalletDao, BusinessWalletEntity> implements BusinessWalletService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BusinessHotspottyService businessHotspottyService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinessWalletEntity> page = this.page(
                new Query<BusinessWalletEntity>().getPage(params),
                new QueryWrapper<BusinessWalletEntity>()
        );

        PageUtils pageUtils = new PageUtils(page);

        System.out.println(JSON.toJSONString(pageUtils));
        return pageUtils;
    }

    @Override
    public void crawlingData() throws MsgException {
        crawlingData(null);
    }

    @Override
    public void crawlingData(Long userId) throws MsgException {
        List<BusinessWalletEntity> wallets = baseMapper.findAllByCreateUserId(userId);
        List<Device> devices = new ArrayList<>();
        for (BusinessWalletEntity wallet : wallets) {
            System.out.println("wallet " + wallet);
            devices = HeliumUtils.getHotspotsByWalletId(wallet.getOwner());
            for (Device device : devices) {
                device.setCreateUserId(wallet.getCreateUserId());
                device.setTotal(HeliumUtils.getHotspotsTotal(2, device.getAddress()));
                businessHotspottyService.addHotsPotty(device);
            }
        }
    }


    @Override
    public void crawlingDatas() {
        List<BusinessWalletEntity> wallets = baseMapper.findAllByCreateUserId(null);
        Device device = null;
        for (BusinessWalletEntity wallet : wallets) {
            System.out.println("wallet " + wallet);
            try {
                device = HeliumUtils.getHotspotsById(wallet.getOwner());
                System.out.println(device.getAddress() + " => " + device.getOwner());
            } catch (Exception e) {
                System.out.println(String.format("getHotspotsById(%s) %s", wallet, e.getMessage()));
            }

            baseMapper.updateOwnerByOwner(device.getOwner(), wallet.getOwner());
            try {
                device.setCreateUserId(wallet.getCreateUserId());
                device.setTotal(HeliumUtils.getHotspotsTotal(2, device.getAddress()));
                businessHotspottyService.addHotsPotty(device);
            } catch (Exception e) {
                System.out.println(String.format("getHotspotsTotal(%s) %s", device.getAddress(), e.getMessage()));
//                    e.printStackTrace();
            }
        }
    }

}
