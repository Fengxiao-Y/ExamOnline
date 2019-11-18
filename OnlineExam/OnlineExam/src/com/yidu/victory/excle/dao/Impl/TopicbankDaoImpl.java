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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="insert into topicbank(testtype,aresult,bresult, "
					+ " cresult,dresult,eresult,fresult,rightsult,content,grade,falsely, "
					+ " cname,stagename) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
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
			//调用语句对象返回
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="delete from topicbank where testid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1,testid);
			
			//调用语句对象返回
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="update topicbank set testtype=?,aresult=?,bresult=?,cresult=?,"
					+ "dresult=?,eresult=?,fresult=?,rightsult=?,content=?,grade=?,falsely=?,cname=?,"
					+ "stagename=? where testid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
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
			//调用语句对象返回
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Topicbank topicbank=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from topicbank where testid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, testid);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				topicbank=new Topicbank();
				//将结果集内的数据赋给实体类对象
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Topicbank> topicbanklist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult, " 
					+" fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename "
					+" FROM topicbank T "
					+" JOIN difficulty D ,conditions C"
					+" WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid  "+condition+" limit ?,?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			while(rs.next()){
				//实例化实体类对象
				Topicbank topicbank=new Topicbank();
				//将结果集内的数据赋给实体类对象
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select count(*) from topicbank where 1=1 "+condition;
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			//调用语句对象返回
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select max(testid) from topicbank";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			//调用语句对象返回
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
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Topicbank> topicbanklist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult, " 
							+" fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename "
							+" FROM topicbank T "
							+" JOIN difficulty D ,conditions C"
							+" WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid  "+condition+" order by C.falsely desc";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值

					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					while(rs.next()){
						//实例化实体类对象
						Topicbank topicbank=new Topicbank();
						//将结果集内的数据赋给实体类对象
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Topicbank> topicbanklist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="SELECT testid,testtype,aresult,bresult,cresult,dresult,eresult, " 
					+" fresult,rightsult,content,D.grade,C.falsely,T.cname,t.stagename "
					+" FROM topicbank T "
					+" JOIN difficulty D ,conditions C"
					+" WHERE 1=1 AND T.testid=D.tid  AND T.testid=C.tid  "+condition;
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值

			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			while(rs.next()){
				//实例化实体类对象
				Topicbank topicbank=new Topicbank();
				//将结果集内的数据赋给实体类对象
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
