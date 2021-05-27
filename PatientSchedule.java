public class PatientSchedule {

	private Hospital hospital;
	private Doctor doctor;
	private DoctorSchedule doctorSchedule;
	private double overallPrice, doctorFees;
	private String consultStatus;
	
	 public PatientSchedule(Hospital hospital,Doctor doctor, DoctorSchedule doctorSchedule,double overallPrice, double doctorFees,String consultStatus) {
		  this.hospital = hospital;
		  this.doctor = doctor;
		  this.doctorSchedule= doctorSchedule;
		  this.overallPrice=overallPrice;
		  this.doctorFees = doctorFees;
		  this.consultStatus = consultStatus;
		  
		 }
	
	public double getDoctorFees() {
		return doctorFees;
	}
	
	public void setDoctorFees(double doctorFees) {
		this.doctorFees = doctorFees;
	}
	
	public Hospital getHospital() {
		return hospital;
	}
	
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	
	public Doctor getDoctor() {
		return doctor;
	}
	
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	public DoctorSchedule getDoctorSchedule() {
		return doctorSchedule;
	}
	
	public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
		this.doctorSchedule = doctorSchedule;
	}
	
	public String getconsultStatus() {
		return consultStatus;
	}
	
	public void setconsultStatus(String consultStatus) {
		this.consultStatus = consultStatus;
	}
	
	@Override
	public String toString() {
		return "\nHospital ID: " +hospital.getHospitalID()
				+ "\nHospital Name: " +hospital.getHospitalName()
				+ "\nDoctor Name: " + doctor.getDoctorName()
				+ "\nDoctor: " + doctor.getDoctorName()
				+ "\nOverall price: RM" + overallPrice 
				+ "\nconsultStatus:" + consultStatus;
	}
	
	
}

	
	
