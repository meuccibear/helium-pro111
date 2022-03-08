package io.renren.modules.business.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.business.entity.BusinessAnagementMachineEntity;
import io.renren.modules.business.service.BusinessAnagementMachineService;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 管理机
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-07 19:34:07
 */
@RestController
@RequestMapping("business/businessanagementmachine")
public class BusinessAnagementMachineController {
    @Autowired
    private BusinessAnagementMachineService businessAnagementMachineService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("business:businessanagementmachine:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = businessAnagementMachineService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{mmId}")
    @RequiresPermissions("business:businessanagementmachine:info")
    public R info(@PathVariable("mmId") Long mmId){
		BusinessAnagementMachineEntity businessAnagementMachine = businessAnagementMachineService.getById(mmId);

        return R.ok().put("businessAnagementMachine", businessAnagementMachine);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("business:businessanagementmachine:save")
    public R save(@RequestBody BusinessAnagementMachineEntity businessAnagementMachine){
		businessAnagementMachineService.save(businessAnagementMachine);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("business:businessanagementmachine:update")
    public R update(@RequestBody BusinessAnagementMachineEntity businessAnagementMachine){
		businessAnagementMachineService.updateById(businessAnagementMachine);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("business:businessanagementmachine:delete")
    public R delete(@RequestBody Long[] mmIds){
		businessAnagementMachineService.removeByIds(Arrays.asList(mmIds));

        return R.ok();
    }

}
