/**
 * 
 */
package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * 内容：Conditions表实体类
 * 作者 tzh
 * 编写日期:下午6:33:35
 * 版本1.0
 */
public class Conditions implements Serializable {
	/**
	 * @author d280
	 * 编写日期:下午6:43:09
	 * 版本1.0
	 */
	private static final long serialVersionUID = -2889134158215112525L;
	//试题编号(主键)
	private int tid;
	//难度等级
	private double falsely;
	
	/**
	 *  默认构造方法
	 * @author d280
	 * 编写日期:下午6:37:18
	 * 版本1.0
	 */
	public Conditions() {
		super();
	}

	/**
	 * 带参构造方法
	 */
	
	public Conditions(int tid, double falsely) {
		super();
		this.tid = tid;
		this.falsely = falsely;
	}

	/**
	 *   SET  GET 构造方法
	 * @return the tid
	 */
	public int getTid() {
		return tid;
	}

	/**
	 * @param tid the tid to set
	 */
	public void setTid(int tid) {
		this.tid = tid;
	}

	/**
	 * @return the falsely
	 */
	public double getFalsely() {
		return falsely;
	}

	/**
	 * @param falsely the falsely to set
	 */
	public void setFalsely(double falsely) {
		this.falsely = falsely;
	}
	
	
	
	
}
