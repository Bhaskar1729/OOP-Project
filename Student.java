
package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student extends User implements Comparable<Student>, Runnable {
	private String station;
	private String branch;
	private ArrayList<String> pref = new ArrayList<String>();
	private double cg;
	private String name;
	private int id;
	private ArrayList<String> subjectsCompleted = new ArrayList<String>();
	private int roundStart = 0;
	private AllotData allotData;
	
	Random random = new Random();
	
	Scanner sc = new Scanner(System.in);
	
	public Student (String name, double cg, int id, String branch, ArrayList<String> subjectsCompleted, ArrayList<String> pref, AllotData allotData) {
		this.setName(name);
		this.setId(id);
		this.cg = cg;
		this.setBranch(branch);
		this.setSubjectsCompleted(subjectsCompleted);
		this.setStation(null);
		this.pref = pref;
		this.allotData = allotData;
		allotData.studentChanceFlag.put(id, false);
		students.add(this);
		studentsInRound.add(this);
	}
	
	
	public void run() {
		
		synchronized (allotData.lock1) {
			
			while (!allotData.allStudentsAllotted) {
				
				while(!allotData.roundFinished || allotData.studentChanceFlag.get(id)) {
					try {
						allotData.lock1.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if (!allotData.allStudentsAllotted) {
					boolean accept = false;
					if (this.station != null) {
						System.out.println("Does " + this.name + " accept " + this.station + " (Y/N)");
						String inp = sc.next();
						if (inp.equals("Y")) {
							accept = true;
						}
						
						else {
							accept = false;
						}
					}
					
					
					if (accept || this.station == null) {
						accept();
					}
					
					else {
						reject();
					}
				
				
					allotData.studentChanceFlag.put(id, true);
				
					allotData.lock1.notifyAll();
				}
			}
		}
		
	}
	
	public void accept() {
		if (this.station == null) {
			System.out.println(this.name + " did not get any station");
		}
		
		else {
			System.out.println(this.name + " got " + this.station);

		}
	}
	
	public void reject() {
		Station temp = User.stations.get(this.station);
		if (temp == null) {
			return;
		}
		temp.setSeats(temp.getSeats() + 1);
		stations.put(this.station, temp);
		studentsInRound.add(this);
		System.out.println(this.name + " rejected " + this.station);
		this.station = null;
	}
	
	@Override
	public int compareTo(Student o) {
		if (this.getCg() > o.getCg()) {
			return -1;
		}
		
		else if (this.getCg() < o.getCg()) {
			return 1;
		}
		
		return 0;
	}

	public int getRoundStart() {
		return roundStart;
	}

	public void setRoundStart(int roundStart) {
		this.roundStart = roundStart;
	}

	public ArrayList<String> getPref() {
		return pref;
	}

	public void setPref(ArrayList<String> pref) {
		this.pref = pref;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public ArrayList<String> getSubjectsCompleted() {
		return subjectsCompleted;
	}

	public void setSubjectsCompleted(ArrayList<String> subjectsCompleted) {
		this.subjectsCompleted = subjectsCompleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCg() {
		return cg;
	}

	public void setCg(double cg) {
		this.cg = cg;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}
