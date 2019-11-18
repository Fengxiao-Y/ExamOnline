package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.TestPaper;

/**
 * TestPaper���ʵ���ݲ�ӿ�
 * @author asus
 *
 */
public interface TestPaperDao {
	/**
	 * TestPaper������ӷ���
	 * @param testPaper
	 * @return
	 */
	public int add(TestPaper testPaper);
	
	/**
	 * TestPaper���ɾ������
	 * @param cid
	 * @return
	 */
	public int delete(int cid);
	
	/**
	 * TestPaper����޸ķ���
	 * @param testPaper
	 * @return
	 */
	public int update(TestPaper testPaper);
	
	/**
	 * TestPaper���ѯ��������
	 * @param cid
	 * @return
	 */
	public TestPaper findById(int cid);
	/**
	 * TestPaper ���ѯ���з���
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<TestPaper> findAll(int rows,int page,String condition);
	
	/**
	 * TestPaper���ѯ��¼����
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	public int max();
	public List<TestPaper> findAll();
	public TestPaper findAll(String condition);
}
