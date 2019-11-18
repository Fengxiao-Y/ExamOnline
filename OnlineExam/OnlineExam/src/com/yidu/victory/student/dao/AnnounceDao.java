package com.yidu.victory.student.dao;

import java.util.List;
import com.yidu.victory.student.domain.Announce;

public interface AnnounceDao {
	/**
	 * 添加
	 * @param announse
	 * @return
	 */
	public int add(Announce announse);
	/**
	 * 删除
	 * @param aid
	 * @return
	 */
	public int delete (int aid);
	/**
	 * 更新
	 * @param announse
	 * @return
	 */
	public int update(Announce announse);
	/**
	 * 查询单个
	 * @param aid
	 * @return
	 */
	public Announce findById(int aid); 
	/**
	 * 查询所有
	 * @return
	 */
	public List<Announce> findAll();
	/**
	 * 分页查询
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<Announce> findByPage(int rows,int page);
	/**
	 * 从数据库表中按特定条件进行分页查找数据
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Announce> findByPage(int rows,int page,String condition);
	/**
	 * 统计数据库表中总行数
	 * @return
	 */
	public int count();
	/**
	 * 统计数据库表中符合 条件的总行数
	 * @param condition
	 * @return
	 */
	public int count(String condition);
}
