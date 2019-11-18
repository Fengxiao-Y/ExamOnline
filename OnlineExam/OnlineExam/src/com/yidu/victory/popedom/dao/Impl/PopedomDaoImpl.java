package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.PopedomDao;
import com.yidu.victory.popedom.domain.Popedom;

public class PopedomDaoImpl implements PopedomDao {

	@Override
	public Popedom findById(int pdmid) {
		//创建数据库连接对象
				Connection conn=null;
				//创建数据库语句对象
				PreparedStatement pstmt=null;
				//创建结果集对象
				ResultSet rs=null;
				//创建返回
				Popedom pdm=null;
				try {
					//实例化数据库连接对象
					conn=JdbcUtils.getConnection();
					//创建SQL执行语句
					String sql="select * from popedom where pdmid=? ";
					//实例化语句对象
					pstmt=conn.prepareStatement(sql);
					//给SQL执行语句赋值
					pstmt.setInt(1, pdmid);
					//调用语句对象返回
					rs=pstmt.executeQuery();
					//判断结果集是否为空
					while(rs.next()){
						//实例化实体类对象
						pdm=new Popedom();
						//将结果集内的数据赋给实体类对象
						pdm.setId(rs.getInt("pdmid"));
						pdm.setText(rs.getString("pdmname"));
						pdm.setPdmfather(rs.getInt("pdmfather"));
						
					}
							
					} catch (SQLException e) {
						throw new RuntimeException(e.getMessage());
					}finally{
						JdbcUtils.close(rs, pstmt, conn);
					}
				return pdm;
	}

}
