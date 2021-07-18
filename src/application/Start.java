package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args)throws IOException {
		System.out.println("Welcome to student management app");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to DELETE student");
			System.out.println("Press 3 to SHOW student");
			System.out.println("Press 4 to UPDATE student");
			System.out.println("Press 5 to EXIT");
			int choice = Integer.parseInt(br.readLine());
			switch(choice) {
			case 1:
				// add a student
				System.out.println("Enter student name: ");
				String name = br.readLine();
				
				System.out.println("Enter student phone: ");
				String phone = br.readLine();
				
				System.out.println("Enter student city: ");
				String city = br.readLine();
				
				//create student object to store student data
				Student st = new Student(name, phone, city);
				boolean ans = StudentDao.insertStudentToDB(st);
				if(ans) {
					System.out.println("Student added successfully!");
				}else {
					System.out.println("Something went wrong!");
				}
				break;
			case 2:
				System.out.println("Enter student ID to DELETE: ");
				int userId = Integer.parseInt(br.readLine());
				boolean flag = StudentDao.deleteStudent(userId);
				if(flag) {
					System.out.println("Deleted successfully!");
				}else {
					System.out.println("Something went wrong!");
				}
				
				break;
			case 3:
				System.out.println("Student list here :");
				StudentDao.showAllStudent();
				break;
			case 4:
				// update a student
				System.out.println("Enter student ID to update: ");
				int userIdDel = Integer.parseInt(br.readLine());
				
				System.out.println("Enter student new name: ");
				String newName = br.readLine();
				
				System.out.println("Enter student new phone: ");
				String newPhone = br.readLine();
				
				System.out.println("Enter student new city: ");
				String newCity = br.readLine();
				
				//create student object to store student data
				Student st2 = new Student(userIdDel, newName, newPhone, newCity);
				boolean ansDel = StudentDao.updateStudentToDB(st2);
				if(ansDel) {
					System.out.println("Student updated successfully!");
				}else {
					System.out.println("Something went wrong!");
				}
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid option!");
			}
		}
	}

}
