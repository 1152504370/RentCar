package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Rent s = new Rent();
		s.creatGarage();
		int kind;
		do {
			System.out.println("请输入您想租用的车的类别：(1，轿车2，客车)");
			kind = input.nextInt();
		} while (kind != 1 && kind != 2);
		switch (kind) {
		case 1:
			s.rentCar(s.car);
			break;
		case 2:
			s.rentCar(s.bus);
			break;

		default:
			break;
		}

	}
}
