package com.cinema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cinema.model.Movie;
import com.cinema.util.StringUtil;

/**
 * 影片Dao类
 */
public class MovieDao {

	/**
	 * 影片添加
	 * @param con
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Movie movie)throws Exception{
		String sql = "insert into t_movie values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, movie.getMovieName());
		pstmt.setString(2, movie.getDirector());
		pstmt.setString(3, movie.getActor());
		pstmt.setInt(4, movie.getDuration());
		pstmt.setString(5, movie.getBrief());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 影片查询
	 * @param con
	 * @param movie
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Movie movie)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_movie");
		if(StringUtil.isNotEmpty(movie.getMovieName())) {
			sb.append(" and movie like '%"+ movie.getMovieName()+"%'");
		}
		if(StringUtil.isNotEmpty(movie.getDirector())) {
			sb.append(" and director like '%"+ movie.getDirector()+"%'");
		}
		if(StringUtil.isNotEmpty(movie.getActor())) {
			sb.append(" and actor like '%"+ movie.getActor()+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}
	
	/**
	 * 影片信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String movieName)throws Exception{
		String sql = "delete from t_movie where movie=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, movieName);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 影片信息修改事件
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Movie movie) throws Exception{
		String sql="update t_movie set director=?,actor=?,duration=?,brief=? where movie=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, movie.getDirector());
		pstmt.setString(2, movie.getActor());
		pstmt.setInt(3, movie.getDuration());
		pstmt.setString(4, movie.getBrief());
		pstmt.setString(5, movie.getMovieName());
		return pstmt.executeUpdate();
	}
}
