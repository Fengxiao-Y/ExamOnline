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
			String sql="insert into exam(cid,headline,cname,sqid,examtime, "
					+  " finishtime,againexam) values(?,?,?,?,?,?,?)";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			
			pstmt.setInt(1, exam.getCid());
			pstmt.setString(2, exam.getHeadline());
			pstmt.setString(3, exam.getCname());;
			pstmt.setInt(4, exam.getSqid());
			pstmt.setString(5, exam.getExamtime());
			pstmt.setString(6, exam.getFinishtime());
			pstmt.setString(7, exam.getAgainexam());
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
	public int delete(int eid) {
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
			String sql="delete from exam where eid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, eid);
			
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
	public int update(Exam exam) {
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
			String sql="update exam set cid=?,headline=?,cname=?,sqid=?, "
					+ " examtime=?,finishtime=?,againexam=? where eid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, exam.getCid());
			pstmt.setString(2, exam.getHeadline());
			pstmt.setString(3, exam.getCname());;
			pstmt.setInt(4, exam.getSqid());
			pstmt.setString(5, exam.getExamtime());
			pstmt.setString(6, exam.getFinishtime());
			pstmt.setString(7, exam.getAgainexam());
			pstmt.setInt(8, exam.getEid());
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
	public Exam findById(int eid) {
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		Exam exam=null;
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from exam where eid=?";
			//实例化语句对象
			pstmt=conn.prepareStatement(sql);
			//给SQL语句赋值
			pstmt.setInt(1, eid);
			//调用语句对象返回
			rs=pstmt.executeQuery();
			//判断结果集是否为空
			if(rs.next()){
				//实例化实体类对象
				exam=new Exam();
				//将结果集内的数据赋给实体类对象
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
		//创建数据库连接对象
		Connection conn=null;
		//创建数据库语句对象
		PreparedStatement pstmt=null;
		//创建结果集对象
		ResultSet rs=null;
		//创建返回
		List<Exam> examlist=new ArrayList<>();
		try {
			//实例化数据库连接对象
			conn=JdbcUtils.getConnection();
			//创建SQL执行语句
			String sql="select * from exam "+condition+" limit ?,?";
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
				Exam exam=new Exam();
				//将结果集内的数据赋给实体类对象
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
			String sql="select count(*) from exam "+condition;
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
	public List<Exam> findAll() {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				List<Exam> examlist=new ArrayList<>();
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from exam ";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);

					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					while(rs.next()){
						//实例化实体类对象
						Exam exam=new Exam();
						//将结果集内的数据赋给实体类对象
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
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				Exam exam=null;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from exam "+condition;
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL语句赋值
					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					if(rs.next()){
						//实例化实体类对象
						exam=new Exam();
						//将结果集内的数据赋给实体类对象
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
