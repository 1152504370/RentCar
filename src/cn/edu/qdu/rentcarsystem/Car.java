package cn.edu.qdu.rentcarsystem;

public class Car extends Moto {
	private String type;

	public Car(String name, String type, int price) {
		super(name, price);
		this.setType(type);
	}

	public void show(int i) {
		System.out.print((i + 1) + "\t" + getType() + "½Î³µ\t" + getPrice() + "\t" + getCarID());

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
