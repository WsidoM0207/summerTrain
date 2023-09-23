package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.model.Manager;

/**
 * 经理Dao类
 */
public class ManagerDao {
	
	/**
	 * 登录验证
	 * @param con
	 * @param manager
	 * @return
	 * @throws Exception
	 */
	public Manager login(Connection con, Manager manager)throws Exception{
		Manager resultManager = null;
		String sql="select * from t_manage where managerName=? and password=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, manager.getManageName());
		pstmt.setString(2, manager.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultManager = new Manager();
			resultManager.setId(rs.getInt("id"));
			resultManager.setManageName(rs.getString("managerName"));
			resultManager.setPassword(rs.getString("password"));
		}
		return resultManager;
	}
}
