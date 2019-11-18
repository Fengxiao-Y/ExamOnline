
package com.yidu.victory.student.domain;

/**
 * 内容：Makeuptable表实体类
 * 作者 tzh
 * 编写日期:下午7:31:43
 * 版本1.0
 */
public class Makeuptable {
	/**
	 * @author d280
	 * 编写日期:下午7:40:04
	 * 版本1.0
	 */
	private static final long serialVersionUID = 2494130676412390L;
	//学号(主键,来自学生表)
	private int sid;
	//学生名称
	private String sname;
	//分数
	private int grade;
	//班级编号
	private int squadid;
	//考试编号
	private int eid;
	//状态
	private String conditions;
	/**
	 * 默认构造方法
	 */
	/**
	 * @author d280
	 * 编写日期:上午8:57:11
	 * 版本1.0
	 */
	public Makeuptable() {
		super();
	}
	/**
	 *带参构造方法
	 * @author d280
	 * 编写日期:下午7:38:05
	 * 版本1.0
	 */
	
	public Makeuptable(int sid, String sname, int grade, int squadid, int eid, String conditions) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.grade = grade;
		this.squadid = squadid;
		this.eid = eid;
		this.conditions = conditions;
	}
	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}
	/**
	 * @return the sname
	 */
	public String getSname() {
		return sname;
	}
	/**
	 * @param sname the sname to set
	 */
	public void setSname(String sname) {
		this.sname = sname;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(int grade) {
		this.grade = grade;
	}
	/**
	 * @return the squadId
	 */
	public int getSquadid() {
		return squadid;
	}
	/**
	 * @param squadid the squadId to set
	 */
	public void setSquadid(int squadid) {
		this.squadid = squadid;
	}
	/**
	 * @return the eid
	 */
	public int getEid() {
		return eid;
	}
	/**
	 * @param eid the eid to set
	 */
	public void setEid(int eid) {
		this.eid = eid;
	}
	/**
	 * @return the conditions
	 */
	public String getConditions() {
		return conditions;
	}
	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * SET GET  构造方法
	 * @return the sid
	 */
}
