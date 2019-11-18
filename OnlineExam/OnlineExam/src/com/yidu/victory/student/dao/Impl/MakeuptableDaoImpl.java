/**
 * 
 */
package com.yidu.victory.student.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.student.dao.MakeuptableDao;
import com.yidu.victory.student.domain.Makeuptable;

/**
 * 内容：
 * 作者 tzh
 * 编写日期:下午3:19:03
 * 版本1.0
 */
public class MakeuptableDaoImpl  implements MakeuptableDao{
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#add(com.yidu.victory.makeuptable.domain.Makeuptable)
	 */
	@Override
	public int add(Makeuptable makeuptable) {
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
			String sql="insert into makeuptable(sid,sname,grade,squadId,eid,conditions) "
					+ " values(?,?,?,?,?,?)";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, makeuptable.getSid());
			pstmt.setString(2, makeuptable.getSname());
			pstmt.setInt(3, makeuptable.getGrade());
			pstmt.setInt(4, makeuptable.getSquadid());
			pstmt.setInt(5, makeuptable.getEid());
			pstmt.setString(6, makeuptable.getConditions());
			//调用语句对象返回
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}

	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#delete(int)
	 */
	@Override
	public int delete(int sid) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		int rows=0;
		System.out.print("xxxxx"+rows);
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="delete from makeuptable where sid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1 ,sid);
			
			//调用语句对象返回
			rows=pstmt.executeUpdate();
			System.out.println("ssss"+rows);
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtils.close(rs, pstmt, conn);
		}
		return rows;
	}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#update(com.yidu.victory.makeuptable.domain.Makeuptable)
	 */
	@Override
	public int update(Makeuptable makeuptable) {
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
					String sql="update makeuptable set sname=?,grade=?,squadId=?,eid=?,"
							+ "conditions=? where sid=?";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					
					pstmt.setString(1, makeuptable.getSname());
					pstmt.setInt(2, makeuptable.getGrade());
					pstmt.setInt(3, makeuptable.getSquadid());
					pstmt.setInt(4, makeuptable.getEid());
					pstmt.setString(5, makeuptable.getConditions());
					pstmt.setInt(6, makeuptable.getSid());
					//调用语句对象返回
					rows=pstmt.executeUpdate();
					
				} catch (SQLException e) {
					throw new RuntimeException(e.getMessage());
				}finally{
					JdbcUtils.close(rs, pstmt, conn);
				}
		return rows;
		}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#findById(java.lang.String)
	 */
	@Override
	public Makeuptable findById(String sid) {
			//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				Makeuptable makeuptable=null;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from Makeuptable where sid=?";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					pstmt.setString(1, sid);
					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					if(rs.next()){
						//实例化实体类对象
						makeuptable=new Makeuptable();
						//将结果集内的数据赋给实体类对象
						makeuptable.setSid(rs.getInt("sid"));
						makeuptable.setSname(rs.getString("sname"));
						makeuptable.setGrade(rs.getInt("grade"));
						makeuptable.setSquadid(rs.getInt("squadid"));
						makeuptable.setEid(rs.getInt("eid"));
						makeuptable.setConditions(rs.getString("conditions"));
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return makeuptable;
			}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#findAll(int, int, java.lang.String)
	 */
	@Override
	public List<Makeuptable> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Makeuptable> makeuptablelist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from makeuptable "+condition+" limit ?,?";
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
						Makeuptable makeuptable=new Makeuptable();
						//将结果集内的数据赋给实体类对象
						makeuptable.setSid(rs.getInt("sid"));
						makeuptable.setSname(rs.getString("sname"));
						makeuptable.setGrade(rs.getInt("grade"));
						makeuptable.setSquadid(rs.getInt("squadid"));
						makeuptable.setEid(rs.getInt("eid"));
						makeuptable.setConditions(rs.getString("conditions"));
						
						makeuptablelist.add(makeuptable);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return makeuptablelist;
			}
	
	/* (non-Javadoc)
	 * @see com.yidu.victory.makeuptable.dao.MakeuptableDao#count(java.lang.String)
	 */
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
					String sql="select count(*) from makeuptable "+condition;
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

		}