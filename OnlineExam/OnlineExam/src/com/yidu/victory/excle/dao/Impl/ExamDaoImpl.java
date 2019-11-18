package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.ExamDao;
import com.yidu.victory.excle.domain.Exam;

public class ExamDaoImpl implements ExamDao {

	@Override
	public int add(Exam exam) {
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
			String sql="insert into exam(cid,headline,cname,sqid,examtime, "
					+  " finishtime,againexam) values(?,?,?,?,?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			
			pstmt.setInt(1, exam.getCid());
			pstmt.setString(2, exam.getHeadline());
			pstmt.setString(3, exam.getCname());;
			pstmt.setInt(4, exam.getSqid());
			pstmt.setString(5, exam.getExamtime());
			pstmt.setString(6, exam.getFinishtime());
			pstmt.setString(7, exam.getAgainexam());
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
	public int delete(int eid) {
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
			String sql="delete from exam where eid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, eid);
			
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
	public int update(Exam exam) {
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
			String sql="update exam set cid=?,headline=?,cname=?,sqid=?, "
					+ " examtime=?,finishtime=?,againexam=? where eid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, exam.getCid());
			pstmt.setString(2, exam.getHeadline());
			pstmt.setString(3, exam.getCname());;
			pstmt.setInt(4, exam.getSqid());
			pstmt.setString(5, exam.getExamtime());
			pstmt.setString(6, exam.getFinishtime());
			pstmt.setString(7, exam.getAgainexam());
			pstmt.setInt(8, exam.getEid());
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
	public Exam findById(int eid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Exam exam=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from exam where eid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, eid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				exam=new Exam();
				//��������ڵ����ݸ���ʵ�������
				exam.setEid(rs.getInt("eid"));
				exam.setCid(rs.getInt("cid"));
				exam.setHeadline(rs.getString("headline"));
				exam.setCname(rs.getString("cname"));
				exam.setSid(rs.getInt("sqid"));
				exam.setExamtime(rs.getString("examtime"));
				exam.setFinishtime(rs.getString("finishtime"));
				exam.setAgainexam(rs.getString("againexam"));		
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return exam;
	}

	@Override
	public List<Exam> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Exam> examlist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from exam "+condition+" limit ?,?";
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
				Exam exam=new Exam();
				//��������ڵ����ݸ���ʵ�������
				exam.setEid(rs.getInt("eid"));
				exam.setCid(rs.getInt("cid"));
				exam.setHeadline(rs.getString("headline"));
				exam.setCname(rs.getString("cname"));
				exam.setSid(rs.getInt("sqid"));
				exam.setExamtime(rs.getString("examtime"));
				exam.setFinishtime(rs.getString("finishtime"));
				exam.setAgainexam(rs.getString("againexam"));

				examlist.add(exam);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
			return examlist;
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
			String sql="select count(*) from exam "+condition;
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
	public List<Exam> findAll() {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Exam> examlist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from exam ";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);

					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						Exam exam=new Exam();
						//��������ڵ����ݸ���ʵ�������
						exam.setEid(rs.getInt("eid"));
						exam.setCid(rs.getInt("cid"));
						exam.setHeadline(rs.getString("headline"));
						exam.setCname(rs.getString("cname"));
						exam.setSid(rs.getInt("sqid"));
						exam.setExamtime(rs.getString("examtime"));
						exam.setFinishtime(rs.getString("finishtime"));
						exam.setAgainexam(rs.getString("againexam"));

						examlist.add(exam);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
					return examlist;
	}

	@Override
	public Exam findbycondition(String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				Exam exam=null;
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="select * from exam "+condition;
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ
					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					if(rs.next()){
						//ʵ����ʵ�������
						exam=new Exam();
						//��������ڵ����ݸ���ʵ�������
						exam.setEid(rs.getInt("eid"));
						exam.setCid(rs.getInt("cid"));
						exam.setHeadline(rs.getString("headline"));
						exam.setCname(rs.getString("cname"));
						exam.setSid(rs.getInt("sqid"));
						exam.setExamtime(rs.getString("examtime"));
						exam.setFinishtime(rs.getString("finishtime"));
						exam.setAgainexam(rs.getString("againexam"));		
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return exam;
	}

}
