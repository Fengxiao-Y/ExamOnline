/**
 * 
 */
package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Conditions;

/**
 * Student������ݲ�ӿ�
 * @author tzg
 *
 */
public interface ConditionsDao {
	/**
	 * Conditions������ӷ���
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int add(Conditions conditions);
	/**
	 * Conditions���ɾ������
	 * @param sid ����
	 * @return Ӱ������
	 */
	public int delete(int tid);
	/**
	 * Conditions����޸ķ���
	 * @param student ʵ�������
	 * @return Ӱ������
	 */
	public int update(Conditions conditions);
	
	/**
	 * Conditions��Ĳ�ѯ��������
	 * @param sid ����
	 * @return ʵ�������
	 */
	public Conditions findById(int tid);
	/**
	 * Conditions���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Conditions> findAll(int rows,int page,String condition);
	/**
	 * Conditions���ѯ��¼����
	 * @param condition ����
	 * @return ��¼����
	 */
	public int count(String condition);
}
