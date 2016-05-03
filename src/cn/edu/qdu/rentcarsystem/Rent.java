package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Rent {
	private int days;
	private int totalPrice;
	Car[] car = new Car[3];
	Bus[] bus = new Bus[2];
	Scanner input = new Scanner(System.in);

	public void creatGarage() {
		String[] type1 = { "�������", "����550i", "��������" };
		String[] type2 = { "����16��", "����16��" };
		int[] price1 = { 600, 500, 300 };
		int[] price2 = { 800, 1500 };
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car("�γ�", type1[i], price1[i]);
		}

		for (int i = 0; i < bus.length; i++) {
			bus[i] = new Bus("�ͳ�", type2[i], price2[i]);
		}
	}

	public void welcome() {
		System.out.println("******************");
		System.out.println("��ӭʹ���Զ��⳵ϵͳ��");
		System.out.println("******************");
	}

	public void rentCar(Moto[] v) {
		System.out.println("���нγ���ϢΪ��");
		System.out.println("���\t����\t�����\t���ƺ�");
		for (int i = 0; i < v.length; i++) {

			car[i].show(i);
		}
		int num;
		do {
			System.out.println("����������Ҫ�ĳ��ͣ�(��д�������е���ż���)");
			num = input.nextInt();
		} while (num <= 0 || num > v.length);
		System.out.println("��ѡ����ǳ�����" + v[num - 1].getType() + v[num - 1].getName() + "�������Ϊ" + v[num - 1].getPrice());
		System.out.println("��������Ҫ���õ�������");
		days = input.nextInt();
		totalPrice = v[num - 1].countPrice(days);
		System.out.println("�����⳵����Ϊ" + totalPrice);
		System.out.println("ȷ�����Ѳ����øó�����Y/N��");
		String yn = input.next();
		if (yn.equalsIgnoreCase("y")) {
			System.out.println("�����õ��ƺ�Ϊ" + v[num - 1].getCarID() + "���պ����ĳ�Կ�ף�");
		}

		System.out.println("�ټ���");
	}

}
