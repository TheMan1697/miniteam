package service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Seatstatus;

/*
 * 유저가 자리를 선택해서 비어있으면 들어간다
 * 들어간 자리에 유저id와 시간을 표시
 * 
 */
public class SeatService {
	private static SeatService seatService = new SeatService();
	CustomerService cusservice = CustomerService.getCusservice();


	public static SeatService getSeatService() {
		return seatService;
	}

	private SeatService() {
	}

	private List<Seatstatus> seats = new ArrayList<Seatstatus>();
	{
		seats.add(new Seatstatus(1));
		seats.add(new Seatstatus(2));
		seats.add(new Seatstatus(3));
	}

	public void list() {  // list 호출 시 각 좌석에 사용중인 사용자의 이름, 시간, 분을 셋팅 
		for(Seatstatus st : seats) {
			if(st.isSeatstatus() == true) {
				if(cusservice.getUserSeat(st.getUserid()) == true && cusservice.getUserTime(st.getUserid()) > 0) {
					cusservice.seatTing1(st.getUserid());
					cusservice.tmpMinute(st.getUserid());
					st.setUserhour(cusservice.userHour(st.getUserid()));
					st.setUserminute(cusservice.userMinute(st.getUserid()));
					cusservice.seatTing2(st.getUserid());
				} else {
					st.setSeatstatus(false);
					st.setUserid(null);
				}
			}
			System.out.println(st);
		}
	}
	public void findBy(int seatno, String userid) {         // 사용자의 시간 확인 후 입력한 좌석이 비어있으면 좌석 이용시작
		int i = seatno - 1;
		if(cusservice.getUserTime(userid) > 0) {
			if (seats.get(i).isSeatstatus() == false) {
				seats.get(i).setSeatstatus(true);
				seats.get(i).setUsername(cusservice.userName(userid));
				seats.get(i).setUserid(userid);
				seats.get(i).setUserhour(cusservice.userHour(userid));
				seats.get(i).setUserminute(cusservice.userMinute(userid));
				cusservice.setUserSeat(userid, seatno);
				cusservice.seatStart(userid);
			} else {
				System.out.println("사용중인 자리 입니다.");
			}			
		} else {
			System.out.println("회원님의 잔여시간이 부족합니다.");
		}
	}
	
	public void logout(int seatNo) {
		
	}
	
}