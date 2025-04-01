package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhaoshengzhengceEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-02-22
 */
public interface ZhaoshengzhengceService extends IService<ZhaoshengzhengceEntity> {

     PageUtils queryPage(Map<String, Object> params);

}