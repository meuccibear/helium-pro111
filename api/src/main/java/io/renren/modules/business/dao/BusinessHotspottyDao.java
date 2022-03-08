package io.renren.modules.business.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import io.renren.modules.business.entity.BusinessHotspottyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 设备管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@Mapper
public interface BusinessHotspottyDao extends BaseMapper<BusinessHotspottyEntity> {

    Long findHotspottyIdByAddress(@Param("address")String address);

    int insertSelective(BusinessHotspottyEntity businessHotspottyEntity);

}
