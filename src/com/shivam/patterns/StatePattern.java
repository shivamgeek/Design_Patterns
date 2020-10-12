package com.shivam.patterns;


/*
 * State Pattern
 * 
 * State pattern allows an object to change its behavior when its internal state changes, the object will appear to change classes.
 * 
 */
public class StatePattern {

	public static void main(String[] args) {
		Bug bug = new Bug();
		bug.createBug("This is a new Bug");
		bug.assignOwner("shivam");
		bug.changeOwner("aggarwal");
	}

}

/* Delegates all calls to BugState as all logic lies there only */
class Bug {
	BugState state;
	
	public Bug() {
		this.state = new NewBug(this);
	}
	
	void createBug(String details) {
		state.createBug(details);
	}
	void addDescription(String desc) {
		state.addDescription(desc);
	}
	void assignOwner(String owner) {
		state.assignOwner(owner);
	}
	void changeOwner(String newOwner) {
		state.changeOwner(newOwner);
	}
	void closeBug() {
		state.closeBug();
	}
	void changeState(BugState state) {
		this.state = state;
	}
}

class BugState {
	Bug bug;
	
	public BugState(Bug bug) {
		this.bug = bug;
	}
	
	void createBug(String details) {
		System.out.println("Invalid Operation");
	}
	void addDescription(String desc) {
		System.out.println("Invalid Operation");
	}
	void assignOwner(String owner) {
		System.out.println("Invalid Operation");
	}
	void changeOwner(String newOwner) {
		System.out.println("Invalid Operation");
	}
	void closeBug() {
		System.out.println("Invalid Operation");
	}
}

class NewBug extends BugState {
	public NewBug(Bug bug) {
		super(bug);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createBug(String details) {
		System.out.println(this.getClass().getSimpleName()+ ": created a new bug");
		bug.changeState(this);
	}

	@Override
	public void addDescription(String desc) {
		System.out.println(this.getClass().getSimpleName()+ ": added description to bug");
		bug.changeState(this);
	}

	@Override
	public void assignOwner(String owner) {
		System.out.println(this.getClass().getSimpleName()+ ": Assigned to "+owner);
		bug.changeState(new AssignedBug(bug));
	}
	
}

class AssignedBug extends BugState {

	public AssignedBug(Bug bug) {
		super(bug);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void changeOwner(String newOwner) {
		System.out.println(this.getClass().getSimpleName()+ ": New owner is "+newOwner);	
		bug.changeState(this);
	}

	@Override
	public void closeBug() {
		System.out.println(this.getClass().getSimpleName()+ ": invalid to close bug");
		bug.changeState(new ClosedState(bug));
	}	
}

class ClosedState extends BugState {

	public ClosedState(Bug bug) {
		super(bug);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void closeBug() {
		System.out.println(this.getClass().getSimpleName()+ ": invalid to close bug");
		bug.changeState(this);
	}	
}
