/**
 * 
 */
package com.yidu.victory.excle.domain;

import java.io.Serializable;

/**
 * ���ݣ�Conditions��ʵ����
 * ���� tzh
 * ��д����:����6:33:35
 * �汾1.0
 */
public class Conditions implements Serializable {
	/**
	 * @author d280
	 * ��д����:����6:43:09
	 * �汾1.0
	 */
	private static final long serialVersionUID = -2889134158215112525L;
	//������(����)
	private int tid;
	//�Ѷȵȼ�
	private double falsely;
	
	/**
	 *  Ĭ�Ϲ��췽��
	 * @author d280
	 * ��д����:����6:37:18
	 * �汾1.0
	 */
	public Conditions() {
		super();
	}

	/**
	 * ���ι��췽��
	 */
	
	public Conditions(int tid, double falsely) {
		super();
		this.tid = tid;
		this.falsely = falsely;
	}

	/**
	 *   SET  GET ���췽��
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
