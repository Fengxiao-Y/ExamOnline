package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Stugrade;

/**
 * Stugrade������ݲ�ӿ�
 * @author asus
 *
 */
public interface StugradeDao {
	/**
	 * Stugrade������ӷ���
	 * @param stugrade
	 * @return
	 */
	public int add(Stugrade stugrade);
	
	/**
	 * Stugrade���ɾ������
	 * @param gid
	 * @return
	 */
	public int delete(int gid);
	
	/**
	 * Stugrade����޸ķ���
	 * @param stugrade
	 * @return
	 */
	public int update(Stugrade stugrade);
	
	/**
	 * Stugrade��Ĳ�ѯ��������
	 * @param gid
	 * @return
	 */
	public Stugrade findById(int gid);
	
	/**
	 * Stugrade��Ĳ�ѯ���з���
	 * @param rows
	 * @param page
	 * @param conditon
	 * @return
	 */
	public List<Stugrade> findAll(int rows,int page,String condition);
	
	/**
	 * Stugrade��Ĳ�ѯ��¼����
	 * @param conditon
	 * @return
	 */
	public int count(String condition);
	public Stugrade findByCondition(String condition);
}
