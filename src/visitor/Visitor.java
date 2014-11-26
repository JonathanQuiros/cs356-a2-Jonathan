package visitor;

import twitter.User;
import twitter.UserGroup;

public interface Visitor {
	
	public void visit(User user);
	public void visit(UserGroup userGroup);
	public int getResult();
}
