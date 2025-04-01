package com.entity.vo;

import com.entity.ZhaoshengzhengceEntity;
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
@TableName("zhaoshengzhengce")
public class ZhaoshengzhengceVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 招生政策
     */

    @TableField(value = "notice_content")
    private String noticeContent;


    /**
     * 上次修改时间
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
	 * 设置：招生政策
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：招生政策
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    /**
	 * 设置：上次修改时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：上次修改时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
