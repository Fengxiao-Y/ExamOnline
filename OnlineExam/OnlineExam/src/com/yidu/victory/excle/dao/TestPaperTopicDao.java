package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.TestPaperTopic;

/**
 * testPaperTopic������ݲ�ӿ�
 * @author asus
 *
 */
public interface TestPaperTopicDao {
	/**
	 * testPaperTopic ������ӷ���
	 * @param testPaperTopic
	 * @return
	 */
	public int add(TestPaperTopic testPaperTopic );
	
	/**
	 * testPaperTopic ���ɾ������
	 * @param tid
	 * @return
	 */
	public int delete(int testpaperid);
	
	/**
	 * testPaperTopic ����޸ķ���
	 * @param testPaperTopic
	 * @return
	 */
	public int update(TestPaperTopic testPaperTopic);
	
	/**
	 * testPaperTopic ��Ĳ�ѯ��������
	 * @param tid
	 * @return
	 */
	public TestPaperTopic findById(int tid); 
	
	/**
	 * testPaperTopic ��Ĳ�ѯ���з���
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<TestPaperTopic> findAll(int rows,int page,String condition);
	
	/**
	 * testPaperTopic ��Ĳ�ѯ��¼����
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	public List<TestPaperTopic> findall(String condition);
}
