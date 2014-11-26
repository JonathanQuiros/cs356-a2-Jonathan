package twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import observer.Observer;
import observer.Subject;
import visitor.*;

public class User extends UserComponent implements Subject {
	private HashSet<Object> followers;
	private HashSet<String> following;
	private ArrayList<Observer> tweets;
	private ArrayList<?> newsFeed;
	private String userId;
	
	public User(String userId) {
		super();
		this.userId = userId;
		tweets = new ArrayList<Observer>();
		followers = new HashSet<Object>();
		setFollowing(new HashSet<String>());
		setNewsFeed(new ArrayList<Object>());
	}
	
	public boolean userExists(String id) {
		if (followers.contains(id)) {
			return false;
		} else return true;
	}
	
	public void addFollower(String text) {
		followers.add(text);
	}
	
	public HashSet<Object> getFollowers() {
		return followers;
	}
	
	public int getSize() {
		return followers.size();
	}

	public void tweet(Observer tweet) {
		tweets.add(tweet);
	}
	
	public ArrayList<Observer> getTweets() {
		return tweets;
	}

	public String getId() {
		return userId;
	}

	public void setId(String id) {
		this.userId = id;
	}

	public void displayComponent() {
		
		System.out.println(getName() + "");
			
	}

//	@Override
//	public double accept(Visitor visitor) {
//		return visitor.visit(this);
//	}

	@Override
	public void register(Observer newObserver) {
		followers.add(newObserver);
	}

	@Override
	public void unregister(Observer deleteObserver) {
		int followerIndex = ((List<?>) followers).indexOf(deleteObserver);
		
		System.out.println("Follower" + (followerIndex+1) + " deleted");
		
		followers.remove(followerIndex);
	}

	@Override
	public void notifyObserver() {
//		for(Observer follower : followers) {
//			follower.update(tweets);
//		}
	}

	public ArrayList<?> getNewsFeed() {
		return newsFeed;
	}

	public void setNewsFeed(ArrayList<?> newsFeed) {
		this.newsFeed = newsFeed;
	}

	public HashSet<?> getFollowing() {
		return following;
	}

	public void setFollowing(HashSet<String> following) {
		this.following = following;
	}
	
}
