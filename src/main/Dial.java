package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class Dial {
	// initialize list for freeOperators
	ArrayList<Operator> freeOperators;
	// initialize queue for calls in queue
	CallQueue incomingCallQueue = new CallQueue();
	// initialize list for list of all operators
	OperatorList listOfAllOperators = new OperatorList();
	Queue<User> queue;
	Queue<User> temporaryQueue;

	public void addCall(User user) {
		// adding new caller to the queue
		incomingCallQueue.setCall(user);
	}

	// convert some shit here
	public void disconnectCall(String phone) {
		ArrayList<Operator> busyOperators = listOfAllOperators
				.getBusyOperators();
		HashMap<Operator, User> hashmap = listOfAllOperators.getHash();
		Iterator<Operator> itr = busyOperators.iterator();
		Iterator<User> iteratorForUser = User.busyUser.iterator();
		while (itr.hasNext()) {
			Operator operator = itr.next();
			User userFromHash = hashmap.get(operator);
			if (userFromHash != null) {
				if (phone.equals(userFromHash.getPhone())) {
					hashmap.put(operator, null);
					int i=0;
					while(iteratorForUser.hasNext()){
						User tempUser = iteratorForUser.next();
						if(tempUser.getPhone().equals(phone)){
							break;
						}
						i++;
					}
					User.busyUser.remove(i);
					System.out.println("Call disconnected");
					if(!incomingCallQueue.isEmpty()){
						operatorAllocator();
					}
						
					break;
				}
			}
		}

	}

	public ArrayList<Operator> getFreeOperators() {
		return freeOperators;
	}

	public void setFreeOperators(ArrayList<Operator> freeOperators) {
		this.freeOperators = freeOperators;
	}

	public CallQueue getIncomingCallQueue() {
		return incomingCallQueue;
	}

	public void setIncomingCallQueue(CallQueue incomingCallQueue) {
		this.incomingCallQueue = incomingCallQueue;
	}

	public OperatorList getListOfAllOperators() {
		return listOfAllOperators;
	}

	public void setListOfAllOperators(OperatorList listOfAllOperators) {
		this.listOfAllOperators = listOfAllOperators;
	}

	public void operatorAllocator() {
		// get free Operators from Operator class
		freeOperators = listOfAllOperators.getFreeOperators();
		Iterator<Operator> itr = freeOperators.iterator();
		if (freeOperators.isEmpty()) {
			System.out.println("Operator not available.");
		} else {
			User user = incomingCallQueue.getCall();
			boolean flag = false;
			String Ulang = user.getLanguage();
			while (itr.hasNext()) {
				Operator currentOperator = itr.next();
				String OPlang = currentOperator.getLanguage();

				// if language preference matches, call is connected.
				if (Ulang.equals(OPlang)) {
					queue = incomingCallQueue.getqueueOfUser();
					User frontCaller = queue.poll();
					HashMap<Operator, User> hashmap = listOfAllOperators.getHash();
					hashmap.put(currentOperator, frontCaller);
					flag = true;
					User.busyUser.add(frontCaller);
					System.out.println("Operator allocated.");
					break;
				}
				
			}
			
			
			if (!flag) {
				temporaryQueue=new LinkedList<User>();
				Iterator<User> iteratorOfQueue = queue.iterator();
				temporaryQueue.add(queue.poll());
				while(iteratorOfQueue.hasNext()) {
					operatorAllocator();
				}
				queue=temporaryQueue;
				incomingCallQueue.setQ(queue);
				System.out.println(queue.peek());
				System.out.println("No Matching Operator Found. Putting on wait. ");
			}
		}

	}
}