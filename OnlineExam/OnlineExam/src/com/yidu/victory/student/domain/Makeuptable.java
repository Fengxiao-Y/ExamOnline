
package com.yidu.victory.student.domain;

/**
 * ���ݣ�Makeuptable��ʵ����
 * ���� tzh
 * ��д����:����7:31:43
 * �汾1.0
 */
public class Makeuptable {
	/**
	 * @author d280
	 * ��д����:����7:40:04
	 * �汾1.0
	 */
	private static final long serialVersionUID = 2494130676412390L;
	//ѧ��(����,����ѧ����)
	private int sid;
	//ѧ������
	private String sname;
	//����
	private int grade;
	//�༶���
	private int squadid;
	//���Ա��
	private int eid;
	//״̬
	private String conditions;
	/**
	 * Ĭ�Ϲ��췽��
	 */
	/**
	 * @author d280
	 * ��д����:����8:57:11
	 * �汾1.0
	 */
	public Makeuptable() {
		super();
	}
	/**
	 *���ι��췽��
	 * @author d280
	 * ��д����:����7:38:05
	 * �汾1.0
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
	 * SET GET  ���췽��
	 * @return the sid
	 */
}
