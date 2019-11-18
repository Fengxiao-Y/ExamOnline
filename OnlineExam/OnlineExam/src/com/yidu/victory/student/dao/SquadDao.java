package com.yidu.victory.student.dao;

import java.util.List;
/**
 * squad������ݲ�ӿ�
 */

import com.yidu.victory.student.domain.Squad;


public interface SquadDao {
	/**
	 * squad������ӷ���
	 * @param squadt ʵ�������
	 * @return Ӱ������
	 */
	public int add(Squad squad);
	/**
	 * squad���ɾ������
	 * @param sid ����
	 * @return Ӱ������
	 */
	public int delete(int sqid);
	/**
	 * squad����޸ķ���
	 * @param squad ʵ�������
	 * @return Ӱ������
	 */
	public int update(Squad squad);
	/**
	 * squad��Ĳ�ѯ��������
	 * @param sid ����
	 * @return ʵ�������
	 */
	public Squad findById(int sqid);
	/**
	 * squad���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Squad> findAll(int rows,int page,String condition);
	/**
	 * squad���ѯ��¼����
	 * @param condition ����
	 * @return ��¼����
	 */
	public int count(String condition);
	public List<Squad> findAll();
}
