package io.renren.modules.business.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.sys.entity.SysMenuEntity;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.business.entity.BusinessGroupEntity;
import io.renren.modules.business.service.BusinessGroupService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 分组管理
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@RestController
@RequestMapping("business/businessgroup")
public class BusinessGroupController {
    @Autowired
    private BusinessGroupService businessGroupService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businessgroup:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = businessGroupService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{groupId}")
    @RequiresPermissions("business:businessgroup:info")
    public R info(@PathVariable("groupId") Long groupId){
		BusinessGroupEntity businessGroup = businessGroupService.getById(groupId);

        return R.ok().put("businessGroup", businessGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businessgroup:save")
    public R save(@RequestBody BusinessGroupEntity businessGroup){
		businessGroupService.save(businessGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businessgroup:update")
    public R update(@RequestBody BusinessGroupEntity businessGroup){
		businessGroupService.updateById(businessGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businessgroup:delete")
    public R delete(@RequestBody Long[] groupIds){
		businessGroupService.removeByIds(Arrays.asList(groupIds));

        return R.ok();
    }


    /**
     * 选择菜单(添加、修改菜单)
     */
    @GetMapping("/select")
//    @RequiresPermissions("business:businessgroup:select")
    public R select(){
        //查询列表数据
        List<BusinessGroupEntity> groupList = businessGroupService.queryNotButtonList();
        return R.ok().put("groupList", groupList);
    }
}
