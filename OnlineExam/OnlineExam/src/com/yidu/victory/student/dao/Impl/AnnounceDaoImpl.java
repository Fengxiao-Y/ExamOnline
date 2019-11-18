package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.student.domain.Announce;
import com.yidu.victory.student.dao.AnnounceDao;
import com.yidu.victory.JdbcUtils.JdbcUtils;

public class AnnounceDaoImpl implements AnnounceDao {
	@Override
	public int add(Announce announce) {
		
		//定义一个行数变量
		int rows=0;
		//声明一个连接对象
		Connection conn=null;
		//声明一个语句对象
		PreparedStatement pstmt=null;
		try {
			//1.实例化连接对象
			conn=JdbcUtils.getConnection();
			//2.A定义一个SQL操作语句
			String sql="insert into announce(theme,"
					+ "titlecontent,announcecont,issuepeople,issuetime)"
					+ "  values(?,?,?,?,?)";
			//2.B实例化SQL语句及连接对象，得到语句对象
			pstmt=conn.prepareStatement(sql);
			//2.C将对象中的值给到语句对象中 
			
			pstmt.setString(1, announce.getTheme());
			pstmt.setString(2, announce.getTitlecontent());
			pstmt.setString(3, announce.getAnnouncecont());
			pstmt.setString(4, announce.getIssuepeople());
			pstmt.setString(5, announce.getIssuetime());
			//更新语句对象，将改变的值给到rows
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回行数变量
		return rows;
	}

@Override
	public int delete(int aid) {
		//定义一个行数变量
		int rows=0;
		//声明一个连接对象
		Connection conn=null;
		//声明一个语句对象
		PreparedStatement pstmt=null;
		try {
			//1.实例化连接对象
			conn=JdbcUtils.getConnection();
			//2.A定义一个SQL操作语句
			String sql="delete from announce where aid=?";
			//2.B实例化SQL语句及连接对象，得到语句对象
			pstmt=conn.prepareStatement(sql);
			//2.C将对象中的值给到语句对象中 
			pstmt.setInt(1, aid);
			//更新语句对象，将改变的值给到rows
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回行数变量
		return rows;
	}

@Override
	public int update(Announce announce) {
	//定义一个行数变量
	int rows=0;
	//声明一个连接对象
	Connection conn=null;
	//声明一个语句对象
	PreparedStatement pstmt=null;
	try {
		//1.实例化连接对象
		conn=JdbcUtils.getConnection();
		//2.A定义一个SQL操作语句
		String sql="update announce set theme=?,titlecontent=?,"
				+ "announcecont=?,issuepeople=?,issuetime=?"
				+ " where aid=?";
		//2.B实例化SQL语句及连接对象，得到语句对象
		pstmt=conn.prepareStatement(sql);
		//2.C将对象中的值给到语句对象中 
		pstmt.setString(1, announce.getTheme());
		pstmt.setString(2, announce.getTitlecontent());
		pstmt.setString(3, announce.getAnnouncecont());
		pstmt.setString(4, announce.getIssuepeople());
		pstmt.setString(5, announce.getIssuetime());
		pstmt.setInt(6, announce.getAid());
		//更新语句对象，将改变的值给到rows
		rows=pstmt.executeUpdate();
		
	} catch (SQLException e) {
		throw new RuntimeException(e.getMessage(),e);
	} finally{
		JdbcUtils.close(null, pstmt, conn);
	}
	return rows;
	}

@Override
	public Announce findById(int aid) {
		Announce announce=null;
		//声明一个连接对象
		Connection conn=null;
		//声明一个语句对象
		PreparedStatement pstmt=null;
		//定义一个结果集
		ResultSet rs=null;
		try {
			//1.实例化连接对象
			conn=JdbcUtils.getConnection();
			//2.A定义一个SQL操作语句
			String sql="select * from announce where aid=?";
			//2.B实例化SQL语句及连接对象，得到语句对象
			pstmt=conn.prepareStatement(sql);
			//2.C将对象中的值给到语句对象中 
			pstmt.setInt(1, aid);
			//更新语句对象，将值给到rs结果集
			rs=pstmt.executeQuery();
			if(rs.next()){
				announce=new Announce();
				announce.setAid(rs.getInt("aid"));
				announce.setTheme(rs.getString("theme"));
				announce.setTitlecontent(rs.getString("titlecontent"));
				announce.setAnnouncecont(rs.getString("announcecont"));
				announce.setIssuepeople(rs.getString("issuepeople"));
				announce.setIssuetime(rs.getString("issuetime"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return announce;
	}
@Override
	public List<Announce> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
@Override
public List<Announce> findByPage(int rows, int page) {
	List<Announce> announceList=new ArrayList<Announce>();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try {
		conn=JdbcUtils.getConnection();
		String sql="select * from announce limit ?,?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, (page-1)*rows);
		pstmt.setInt(2, rows);
		rs=pstmt.executeQuery();
		while(rs.next()){
			Announce announce=new Announce();
			announce.setAid(rs.getInt("aid"));
			announce.setTheme(rs.getString("theme"));
			announce.setTitlecontent(rs.getString("titlecontent"));
			announce.setAnnouncecont(rs.getString("announcecont"));
			announce.setIssuepeople(rs.getString("issuepeople"));
			announce.setIssuetime(rs.getString("issuetime"));
			
			announceList.add(announce);
		}
	} catch (SQLException e) {
		throw new RuntimeException(e.getMessage(),e);
	} finally{
		JdbcUtils.close(rs, pstmt, conn);
	}
	return announceList;
}

@Override
	public List<Announce> findByPage(int rows, int page, String condition) {
		List<Announce> announceList=new ArrayList<Announce>();
		//声明一个连接对象
		Connection conn=null;
		//声明一个语句对象
		PreparedStatement pstmt=null;
		//定义一个结果集
		ResultSet rs=null;
		try {
			//1.实例化连接对象
			conn=JdbcUtils.getConnection();
			//2.A定义一个SQL操作语句
			String sql="select * from announce "+condition+" limit ?,? ";
			//2.B实例化SQL语句及连接对象，得到语句对象
			pstmt=conn.prepareStatement(sql);
			//2.C将对象中的值给到语句对象中 
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//更新语句对象，将值给到rs结果集
			rs=pstmt.executeQuery();
			while(rs.next()){
				Announce announce=new Announce();
				announce.setAid(rs.getInt("aid"));
				announce.setTheme(rs.getString("theme"));
				announce.setTitlecontent(rs.getString("titlecontent"));
				announce.setAnnouncecont(rs.getString("announcecont"));
				announce.setIssuepeople(rs.getString("issuepeople"));
				announce.setIssuetime(rs.getString("issuetime"));
				//将对象中的值给到集合中
				announceList.add(announce);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return announceList;
	}

@Override
	public int count() {
		//定义一个行数变量
		int rows=0;
		//声明一个连接对象
		Connection conn=null;
		//声明一个语句对象
		PreparedStatement pstmt=null;
		//定义一个结果集
		ResultSet rs=null;
		try {
			//1.实例化连接对象
			conn=JdbcUtils.getConnection();
			//2.A定义一个SQL操作语句
			String sql="select count(*) from announce";
			//2.B实例化SQL语句及连接对象，得到语句对象
			pstmt=conn.prepareStatement(sql);
			//更新语句对象，将值给到rs结果集
			rs=pstmt.executeQuery();
			//判断结果集中是否有值
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}
	@Override
		public int count(String condition) {
			int rows=0;
			//声明一个连接对象
			Connection conn=null;
			//声明一个语句对象
			PreparedStatement pstmt=null;
			//定义一个结果集
			ResultSet rs=null;
			try {
				//1.实例化连接对象
				conn=JdbcUtils.getConnection();
				//2.A定义一个SQL操作语句
				String sql="select count(*) from announce "+condition;
				//2.B实例化SQL语句及连接对象，得到语句对象
				pstmt=conn.prepareStatement(sql);
				//更新语句对象，将值给到rs结果集
				rs=pstmt.executeQuery();
				if(rs.next()){
					rows=rs.getInt(1);
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage(),e);
			} finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
			return rows;
		}
	
}
