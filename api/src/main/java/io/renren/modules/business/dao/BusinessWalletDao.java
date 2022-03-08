package io.renren.modules.business.dao;
import io.renren.modules.business.dao.FindOwnerAndCreateUserIdByCreateUserIdResult;
import org.apache.ibatis.annotations.Param;

import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.entity.BusinessWalletEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 钱包管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Mapper
public interface BusinessWalletDao extends BaseMapper<BusinessWalletEntity> {

    List<String> findOwnerByCreateUserId(@Param("createUserId")Long createUserId);

    List<FindOwnerAndCreateUserIdByCreateUserIdResult> findOwnerAndCreateUserIdByCreateUserId(@Param("createUserId")Long createUserId);

    List<BusinessWalletEntity> findAllByCreateUserId(@Param("createUserId")Long createUserId);


    int updateOwnerByOwner(@Param("updatedOwner")String updatedOwner,@Param("owner")String owner);


}
