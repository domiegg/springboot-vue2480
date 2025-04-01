package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuanyeEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-02-22
 */
public interface ZhuanyeService extends IService<ZhuanyeEntity> {

     PageUtils queryPage(Map<String, Object> params);

}