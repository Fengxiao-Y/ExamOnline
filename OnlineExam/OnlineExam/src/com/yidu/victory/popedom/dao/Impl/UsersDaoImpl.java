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
		//定义影响行数的变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		try {
			conn=JdbcUtils.getConnection();
			//创建sql语句
			String sql="insert into users(unumber,passwords)"
					+ "values(?,?)";
			//通过连接对象实例化语句对象
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, user.getUnumber());
			pstmt.setString(2, user.getPasswords());
			//执行并返回影响的行数
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回
		return rows;
	}

	@Override
	public int delete(int uid) {
		//定义影响行数的变量
		int rows=0;
		//声明连接对象
		Connection conn=null;
		//声明连接对象
		PreparedStatement pstmt=null;
		try {
			//实例化连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="delete from users where uid=?";
			//实例化连接对象
			pstmt=conn.prepareStatement(sql);
			//给参数赋值
			pstmt.setInt(1, uid);
			//执行并返回
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回rows
		return rows;
	}

	@Override
	public int update(Users user) {
		//定义影响的行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="update users set unumber=?,passwords=? "
					+ "where uid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//通过语句对象赋值
			pstmt.setString(1, user.getUnumber());
			pstmt.setString(2, user.getPasswords());
			pstmt.setInt(3, user.getUid());
			//执行并返回
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(null, pstmt, conn);
		}
		//返回rows
		return rows;
	}

	@Override
	public Users findById(String unumber) {
		//定义Users对象
		Users user=null;
		//定义数据库连接对象
		Connection conn=null;
		//定义语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select * from users where unumber=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql语句的参数赋值
			pstmt.setString(1, unumber);
			//执行并返回结果集
			rs=pstmt.executeQuery();
			//判断
			if(rs.next()){
				user=new Users();
				//给对象的属性赋值
				user.setUid(rs.getInt("uid"));
				user.setUnumber(rs.getString("unumber"));
				user.setPasswords(rs.getString("passwords"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(rs, pstmt, conn);
		}
		
		//返回用户对象
		return user;
	}

	@Override
	public List<Users> findByPage(int rows, int page) {
		//定义list集合
		List<Users> userList=new ArrayList<Users>();
		//声明连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select * from users limit ?,?";
			//实例化语句对戏那个
			pstmt=conn.prepareStatement(sql);
			//给sql语句中的参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//执行并返回结果集
			rs=pstmt.executeQuery();
			//while循环判断
			while(rs.next()){
				Users user=new Users();
				//给用户对象的属性赋值
				user.setUid(rs.getInt("uid"));
				user.setUnumber(rs.getString("unumber"));
				user.setPasswords(rs.getString("passwords"));
				//把user对象添加到集合中
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回list集合
		return userList;
	}

	@Override
	public List<Users> findByPage(int rows, int page, String condition) {
		//定义list集合
		List<Users> userList=new ArrayList<Users>();
		//创建数据连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select * from users "+condition+" limit ?,? ";
			//通过连接对象实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给sql语句中的参数赋值
			pstmt.setInt(1, (page-1)*rows);
			pstmt.setInt(2, rows);
			//执行并返回结果集
			rs=pstmt.executeQuery();
			//循环判断
			while(rs.next()){
				Users user=new Users();
				//给用户对象的属性赋值
				user.setUid(rs.getInt("uid"));
				user.setUnumber(rs.getString("unumber"));
				user.setPasswords(rs.getString("passwords"));
				//把user对象添加到集合中去
				userList.add(user);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回list集合
		return userList;
	}

	@Override
	public int count() {
		//定义影响的行数变量
		int rows=0;
		//声明数据库连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select count(*) from users ";
			//通过连接对象实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//执行并返回
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	@Override
	public int count(String condition) {
		//定义影响行数的变量
		int rows=0;
		//生数据库连接对象
		Connection conn=null;
		//声明语句对象
		PreparedStatement pstmt=null;
		//声明结果集对象
		ResultSet rs=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//定义sql语句
			String sql="select count(*) from users "+condition;
			//通过连接对象实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//执行并返回
			rs=pstmt.executeQuery();
			if(rs.next()){
				rows=rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(),e);
		} finally{
			//关闭资源
			JdbcUtils.close(rs, pstmt, conn);
		}
		//返回
		return rows;
	}

	@Override
	public Users findById(int uid) {
		//定义Users对象
				Users user=null;
				//定义数据库连接对象
				Connection conn=null;
				//定义语句对象
				PreparedStatement pstmt=null;
				//声明结果集对象
				ResultSet rs=null;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//定义sql语句
					String sql="select * from users where uid=?";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给sql语句的参数赋值
					pstmt.setInt(1, uid);
					//执行并返回结果集
					rs=pstmt.executeQuery();
					//判断
					if(rs.next()){
						user=new Users();
						//给对象的属性赋值
						user.setUid(rs.getInt("uid"));
						user.setUnumber(rs.getString("unumber"));
						user.setPasswords(rs.getString("passwords"));
					}
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage(),e);
				} finally{
					//关闭资源
					JdbcUtils.close(rs, pstmt, conn);
				}
				
				//返回用户对象
				return user;
	}

	
}
