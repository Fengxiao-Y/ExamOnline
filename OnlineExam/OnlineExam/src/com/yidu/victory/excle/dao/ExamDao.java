package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Exam;

/**
 * Exam表的数据层接口
 * @author asus
 *
 */
public interface ExamDao {
	/**
	 * Exam表的增加方法
	 * @param eid
	 * @return
	 */
	public int add(Exam exam);
	/**
	 * Exam表的删除方法
	 * @param eid
	 * @return
	 */
	public int delete(int eid);
	
	/**
	 * Exam表的修改方法
	 * @param exam
	 * @return
	 */
	public int update(Exam exam);
	
	/**
	 * Exam表的查询单个方法
	 * @param eid
	 * @return
	 */
	public Exam findById(int eid);
	
	/**
	 * Exam表的查询所有方法
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Exam> findAll(int rows,int page, String condition);
	
	/**
	 * Exam表查询记录总数
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	public List<Exam> findAll();
	public Exam findbycondition(String condition);
}
