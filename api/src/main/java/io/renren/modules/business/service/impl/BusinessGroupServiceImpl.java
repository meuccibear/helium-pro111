package io.renren.modules.business.service.impl;

import io.renren.modules.sys.entity.SysMenuEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;

import io.renren.modules.business.dao.BusinessGroupDao;
import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.service.BusinessGroupService;


@Service("businessGroupService")
public class BusinessGroupServiceImpl extends ServiceImpl<BusinessGroupDao, BusinessGroupEntity> implements BusinessGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BusinessGroupEntity> page = this.page(
                new Query<BusinessGroupEntity>().getPage(params),
                new QueryWrapper<BusinessGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<BusinessGroupEntity> queryNotButtonList() {
        return baseMapper.queryNotButtonList();
    }

}
