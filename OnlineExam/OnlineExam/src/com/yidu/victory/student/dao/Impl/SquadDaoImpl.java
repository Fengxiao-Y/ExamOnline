package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.SquadDao;
import com.yidu.victory.student.domain.Squad;
import com.yidu.victory.student.domain.Student;

public class SquadDaoImpl implements SquadDao {

	@Override
	public int add(Squad squad) {
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
					String sql="insert into squad(snumber,speople,squadtime,teacher,"
							+ "sadministration,state,classify)"
							
							+ "  values(?,?,?,?,?,?,?)";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					pstmt.setString(1, squad.getSnumber() );
					pstmt.setInt(2, squad.getSpeople());
					pstmt.setString(3, squad.getSquadtime() );
					pstmt.setString(4, squad.getTeacher());
					pstmt.setString(5, squad.getSadministration());
					pstmt.setString(6, squad.getState());
					pstmt.setString(7, squad.getClassify());
					
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
	public int delete(int sqid) {
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
			String sql="delete from squad where sqid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1,sqid);
			
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
	public int update(Squad squad) {
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
			String sql="update squad set snumber=?,speople=?,"
					+ "squadtime=?,teacher=?,sadministration=?,"
					+ "state=?,classify=? where sqid=?";
					
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值

			pstmt.setString(1, squad.getSnumber() );
			pstmt.setInt(2, squad.getSpeople());
			pstmt.setString(3, squad.getSquadtime() );
			pstmt.setString(4, squad.getTeacher());
			pstmt.setString(5, squad.getSadministration());
			pstmt.setString(6, squad.getState());
			pstmt.setString(7, squad.getClassify());
			pstmt.setInt(8, squad.getsqid());
			
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
	public Squad findById(int sqid) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Squad squad=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from squad where sqid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, sqid);
			
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				squad=new Squad();
				//将结果集内的数据赋给实体类对象
				squad.setsqid(rs.getInt("sqid"));
				squad.setSnumber(rs.getString("snumber"));
				squad.setSpeople(rs.getInt("speople"));
				squad.setSquadtime(rs.getString("squadtime"));
				squad.setTeacher(rs.getString("teacher"));
				squad.setSadministration(rs.getString("sadministration"));
				squad.setState(rs.getString("state"));
				squad.setClassify(rs.getString("classify"));
				
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return squad;
	}

	@Override
	public List<Squad> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Squad> squadlist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from squad  "+condition+" limit ?,?";
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
				Squad squad=new Squad();
				//将结果集内的数据赋给实体类对象
				squad.setsqid(rs.getInt("sqid"));
				squad.setSnumber(rs.getString("snumber"));
				squad.setSpeople(rs.getInt("speople"));
				squad.setSquadtime(rs.getString("squadtime"));
				squad.setTeacher(rs.getString("teacher"));
				squad.setSadministration(rs.getString("sadministration"));
				squad.setState(rs.getString("state"));
				squad.setClassify(rs.getString("classify"));
				
				squadlist.add(squad);
				
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return squadlist;
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
			String sql="select count(*) from squad "+condition;
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			
			//调用语句对象返回
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public List<Squad> findAll() {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Squad> squadlist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from squad  ";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					while(rs.next()){
						//实例化实体类对象
						Squad squad=new Squad();
						//将结果集内的数据赋给实体类对象
						squad.setsqid(rs.getInt("sqid"));
						squad.setSnumber(rs.getString("snumber"));
						squad.setSpeople(rs.getInt("speople"));
						squad.setSquadtime(rs.getString("squadtime"));
						squad.setTeacher(rs.getString("teacher"));
						squad.setSadministration(rs.getString("sadministration"));
						squad.setState(rs.getString("state"));
						squad.setClassify(rs.getString("classify"));
						
						squadlist.add(squad);
						
					}
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
				return squadlist;
	}

}
