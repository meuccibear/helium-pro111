package io.renren.modules.generator.controller;

import java.util.Map;

import com.alibaba.fastjson.TypeReference;
import io.renren.business.domin.ParamsBean;
import io.renren.business.domin.starsharks.vo.StarsharksResult;
import io.renren.business.starsharks.Market;
import io.renren.common.gitUtils.BeanUtils;
import io.renren.common.gitUtils.PageDTO;
import io.renren.common.utils.PageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.renren.common.utils.R;


/**
 * 用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-03-04 03:27:22
 */
@RestController
@RequestMapping("generator/starsharks")
public class StarsharksController {

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    @RequiresPermissions("generator:starsharks:list")
////    public R list(@RequestParam Map<String, Object> params) {
//    public R list(@ModelAttribute PageDTO params) {
////        ParamsBean paramsBean = BeanUtils.toJavaObject(params, new TypeReference<ParamsBean>() {
////        });
//        StarsharksResult starsharksResult = new Market().starsharks(params.getPage(), params.getLimit());
//        PageUtils page = new PageUtils(starsharksResult.getSharkList(), starsharksResult.getTotal_count(),
//                starsharksResult.getTotal_page(), starsharksResult.getCurr_page());
//        return R.ok().put("page", page);
//    }

}
