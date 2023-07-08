package project;

import java.util.ArrayList;
import java.io.FileReader;
import java.util.*;
import java.util.Scanner; 

public class Main {
	public static void main(String args[]) throws Exception{
		
		AllotData allotData = new AllotData();
		Admin a1 = new Admin(1, allotData);
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Thread ad = new Thread(a1);
		ad.start();
		
		threads.add(ad);


        Scanner std = new Scanner(new FileReader("inp1.txt")); 
        Scanner std1 = null;
        Scanner sta = new Scanner(new FileReader("inp2.txt"));
        Scanner sta1 = null;

        String newLine=null;
        
        while(std.hasNextLine()){
            newLine = std.nextLine();
            std1 = new Scanner(newLine);
            std1.useDelimiter("/");
            int n = std1.nextInt();
            int m = std1.nextInt();

            String a=std1.next();
            double b=std1.nextDouble();
            int c=std1.nextInt();
            String d=std1.next();
            ArrayList<String> e = new ArrayList<String> ();
            ArrayList<String> f = new ArrayList<String> ();
            for (int j=0;j<n;j++){
                e.add(std1.next());
            }
            for (int j=0;j<m;j++){
                f.add(std1.next());
            }
            Student x = new Student(a, b, c, d, e, f, allotData);
            Thread s = new Thread(x);
            s.start();
            threads.add(s);
        }

        while(sta.hasNextLine()){
            newLine = sta.nextLine();
            sta1 = new Scanner(newLine);
            sta1.useDelimiter("/");
            int n = sta1.nextInt();
            int m = sta1.nextInt();

            String a=sta1.next();
            ArrayList<String> b = new ArrayList<String> ();
            ArrayList<String> c = new ArrayList<String> ();
            for (int j=0;j<n;j++){
                b.add(sta1.next());
            }
            for (int j=0;j<m;j++){
                c.add(sta1.next());
            }
            int d=sta1.nextInt();

            Station y = new Station(a, b, c, d);
        }

		//a1.assignStation();	
        
        for (int i = 0; i < threads.size(); i++) {
        	threads.get(i).join();
//        	System.out.println(threads.get(i));
//        	System.out.println(allotData.allStudentsAllotted);
//        	for (int j = 0; j < User.students.size(); j++) {
//        		System.out.print(User.students.get(j).getName() + " " + allotData.studentChanceFlag.get(User.students.get(j).getId()));
//        	}
        }
        
        System.out.println();
        

		for (int i = 0; i < 4; i++) {
			if (User.students.get(i).getStation() != null) {
				System.out.println(User.students.get(i).getName() + " got " + User.students.get(i).getStation());

			}
			
			else {
				System.out.println(User.students.get(i).getName() + " did not get any station.");

			}
		}

        std.close();
        sta.close();

	}
}


//package project;
//
//import java.util.ArrayList;
//import java.util.*;
//
//public class Main {
//	public static void main(String args[]) {
//		ArrayList<String> temp = new ArrayList<String>();
//		ArrayList<String> temp2 = new ArrayList<String>(Arrays.asList("A", "B", "C"));
//
//		temp.add("OOP");
//		temp.add("DSA");
//		temp.add("DBS");
//		ArrayList<String> t5 = new ArrayList<String>();
//		t5.add("OOP");
//		t5.add("DSA");
//
//		Student s1 = new Student("A", 9.8, 1, "CS", temp, temp2);
//		Student s2 = new Student("B", 7, 2, "CS", temp, temp2);
//		Student s3 = new Student("C", 8, 3, "EEE", temp, temp2);
//		Student s4 = new Student("D", 8.5, 4, "EEE", temp, temp2);
//
//		Admin a1 = new Admin(1);
////		//User.students.add(s1);
////		s1.setPref((ArrayList<String>) (Arrays.asList("A", "B", "C"));
////		//User.students.add(s2);
////		s2.setPref((ArrayList<String>) (Arrays.asList("A", "B", "C"));
////		//User.students.add(s3)
////		s3.setPref((ArrayList<String>) (Arrays.asList("A", "B", "C"));
//		
//		ArrayList<String> t3 = new ArrayList<String> ();
//		ArrayList<String> t4 = new ArrayList<String> ();
//
//		
//		t4.add("EEE");
//		
//		t3.add("EEE");
//		t3.add("CS");
//		
//		Station st1 = new Station("A", t3, temp);
//		Station st2 = new Station("B", t4, temp);
//		Station st3 = new Station("C", t4, temp);
//		
////		ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(s1, s2, s3, s4));
////		students.sort(null);
////		
////		for (int i = 0; i < 4; i++) {
////			System.out.print(students.get(i).getName());
////		}
//		
//		a1.assignStation();		
//		
//		for (int i = 0; i < 4; i++) {
//			System.out.println(User.students.get(i).getName() + " " + User.students.get(i).getStation());
//		}
//		
//		//System.out.println(st1.getBranchReq());
//
//		
////		for (int i = 0; i < 3; i++) {
////			User.studentsInRound.add(User.students.get(i));
////		}
//		
//		
//
//		
//	}
//}
