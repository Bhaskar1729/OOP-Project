package project;

import java.util.ArrayList;

public class Station {
	private int seats;
	private String name;
	private ArrayList<String> branchReq = new ArrayList<String>();
	private ArrayList<String> compulsorySubjects = new ArrayList<String>();
	private String location;
	
	public Station (String name, ArrayList<String> branchReq, ArrayList<String> compulsorySubjects, int seats) {
		this.setName(name);
		this.setBranchReq(branchReq);
		this.setCompulsorySubjects(compulsorySubjects);
		this.seats = seats; 	//change later
		User.stations.put(name, this);
	}

	public ArrayList<String> getBranchReq() {
		return branchReq;
	}

	public void setBranchReq(ArrayList<String> branchReq) {
		this.branchReq = branchReq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public ArrayList<String> getCompulsorySubjects() {
		return compulsorySubjects;
	}

	public void setCompulsorySubjects(ArrayList<String> compulsorySubjects) {
		this.compulsorySubjects = compulsorySubjects;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
