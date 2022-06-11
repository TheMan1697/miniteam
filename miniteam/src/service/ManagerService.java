package service;

import java.util.Stack;

public class ManagerService {
	private static ManagerService managerService = new ManagerService();
	private ManagerService() {}
	public static ManagerService getInstance() {
		return managerService;
	}
	SeatService seatService = SeatService.getSeatService();
	ChargeSevice chargeSevice = ChargeSevice.getInstance();
	
	public void foodsCharge() {
		Stack<Integer> menusales = MenuService.getMenuService().sales;
		int salesum = 0;
		for (int ss : menusales) {
			salesum +=ss;
		}
		System.out.println("음식 매출은 "+salesum+"입니다.");
		
	}
	
	public void seatCharge() {
		Stack<Integer> charges = ChargeSevice.getInstance().cha;
		int chargesum = 0;
		for (int cs : charges) {
			chargesum +=cs;
		}
		System.out.println("요금제 매출은 "+chargesum+"입니다.");
	}
	
}
