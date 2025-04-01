package com.entity.view;

import com.entity.BaomingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-02-22
 */
@TableName("baoming")
public class BaomingView extends BaomingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public BaomingView() {

	}

	public BaomingView(BaomingEntity baomingEntity) {
		try {
			BeanUtils.copyProperties(this, baomingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
