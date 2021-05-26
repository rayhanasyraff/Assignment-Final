package Assignment_Final;

class Hospital {

	private String hospitalID, hospitalName, hospitalAddress, hospitalWorkingHours, hospitalRate;
	
	public Hospital(String hospitalID, String hospitalName, String hospitalAddress, String hospitalWorkingHours, String hospitalRate) {
		this.hospitalID = hospitalID;
		this.hospitalName = hospitalName;
		this.hospitalWorkingHours = hospitalWorkingHours;
		this.hospitalAddress = hospitalAddress;
		this.hospitalRate = hospitalRate;
	}
	
	public String getHospitalID() {
		return hospitalID;
	}
	
	public String getHospitalName() {
		return hospitalName;
	}
	
	public String getHospitalAddress() {
		return hospitalAddress;
	}
	
	public String getHospitalWorkingHours() {
		return hospitalWorkingHours;
	}

	public String getHospitalRate() {
		return hospitalRate;
	}

	public String toString() {
		return "HospitalID: " + hospitalID + 
				" Hospital Name: " + hospitalName +
				" Hospital Working Hours: " + hospitalWorkingHours +
				" Hospital Address: " + hospitalAddress +
				" Hospital Rate: " + hospitalRate;
	}
}
