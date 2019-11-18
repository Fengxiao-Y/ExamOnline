package com.yidu.victory.student.dao;

import java.util.List;
import com.yidu.victory.student.domain.Announce;

public interface AnnounceDao {
	/**
	 * ���
	 * @param announse
	 * @return
	 */
	public int add(Announce announse);
	/**
	 * ɾ��
	 * @param aid
	 * @return
	 */
	public int delete (int aid);
	/**
	 * ����
	 * @param announse
	 * @return
	 */
	public int update(Announce announse);
	/**
	 * ��ѯ����
	 * @param aid
	 * @return
	 */
	public Announce findById(int aid); 
	/**
	 * ��ѯ����
	 * @return
	 */
	public List<Announce> findAll();
	/**
	 * ��ҳ��ѯ
	 * @param rows
	 * @param page
	 * @return
	 */
	public List<Announce> findByPage(int rows,int page);
	/**
	 * �����ݿ���а��ض��������з�ҳ��������
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Announce> findByPage(int rows,int page,String condition);
	/**
	 * ͳ�����ݿ����������
	 * @return
	 */
	public int count();
	/**
	 * ͳ�����ݿ���з��� ������������
	 * @param condition
	 * @return
	 */
	public int count(String condition);
}
