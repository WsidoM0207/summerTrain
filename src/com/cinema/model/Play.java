package com.cinema.model;

/**
 * 排片实体
 */
public class Play {
	private int id;
	private String movieName;
	private float price;
	private String room;
	private String time;
	
	
	public Play(String movieName, String room, String time) {
		super();
		this.movieName = movieName;
		this.room = room;
		this.time = time;
	}
	public Play(String movieName, float price, String room, String time) {
		super();
		this.movieName = movieName;
		this.price = price;
		this.room = room;
		this.time = time;
	}
	public Play() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
