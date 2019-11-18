package com.yidu.victory.popedom.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yidu.victory.JdbcUtils.JdbcUtils;
import com.yidu.victory.popedom.dao.RoleDao;
import com.yidu.victory.popedom.domain.Role;

public class RoleDaoImpl implements RoleDao {

	@Override
	public Role findById(int roleid) {
		// 定义Role对象
		Role role = null;
		// 定义数据库连接对象
		Connection conn = null;
		// 定义语句对象
		PreparedStatement pstmt = null;
		// 声明结果集对象
		ResultSet rs = null;
		try {
			// 实例化数据库连接对象
			conn = JdbcUtils.getConnection();
			// 定义sql语句
			String sql = "select * from role where roleid=?";
			// 实例化语句对象
			pstmt = conn.prepareStatement(sql);
			// 给sql语句的参数赋值
			pstmt.setInt(1, roleid);
			// 执行并返回结果集
			rs = pstmt.executeQuery();
			// 判断
			if (rs.next()) {
				role = new Role();
				// 给对象的属性赋值
				role.setRoleid(roleid);
				role.setRolename(rs.getNString("rolename"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			// 关闭资源
			JdbcUtils.close(rs, pstmt, conn);
		}

		// 返回用户对象
		return role;
	}

}