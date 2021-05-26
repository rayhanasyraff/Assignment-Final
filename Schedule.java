package Assignment_Final;

class Schedule {
	
	private String time;
	private String date;
	private String status;
	private String scheduleID;

	
	public Schedule(String scheduleID, String time, String date, String status) {
		this.scheduleID = scheduleID;
		this.time = time;
		this.date = date;
		this.status = status;
	}

	public String getScheduleID() {
		return scheduleID;
	}
	
	public String getTime() {
		return time;
	}


	public String getDate() {
		return date;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String displaySchedule() {
			return "Schedule ID: " + scheduleID + "\nTime: " + time + "\nDate: " + date + "\nStatus: " + status;
		
		}
	}

