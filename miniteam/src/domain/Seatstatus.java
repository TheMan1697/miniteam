package domain;

public class Seatstatus {
	private int seatno;
	private String userid;
	private String username;
	private boolean seatstatus;
	private int userhour;
	private int userminute;
	private String seatcurrent;

	public Seatstatus() {

	}

	public Seatstatus(int seatno, String userid, boolean seatstatus, int userhour, int userminute) {
		this.seatno = seatno;
		this.userid = userid;
		this.seatstatus = seatstatus;
		this.userhour = userhour;
		this.userminute = userminute;
	}

	public Seatstatus(String userid, boolean seatstatus) {
		this.userid = userid;
		this.seatstatus = seatstatus;
	}

	public Seatstatus(int seatno) {
		this.seatno = seatno;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isSeatstatus() {
		return seatstatus;
	}

	public void setSeatstatus(boolean seatstatus) {
		this.seatstatus = seatstatus;
	}

	public int getSeatno() {
		return seatno;
	}

	public void setSeat(int seatno) {
		this.seatno = seatno;
	}

	public int getUserhour() {
		return userhour;
	}

	public void setUserhour(int userhour) {
		this.userhour = userhour;
	}

	public int getUserminute() {
		return userminute;
	}

	public void setUserminute(int userminute) {

		this.userminute = userminute;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	// 시간은 0도 가능한 대신에 분은 1이상
	public String toString() {
		if (userid == null) {
			username = "사용자 없음";
			seatcurrent = "\n";
		} else {
			username = getUsername();
			seatcurrent = getUserhour() + " : " + getUserminute() + "\n";
		}

		return "[" + seatno + "번 자리" + "]\n" + username + "\n" + seatcurrent;
	}
}