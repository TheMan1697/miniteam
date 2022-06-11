package service;
import java.util.ArrayList;
import java.util.List;
import domain.Customer;

public class CustomerService {
	private static CustomerService cusservice = new CustomerService();
	private List<Customer> customers = new ArrayList<Customer>();
	public static CustomerService getCusservice() {
		return cusservice;
	}
	
	public Customer findBy(String userid, String userpw) {  // 로그인 시 입력한 Id, Pw가 존재하는지 확인
		Customer cus = null;
		for (Customer c : customers) {
			if (c.getId().equals(userid) && c.getPw().equals(userpw)) {
				cus = c;
			}
		}
		return cus;
	}
	public Customer findBy1(String userid) {  // 회원가입 시 이미 존재하는 Id인지 확인
		Customer cus = null;
		for(Customer c : customers) {
			if (c.getId().equals(userid)) {	
				cus = c;
			}
		}			
		return cus;
	}
	
	public void addUser(String username, String userid, String userpw) {  // 회원가입 과정 모두 통과 후 유저목록에 유저 추가
		customers.add(new Customer(username, userid, userpw));
	}
	
	public int userHour(String userid) {  // 사용자의 시간을 리턴 (사용중인 자리에 시간 셋팅 위함)
		int hour = 0;
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				hour = c.getHour();
				break;
			}
		}
		return hour;
	}
	
	public int userMinute(String userid) {  // 사용자의 분을 리턴 (사용중인 자리에 분 셋팅 위함)
		int minute = 0;
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				minute = c.getMinute();
				break;
			}
		}
		return minute;
	}
	
	public String userName(String userid) {  // 사용자의 이름을 리턴 (사용중인 자리에 이름 셋팅 위함)
		String name = "";
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				name = c.getName();
				break;
			}
		}
		return name;
	}
	
	public void userAddTime(String userid, int chargeno) {  // 사용자의 시간 충전 (요금제) 
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				c.setHour(c.getHour() + chargeno);
				break;
			}
		}
	}
	
	public boolean UserSeat(String userid) {     // 사용자의 PC이용 상태 리턴 
		boolean seatcurrent = false;
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				seatcurrent = c.isSeatsetting();
				break;
			}
		}
		return seatcurrent;
	}
	
	public void setUserSeat(String userid, int seatno) {  // 사용자의 PC이용 상태를 true로 변경 (자리 이용 시작)
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				c.setSeatsetting(true);
				c.setSeatno(seatno);
				break;
			}
		}
	}
	
	public int getUserTime(String userid) {  // 사용자의 남은 시간,분을 빼고 절대값으로 변경 후 리턴
		int minimumTime = 0;
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				int hour = c.getHour();
				int minute = c.getMinute();
				minimumTime = hour - minute;
			}
		}
		return Math.abs(minimumTime);
	}
	
	public void tmpMinute(String userid) {  // 사용자의 시간을 1초 마다 1분만큼 빠지게 하기 위함
		int m;                              
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				// 사용자의 PC이용 중간 확인을 마친 시간이 0 이라면 이제 막 자리선택을 마친 사용자이기 때문에 자리를 선택한 시간과 현재 시간을 뺌
				if(c.getIngminute2() == 0) {  
					m = ((int)(c.getIngminute() - c.getStartminute())) / 1000;
				} else {// 사용자의 PC이용 중간 확인을 마친 시간이 0이 아니라면 계속해서 PC를 사용중이기 때문에 중간 확인 마친 시간과 현재 시간을 뺌 
					m = ((int)(c.getIngminute() - c.getIngminute2())) / 1000;
				}
				
				c.setMinute(c.getMinute() - m);  // 사용자가 가지고 있는 시간과 현재까지 이용한 시간을 뺌
				if(c.getMinute() < 0 && c.getHour() > 0) {  // 이후 사용자의 분이 0보다 작아지면 시간에서 1을 빼고 59분부터 다시 1분씩 빼줌
					c.setHour(c.getHour() - 1);		
					c.setMinute(59 - m);
				}
				
				if(c.getMinute() < 0 && c.getHour() <= 0) {  // 사용자의 시간과 분이 모드 0보다 작아질 때 이용종료 *미구현
					c.setSeatsetting(false);
					c.setMinute(0);
					c.setHour(0);
					c.setIngminute(0);
					c.setIngminute2(0);
				}
			}
		}
	}
	
	public void seatStart(String userid) {  // 사용자가 PC이용을 시작한 시간
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				c.setStartminute(System.currentTimeMillis());
			}
		}
	}
	
	public void seatTing1(String userid) {  // 사용자의 PC이용 중간 확인 시작 시간
		for(Customer c : customers) {
			if(c.getId().equals(userid)) {
				c.setIngminute(System.currentTimeMillis());
			}
		}
	}
	
	public void seatTing2(String userId) {  // 사용자의 PC이용 중간 확인 마침 시간
		for(Customer c : customers) {
			if(c.getId().equals(userId)) {
				c.setIngminute2(System.currentTimeMillis());
			}
		}
	}
	
	public boolean getUserSeat(String userId) {  // 사용자의 PC이용 상태를 리턴 (boolean)
		boolean us = false;
		for(Customer c : customers) {
			if(c.getId().equals(userId)) {
				us = c.isSeatsetting();
			}
		}
		return us;
	}
}
