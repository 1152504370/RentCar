package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Rent {
	private int totalPrice = 0, n = -1;
	Car[] car = new Car[15];
	Bus[] bus = new Bus[10];
	Scanner input = new Scanner(System.in);

	// 开始方法是整个系统的入口，建立两个对象数组，调用构造方法初始化车辆信息
	public void start() {
		String[] type = { "别克商务", "宝马550i", "别克林荫道" };
		int[] seat = { 10, 18 };
		int[] price1 = { 600, 500, 300 };
		int[] price2 = { 800, 1500 };
		for (int i = 0; i < car.length; i++) {
			if (i < car.length / 3) {
				car[i] = new Car("轿车", type[0], price1[0]);
			} else if (i < 2 * car.length / 3) {
				car[i] = new Car("轿车", type[1], price1[1]);
			} else {
				car[i] = new Car("轿车", type[2], price1[2]);

			}
		}
		for (int i = 0; i < bus.length; i++) {
			if (i < bus.length / 2) {
				bus[i] = new Bus("客车", seat[0], price2[0]);
			} else {
				bus[i] = new Bus("客车", seat[1], price2[1]);
			}

		}
		this.welcome();
	}

	// welcome方法显示欢迎界面，并选择轿车或客车的类别，由此进入rent方法
	public void welcome() {
		System.out.println("******************");
		System.out.println("欢迎使用自动租车系统！");
		System.out.println("******************");
		System.out.println("请输入租车数量：(需小于等于车库总车数" + (car.length + bus.length) + ")");
		do {
			if (n != -1)
				System.out.println("您的输入有误，请重新输入！");
			n = input.nextInt();
		} while (n <= 0 || n > (car.length + bus.length));
		for (int i = 0; i < n; i++) {

			int kind = -1;
			do {
				if (kind != -1) {
					System.out.println("您的输入有误或者您选择的车型已全被租用，请重新选则！");
				}
				System.out.println("请输入您想租用第" + (i + 1) + "辆车的类别：(1，轿车2，客车)");
				kind = input.nextInt();
			} while (kind != 1 && kind != 2 || !useful(kind));
			switch (kind) {
			case 1:
				this.rent(this.car); // 通过不同的参数决定具体要调用的子类对象
				break;
			case 2:
				this.rent(this.bus);
				break;

			default:
				break;
			}
		}
	}

	// rent方法，由父类引用指向子类对象，同时实现了轿车和客车两种车型的选择租用功能，节省了代码量
	public void rent(Moto[] v) {
		System.out.println("现有" + v[0].getName() + "信息为：");
		System.out.println("编号\t车型\t\t日租金\t车牌号");

		int a = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i].isUseful()) {
				v[i].show(i);
				System.out.println();
				a++;
			}

		}
		if (a == 0)
			System.out.println("该类型的车辆已全被租用");
		int num = -1;
		do {
			if (num != -1)
				System.out.println("您输入的车型不存在或已被租用，请重新选择！");
			System.out.println("请输入您想要的车型：(填写上述表中的序号即可)");
			num = input.nextInt();
		} while (num <= 0 || num > v.length || !v[num - 1].isUseful());
		System.out.println("您选择的车型单日租金为: " + v[num - 1].getPrice());
		System.out.println("请输入您要租用的天数：");
		int time = input.nextInt();
		v[num - 1].setDays(time);
		v[num - 1].countPrice();
		totalPrice += v[num - 1].getTotalCost();
		v[num - 1].setUseful(false);

		// System.out.println("您的租车费用为: " + totalPrice);
		// System.out.println("确定付费并租用该车？（Y/N）");
		// String yn = input.next();
		// if (yn.equalsIgnoreCase("y")) {
		// System.out.println("您租用的牌号为： " + v[num - 1].getCarID() + "
		// 请收好您的车钥匙！");
		// }
		//
		// System.out.println("再见！");
	}

	public void finalResult() {
		System.out.println("您租用的车辆信息为：");
		System.out.println("序号\t车型\t\t日租金\t车牌号\t租用天数\t租金");
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
		System.out.println("您的租车总费用为：" + totalPrice);
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
