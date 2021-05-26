package Assignment_Final;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class TestAssignment {


	
//	public static double getRandomUserID(double min, double max) {
//		
//		double randomUserID = Math.random();
//		int userID = (int) randomUserID;
//		userID = Integer.parseInt(Str);
//		return userID;
//	}
	
//	public static String generateRandomID(ArrayList<Random> randoms) {
//	
//		
//		   Random rand = new Random();
//		   
//		   	int max = 99999;
//		   	int min = 10000;
//		   	
//		   	int int_random = rand.nextInt((max - min) + 1) + min;
//		     
//		    String random = Integer.toString(int_random);
//		      
//		      return random;
//		      
//
//		      
//	}
	
	public String genPatientID(ArrayList<Patient> patient) {
	   
		
	    int min = 10000;
	    int max = 99999;
	    
	    String newPatientID = (Integer.toString((int)Math.floor(Math.random()*(max-min+1)+min)));
	    
	    boolean checkID = false;
	    
	    while(checkID == false) {
	    	
	    	 for (int i = 0; i < patient.size(); i++) {
	    		  
	    		    if (newPatientID.equals(patient.get(i).getUserID())) {
	    		    	
	    		    	
	    		    	
	    		    }
	    		    	
	    		   }
	    		  
	    	
	    }
 }
	

	
	public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
        
    	System.out.println("\n\n**********************************************************************************************************************************************************************************************************");
    	System.out.println("\n						              WELCOME TO APPOINTMENT BOOKING SYSTEM, GET YOUR CONSULTATION BOOKED NOW!\n");
    	System.out.println("**********************************************************************************************************************************************************************************************************");
    	System.out.println("\n");
    	
    	System.out.print("Press 1 to Register (New User)");
    	System.out.print("\nPress 2 to Login (Existing User)");
    	System.out.print("\n\nAre you a new or an existing user?\t");
    	int determine = scanner.nextInt();
    	
	
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
				
				patientBw.write("ID\t");
			  
				System.out.print("\n\nEnter Name: ");
				name = scanner.next();
				patientBw.write(name + "\t");
				
				scanner.nextLine();

				System.out.print("\n\nEnter Password: ");
				password = scanner.next();
				patientBw.write(password + "\t");
				
				scanner.nextLine();

				System.out.print("\n\nEnter Email: ");
				email = scanner.next();
				patientBw.write(email + "\t");
				
				scanner.nextLine();

				System.out.print("\n\nEnter Phone number: ");
				phone = scanner.next();
				patientBw.write(phone + "\t");
				
				scanner.nextLine();

				System.out.print("\n\nEnter Date of Birth (DD/MM/YYYY):	");
				DOB = scanner.next();
				patientBw.write(DOB);
				
				scanner.nextLine();

				patients.add(new Patient("ID", name, password, email, phone, DOB));
				
				patientBw.flush();
				patientBw.close();

			} else if(determine == 2) {
				
				System.out.print("\n\nEnter User ID: ");
				userID = scanner.next();
				
				System.out.print("\n\nEnter Password: ");
				password = scanner.next();
				
			}
    	
    	}
    	
    	catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } 
    	
    	catch (IOException e) {
	        e.printStackTrace();
	    }
    	
    	


    	System.out.println("\n\n\n");
    	
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
    

        for(int i = 0 ; i < hospitals.size(); i++) {
			System.out.println(hospitals.get(i).toString());
		}
        
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
        
        System.out.println("\nEnter doctor ID: ");
        String doctorInput = scanner.nextLine();

        System.out.print("\n");
        
        //Schedule Array
        ArrayList<Schedule> schedules = new ArrayList();       


        foundState = false;

        for(int i = 0; i < doctors.size(); i++) {
        	if (doctorInput.equals(doctors.get(i).getDoctorID())) {
                foundState = true;
        		String scheduleFileName = "scheduleDatabase/" + doctorInput + ".txt"; 
        	    Path scheduleFilePath = Paths.get(scheduleFileName);
        	    lines = "";
        	        
        	        try {

        	            // Tell the program to read the chosen file path
        	            BufferedReader scheduleBr = Files.newBufferedReader(scheduleFilePath);
        	            
        	            // Read the first line only
        	            scheduleBr.readLine();
        	            
        	            // Read the rest of the line and insert in Hospital Data
        	            while((lines = scheduleBr.readLine()) != null) {
        	                String[] scheduleData = lines.split("\t");
        	                schedules.add(new Schedule(scheduleData[0],scheduleData[1],scheduleData[2],scheduleData[3]));
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
        
        for(int i = 0; i < schedules.size(); i++) {
        	if (schedules.get(i).getStatus().equals("Available")) {
        		System.out.println(schedules.get(i).displaySchedule());
        		
        	}
        	
        }
        
        System.out.println("\n\nEnter your booking Schedule ID from timeslots availabe: ");
        String scheduleInput = scanner.nextLine();
        
        foundState = false;
        
        for(int i = 0; i < schedules.size(); i++) {
        	if(scheduleInput.equals(schedules.get(i).getScheduleID())) {
        		schedules.get(i).setStatus("Unavailable");
        		foundState = true;
        	}
        }
        
        if(foundState != true){
            System.out.println("ID does not found");
		}

    }
