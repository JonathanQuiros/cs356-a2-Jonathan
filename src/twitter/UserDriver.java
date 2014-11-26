package twitter;

public class UserDriver {

	UserComponent users;
	
	public UserDriver(UserComponent newUsers) {
		
		users = newUsers;
	}
	
	public void getUsers() {
		
		users.displayComponent();
	}
}
