package com.entity.vo;

import com.entity.ZhuanyeEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-02-22
 */
@TableName("zhuanye")
public class ZhuanyeVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 专业名称  Search
     */

    @TableField(value = "name")
    private String name;


    /**
     * 培养目标
     */

    @TableField(value = "aobjective")
    private String aobjective;


    /**
     * 就业前景
     */

    @TableField(value = "prospects")
    private String prospects;


    /**
     * 专业图片
     */

    @TableField(value = "zy_photo")
    private String zyPhoto;


    /**
     * 专业介绍
     */

    @TableField(value = "notice_content")
    private String noticeContent;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：专业名称  Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：专业名称  Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：培养目标
	 */
    public String getAobjective() {
        return aobjective;
    }


    /**
	 * 获取：培养目标
	 */

    public void setAobjective(String aobjective) {
        this.aobjective = aobjective;
    }
    /**
	 * 设置：就业前景
	 */
    public String getProspects() {
        return prospects;
    }


    /**
	 * 获取：就业前景
	 */

    public void setProspects(String prospects) {
        this.prospects = prospects;
    }
    /**
	 * 设置：专业图片
	 */
    public String getZyPhoto() {
        return zyPhoto;
    }


    /**
	 * 获取：专业图片
	 */

    public void setZyPhoto(String zyPhoto) {
        this.zyPhoto = zyPhoto;
    }
    /**
	 * 设置：专业介绍
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：专业介绍
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

}
