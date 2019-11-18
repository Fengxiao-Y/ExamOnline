package com.yidu.victory.excle.domain;

import java.io.Serializable;

import com.yidu.victory.excle.dao.Impl.ExamDaoImpl;
import com.yidu.victory.student.dao.Impl.SquadDaoImpl;
import com.yidu.victory.student.domain.Squad;

/**
 * stugrade表的实体类
 * @author asus
 *
 */
public class Stugrade implements Serializable{

	private static final long serialVersionUID = 1559282639185959291L;
	
	//成绩编号,主键
	private int gid;
	//学号
	private String sid;
	//学生名称
	private String sname;
	//分数
	private int grade;
	//班级编号
	private Squad squadid;
	//考试编号
	private Exam cid;
	//备注
	private String remark;
	
	/**
	 * 默认的构造方法
	 */
	public Stugrade() {
		super();
	}
	/**
	 * 带参构造方法
	 * @param gid
	 * @param sid
	 * @param sname
	 * @param grade
	 * @param squadid
	 * @param cid
	 * @param remark
	 */
	public Stugrade(int gid, String sid, String sname, int grade, int squadid, int cid, String remark) {
		super();
		this.gid = gid;
		this.sid = sid;
		this.sname = sname;
		this.grade = grade;
		this.squadid = new SquadDaoImpl().findById(squadid);
		this.cid = new ExamDaoImpl().findById(cid);
		this.remark = remark;
	}
	
	
	
	public Stugrade(String sid, String sname, int grade, int squadid, int cid, String remark) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.grade = grade;
		this.squadid = new SquadDaoImpl().findById(squadid);
		this.cid = new ExamDaoImpl().findById(cid);
		this.remark = remark;
	}
	//生成的setter和getter方法
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public Squad getSquadid() {
		return squadid;
	}
	public void setSquadid(int squadid) {
		this.squadid = new SquadDaoImpl().findById(squadid);
	}
	public Exam getcid() {
		return cid;
	}
	public void setcid(int cid) {
		this.cid = new ExamDaoImpl().findById(cid);
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
