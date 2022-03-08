package io.renren.modules.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.gitUtils.exception.MsgException;
import io.renren.common.utils.PageUtils;
import io.renren.modules.business.entity.BusinessWalletEntity;

import java.util.List;
import java.util.Map;

/**
 * 钱包管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
public interface BusinessWalletService extends IService<BusinessWalletEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     *
     * @param userId
     */
    void crawlingData(Long userId) throws MsgException;

    void crawlingDatas();

    /**
     *
     */
    void crawlingData() throws MsgException;

}

