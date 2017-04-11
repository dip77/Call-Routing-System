package main;

import java.util.ArrayList;

public class User {
	private String language, phone;
	public  static ArrayList<User> busyUser = new ArrayList<User>();
	
	public User(String phone, String language) {
		this.language = language;
		this.phone = phone;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void getBusyUsers(){
		
	}

}