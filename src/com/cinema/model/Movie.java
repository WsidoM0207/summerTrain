package com.cinema.model;

/**
 * 电影实体
 */
public class Movie {
	
	private int id;
	private String movieName;
	private String director;
	private String actor;
	private int duration;
	private String brief;
	
	
	
	public Movie(String movieName, String director, String actor) {
		super();
		this.movieName = movieName;
		this.director = director;
		this.actor = actor;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String movieName, String director, String actor, int duration, String brief) {
		super();
		this.movieName = movieName;
		this.director = director;
		this.actor = actor;
		this.duration = duration;
		this.brief = brief;
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
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	
}
