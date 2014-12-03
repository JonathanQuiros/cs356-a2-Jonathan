package twitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import observer.Observer;
import observer.Subject;
import visitor.*;

public class UserGroup extends UserComponent implements Subject {

	private ArrayList<UserComponent> userComponents = new ArrayList<UserComponent>();
	private HashSet<Object> followers;
	private String name;
	
	public UserGroup() {
		this.name = name;
		followers = new HashSet<Object>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addFollower(String text) {
		followers.add(text);
	}
	
	public void add(UserComponent newUserComponent) {
		
		userComponents.add(newUserComponent);
	}
	
	public void remove(UserComponent newUserComponent) {
		
		userComponents.remove(newUserComponent);
	}
	
	public UserComponent getUserGroup(int componentIndex) {
			
		return (UserComponent)userComponents.get(componentIndex);
	}

	public void displayComponent() {
		
		System.out.println(getName() + "");
		
		Iterator<UserComponent> userIterator = userComponents.iterator();
		
		while(userIterator.hasNext()) {
			
			UserComponent userInfo = (UserComponent) userIterator.next();
			userInfo.displayComponent();
		}
	}

	@Override
	public void register(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unregister(Observer o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		
	}

	public HashSet<Object> getFollowers() {
		return followers;
	}

	public void setFollowers(HashSet<Object> followers) {
		this.followers = followers;
	}

	public int getSize() {
		return followers.size();
	}

	@Override
	public void verification() {
		for(Object s : followers) {
			System.out.println("Verified!");
		}
	}

	public void setId(String text) {
		name = text;
	}
}
