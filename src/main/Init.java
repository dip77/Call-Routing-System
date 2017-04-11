package main;

public class Init {
	public static void main(String[] args) {
		User user1 = new User("845","Hindi");
		User user2 = new User("846","Hindi");
		User user3 = new User("847","Eng");
		User user4 = new User("848","Eng");
		User user5 = new User("849","Eng");
		User user6 = new User("850","Hindi");
		
		Dial dialer= new Dial();
		
		dialer.addCall(user1);
		dialer.operatorAllocator();
	
		dialer.addCall(user2);
		dialer.operatorAllocator();

		dialer.addCall(user3);
		dialer.operatorAllocator();
		
		dialer.addCall(user4);
		dialer.operatorAllocator();
		
		dialer.addCall(user5);
		dialer.operatorAllocator();
		
		dialer.addCall(user6);
		dialer.operatorAllocator();

		dialer.disconnectCall("845");
		
		dialer.addCall(user1);
		dialer.operatorAllocator();
		
		dialer.disconnectCall("850");
		dialer.disconnectCall("846");
		
		dialer.addCall(user1);
		dialer.operatorAllocator();
		
		dialer.disconnectCall("845");
	}
}
