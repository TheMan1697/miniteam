package domain;

public class Menu {
	
	private int menuno;
	private String name;
	private int price;
	private int amount;
	private int category; //1. 라면 2. 식사류 3. 음료 4. 스낵
	private int sales;

	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public Menu(int menuno,String name, int price, int amount, int category) {
		this.menuno = menuno;
		this.name=name;
		this.price = price;
		this.amount = amount;	
		this.category = category;
	}

	public Menu(int sales) {
		this.sales = sales;
	}


	public int getMenuno() {
		return menuno;
	}

	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	@Override
	public String toString() {
		return "Menu [" + menuno +" : " + name + ", 가격 =" + price + "원, 재고=" + amount + "개]";
	}


	
	

}


