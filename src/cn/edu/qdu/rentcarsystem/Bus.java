package cn.edu.qdu.rentcarsystem;

public class Bus extends Moto {
	int seatCount;

	public Bus(String name, int seat, int price) {
		super(name, price);
		this.setSeatCount(seat);
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	@Override
	public void show(int i) {
		System.out.print((i + 1) + "\t" + getSeatCount() + "×ù¿Í³µ\t\t" + getPrice() + "\t" + getCarID());

	}

}
