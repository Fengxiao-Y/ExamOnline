package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.TeacherDao;
import com.yidu.victory.student.domain.Student;
import com.yidu.victory.student.domain.Teacher;

public class TeacherDaoImpl implements TeacherDao {

	@Override
	public int add(Teacher teacher) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		int rows=0;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="insert into teacher(tid,tname,"
					+ "sex,age,phone,"
					+ "penguin,address,situation)"
					+ " values(?,?,?,?,?,?,?,?)";

			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, teacher.getTid());
			pstmt.setString(2, teacher.getTname() );
			pstmt.setString(3, teacher.getSex());
			pstmt.setInt(4, teacher.getAge() );
			pstmt.setString(5, teacher.getPhone());
			pstmt.setInt(6, teacher.getPenguin());
			pstmt.setString(7, teacher.getAddress());
			pstmt.setString(8, teacher.getSituation());
			//���������󷵻�
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public int delete(String tid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		int rows=0;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="delete from teacher where tid=?";
			pstmt=conn.prepareStatement(sql);
			//ʵ����������
			pstmt.setString(1,tid);
			//���������󷵻�
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public int update(Teacher teacher) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		int rows=0;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="update teacher set tname=?,sex=?,age=?,phone=?,penguin=?,"

					+ "address=?,situation=? where tid=?";

			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, teacher.getTname() );
			pstmt.setString(2, teacher.getSex());
			pstmt.setInt(3, teacher.getAge() );
			pstmt.setString(4, teacher.getPhone());
			pstmt.setInt(5, teacher.getPenguin());
			pstmt.setString(6, teacher.getAddress());
			pstmt.setString(7, teacher.getSituation());
			pstmt.setString(8, teacher.getTid());
			//���������󷵻�
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;

	}

	@Override
	public Teacher findById(String tid) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				Teacher teacher=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from teacher where tid=?";

					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setString(1, tid);
					//���������󷵻�
					rs=pstmt.executeQuery();
					if(rs.next()){
						//ʵ����ʵ�������
						teacher=new Teacher();
						//��������ڵ����ݸ���ʵ�������
						teacher.setTid(rs.getString("tid"));
						teacher.setTname(rs.getString("tname"));
						teacher.setSex(rs.getString("sex"));
						teacher.setAge(rs.getInt("age"));
						teacher.setPhone(rs.getString("phone"));
						teacher.setPenguin(rs.getInt("penguin"));
						teacher.setAddress(rs.getString("address"));
						teacher.setSituation(rs.getString("situation"));

					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return teacher;
	}

	@Override
	public List<Teacher> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Teacher> teacherlist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from teacher "+condition+" limit ?,?";

					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setInt(1, (page-1)*rows);
					pstmt.setInt(2, rows);
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						Teacher teacher=new Teacher();
						//��������ڵ����ݸ���ʵ�������
						teacher.setTid(rs.getString("tid"));
						teacher.setTname(rs.getString("tname"));
						teacher.setSex(rs.getString("sex"));
						teacher.setAge(rs.getInt("age"));
						teacher.setPhone(rs.getString("phone"));
						teacher.setPenguin(rs.getInt("penguin"));
						teacher.setAddress(rs.getString("address"));
						teacher.setSituation(rs.getString("situation"));
						
						teacherlist.add(teacher);
						
					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
		return teacherlist;
	}

	@Override
	public int count(String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		int rows=0;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select count(*) from teacher "+condition;
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ

			//���������󷵻�
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public List<Teacher> findAll() {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Teacher> teacherlist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from teacher ";

			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ

			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			while(rs.next()){
				//ʵ����ʵ�������
				Teacher teacher=new Teacher();
				//��������ڵ����ݸ���ʵ�������
				teacher.setTid(rs.getString("tid"));
				teacher.setTname(rs.getString("tname"));
				teacher.setSex(rs.getString("sex"));
				teacher.setAge(rs.getInt("age"));
				teacher.setPhone(rs.getString("phone"));
				teacher.setPenguin(rs.getInt("penguin"));
				teacher.setAddress(rs.getString("address"));
				teacher.setSituation(rs.getString("situation"));
				
				teacherlist.add(teacher);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
return teacherlist;
	}

}
