package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Rent {
	private int totalPrice = 0, n = -1;
	Car[] car = new Car[15];
	Bus[] bus = new Bus[10];
	Scanner input = new Scanner(System.in);

	// ��ʼ����������ϵͳ����ڣ����������������飬���ù��췽����ʼ��������Ϣ
	public void start() {
		String[] type = { "�������", "����550i", "��������" };
		int[] seat = { 10, 18 };
		int[] price1 = { 600, 500, 300 };
		int[] price2 = { 800, 1500 };
		for (int i = 0; i < car.length; i++) {
			if (i < car.length / 3) {
				car[i] = new Car("�γ�", type[0], price1[0]);
			} else if (i < 2 * car.length / 3) {
				car[i] = new Car("�γ�", type[1], price1[1]);
			} else {
				car[i] = new Car("�γ�", type[2], price1[2]);

			}
		}
		for (int i = 0; i < bus.length; i++) {
			if (i < bus.length / 2) {
				bus[i] = new Bus("�ͳ�", seat[0], price2[0]);
			} else {
				bus[i] = new Bus("�ͳ�", seat[1], price2[1]);
			}

		}
		this.welcome();
	}

	// welcome������ʾ��ӭ���棬��ѡ��γ���ͳ�������ɴ˽���rent����
	public void welcome() {
		System.out.println("******************");
		System.out.println("��ӭʹ���Զ��⳵ϵͳ��");
		System.out.println("******************");
		System.out.println("�������⳵������(��С�ڵ��ڳ����ܳ���" + (car.length + bus.length) + ")");
		do {
			if (n != -1)
				System.out.println("���������������������룡");
			n = input.nextInt();
		} while (n <= 0 || n > (car.length + bus.length));
		for (int i = 0; i < n; i++) {

			int kind = -1;
			do {
				if (kind != -1) {
					System.out.println("�����������������ѡ��ĳ�����ȫ�����ã�������ѡ��");
				}
				System.out.println("�������������õ�" + (i + 1) + "���������(1���γ�2���ͳ�)");
				kind = input.nextInt();
			} while (kind != 1 && kind != 2 || !useful(kind));
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
	}

	// rent�������ɸ�������ָ���������ͬʱʵ���˽γ��Ϳͳ����ֳ��͵�ѡ�����ù��ܣ���ʡ�˴�����
	public void rent(Moto[] v) {
		System.out.println("����" + v[0].getName() + "��ϢΪ��");
		System.out.println("���\t����\t\t�����\t���ƺ�");

		int a = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].isUseful()) {
				v[i].show(i);
				System.out.println();
				a++;
			}

		}
		if (a == 0)
			System.out.println("�����͵ĳ�����ȫ������");
		int num = -1;
		do {
			if (num != -1)
				System.out.println("������ĳ��Ͳ����ڻ��ѱ����ã�������ѡ��");
			System.out.println("����������Ҫ�ĳ��ͣ�(��д�������е���ż���)");
			num = input.nextInt();
		} while (num <= 0 || num > v.length || !v[num - 1].isUseful());
		System.out.println("��ѡ��ĳ��͵������Ϊ: " + v[num - 1].getPrice());
		System.out.println("��������Ҫ���õ�������");
		int time = input.nextInt();
		v[num - 1].setDays(time);
		v[num - 1].countPrice();
		totalPrice += v[num - 1].getTotalCost();
		v[num - 1].setUseful(false);

		// System.out.println("�����⳵����Ϊ: " + totalPrice);
		// System.out.println("ȷ�����Ѳ����øó�����Y/N��");
		// String yn = input.next();
		// if (yn.equalsIgnoreCase("y")) {
		// System.out.println("�����õ��ƺ�Ϊ�� " + v[num - 1].getCarID() + "
		// ���պ����ĳ�Կ�ף�");
		// }
		//
		// System.out.println("�ټ���");
	}

	public void finalResult() {
		System.out.println("�����õĳ�����ϢΪ��");
		System.out.println("���\t����\t\t�����\t���ƺ�\t��������\t���");
		int count = 0;
		for (int i = 0; i < car.length; i++) {
			if (!car[i].isUseful()) {
				car[i].show(count);
				System.out.println("\t" + car[i].getDays() + "\t" + car[i].getTotalCost());
				count++;
			}
		}
		for (int i = 0; i < bus.length; i++) {
			if (!bus[i].isUseful()) {
				bus[i].show(count);
				System.out.println("\t" + bus[i].getDays() + "\t" + bus[i].getTotalCost());
				count++;
			}
		}
		System.out.println("�����⳵�ܷ���Ϊ��" + totalPrice);
	}

	public boolean useful(int kind) {
		switch (kind) {
		case 1:
			for (int i = 0; i < car.length; i++) {
				if (car[i].isUseful())
					return true;
			}
			return false;
		case 2:
			for (int i = 0; i < bus.length; i++) {
				if (bus[i].isUseful())
					return true;
			}
			return false;

		default:
			break;
		}
		return false;

	}

}
