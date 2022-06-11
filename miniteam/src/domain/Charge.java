package domain;

public class Charge {
	int chargeno;
	int time;
	int money;
	

	public Charge(int chargeno, int time, int money) {
		this.chargeno = chargeno;
		this.time = time;
		this.money = money;
	}

	

	public int getchargeno() {
		return chargeno;
	}

	public void setchargeno(int chargeno) {
		this.chargeno = chargeno;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "[" + chargeno + "번] " + " [" + time + "시간 : " + money + "원]";
	}
	
	
}
