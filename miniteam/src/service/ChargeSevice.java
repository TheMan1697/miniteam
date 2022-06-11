package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import domain.Charge;

public class ChargeSevice {
	private static ChargeSevice chargeSevice = new ChargeSevice();

	public static ChargeSevice getInstance() {
		return chargeSevice;
	}

	private ChargeSevice() {
	}

	Stack<Integer> cha = new Stack<Integer>();

	private List<Charge> charges = new ArrayList<Charge>();

	{
		int i = 1;
		charges.add(new Charge(i++, 1, 1000));
		charges.add(new Charge(i++, 2, 2000));
		charges.add(new Charge(i++, 3, 3000));
		charges.add(new Charge(i++, 4, 4000));
		charges.add(new Charge(i++, 5, 5000));
		charges.add(new Charge(i++, 6, 6000));
		charges.add(new Charge(i++, 7, 7000));
		charges.add(new Charge(i++, 8, 8000));
		charges.add(new Charge(i++, 9, 9000));
		charges.add(new Charge(i++, 10, 10000));

	}

	public void priceList() { // 요금제 표
		for (Charge charge : charges) {
			System.out.println(charge);
		}
	}

	public Charge findBy(int chargeno) {
		Charge charge = null;
		for (Charge ch : charges) {
			if (ch.getchargeno() == chargeno) {
				charge = ch;
				int price = ch.getMoney();
				cha.push(price);
				System.out.println(ch.getMoney());
				break;
			}
		}
		return charge;
	}

}
