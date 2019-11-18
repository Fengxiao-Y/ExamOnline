package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Topicbank;

/**
 * Topicbank表的数据层接口
 * @author asus
 *
 */
public interface TopicbankDao {
	/**
	 * Topicbank表的增加方法
	 * @param topicbank
	 * @return
	 */
	public int add(Topicbank topicbank);
	/**
	 * Topicbank表的删除方法
	 * @param testid
	 * @return
	 */
	public int delete(int testid);
	
	/**
	 * Topicbank表的修改方法
	 * @param topicbank
	 * @return
	 */
	public int update(Topicbank topicbank);
	
	/**
	 * Topicbank 表的查询单个方法
	 * @param testid
	 * @return
	 */
	public Topicbank findById(int testid);
	
	/**
	 * Topicbank表的查询所有方法
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Topicbank> findAll(int rows,int page,String condition);
	
	/**
	 * Topicbank表查询记录总数
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	/**
	 * 查找最后一个数据的主键
	 */
	public int findlast();
	public List<Topicbank> findCondition(String condition);
	public List<Topicbank> findall(String condition);
}
