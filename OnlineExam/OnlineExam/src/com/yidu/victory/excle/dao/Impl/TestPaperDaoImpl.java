package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.TestPaperDao;
import com.yidu.victory.excle.domain.TestPaper;

public class TestPaperDaoImpl implements TestPaperDao {

	@Override
	public int add(TestPaper testPaper) {
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
			String sql="insert into testpaper(cid,headline,courseid,state) "
					+ " values(?,?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, testPaper.getCid());
			pstmt.setString(2, testPaper.getHeadline());
			pstmt.setString(3, testPaper.getCourseid());
			pstmt.setString(4, testPaper.getState());
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
			String sql="delete from testpaper where cid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1,cid);
			
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
	public int update(TestPaper testPaper) {
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
			String sql="update testpaper set headline=?,courseid=?,state=? "
					+ " where cid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, testPaper.getHeadline());
			pstmt.setString(2, testPaper.getCourseid());
			pstmt.setString(3, testPaper.getState());
			pstmt.setInt(4, testPaper.getCid());
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
	public TestPaper findById(int cid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		TestPaper testPaper=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from testpaper where cid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, cid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				testPaper=new TestPaper();
				//��������ڵ����ݸ���ʵ�������
				testPaper.setCid(rs.getInt("cid"));
				testPaper.setHeadline(rs.getString("headline"));
				testPaper.setCourseid(rs.getString("courseid"));
				testPaper.setState(rs.getString("state"));
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
			return testPaper;
	}

	@Override
	public List<TestPaper> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<TestPaper> testPaperlist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from testpaper "+condition+" limit ?,?";
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
				TestPaper testPaper=new TestPaper();
				//��������ڵ����ݸ���ʵ�������
				testPaper.setCid(rs.getInt("cid"));
				testPaper.setHeadline(rs.getString("headline"));
				testPaper.setCourseid(rs.getString("courseid"));
				testPaper.setState(rs.getString("state"));
				testPaperlist.add(testPaper);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return testPaperlist;
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
			String sql="select count(*) from testpaper "+condition;
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
	public int max() {
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
			String sql="select max(cid) from testpaper ";
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
	public List<TestPaper> findAll() {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<TestPaper> testPaperlist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from testpaper ";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);

					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						TestPaper testPaper=new TestPaper();
						//��������ڵ����ݸ���ʵ�������
						testPaper.setCid(rs.getInt("cid"));
						testPaper.setHeadline(rs.getString("headline"));
						testPaper.setCourseid(rs.getString("courseid"));
						testPaper.setState(rs.getString("state"));
						testPaperlist.add(testPaper);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return testPaperlist;
	}

	@Override
	public TestPaper findAll(String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				TestPaper testPaper=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from testpaper "+condition;
					//ʵ����������
					pstmt=conn.prepareStatement(sql);

					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					if(rs.next()){
						//ʵ����ʵ�������
						testPaper=new TestPaper();
						//��������ڵ����ݸ���ʵ�������
						testPaper.setCid(rs.getInt("cid"));
						testPaper.setHeadline(rs.getString("headline"));
						testPaper.setCourseid(rs.getString("courseid"));
						testPaper.setState(rs.getString("state"));
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
					return testPaper;
	}

}
