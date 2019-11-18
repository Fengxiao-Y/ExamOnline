package com.yidu.victory.student.dao;

import java.util.List;

import com.yidu.victory.student.domain.Student;

/**
 * Student表的数据层接口
 * @author tang
 *
 */
public interface StudentDao {
	/**
	 * student表的增加方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int add(Student student);
	/**
	 * student表的删除方法
	 * @param sid 主键
	 * @return 影响行数
	 */
	public int delete(String sid);
	/**
	 * student表的修改方法
	 * @param student 实体类对象
	 * @return 影响行数
	 */
	public int update(Student student);
	/**
	 * student表的查询单个方法
	 * @param sid 主键
	 * @return 实体类对象
	 */
	public Student findById(String sid);
	/**
	 * student表查询所有方法
	 * @param rows 行数
	 * @param page 页码
	 * @param condition 条件
	 * @return 实体类对象集合
	 */
	public List<Student> findAll(int rows,int page,String condition);
	/**
	 * Student表查询记录总数
	 * @param condition 条件
	 * @return 记录总数
	 */
	public int count(String condition);
	public List<Student> findAll(String condition);
}
