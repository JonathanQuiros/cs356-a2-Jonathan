package twitter;

public abstract class UserComponent {
	protected long creationTime;
	
	public void add(UserComponent newUserComponent) {
		
		throw new UnsupportedOperationException();
	}
	
	public void remove(UserComponent newUserComponent) {
		
		throw new UnsupportedOperationException();
	}
	
	public String getName() {
		
		throw new UnsupportedOperationException();
	}

	public void displayComponent() {
		
		throw new UnsupportedOperationException();
	}
	
	public void setCreationTime() {
		this.creationTime = System.currentTimeMillis();
	}

	public void getCreationTime() {
		System.out.println("Created at: " + creationTime);;
	}
	
}
