package project;

import java.util.Map;

public class Admin extends User implements Runnable {
	private int id;
	AllotData allotData;
	
	public Admin(int id, AllotData allotData) {
		this.id = id;
		this.allotData = allotData;
	}
	
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		synchronized (allotData.lock1) {
			
			while (studentsInRound.size() != 0) {
				allotData.roundFinished = false;
				//allotData.studentChanceFlag.clear();
				for (int i = 0; i < studentsInRound.size(); i++) {
					allotData.studentChanceFlag.put(studentsInRound.get(i).getId(), false);
				}
				
				assignStation();
				
				allotData.roundFinished = true;
				
				allotData.lock1.notifyAll();
								
				while (!allStudentsDone()) {
					try {
						allotData.lock1.wait();
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
			allotData.allStudentsAllotted = true;
			
			for (int i = 0; i < students.size(); i++) {
				allotData.studentChanceFlag.put(students.get(i).getId(), false);
			}
			allotData.lock1.notifyAll();
		}
	}
	
	public boolean allStudentsDone() {
		for (Map.Entry<Integer, Boolean> element: allotData.studentChanceFlag.entrySet()) {
			if (element.getValue() == false) {
				return false;
			}
		}
		
		return true;
	}
	
	public void assignStation() {
		studentsInRound.sort(null);
		students.sort(null);
		for (int i = 0; i < studentsInRound.size(); i++) {
			int assigned = 0;
			Student currentStudent = studentsInRound.get(i);
//			System.out.print(currentStudent.getName());
//			System.out.print(students.get(i).getName());
			for (int j = currentStudent.getRoundStart(); j < currentStudent.getPref().size(); j++) {
				String x = currentStudent.getPref().get(j);
				Station temp = stations.get(x);
				if (temp.getSeats() > 0 && temp.getBranchReq().contains(currentStudent.getBranch()) && currentStudent.getSubjectsCompleted().containsAll(temp.getCompulsorySubjects())){
					currentStudent.setStation(temp.getName());
					//System.out.println(currentStudent.getName() + " " + temp.getName());
					temp.setSeats(temp.getSeats() - 1);
					stations.put(x, temp);
					assigned = 1;
					currentStudent.setRoundStart(j+1);
					break;
				}
			}
			
			if (assigned == 0) {
				assigned = 0; //Decide what to do if no station is granted
				currentStudent.setStation(null);
			}		
		}
		studentsInRound.clear();
	}
	
	public void addStation(Station station) {
		stations.put(station.getName(), station);
	}
	
	public void updateSeats(String st, int seats) {
		Station station = stations.get(st);
		station.setSeats(seats);
		stations.put(st, station);
	}
	
	public void updateLocation(String st, String location) {
		Station station = stations.get(st);
		station.setLocation(location);
		stations.put(st, station);
	}
	
	
}
