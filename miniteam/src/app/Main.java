package app;

import static utils.Util.*;
import service.Service;

public class Main {
	public static void main(String[] args) {
		Service service = new Service();
		
		
		for(boolean b = true; b;) {
			int input = nextInt("╭                                             ╮\r\n"+
							   "   Ⅰ.로그인 Ⅱ회원가입 Ⅲ. 관리자 모드 Ⅳ. 종료  \r\n"+
							    "╰                                             ╯\r\n");
			switch (input) {
			case 1:
				service.login();
				break;
			case 2:
				service.register();
				break;
			case 3:
				service.manager();
				break;
			}
		}
	}
}
