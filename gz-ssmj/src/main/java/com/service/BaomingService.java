package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaomingEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-02-22
 */
public interface BaomingService extends IService<BaomingEntity> {

     PageUtils queryPage(Map<String, Object> params);

}