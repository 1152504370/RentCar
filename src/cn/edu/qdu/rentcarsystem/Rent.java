package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Rent {
	private int days;
	private int totalPrice;
	Car[] car = new Car[3];
	Bus[] bus = new Bus[2];
	Scanner input = new Scanner(System.in);

	// ��ʼ����������ϵͳ����ڣ����������������飬���ù��췽����ʼ��������Ϣ
	public void start() {
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
		this.welcome();
	}

	// welcome������ʾ��ӭ���棬��ѡ��γ���ͳ�������ɴ˽���rent����
	public void welcome() {
		System.out.println("******************");
		System.out.println("��ӭʹ���Զ��⳵ϵͳ��");
		System.out.println("******************");
		int kind;
		do {
			System.out.println("�������������õĳ������(1���γ�2���ͳ�)");
			kind = input.nextInt();
		} while (kind != 1 && kind != 2);
		switch (kind) {
		case 1:
			this.rent(this.car); // ͨ����ͬ�Ĳ�����������Ҫ���õ��������
			break;
		case 2:
			this.rent(this.bus);
			break;

		default:
			break;
		}
	}

	// rent�������ɸ�������ָ���������ͬʱʵ���˽γ��Ϳͳ����ֳ��͵�ѡ�����ù��ܣ���ʡ�˴�����
	public void rent(Moto[] v) {
		System.out.println("����" + v[0].getName() + "��ϢΪ��");
		System.out.println("���\t����\t�����\t���ƺ�");
		for (int i = 0; i < v.length; i++) {

			v[i].show(i);
		}
		int num;
		do {
			System.out.println("����������Ҫ�ĳ��ͣ�(��д�������е���ż���)");
			num = input.nextInt();
		} while (num <= 0 || num > v.length);
		System.out.println(
				"��ѡ����ǳ�����: " + v[num - 1].getType() + v[num - 1].getName() + " �������Ϊ: " + v[num - 1].getPrice());
		System.out.println("��������Ҫ���õ�������");
		days = input.nextInt();
		totalPrice = v[num - 1].countPrice(days);
		System.out.println("�����⳵����Ϊ: " + totalPrice);
		System.out.println("ȷ�����Ѳ����øó�����Y/N��");
		String yn = input.next();
		if (yn.equalsIgnoreCase("y")) {
			System.out.println("�����õ��ƺ�Ϊ�� " + v[num - 1].getCarID() + " ���պ����ĳ�Կ�ף�");
		}

		System.out.println("�ټ���");
	}

}
