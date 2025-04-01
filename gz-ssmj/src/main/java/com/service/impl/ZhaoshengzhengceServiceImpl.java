package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ZhaoshengzhengceDao;
import com.entity.ZhaoshengzhengceEntity;
import com.service.ZhaoshengzhengceService;
import com.entity.view.ZhaoshengzhengceView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("zhaoshengzhengceService")
@Transactional
public class ZhaoshengzhengceServiceImpl extends ServiceImpl<ZhaoshengzhengceDao, ZhaoshengzhengceEntity> implements ZhaoshengzhengceService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ZhaoshengzhengceView> page =new Query<ZhaoshengzhengceView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
