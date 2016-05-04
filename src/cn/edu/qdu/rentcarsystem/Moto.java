package cn.edu.qdu.rentcarsystem;

public abstract class Moto {
	private String name;

	private int price;
	private String carID;
	private int days;
	private int totalCost;
	private boolean useful;

	public Moto() {

	}

	public Moto(String name, int price) {
		this.setName(name);
		this.setPrice(price);
		this.useful = true;
		String iD = "³B" + (int) (Math.random() * 9000 + 1000);
		this.setCarID(iD);
	}

	public abstract void show(int i);

	public int countPrice() {
		totalCost = days * this.price;
		return totalCost;
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

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}

	public boolean isUseful() {
		return useful;
	}

	public void setUseful(boolean useful) {
		this.useful = useful;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

}
