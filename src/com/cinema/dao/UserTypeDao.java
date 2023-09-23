package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.model.UserType;
import com.cinema.util.StringUtil;

/**
 * 用户类别Dao类
 */
public class UserTypeDao {
	
	/**
	 * 用户类别添加
	 * @param con
	 * @param userType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, UserType userType)throws Exception{
		String sql = "insert into t_usertype values(null,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userType.getUserTypeName());
		pstmt.setString(2, userType.getUserTypeDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询用户类别集合
	 * @param con
	 * @param userType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, UserType userType)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_usertype");
		if(StringUtil.isEmpty(userType.getUserTypeName())) {
			sb.append(" and userTypeName like '%" + userType.getUserTypeName() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
}
