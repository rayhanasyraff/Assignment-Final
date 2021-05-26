package Assignment_Final;

public class Doctor {
	private String specialty;
	private String doctorID;
	private String doctorName;
	private String phone;

  public Doctor(String doctorID, String doctorName, String phone, String specialty) {
	  this.doctorID = doctorID;
	  this.doctorName = doctorName;
	  this.phone = phone;
	  this.specialty = specialty;
  }


public String getDoctorID() {
	return doctorID;
}
public String getDoctorName() {
	return doctorName;
}
public String getPhone() {
	return phone;
}
public String getSpecialty() {
	return specialty;
}
public String toString() {
	return "\nDoctor ID: "+ doctorID + "\nDoctor Name: "+ doctorName + "\nDoctor's phone: " 
			+ phone + "\nDoctor's Specialty: " + specialty; 
}

  
}
