package com.entity.model;

import com.entity.KechengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-02-22
 */
public class KechengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 课程名称 Search
     */
    private String name;


    /**
     * 所属专业 Search
     */
    private Integer zyTypes;


    /**
     * 课程图片
     */
    private String kcPhoto;


    /**
     * 课程描述
     */
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
	 * 设置：课程名称 Search
	 */
    public String getName() {
        return name;
    }


    /**
	 * 获取：课程名称 Search
	 */

    public void setName(String name) {
        this.name = name;
    }
    /**
	 * 设置：所属专业 Search
	 */
    public Integer getZyTypes() {
        return zyTypes;
    }


    /**
	 * 获取：所属专业 Search
	 */

    public void setZyTypes(Integer zyTypes) {
        this.zyTypes = zyTypes;
    }
    /**
	 * 设置：课程图片
	 */
    public String getKcPhoto() {
        return kcPhoto;
    }


    /**
	 * 获取：课程图片
	 */

    public void setKcPhoto(String kcPhoto) {
        this.kcPhoto = kcPhoto;
    }
    /**
	 * 设置：课程描述
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：课程描述
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    }
