package com.yidu.victory.excle.dao;

import java.util.List;

import com.yidu.victory.excle.domain.Exam;

/**
 * Exam������ݲ�ӿ�
 * @author asus
 *
 */
public interface ExamDao {
	/**
	 * Exam������ӷ���
	 * @param eid
	 * @return
	 */
	public int add(Exam exam);
	/**
	 * Exam���ɾ������
	 * @param eid
	 * @return
	 */
	public int delete(int eid);
	
	/**
	 * Exam����޸ķ���
	 * @param exam
	 * @return
	 */
	public int update(Exam exam);
	
	/**
	 * Exam��Ĳ�ѯ��������
	 * @param eid
	 * @return
	 */
	public Exam findById(int eid);
	
	/**
	 * Exam��Ĳ�ѯ���з���
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Exam> findAll(int rows,int page, String condition);
	
	/**
	 * Exam���ѯ��¼����
	 * @param condition
	 * @return
	 */
	public int count(String condition);
	public List<Exam> findAll();
	public Exam findbycondition(String condition);
}
