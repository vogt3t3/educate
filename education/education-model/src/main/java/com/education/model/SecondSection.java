package com.education.model;
/**
 * 课程小节
 * 
 * @author 赵京华
 *
 */

import java.io.Serializable;
import java.util.Date;

import com.education.util.DateUtil;


public class SecondSection implements Serializable {
	/**
	 * 小节编号
	 */
	private int part_id;
	/**
	 * 视频编号
	 */
	private int video_id;
	/**
	 * 章节编号
	 */
	private int section_id;
	/**
	 * 小节编号名
	 */
	private String part_id_name;
	/**
	 * 小节名称
	 */
	private String part_name;
	/**
	 * 访问次数
	 */
	private int part_frequence;
	/**
	 * 发布时间
	 */
	private Date part_addtime;
	/**
	 * 发布时间
	 */
	private String str_part_addtime;
	/**
	 * 修改人
	 */
	private String part_modify_person;
	/**
	 * 修改时间
	 */
	private Date part_modify_date;
	/**
	 * 修改时间
	 */
	private String str_part_modify_date;
	/**
	 * 删除状态
	 */
	private int part_delete;
	
	
	
	public int getPart_id() {
		return part_id;
	}
	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public int getSection_id() {
		return section_id;
	}
	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}
	public String getPart_id_name() {
		return part_id_name;
	}
	public void setPart_id_name(String part_id_name) {
		this.part_id_name = part_id_name;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public int getPart_frequence() {
		return part_frequence;
	}
	public void setPart_frequence(int part_frequence) {
		this.part_frequence = part_frequence;
	}
	public Date getPart_addtime() {
		return part_addtime;
	}
	public void setPart_addtime(Date part_addtime) {
		this.part_addtime = part_addtime;
	}
	public String getStr_part_addtime() {
		return str_part_addtime;
	}
	public void setStr_part_addtime() {
		Date time=this.getPart_addtime();
		String strtime=DateUtil.formatDate(time, "yyyy-HH-dd");
		this.str_part_addtime =strtime;
	}
	public String getPart_modify_person() {
		return part_modify_person;
	}
	public void setPart_modify_person(String part_modify_person) {
		this.part_modify_person = part_modify_person;
	}
	public Date getPart_modify_date() {
		return part_modify_date;
	}
	public void setPart_modify_date(Date part_modify_date) {
		this.part_modify_date = part_modify_date;
	}
	public String getStr_part_modify_date() {
		return str_part_modify_date;
	}
	public void setStr_part_modify_date() {
		Date time=this.getPart_modify_date();
		String strtime=DateUtil.formatDate(time, "yyyy-HH-dd");
		this.str_part_modify_date = strtime;
	}
	public int getPart_delete() {
		return part_delete;
	}
	public void setPart_delete(int part_delete) {
		this.part_delete = part_delete;
	}
}













