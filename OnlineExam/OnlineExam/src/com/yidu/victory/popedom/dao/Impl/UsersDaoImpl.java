package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.UsersDao;
import com.yidu.victory.popedom.domain.Users;


public class UsersDaoImpl implements UsersDao {

	@Override
	public int add(Users user) {
		//����Ӱ�������ı���
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="insert into users(unumber,passwords)"
					+ "values(?,?)";
			//ͨ�����Ӷ���ʵ����������
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUnumber());
			pstmt.setString(2, user.getPasswords());
			//ִ�в�����Ӱ�������
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(null, pstmt, conn);
		}
		//����
		return rows;
	}

	@Override
	public int delete(int uid) {
		//����Ӱ�������ı���
		int rows=0;
		//�������Ӷ���
		Connection conn=null;
		//�������Ӷ���
		PreparedStatement pstmt=null;
		try {
			//ʵ�������Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="delete from users where uid=?";
			//ʵ�������Ӷ���
			pstmt=conn.prepareStatement(sql);
			//��������ֵ
			pstmt.setInt(1, uid);
			//ִ�в�����
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(null, pstmt, conn);
		}
		//����rows
		return rows;
	}

	@Override
	public int update(Users user) {
		//����Ӱ�����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="update users set unumber=?,passwords=? "
					+ "where uid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//ͨ��������ֵ
			pstmt.setString(1, user.getUnumber());
			pstmt.setString(2, user.getPasswords());
			pstmt.setInt(3, user.getUid());
			//ִ�в�����
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(null, pstmt, conn);
		}
		//����rows
		return rows;
	}

	@Override
	public Users findById(String unumber) {
		//����Users����
		Users user=null;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select * from users where unumber=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��sql���Ĳ�����ֵ
			pstmt.setString(1, unumber);
			//ִ�в����ؽ����
			rs=pstmt.executeQuery();
			//�ж�
			if(rs.next()){
				user=new Users();
				//����������Ը�ֵ
				user.setUid(rs.getInt("uid"));
				user.setUnumber(rs.getString("unumber"));
				user.setPasswords(rs.getString("passwords"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(rs, pstmt, conn);
		}
		
		//�����û�����
		return user;
	}

	@Override
	public List<Users> findByPage(int rows, int page) {
		//����list����
		List<Users> userList=new ArrayList<Users>();
		//�������Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ��������Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select * from users limit ?,?";
			//ʵ��������Ϸ�Ǹ�
			pstmt=conn.prepareStatement(sql);
			//��sql����еĲ�����ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//ִ�в����ؽ����
			rs=pstmt.executeQuery();
			//whileѭ���ж�
			while(rs.next()){
				Users user=new Users();
				//���û���������Ը�ֵ
				user.setUid(rs.getInt("uid"));
				user.setUnumber(rs.getString("unumber"));
				user.setPasswords(rs.getString("passwords"));
				//��user������ӵ�������
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����list����
		return userList;
	}

	@Override
	public List<Users> findByPage(int rows, int page, String condition) {
		//����list����
		List<Users> userList=new ArrayList<Users>();
		//�����������Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select * from users "+condition+" limit ?,? ";
			//ͨ�����Ӷ���ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��sql����еĲ�����ֵ
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//ִ�в����ؽ����
			rs=pstmt.executeQuery();
			//ѭ���ж�
			while(rs.next()){
				Users user=new Users();
				//���û���������Ը�ֵ
				user.setUid(rs.getInt("uid"));
				user.setUnumber(rs.getString("unumber"));
				user.setPasswords(rs.getString("passwords"));
				//��user������ӵ�������ȥ
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����list����
		return userList;
	}

	@Override
	public int count() {
		//����Ӱ�����������
		int rows=0;
		//�������ݿ����Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select count(*) from users ";
			//ͨ�����Ӷ���ʵ����������
			pstmt=conn.prepareStatement(sql);
			//ִ�в�����
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public int count(String condition) {
		//����Ӱ�������ı���
		int rows=0;
		//�����ݿ����Ӷ���
		Connection conn=null;
		//����������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����sql���
			String sql="select count(*) from users "+condition;
			//ͨ�����Ӷ���ʵ����������
			pstmt=conn.prepareStatement(sql);
			//ִ�в�����
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//�ر���Դ
			JdbcUtils.close(rs, pstmt, conn);
		}
		//����
		return rows;
	}

	@Override
	public Users findById(int uid) {
		//����Users����
				Users user=null;
				//�������ݿ����Ӷ���
				Connection conn=null;
				//����������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����sql���
					String sql="select * from users where uid=?";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��sql���Ĳ�����ֵ
					pstmt.setInt(1, uid);
					//ִ�в����ؽ����
					rs=pstmt.executeQuery();
					//�ж�
					if(rs.next()){
						user=new Users();
						//����������Ը�ֵ
						user.setUid(rs.getInt("uid"));
						user.setUnumber(rs.getString("unumber"));
						user.setPasswords(rs.getString("passwords"));
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage(),e);
				} finally{
					//�ر���Դ
					JdbcUtils.close(rs, pstmt, conn);
				}
				
				//�����û�����
				return user;
	}

	
}
