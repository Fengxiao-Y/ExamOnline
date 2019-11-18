/**
 * 
 */
package com.yidu.victory.student.dao;

import java.util.List;

import com.yidu.victory.student.domain.Makeuptable;

/**
 * ���ݣ�Makeuptable������ݲ�ӿ�
 * ���� tzh
 * ��д����:����7:40:45
 * �汾1.0
 */
public interface MakeuptableDao {
	/**
	 * Makeuptable������ӷ���
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int add(Makeuptable makeuptable);
	
	/**
	 * Makeuptable���ɾ������
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int delete(int sid);
	
	/**
	 * Makeuptable����޸ķ���
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int update(Makeuptable makeuptable);
	/**
	 * Makeuptable��Ĳ�ѯ��������
	 * @param sid ����
	 * @return ʵ�������
	 */
	public Makeuptable findById(String sid);
	/**
	 * Makeuptable���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Makeuptable> findAll(int rows,int page,String condition);
	/**
	 * Makeuptable���ѯ��¼����
	 * @param condition ����
	 * @return ��¼����
	 */
	public int count(String condition);
}
