package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.ZhuanyeEntity;
import com.service.ZhuanyeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.BaomingEntity;

import com.service.BaomingService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-02-22
*/
@RestController
@Controller
@RequestMapping("/baoming")
public class BaomingController {
    private static final Logger logger = LoggerFactory.getLogger(BaomingController.class);

    @Autowired
    private BaomingService baomingService;

    @Autowired
    private ZhuanyeService zhuanyeService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("学生")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = baomingService.queryPage(params);
        }else{
            page = baomingService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        BaomingEntity baoming = baomingService.selectById(id);
        if(baoming!=null){
            return R.ok().put("data", baoming);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BaomingEntity baoming, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
            .eq("xs_types", baoming.getXsTypes())
            .eq("zy_types", baoming.getZyTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
        if("".equals(baoming.getZyPhoto()) || "null".equals(baoming.getZyPhoto())){
            baoming.setZyPhoto(null);
        }
        if(baomingEntity==null){
            baomingService.insert(baoming);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BaomingEntity baoming){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
            .notIn("id",baoming.getId())
            .eq("xs_types", baoming.getXsTypes())
            .eq("zy_types", baoming.getZyTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
        if("".equals(baoming.getZyPhoto()) || "null".equals(baoming.getZyPhoto())){
                baoming.setZyPhoto(null);
        }
        if(baomingEntity==null){
            baomingService.updateById(baoming);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 报名
    */
    @RequestMapping("/apply")
    public R apply(Integer id, HttpServletRequest request){
        ZhuanyeEntity zhuanye = zhuanyeService.selectById(id);
        if(zhuanye != null){
            BaomingEntity baoming = new BaomingEntity();
            baoming.setXsTypes((Integer) request.getSession().getAttribute("userId"));
            baoming.setZyPhoto(zhuanye.getZyPhoto());
            baoming.setZyTypes(zhuanye.getId());
            baoming.setCreateTime(new Date());
            Wrapper<BaomingEntity> queryWrapper = new EntityWrapper<BaomingEntity>()
                    .eq("xs_types", baoming.getXsTypes())
                    ;
            logger.info("sql语句:"+queryWrapper.getSqlSegment());
            BaomingEntity baomingEntity = baomingService.selectOne(queryWrapper);
            if("".equals(baoming.getZyPhoto()) || "null".equals(baoming.getZyPhoto())){
                baoming.setZyPhoto(null);
            }
            if(baomingEntity==null){
                baomingService.insert(baoming);
                return R.ok();
            }else {
                return R.error(511,"每次只能报名一个专业，不能重复报名！！！");
            }
        }else{
            return R.error();
        }

    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        baomingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

