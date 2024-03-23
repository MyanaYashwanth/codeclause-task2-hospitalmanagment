package hospital;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

class Patient {
    String name;
    int age;
    String gender;

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}

public class HospitalManagment {

	public static void main(String[] args){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1311");
			Statement stm= con.createStatement();
			stm.execute("create table patient(name varchar(20), age number(3), gender varchar(6))");
			System.out.println("registerde successfully");
		}catch(Exception e)
		{
			System.err.println(e);
		}
		 Scanner scanner = new Scanner(System.in);
	        List<Patient> patients = new ArrayList<>();

	        while (true) {
	            System.out.println("Hospital Management System");
	            System.out.println("1. Register New Patient");
	            System.out.println("2. View All Patients");
	            System.out.println("3. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    scanner.nextLine();  // Consume newline
	                    System.out.print("Enter patient name: ");
	                    String name = scanner.nextLine();
	                    System.out.print("Enter patient age: ");
	                    int age = scanner.nextInt();
	                    scanner.nextLine();  // Consume newline
	                    System.out.print("Enter patient gender: ");
	                    String gender = scanner.nextLine();

	                    Patient patient = new Patient(name, age, gender);
	                    patients.add(patient);
	                    System.out.println("Patient registered successfully!");
	                    break;

	                case 2:
	                    System.out.println("List of Patients:");
	                    for (int i = 0; i < patients.size(); i++) {
	                        System.out.println("Patient " + (i + 1) + ": " + patients.get(i));
	                    }
	                    break;

	                case 3:
	                    System.out.println("Exiting. Thank you!");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please select a valid option.");
	            }
	        }
	    }
		

	}


