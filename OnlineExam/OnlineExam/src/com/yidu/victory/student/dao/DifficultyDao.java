package com.yidu.victory.student.dao;

import java.util.List;
/**
 * difficulty�����ݲ�ӿ�
 */

import com.yidu.victory.student.domain.Difficulty;



public interface DifficultyDao {
	/**
	 * difficulty������ӷ���
	 * @param adifficulty ʵ�������
	 * @return Ӱ������
	 */
	public int add(Difficulty difficulty);
	/**
	 * difficulty���ɾ������
	 * @param
	 * @return Ӱ������
	 */
	public int delete(int tid);
	/**
	 * difficulty����޸ķ���
	 * @param difficulty ʵ�������
	 * @return Ӱ������
	 */
	public int update(Difficulty difficulty);
	/**
	 * difficulty��Ĳ�ѯ��������
	 * @param tid ����
	 * @return ʵ�������
	 */
	public Difficulty findById(int tid);
	/**
	 * difficulty���ѯ���з���
	 * @param rows ����
	 * @param page ҳ��
	 * @param condition ����
	 * @return ʵ������󼯺�
	 */
	public List<Difficulty> findAll(int rows,int page,String condition);
	/**
	 * difficulty���ѯ��¼����
	 * @param difficulty ����
	 * @return ��¼����
	 */
	public int count(String condition);
}
