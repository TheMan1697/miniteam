package domain;
public class Customer {
	
	private String name;
	private String id;
	private String pw;
	private int hour;
	private int minute;
	private int seatno;
	private boolean seatsetting;
	private long startminute;
	private long ingminute;
	private long startminute2;
	private long ingminute2;
	
	public Customer() {
		
	}
	
	public Customer(String name, String id, String pw) {
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeatno(int seat) {
		this.seatno = seat;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}

	public boolean isSeatsetting() {
		return seatsetting;
	}

	public void setSeatsetting(boolean seatsetting) {
		this.seatsetting = seatsetting;

	}

	public long getStartminute() {
		return startminute;
	}

	public void setStartminute(long startminute) {
		this.startminute = startminute;
	}

	public long getIngminute() {
		return ingminute;
	}

	public void setIngminute(long ingminute) {
		this.ingminute = ingminute;
	}

	public long getStartminute2() {
		return startminute2;
	}

	public void setStartminute2(long startminute2) {
		this.startminute2 = startminute2;
	}

	public long getIngminute2() {
		return ingminute2;
	}

	public void setIngminute2(long ingminute2) {
		this.ingminute2 = ingminute2;
	}
	
	
	
}



