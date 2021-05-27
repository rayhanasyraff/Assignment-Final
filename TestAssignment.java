import java.util.*;
import java.io.*;
import java.nio.file.*;

public class TestAssignment {

	
	public static String genPatientID(ArrayList<Patient> patient) {
	   
		ArrayList<String> randomID = new ArrayList();
		
		for(int i=0; i < patient.size(); i++) {
			
			randomID.add(patient.get(i).getUserID());
			
		}
		
	    int min = 10000;
	    int max = 99999;
	    
	    String newPatientID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    
	    while(randomID.contains(newPatientID)) {
	    	
	    	newPatientID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    	
	    }
	    
	    	randomID.add(newPatientID);
	    	
	    	return newPatientID;
	    
 	}
	

	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		
		System.out.println("\n\n**********************************************************************************************************************************************************************************************************");
		System.out.println("\n						              WELCOME TO APPOINTMENT BOOKING SYSTEM, GET YOUR CONSULTATION BOOKED NOW!\n");
		System.out.println("**********************************************************************************************************************************************************************************************************");
		System.out.println("\n");
		
		System.out.print("Press 1 to Register (New User)");
		System.out.print("\nPress 2 to Login (Existing User)");
		System.out.print("\nAre you a new or an existing user?\t");
		int determine;
		determine = scanner.nextInt();
		
		
		System.out.print("\n**********************************************************************************************************************************************************************************************************");

		String patientFileName = "patientDatabase.txt";
		Path patientFilePath = Paths.get(patientFileName);
		
		String lines = "";
		ArrayList<Patient> patients = new ArrayList();
		
		String userID, name, password, email, phone, DOB;
			
		try {
			
			BufferedReader patientBr = Files.newBufferedReader(patientFilePath);
			patientBr.readLine();
			
			while((lines = patientBr.readLine()) != null) {
				String[] patientData = lines.split("\t");
				patients.add(new Patient(patientData[0],patientData[1],patientData[2],patientData[3],patientData[4],patientData[5]));
			}
			
			patientBr.close();
			
			FileWriter patientFw = new FileWriter(patientFileName,true);        
			BufferedWriter patientBw = new BufferedWriter(patientFw);
			
			if(determine == 1) {
				
				patientBw.write("\n");
				
				patientBw.write(genPatientID(patients) + "\t");
				
				System.out.print("\n\nUsername: ");
				name = scanner.next();
				patientBw.write(name + "\t");
				

				System.out.print("\n\nPassword: ");
				password = scanner.next();
				patientBw.write(password + "\t");
				

				System.out.print("\n\nEmail: ");
				email = scanner.next();
				patientBw.write(email + "\t");

				
				System.out.print("\n\nPhone number: ");
				phone = scanner.next();
				patientBw.write(phone + "\t");
				
				
				System.out.print("\n\nDate of Birth (DD/MM/YYYY):	");
				DOB = scanner.next();
				patientBw.write(DOB);
				
				scanner.nextLine();

				patients.add(new Patient(genPatientID(patients), name, password, email, phone, DOB));
				
				patientBw.flush();
				patientBw.close();
				
				System.out.println("\n\n**********************************************************************************************************************************************************************************************************");

			} 
			
			else if(determine == 2) {
				
				boolean logInStatus = false;
				
				while(logInStatus != true) {
					
					System.out.print("\n\nEnter User ID: ");
					userID = scanner.next();
					
					
					System.out.print("\n\nEnter Password: ");
					password = scanner.next();
				
				
					for(int i = 0; i < patients.size(); i++) {
						
						if(userID.equals(patients.get(i).getUserID()) && password.equals(patients.get(i).getPass())) {
											
							logInStatus = true;
				
						}
										
					}
					
				}
					
				//scanner.nextLine();
			}
			System.out.println("\n\n**********************************************************************************************************************************************************************************************************");
		}
		
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
		
		


		System.out.println("\n");
		
		// Search for hospital file path
		String hospitalFileName = "hospitalDatabase.txt"; 
		Path hospitalFilePath = Paths.get(hospitalFileName);
		lines = "";

		// System.out.println(hospitalFilePath);

		// Hospital Array
		ArrayList<Hospital> hospitals = new ArrayList();
		
		try {

			// Tell the program to read the chosen file path
			BufferedReader hospitalBr = Files.newBufferedReader(hospitalFilePath);
			
			// Read the first line only
			hospitalBr.readLine();
			
			// Read the rest of the line and insert in Hospital Data
			while((lines = hospitalBr.readLine()) != null) {
				String[] hospitalData = lines.split("\t");
				hospitals.add(new Hospital(hospitalData[0],hospitalData[1],hospitalData[2],hospitalData[3],hospitalData[4]));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("LIST OF HOSPITAL DETAILS\n");
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.printf("%3s\t %12s\t %22s\t \t\t%15s\t \t\t%36s", "ID", "Name", "Working Hours", "Address", "Rating");
		
		System.out.println();
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		for(int i = 0; i < hospitals.size(); i++){
			
			System.out.format("%s\t %s\t %s\t %s\t \t%s",
					hospitals.get(i).getHospitalID(), hospitals.get(i).getHospitalName(),hospitals.get(i).getHospitalWorkingHours(), hospitals.get(i).getHospitalAddress(),hospitals.get(i).getHospitalRate());
			System.out.println();
			
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println("\n\n**********************************************************************************************************************************************************************************************************\n\n");
		
		
		System.out.println("LIST OF DOCTOR DETAILS");
			
		System.out.print("\nEnter Hospital ID: ");

		String hospitalInput = scanner.nextLine();
		
		
		
		Boolean foundState = false;

		// Hospital Array
		ArrayList<Doctor> doctors = new ArrayList();       

		for(int i = 0; i < hospitals.size(); i++) {
			if (hospitalInput.equals(hospitals.get(i).getHospitalID())) {
				foundState = true;
				String doctorFileName = "doctorDatabase/" + hospitalInput + ".txt"; 
				Path doctorFilePath = Paths.get(doctorFileName);
				lines = "";
					
					try {

						// Tell the program to read the chosen file path
						BufferedReader doctorBr = Files.newBufferedReader(doctorFilePath);
						
						// Read the first line only
						doctorBr.readLine();
						
						// Read the rest of the line and insert in Hospital Data
						while((lines = doctorBr.readLine()) != null) {
							String[] doctorData = lines.split("\t");
							doctors.add(new Doctor(doctorData[0],doctorData[1],doctorData[2],doctorData[3]));
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					break;
			}
		}

		if(foundState != true){
			System.out.println("ID does not found");
		}

		for(int p = 0 ; p < doctors.size(); p++) {
			System.out.println(doctors.get(p).toString());
		}
		
		System.out.println("\n\n**********************************************************************************************************************************************************************************************************");

		System.out.println("\nEnter doctor ID: ");
		String doctorInput = scanner.nextLine();

		System.out.print("\n");
		
		//Schedule Array
		ArrayList<DoctorSchedule> doctorSchedules = new ArrayList();       


		foundState = false;

		for(int i = 0; i < doctors.size(); i++) {
			if (doctorInput.equals(doctors.get(i).getDoctorID())) {
				foundState = true;
				String doctorScheduleFileName = "scheduleDatabase/" + doctorInput + ".txt"; 
				Path doctorScheduleFilePath = Paths.get(doctorScheduleFileName);
				lines = "";
					
					try {

						// Tell the program to read the chosen file path
						BufferedReader doctorScheduleBr = Files.newBufferedReader(doctorScheduleFilePath);
						
						// Read the first line only
						doctorScheduleBr.readLine();
						
						// Read the rest of the line and insert in Hospital Data
						while((lines = doctorScheduleBr.readLine()) != null) {
							String[] doctorScheduleData = lines.split("\t");
							doctorSchedules.add(new DoctorSchedule(doctorScheduleData[0],doctorScheduleData[1],doctorScheduleData[2],doctorScheduleData[3]));
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
			}
		}
		
		if(foundState != true){
			System.out.println("ID does not found");
		}
		
		for(int i = 0; i < doctorSchedules.size(); i++) {
			if (doctorSchedules.get(i).getDoctorStatus().equals("Available")) {
				System.out.println(doctorSchedules.get(i).displayDoctorSchedule());
				
			}
			
		}
		
		System.out.println("\n\nEnter your booking Schedule ID from timeslots availabe: ");
		String doctorScheduleInput = scanner.nextLine();
		
		foundState = false;
		
		for(int i = 0; i < doctorSchedules.size(); i++) {
			if(doctorScheduleInput.equals(doctorSchedules.get(i).getDoctorScheduleID())) {
				doctorSchedules.get(i).setStatus("Unavailable");
				foundState = true;
			}
		}
		
		if(foundState != true){
			System.out.println("ID does not found");
		}

	}
}