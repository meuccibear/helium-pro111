/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.renren;

import io.renren.modules.business.dao.BusinessHotspottyDao;
import io.renren.modules.business.entity.BusinessHotspottyEntity;
import io.renren.modules.business.service.BusinessWalletService;
import io.renren.modules.helium.HeliumUtils;
import io.renren.modules.helium.domain.Device;
import io.renren.service.DynamicDataSourceTestService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {
    @Autowired
    private DynamicDataSourceTestService dynamicDataSourceTestService;

    @Autowired
    BusinessHotspottyDao businessHotspottyDao;

    @Autowired
    private BusinessWalletService businessWalletService;


    @Test
    public void test(){
        Long id = 1L;

        dynamicDataSourceTestService.updateUser(id);
        dynamicDataSourceTestService.updateUserBySlave1(id);
        dynamicDataSourceTestService.updateUserBySlave2(id);
    }


    @SneakyThrows
    @Test
    /**
     * 循环爬取钱包设备
     */
    public void crawlingData(){
//        businessWalletService.crawlingDatas();


        Device hotspotsById = HeliumUtils.getHotspotsById("11yhGTP2JX2Nr812Wk8F9Sn5YEpfXG3SCK79VnhYDA1hmtvHWhv");
        BusinessHotspottyEntity businessHotspottyEntity = new BusinessHotspottyEntity();
        businessHotspottyEntity.setAddDevice(hotspotsById);
        businessHotspottyDao.insertSelective(businessHotspottyEntity);

    }





}
