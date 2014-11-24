package com.jquiros.Twitter;

public class AdminControlPanel {
	private static AdminControlPanel instance = null;
	
	private AdminControlPanel() {}
	
	public static synchronized AdminControlPanel getInstance() {
		if (instance == null) {
			instance = new AdminControlPanel();
		}
		return instance;
	}
	
	
}
