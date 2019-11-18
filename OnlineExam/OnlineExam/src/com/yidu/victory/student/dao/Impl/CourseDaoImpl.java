package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.CourseDao;
import com.yidu.victory.student.domain.Course;


public class CourseDaoImpl implements CourseDao {

	@Override
	public int add(Course course) {
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
					String sql="insert into course(cname,stagename) "
							+ " values(?,?)";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					
					pstmt.setString(1, course .getCname());
					pstmt.setString(2, course .getStagename());
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
	public int delete(int cid) {
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
					String sql="delete from course where cid=?";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					pstmt.setInt(1, cid);
					
					//���������󷵻�
					rows=pstmt.executeUpdate();
					System.out.println("ssss"+rows);
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return rows;
			}
	@Override
	public int update(Course course) {
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
			String sql="update course set cname=?,stagename=? where cid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			
			pstmt.setString(1, course.getCname());
			pstmt.setString(2, course.getStagename());
			pstmt.setInt(3, course.getCid());
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
	public Course findById(String cid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Course course=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from course where cid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, cid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				course=new Course();
				//��������ڵ����ݸ���ʵ�������
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return course;
	}

	@Override
	public List<Course> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Course> courselist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from course "+condition+" limit ?,?";
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
				Course course=new Course();
				//��������ڵ����ݸ���ʵ�������
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				courselist.add(course);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return courselist;
	}

	
	public List<Course> findAll() {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Course> courselist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from course ";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//���������󷵻�
			rs=pstmt.executeQuery();
			
			//�жϽ�����Ƿ�Ϊ��
			while(rs.next()){
				//ʵ����ʵ�������
				Course course=new Course();
				//��������ڵ����ݸ���ʵ�������
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				courselist.add(course);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return courselist;
	}
	
	public Course findAll(String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Course course=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from course "+condition;
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//���������󷵻�
			rs=pstmt.executeQuery();
			
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				course=new Course();
				//��������ڵ����ݸ���ʵ�������
				course.setCid(rs.getInt("cid"));
				course.setCname(rs.getString("cname"));
				course.setStagename(rs.getString("stagename"));
				
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return course;
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
			String sql="select count(*) from course "+condition;
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
}