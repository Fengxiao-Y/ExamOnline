package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.TopicbankDao;
import com.yidu.victory.excle.domain.Topicbank;

public class TopicbankDaoImpl implements TopicbankDao {

	@Override
	public int add(Topicbank topicbank) {
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
			String sql="insert into topicbank(testtype,aresult,bresult, "
					+ " cresult,dresult,eresult,fresult,rightsult,content,grade,falsely, "
					+ " cname,stagename) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, topicbank.getTesttype());
			pstmt.setString(2, topicbank.getAresult());
			pstmt.setString(3, topicbank.getBresult());
			pstmt.setString(4, topicbank.getCresult());
			pstmt.setString(5, topicbank.getDresult());
			pstmt.setString(6, topicbank.getEresult());
			pstmt.setString(7, topicbank.getFresult());
			pstmt.setString(8, topicbank.getRightsult());
			pstmt.setString(9, topicbank.getContent());
			pstmt.setString(10, topicbank.getGrade());
			pstmt.setDouble(11,0);
			pstmt.setString(12, topicbank.getCname());
			pstmt.setString(13, topicbank.getStagename());
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
	public int delete(int testid) {
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
			String sql="delete from topicbank where testid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1,testid);
			
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
	public int update(Topicbank topicbank) {
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
			String sql="update topicbank set testtype=?,aresult=?,bresult=?,cresult=?,"
					+ "dresult=?,eresult=?,fresult=?,rightsult=?,content=?,grade=?,falsely=?,cname=?,"
					+ "stagename=? where testid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setString(1, topicbank.getTesttype());
			pstmt.setString(2, topicbank.getAresult());
			pstmt.setString(3, topicbank.getBresult());
			pstmt.setString(4, topicbank.getCresult());
			pstmt.setString(5, topicbank.getDresult());
			pstmt.setString(6, topicbank.getEresult());
			pstmt.setString(7, topicbank.getFresult());
			pstmt.setString(8, topicbank.getRightsult());
			pstmt.setString(9, topicbank.getContent());
			pstmt.setString(10, topicbank.getGrade());
			pstmt.setDouble(11, topicbank.getFalsely());
			pstmt.setString(12, topicbank.getCname());
			pstmt.setString(13, topicbank.getStagename());
			pstmt.setInt(14, topicbank.getTestid());
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
	public Topicbank findById(int testid) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		Topicbank topicbank=null;
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="select * from topicbank where testid=?";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ
			pstmt.setInt(1, testid);
			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			if(rs.next()){
				//ʵ����ʵ�������
				topicbank=new Topicbank();
				//��������ڵ����ݸ���ʵ�������
				topicbank.setTestid(rs.getInt("testid"));
				topicbank.setTesttype(rs.getString("testtype"));
				topicbank.setAresult(rs.getString("aresult"));
				topicbank.setBresult(rs.getString("bresult"));
				topicbank.setCresult(rs.getString("cresult"));
				topicbank.setDresult(rs.getString("dresult"));
				topicbank.setEresult(rs.getString("eresult"));
				topicbank.setFresult(rs.getString("fresult"));
				topicbank.setRightsult(rs.getString("rightsult"));
				topicbank.setContent(rs.getString("content"));
				topicbank.setGrade(rs.getString("grade"));
				topicbank.setFalsely(rs.getDouble("falsely"));
				topicbank.setCname(rs.getString("cname"));
				topicbank.setStagename(rs.getString("stagename"));
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
			return topicbank;
	}

	@Override
	public List<Topicbank> findAll(int rows, int page, String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Topicbank> topicbanklist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult, " 
					+" fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename "
					+" FROM topicbank T "
					+" JOIN difficulty D ,conditions C"
					+" WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid  "+condition+" limit ?,?";
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
				Topicbank topicbank=new Topicbank();
				//��������ڵ����ݸ���ʵ�������
				topicbank.setTestid(rs.getInt("testid"));
				topicbank.setTesttype(rs.getString("testtype"));
				topicbank.setAresult(rs.getString("aresult"));
				topicbank.setBresult(rs.getString("bresult"));
				topicbank.setCresult(rs.getString("cresult"));
				topicbank.setDresult(rs.getString("dresult"));
				topicbank.setEresult(rs.getString("eresult"));
				topicbank.setFresult(rs.getString("fresult"));
				topicbank.setRightsult(rs.getString("rightsult"));
				topicbank.setContent(rs.getString("content"));
				topicbank.setGrade(rs.getString("grade"));
				topicbank.setFalsely(rs.getDouble("falsely"));
				topicbank.setCname(rs.getString("cname"));
				topicbank.setStagename(rs.getString("stagename"));
				topicbanklist.add(topicbank);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return topicbanklist;
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
			String sql="select count(*) from topicbank where 1=1 "+condition;
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
	public int findlast() {
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
			String sql="select max(testid) from topicbank";
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//���������󷵻�
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
	public List<Topicbank> findCondition(String condition) {
		//�������ݿ����Ӷ���
				Connection conn=null;
				//�������ݿ�������
				PreparedStatement pstmt=null;
				//�������������
				ResultSet rs=null;
				//��������
				List<Topicbank> topicbanklist=new ArrayList<>();
				try {
					//ʵ�������ݿ����Ӷ���
					conn=JdbcUtils.getConnection();
					//����SQLִ�����
					String sql="SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult, " 
							+" fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename "
							+" FROM topicbank T "
							+" JOIN difficulty D ,conditions C"
							+" WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid  "+condition+" order by C.falsely desc";
					//ʵ����������
					pstmt=conn.prepareStatement(sql);
					//��SQL��丳ֵ

					//���������󷵻�
					rs=pstmt.executeQuery();
					//�жϽ�����Ƿ�Ϊ��
					while(rs.next()){
						//ʵ����ʵ�������
						Topicbank topicbank=new Topicbank();
						//��������ڵ����ݸ���ʵ�������
						topicbank.setTestid(rs.getInt("testid"));
						topicbank.setTesttype(rs.getString("testtype"));
						topicbank.setAresult(rs.getString("aresult"));
						topicbank.setBresult(rs.getString("bresult"));
						topicbank.setCresult(rs.getString("cresult"));
						topicbank.setDresult(rs.getString("dresult"));
						topicbank.setEresult(rs.getString("eresult"));
						topicbank.setFresult(rs.getString("fresult"));
						topicbank.setRightsult(rs.getString("rightsult"));
						topicbank.setContent(rs.getString("content"));
						topicbank.setGrade(rs.getString("grade"));
						topicbank.setFalsely(rs.getDouble("falsely"));
						topicbank.setCname(rs.getString("cname"));
						topicbank.setStagename(rs.getString("stagename"));
						topicbanklist.add(topicbank);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return topicbanklist;
	}

	@Override
	public List<Topicbank> findall(String condition) {
		//�������ݿ����Ӷ���
		Connection conn=null;
		//�������ݿ�������
		PreparedStatement pstmt=null;
		//�������������
		ResultSet rs=null;
		//��������
		List<Topicbank> topicbanklist=new ArrayList<>();
		try {
			//ʵ�������ݿ����Ӷ���
			conn=JdbcUtils.getConnection();
			//����SQLִ�����
			String sql="SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult, " 
					+" fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename "
					+" FROM topicbank T "
					+" JOIN difficulty D ,conditions C"
					+" WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid  "+condition;
			//ʵ����������
			pstmt=conn.prepareStatement(sql);
			//��SQL��丳ֵ

			//���������󷵻�
			rs=pstmt.executeQuery();
			//�жϽ�����Ƿ�Ϊ��
			while(rs.next()){
				//ʵ����ʵ�������
				Topicbank topicbank=new Topicbank();
				//��������ڵ����ݸ���ʵ�������
				topicbank.setTestid(rs.getInt("testid"));
				topicbank.setTesttype(rs.getString("testtype"));
				topicbank.setAresult(rs.getString("aresult"));
				topicbank.setBresult(rs.getString("bresult"));
				topicbank.setCresult(rs.getString("cresult"));
				topicbank.setDresult(rs.getString("dresult"));
				topicbank.setEresult(rs.getString("eresult"));
				topicbank.setFresult(rs.getString("fresult"));
				topicbank.setRightsult(rs.getString("rightsult"));
				topicbank.setContent(rs.getString("content"));
				topicbank.setGrade(rs.getString("grade"));
				topicbank.setFalsely(rs.getDouble("falsely"));
				topicbank.setCname(rs.getString("cname"));
				topicbank.setStagename(rs.getString("stagename"));
				topicbanklist.add(topicbank);
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return topicbanklist;
	}

}
