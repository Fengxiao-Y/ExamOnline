package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.TestPaperTopic;

/**
 * testPaperTopic表的数据层接口
 * @author asus
 *
 */
public interface TestPaperTopicDao {
	/**
	 * testPaperTopic 表的增加方法
	 * @param testPaperTopic
	 * @return
	 */
	public int add(TestPaperTopic testPaperTopic );
	
	/**
	 * testPaperTopic 表的删除方法
	 * @param tid
	 * @return
	 */
	public int delete(int testpaperid);
	
	/**
	 * testPaperTopic 表的修改方法
	 * @param testPaperTopic
	 * @return
	 */
	public int update(TestPaperTopic testPaperTopic);
	
	/**
	 * testPaperTopic 表的查询单个方法
	 * @param tid
	 * @return
	 */
	public TestPaperTopic findById(int tid); 
	
	/**
	 * testPaperTopic 表的查询所有方法
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<TestPaperTopic> findAll(int rows,int page,String condition);
	
	/**
	 * testPaperTopic 表的查询记录总数
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	public List<TestPaperTopic> findall(String condition);
}
