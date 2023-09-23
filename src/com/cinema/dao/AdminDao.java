package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.model.Admin;

/**
 * 管理员Dao类
 */
public class AdminDao {

	/**
	 * 管理员Dao类
	 * @param con
	 * @param admin
	 * @return
	 * @throws Exception
	 */
	public Admin login(Connection con, Admin admin)throws Exception{
		Admin resultAdmin = null;
		String sql = "select * from t_admin where adminName = ? and password = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, admin.getAdminName());
		pstmt.setString(2, admin.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultAdmin = new Admin();
			resultAdmin.setId(1);
			resultAdmin.setAdminName(rs.getString("adminName"));
			resultAdmin.setPassword(rs.getString("password"));
		}
		return resultAdmin;
	}
}
