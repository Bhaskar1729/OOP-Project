package project;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner; 

public class Main {
	public static void main(String args[]) throws Exception{

        Scanner std = new Scanner(new FileReader("inp1.txt")); 
        Scanner std1 = null;
        Scanner sta = new Scanner(new FileReader("inp2.txt"));
        Scanner sta1 = null;

        String newLine=null;
        
        while(std.hasNextLine()){
            newLine = sc.nextLine();
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
            Student x = new Student(a, b, c, d, e, f);
        }

        for (int i=0;i<3;i++){
            newLine = sc.nextLine();
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

		Admin a1 = new Admin(1);
		a1.assignStation();	

		for (int i = 0; i < 4; i++) {
			System.out.println(User.students.get(i).getName() + " " + User.students.get(i).getStation());
		}

        std.close();
        sta.close();
	}
}
