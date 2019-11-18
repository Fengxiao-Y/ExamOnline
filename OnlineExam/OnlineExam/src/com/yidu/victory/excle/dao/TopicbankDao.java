package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Topicbank;

/**
 * Topicbank������ݲ�ӿ�
 * @author asus
 *
 */
public interface TopicbankDao {
	/**
	 * Topicbank������ӷ���
	 * @param topicbank
	 * @return
	 */
	public int add(Topicbank topicbank);
	/**
	 * Topicbank���ɾ������
	 * @param testid
	 * @return
	 */
	public int delete(int testid);
	
	/**
	 * Topicbank����޸ķ���
	 * @param topicbank
	 * @return
	 */
	public int update(Topicbank topicbank);
	
	/**
	 * Topicbank ��Ĳ�ѯ��������
	 * @param testid
	 * @return
	 */
	public Topicbank findById(int testid);
	
	/**
	 * Topicbank��Ĳ�ѯ���з���
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Topicbank> findAll(int rows,int page,String condition);
	
	/**
	 * Topicbank���ѯ��¼����
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	/**
	 * �������һ�����ݵ�����
	 */
	public int findlast();
	public List<Topicbank> findCondition(String condition);
	public List<Topicbank> findall(String condition);
}
