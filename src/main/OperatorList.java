package main;

import java.util.ArrayList;
import java.util.HashMap;

public class OperatorList implements Runnable {

	private HashMap<Operator, User> hash = new HashMap<Operator, User>();
	private ArrayList<Operator> freeOperators;
	private ArrayList<Operator> busyOperators;

	OperatorList() {

		hash.put(new Operator("Hindi", "Raj"), null);
		hash.put(new Operator("Hindi", "Rahul"), null);
		hash.put(new Operator("English", "Ramesh"), null);
		hash.put(new Operator("English", "Rajesh"), null);
		hash.put(new Operator("English", "Raghu"), null);

	}

	public void addOperator(Operator operator) {
		hash.put(operator, null);
	}

	@Override
	public void run() {
		freeOperators = new ArrayList<Operator>();
		busyOperators = new ArrayList<Operator>();
		for (Operator temp : hash.keySet()) {
			User user = hash.get(temp);
			if (user == null)
				freeOperators.add(temp);
			else
				busyOperators.add(temp);
		}
	}

	public void setFreeOperators(ArrayList<Operator> freeOperators) {
		this.freeOperators = freeOperators;
	}

	public HashMap<Operator, User> getHash() {
		return hash;
	}

	public ArrayList<Operator> getFreeOperators() {
		Thread thread = new Thread(this);
		thread.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return freeOperators;
	}

	public ArrayList<Operator> getBusyOperators() {
		Thread thread = new Thread(this);
		thread.start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return busyOperators;
	}

}