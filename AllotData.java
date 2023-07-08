package project;

import java.util.HashMap;

public class AllotData {
	public boolean roundFinished = false;
	public boolean studentResponseDone = false;
	public boolean allStudentsAllotted = false;
	HashMap<Integer, Boolean> studentChanceFlag = new HashMap<Integer, Boolean>();
	
	public AllotData() {
		this.roundFinished = false;
		this.studentResponseDone = false;
		this.allStudentsAllotted = false;
		
	}
	Object lock1 = new Object();
	
}
