package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.KechengDao;
import com.entity.KechengEntity;
import com.service.KechengService;
import com.entity.view.KechengView;

/**
 *  服务实现类
 * @author 
 * @since 2021-02-22
 */
@Service("kechengService")
@Transactional
public class KechengServiceImpl extends ServiceImpl<KechengDao, KechengEntity> implements KechengService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<KechengView> page =new Query<KechengView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
