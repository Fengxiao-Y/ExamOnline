package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.TestPaper;

/**
 * TestPaper表的实数据层接口
 * @author asus
 *
 */
public interface TestPaperDao {
	/**
	 * TestPaper表的增加方法
	 * @param testPaper
	 * @return
	 */
	public int add(TestPaper testPaper);
	
	/**
	 * TestPaper表的删除方法
	 * @param cid
	 * @return
	 */
	public int delete(int cid);
	
	/**
	 * TestPaper表的修改方法
	 * @param testPaper
	 * @return
	 */
	public int update(TestPaper testPaper);
	
	/**
	 * TestPaper表查询单个方法
	 * @param cid
	 * @return
	 */
	public TestPaper findById(int cid);
	/**
	 * TestPaper 表查询所有方法
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<TestPaper> findAll(int rows,int page,String condition);
	
	/**
	 * TestPaper表查询记录总数
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	public int max();
	public List<TestPaper> findAll();
	public TestPaper findAll(String condition);
}
