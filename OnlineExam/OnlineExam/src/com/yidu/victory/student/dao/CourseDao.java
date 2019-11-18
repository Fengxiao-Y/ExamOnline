package com.yidu.victory.student.dao;

import java.util.List;
/**
 * course表的数据层接口
 */

import com.yidu.victory.student.domain.Course;



public interface CourseDao {
	/**
	 * course表的增加方法
	 * @param course 实体类对象
	 * @return 影响行数
	 */
	public int add(Course course);
	/**
	 * course表的删除方法
	 * @param
	 * @return 影响行数
	 */
	public int delete(int cid);
	/**
	 * courset表的修改方法
	 * @param course 实体类对象
	 * @return 影响行数
	 */
	public int update(Course course);
	/**
	 * course表的查询单个方法
	 * @param cid 主键
	 * @return 实体类对象
	 */
	public Course findById(String cid);
	/**
	 * course表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Course> findAll(int rows,int page,String condition);
	/**
	 * courset表查询记录总数
	 * @param condition 条件
	 * @return 记录总数
	 */
	public int count(String condition);
	public List<Course> findAll();
	public Course findAll(String condition);
	
}
