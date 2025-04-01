package com.entity.vo;

import com.entity.BaomingEntity;
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
@TableName("baoming")
public class BaomingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生名称
     */

    @TableField(value = "xs_types")
    private Integer xsTypes;


    /**
     * 专业 Search
     */

    @TableField(value = "zy_types")
    private Integer zyTypes;


    /**
     * 专业图片
     */

    @TableField(value = "zy_photo")
    private String zyPhoto;


    /**
     * 报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


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
	 * 设置：学生名称
	 */
    public Integer getXsTypes() {
        return xsTypes;
    }


    /**
	 * 获取：学生名称
	 */

    public void setXsTypes(Integer xsTypes) {
        this.xsTypes = xsTypes;
    }
    /**
	 * 设置：专业 Search
	 */
    public Integer getZyTypes() {
        return zyTypes;
    }


    /**
	 * 获取：专业 Search
	 */

    public void setZyTypes(Integer zyTypes) {
        this.zyTypes = zyTypes;
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
	 * 设置：报名时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：报名时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
