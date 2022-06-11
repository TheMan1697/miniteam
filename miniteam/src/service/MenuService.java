package service;

import static utils.Util.nextInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import domain.Menu;

public class MenuService {
	private static MenuService menuService = new MenuService();

	public static MenuService getMenuService() {
		return menuService;
	}

	private MenuService() {
	}

	Stack<Integer> sales = new Stack<>();

	private List<Menu> menus = new ArrayList<Menu>();
	{
		int i = 1;
		menus.add(new Menu(i++, "신라면", 2500, 42, 1));
		menus.add(new Menu(i++, "진라면", 2500, 43, 1));
		menus.add(new Menu(i++, "삼양라면", 2000, 36, 1));
		menus.add(new Menu(i++, "참깨라면", 2500, 24, 1));
		menus.add(new Menu(i++, "오징어짬뽕", 2500, 38, 1));
		menus.add(new Menu(i++, "너구리", 2500, 33, 1));
		menus.add(new Menu(i++, "짜파게티", 2500, 40, 1));
		menus.add(new Menu(i++, "팔도비빔면", 2500, 33, 1));
		menus.add(new Menu(i++, "불닭볶음면", 2500, 22, 1));
		menus.add(new Menu(i++, "육개장", 1500, 24, 1));
		menus.add(new Menu(i++, "튀김우동", 1800, 34, 1));
		menus.add(new Menu(i++, "사리곰탕면", 2000, 34, 1));
		menus.add(new Menu(i++, "김치볶음밥", 3500, 40, 2));
		menus.add(new Menu(i++, "새우볶음밥", 3500, 49, 2));
		menus.add(new Menu(i++, "제육덮밥", 5000, 38, 2));
		menus.add(new Menu(i++, "참치마요덮밥", 5000, 29, 2));
		menus.add(new Menu(i++, "소시지계란덮밥", 5000, 45, 2));
		menus.add(new Menu(i++, "제육덮밥", 5000, 38, 2));
		menus.add(new Menu(i++, "돈까스", 6000, 17, 2));
		menus.add(new Menu(i++, "김밥", 2000, 26, 2));
		menus.add(new Menu(i++, "치즈김밥", 2500, 18, 2));
		menus.add(new Menu(i++, "참치김밥", 3000, 33, 2));
		menus.add(new Menu(i++, "소고기김밥", 3000, 21, 2));
		menus.add(new Menu(i++, "오렌지주스", 2000, 25, 3));
		menus.add(new Menu(i++, "사과주스", 2000, 25, 3));
		menus.add(new Menu(i++, "포도주스", 2000, 33, 3));
		menus.add(new Menu(i++, "망고주스", 2000, 34, 3));
		menus.add(new Menu(i++, "레몬주스", 2000, 31, 3));
		menus.add(new Menu(i++, "초코우유", 2000, 21, 3));
		menus.add(new Menu(i++, "바나나우유", 2000, 29, 3));
		menus.add(new Menu(i++, "딸기우유", 2000, 27, 3));
		menus.add(new Menu(i++, "코카콜라", 2500, 32, 3));
		menus.add(new Menu(i++, "칠성사이다", 2500, 29, 3));
		menus.add(new Menu(i++, "몬스터에너지", 3000, 27, 3));
		menus.add(new Menu(i++, "새우깡", 2000, 40, 4));
		menus.add(new Menu(i++, "양파링", 2000, 42, 4));
		menus.add(new Menu(i++, "빼빼로", 2000, 36, 4));
		menus.add(new Menu(i++, "콘칩", 2000, 40, 4));
		menus.add(new Menu(i++, "포카칩", 2200, 41, 4));
		menus.add(new Menu(i++, "치토스", 2200, 33, 4));
		menus.add(new Menu(i++, "초코송이", 1800, 36, 4));
		menus.add(new Menu(i++, "포스틱", 2200, 39, 4));
		menus.add(new Menu(i++, "썬칩", 2500, 35, 4));
		menus.add(new Menu(i++, "꿀꽈배기", 2200, 36, 4));
		menus.add(new Menu(i++, "홈런볼", 2500, 39, 4));
		menus.add(new Menu(i++, "오감자", 2500, 28, 4));
		menus.add(new Menu(i++, "초코칩", 2800, 37, 4));
	}

	public void print(int category) {
		for (Menu m : menus) {
			if (m.getCategory() == category)
				System.out.println(m);
		}
	}

	public Menu findByMenu(int menuno, int amount) {
		Menu menu = null;
		for (Menu m : menus) {
			if(menuno >0 && menuno<48) {
			if (m.getMenuno() == menuno) {
				menu = m;
				if (m.getAmount() >= amount && amount >0) {
					int price = m.getPrice() * amount;
					System.out.println(m.getName() + " " + price + "원 주문되었습니다");
					int s = m.getAmount() - amount;
					int answer = nextInt("Ⅰ. 주문 완료 Ⅱ. 주문취소 Ⅲ. 추가 주문");
					switch (answer) {
					case 1:
						m.setAmount(s);
						sales.push(price);
						break;
					case 2:
						sales.push(price);
						sales.pop();
						System.out.println("주문취소 완료");
						break;
					case 3:
						m.setAmount(s);
						sales.push(price);
						continue;
					}
					break;
				} else {
					System.out.println("재고를 확인해주세요");
				}
			}
				
			}
			else {
				System.out.println("메뉴를 다시 확인해주세요");
				break;
			}
		}

		return menu;

	}

}