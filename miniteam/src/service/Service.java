package service;

import static utils.Util.nextInt;
import static utils.Util.nextLine;

import app.Main;
import domain.Customer;

public class Service {
	private String name;
	private String id;
	private String pw;
	private int seat;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	MenuService menuService = MenuService.getMenuService();
	SeatService seatService = SeatService.getSeatService();
	ChargeSevice chargeSevice = ChargeSevice.getInstance();
	CustomerService cusservice = CustomerService.getCusservice();
	ManagerService managerService = ManagerService.getInstance();

	public void register() { // 회원가입
		name = nextLine("•────⋅☾ 이름 ☽⋅────•");
		this.id = nextLine("•────⋅☾ 아이디 ☽⋅────• ");
		Customer cus = cusservice.findBy1(id);
		if (cus == null) {
			pw = nextLine("•────⋅☾ 비밀번호 ☽⋅────•");
			if (pw.equals(nextLine("•────⋅☾ 비밀번호 확인 ☽⋅────•"))) {
				cusservice.addUser(name, id, pw);
			} 
		}
	}

	public void login() {   // 로그인
		try {
			id = nextLine("•────⋅☾ 아이디 ☽⋅────•");
			pw = nextLine("•────⋅☾ 비밀번호 ☽⋅────•");
			Customer cus = cusservice.findBy(id, pw);
			if (cus == null) {
				System.out.println("회원가입이 필요합니다.");

				Main.main(null);
			} else {
				System.out.println("로그인 완료");

				action();
			}

		} catch (Exception e) {
			System.out.println("비밀번호를 확인해주세요.");

		}
	}

	public void seatList() {  // 좌석 확인
		seatService.list();
		if(cusservice.getUserSeat(id) == false) {
			System.out.println("id == false");
			seatSelection();
		} else {
			System.out.println("id == true");
			action();
		}
	}
	
	public void seatSelection() {	
		seat = nextInt("좌석 번호 입력 > ");
		seatService.findBy(seat, id);
		action();
	}
	
	
	public void action() {  // 유저 메뉴
		int input = nextInt("╒◖═════════════════════════════════════════════════════════════◗╕ \r\n "+
	                           "Ⅰ.좌석 확인 및 선택 Ⅱ. 음식 Ⅲ. 요금제 Ⅳ. 메인이동 Ⅴ.로그아웃\r\n"+ 
	                        "╘◖═════════════════════════════════════════════════════════════◗╛\r\n");

		switch (input) {
		case 1:
			seatList();
			System.out.println("주문 완료");
			break;
		case 2:
			food();
			break;
		case 3:
			charge();
			break;
		case 4:
			Main.main(null);
			break;
		case 5:
			logout();
			break;
		}
	}

	public void food() { // 음식
		int category = nextInt(
				" ╭◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ◜◝ ╮\r\n" + 
				"  Ⅰ.라면 Ⅱ.식사류 Ⅲ.음료 Ⅳ.스낵 ᝰꪑ\r\n" + 
				" ╰◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ◟◞ ╯\r\n"  
				);

		menuService.print(category);
		int menuno = nextInt("•────⋅☾ 음식 번호 ☽⋅────•");
		int amount = nextInt("•────⋅☾ 주문 개수 ☽⋅────•");
		menuService.findByMenu(menuno, amount);
		action();
	}

	public void charge() { // 요금제
		chargeSevice.priceList();
		
		int chargeno = nextInt("⚛》》》요금제 선택《《《⚛");

		chargeSevice.findBy(chargeno);
		cusservice.userAddTime(getId(), chargeno);
		action();
	}
	
	public void manager() {   // 관리자
		String manager;
		manager = nextLine(
				"╭◜◝͡◜◝͡◜◝͡◜◝͡◜◝͡◜◝͡◜◝͡◜◝͡◜◝╮\r\n" + 
				"     관리자 비밀번호\r\n"+
				"╰ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞ ͜ ◟◞╯\r\n" + 
				"O\r\n" + 
				"°\r\n" + 
				"/}__/}\r\n" + 
				"( • ▼•)\r\n" + 
				"");

		if(manager.equals("1234")) {
			// 관리자 모드로 전환
						
						
						int recharge =nextInt("1.매출 확인");
						switch (recharge) {
						case 1:
							managerService.foodsCharge();
							managerService.seatCharge();
				break;
			}
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
	}
	
	public void logout() {
	}

}