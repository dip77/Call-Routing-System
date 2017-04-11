package main;


import java.util.LinkedList;
import java.util.Queue;

public class CallQueue {
	private Queue<User> queueOfUser = new LinkedList<User>();

	public Queue<User> getqueueOfUser() {
		return queueOfUser;
	}

	public void setQ(Queue<User> queueOfUser) {
		this.queueOfUser = queueOfUser;
	}

	public User getCall() {
		return queueOfUser.peek();
	}

	public void setCall(User user) {
		queueOfUser.add(user);
	}
	
	public boolean isEmpty(){
		if(queueOfUser.size()==0)
			return true;
		
		return false;
	}

}

