package com.jquiros.Twitter;

import java.util.ArrayList;
import java.util.Iterator;

public class UserGroup extends UserComponent {

	ArrayList<UserComponent> userComponents = new ArrayList<UserComponent>();
	
	private String name;
	
	public UserGroup(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
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
}
