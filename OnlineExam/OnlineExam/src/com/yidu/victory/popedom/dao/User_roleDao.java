package com.yidu.victory.popedom.dao;

import java.util.List;

import com.yidu.victory.popedom.domain.User_role;

public interface User_roleDao {
	/**
	 * ��ӷ���
	 * @param user_role ����
	 * @return 
	 */
	public int add(User_role user_role);
	public int update(User_role user_role);
	
	/**
	 * ɾ��
	 * @param unumber
	 * @return
	 */
	public int delete(String unumber);
	/**
	 * ��ѯ����
	 * @return ���ض��� 
	 */
	public List<User_role> findByPage(int rows,int page);
	/**
	 * ��������ѯ
	 * 
	 * @param rows
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<User_role> findByPage(int rows,int page,String condition);
	//�鵥������
	public User_role findById(String unumber);
}
	
