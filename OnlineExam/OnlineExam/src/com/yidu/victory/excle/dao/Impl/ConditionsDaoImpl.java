package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.ConditionsDao;
import com.yidu.victory.excle.domain.Conditions;

/**
 * 内容：
 * 作者 tzh
 * 编写日期:下午6:52:17
 * 版本1.0
 */
public class ConditionsDaoImpl implements ConditionsDao {

	/* (non-Javadoc)
	 * @see com.yidu.victry.excle.dao.ConditionsDao#add(com.yidu.victry.excle.domain.Conditions)
	 */
	@Override
	public int add(Conditions conditions) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				int rows=0;
				try{
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="insert into conditions(tid,falsely) values(?,?)";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					pstmt.setInt(1, conditions.getTid());
					pstmt.setDouble(2, conditions.getFalsely());
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
	 * @see com.yidu.victry.excle.dao.ConditionsDao#delete(int)
	 */
	@Override
	public int delete(int tid) {
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
					String sql="delete from conditions where tid=?";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					pstmt.setInt(1,tid);
					
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
	public int update(Conditions conditions) {
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
			String sql="update Conditions set falsely=? where tid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			pstmt.setDouble(1, conditions.getFalsely());
			pstmt.setInt(2, conditions.getTid());

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
	public Conditions findById(int tid) {
			//创建数据库连接对象
			Connection conn=null;
			//创建数据库语句对象
			PreparedStatement pstmt=null;
			//创建结果集对象
			ResultSet rs=null;
			//创建返回
			Conditions conditions=null;
			try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from conditions where tid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, tid);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				conditions=new Conditions();
				//将结果集内的数据赋给实体类对象
				conditions.setTid(rs.getInt("tid"));
				conditions.setFalsely(rs.getDouble("falsely"));
				
				
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return conditions;
			}

	@Override
	public List<Conditions> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Conditions> conditionslist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from conditions "+condition+" limit ?,?";
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
						Conditions conditions=new Conditions();
						//将结果集内的数据赋给实体类对象
						conditions.setTid(rs.getInt("tid"));
						conditions.setFalsely(rs.getDouble("falsely"));
						conditionslist.add(conditions);
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return conditionslist;
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
					String sql="select count(*) from conditions "+condition;
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
