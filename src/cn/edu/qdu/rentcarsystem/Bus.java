package cn.edu.qdu.rentcarsystem;

public class Bus extends Moto {
	int seatCount;
	public Bus(String name, int seat, int price) {
		super(name,price);
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
		System.out.println((i + 1) + "\t" + getSeatCount() + "×ù\t" + getPrice() + "\t" + getCarID());
		
	}

}
