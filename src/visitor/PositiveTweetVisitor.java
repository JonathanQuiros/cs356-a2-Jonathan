package visitor;

import twitter.User;
import twitter.UserGroup;

public class PositiveTweetVisitor implements Visitor {
	int count = 0;
	
	public PositiveTweetVisitor() {
		
	}

	@Override
	public void visit(User user) {
		count++;
	}

	@Override
	public void visit(UserGroup userGroup) {
		count++;
	}
	
	@Override
	public int getResult() {
		return count;
	}
}
