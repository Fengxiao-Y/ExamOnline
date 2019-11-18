package com.yidu.victory.excle.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.excle.dao.StugradeDao;
import com.yidu.victory.excle.domain.Stugrade;

public class StugradeDaoImpl implements StugradeDao {

	@Override
	public int add(Stugrade stugrade) {
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
			String sql="insert into stugrade(sid,sname,grade,squadid,cid,remark) "
					+ "values(?,?,?,?,?,?)";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			pstmt.setString(1, stugrade.getSid());;
			pstmt.setString(2, stugrade.getSname());
			pstmt.setInt(3, stugrade.getGrade());
			pstmt.setInt(4, stugrade.getSquadid().getsqid());
			pstmt.setInt(5, stugrade.getcid().getEid());
			pstmt.setString(6, stugrade.getRemark());

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
	public int delete(int gid) {
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
			String sql="delete from stugrade where gid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, gid);
			
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
	public int update(Stugrade stugrade) {
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
			String sql="update stugrade set sid=?,sname=?,grade=?,squadid=?, "
					+ " cid=?,remark=? where gid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值		
			pstmt.setString(1, stugrade.getSid());;
			pstmt.setString(2, stugrade.getSname());
			pstmt.setInt(3, stugrade.getGrade());
			pstmt.setInt(4, stugrade.getSquadid().getsqid());
			pstmt.setInt(5, stugrade.getcid().getEid());
			pstmt.setString(6, stugrade.getRemark());
			pstmt.setInt(7, stugrade.getGid());
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
	public Stugrade findById(int gid) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Stugrade stugrade=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from stugrade where gid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, gid);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				stugrade=new Stugrade();
				//将结果集内的数据赋给实体类对象
				stugrade.setGid(rs.getInt("gid"));
				stugrade.setSid(rs.getString("sid"));
				stugrade.setSname(rs.getString("sname"));
				stugrade.setGrade(rs.getInt("grade"));
				stugrade.setSquadid(rs.getInt("squadid"));
				stugrade.setcid(rs.getInt("cid"));
				stugrade.setRemark(rs.getString("remark"));
			}
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return stugrade;
	}

	@Override
	public List<Stugrade> findAll(int rows, int page, String condition) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Stugrade> stugradelist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from stugrade "+condition+" limit ?,?";
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
				Stugrade stugrade=new Stugrade();
				//将结果集内的数据赋给实体类对象
				stugrade.setGid(rs.getInt("gid"));
				stugrade.setSid(rs.getString("sid"));
				stugrade.setSname(rs.getString("sname"));
				stugrade.setGrade(rs.getInt("grade"));
				stugrade.setSquadid(rs.getInt("squadid"));
				stugrade.setcid(rs.getInt("cid"));
				stugrade.setRemark(rs.getString("remark"));
				
				stugradelist.add(stugrade);
			}	
					
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}finally{
				JdbcUtils.close(rs, pstmt, conn);
			}
		return stugradelist;
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
			String sql="select count(*) from stugrade "+condition;
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

	@Override
	public Stugrade findByCondition(String condition) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				Stugrade stugrade=null;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from stugrade "+condition;
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);

					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					if(rs.next()){
						//实例化实体类对象
						stugrade=new Stugrade();
						//将结果集内的数据赋给实体类对象
						stugrade.setGid(rs.getInt("gid"));
						stugrade.setSid(rs.getString("sid"));
						stugrade.setSname(rs.getString("sname"));
						stugrade.setGrade(rs.getInt("grade"));
						stugrade.setSquadid(rs.getInt("squadid"));
						stugrade.setcid(rs.getInt("cid"));
						stugrade.setRemark(rs.getString("remark"));
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return stugrade;
	}

}
