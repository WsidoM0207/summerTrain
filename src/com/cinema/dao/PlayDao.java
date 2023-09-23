package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.model.Movie;
import com.cinema.model.Play;
import com.cinema.util.StringUtil;

/**
 * 排片Dao类
 */
public class PlayDao {
	
	/**
	 * 场次添加
	 * @param con
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Play play)throws Exception{
		String sql = "insert into t_play values(null,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, play.getMovieName());
		pstmt.setFloat(2, play.getPrice());
		pstmt.setString(3, play.getRoom());
		pstmt.setString(4, play.getTime());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 场次查询
	 * @param con
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Play play)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_play");
		if(StringUtil.isNotEmpty(play.getMovieName())) {
			sb.append(" and movieName like '%"+ play.getMovieName()+"%'");
		}
		if(StringUtil.isNotEmpty(play.getRoom())) {
			sb.append(" and room like '%"+ play.getRoom()+"%'");
		}
		if(StringUtil.isNotEmpty(play.getTime())) {
			sb.append(" and time like '%"+ play.getTime()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 场次信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String movieName)throws Exception{
		String sql = "delete from t_play where movieName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, movieName);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 场次信息修改事件
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Play play) throws Exception{
		String sql="update t_play set price=?,room=?,time=? where movieName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setFloat(1, play.getPrice());
		pstmt.setString(2, play.getRoom());
		pstmt.setString(3, play.getTime());
		pstmt.setString(4, play.getMovieName());
		return pstmt.executeUpdate();
	}
}
