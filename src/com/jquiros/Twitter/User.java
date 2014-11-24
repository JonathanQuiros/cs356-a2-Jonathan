package com.jquiros.Twitter;

public class User extends UserComponent {
	private String tweet;
	private String name;
	private int id;
	
	public User(String tweet, String name, int id) {
		super();
		this.tweet = tweet;
		this.name = name;
		this.id = id;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void displayComponent() {
		
		System.out.println(getName() + "");
		
		
	}
	

}
