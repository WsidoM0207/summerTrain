package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.model.User;
import com.cinema.util.StringUtil;

/**
 * 用户Dao类
 */
public class UserDao {

	public int add(Connection con, User user)throws Exception{
		String sql = "insert into t_user values(null,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		pstmt.setString(2, user.getUserName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getUserLevel());
		pstmt.setString(5, user.getRegistrationTime());
		pstmt.setInt(6, user.getCostTotal());
		pstmt.setInt(7, user.getCostNum());
		pstmt.setString(8, user.getTelNumber());
		pstmt.setString(9, user.getMailNumber());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 用户查询
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, User user)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_user");
		if(StringUtil.isNotEmpty(Integer.toString(user.getId()))) {
			sb.append(" and id like '%"+ user.getId()+"%'");
		}
		if(StringUtil.isNotEmpty(user.getUserName())) {
			sb.append(" and userName like '%"+ user.getUserName()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 用户信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception{
		String sql = "delete from t_user where userName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 用户信息修改事件
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, User user) throws Exception{
		String sql="update t_user set userLevel=?,costTotal=?,costNum=?,telNumber=?,mailNumber=? where userName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserLevel());
		pstmt.setInt(2, user.getCostTotal());
		pstmt.setInt(3, user.getCostNum());
		pstmt.setString(4, user.getTelNumber());
		pstmt.setString(5, user.getMailNumber());
		pstmt.setString(6, user.getUserName());
		return pstmt.executeUpdate();
	}
}
