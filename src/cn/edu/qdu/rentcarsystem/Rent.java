package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Rent {
	private int days;
	private int totalPrice;
	Car[] car = new Car[3];
	Bus[] bus = new Bus[2];
	Scanner input = new Scanner(System.in);

	// 开始方法是整个系统的入口，建立两个对象数组，调用构造方法初始化车辆信息
	public void start() {
		String[] type1 = { "别克商务", "宝马550i", "别克林荫道" };
		String[] type2 = { "大于16座", "少于16座" };
		int[] price1 = { 600, 500, 300 };
		int[] price2 = { 800, 1500 };
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car("轿车", type1[i], price1[i]);
		}

		for (int i = 0; i < bus.length; i++) {
			bus[i] = new Bus("客车", type2[i], price2[i]);
		}
		this.welcome();
	}

	// welcome方法显示欢迎界面，并选择轿车或客车的类别，由此进入rent方法
	public void welcome() {
		System.out.println("******************");
		System.out.println("欢迎使用自动租车系统！");
		System.out.println("******************");
		int kind;
		do {
			System.out.println("请输入您想租用的车的类别：(1，轿车2，客车)");
			kind = input.nextInt();
		} while (kind != 1 && kind != 2);
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

	// rent方法，由父类引用指向子类对象，同时实现了轿车和客车两种车型的选择租用功能，节省了代码量
	public void rent(Moto[] v) {
		System.out.println("现有" + v[0].getName() + "信息为：");
		System.out.println("序号\t车型\t日租金\t车牌号");
		for (int i = 0; i < v.length; i++) {

			v[i].show(i);
		}
		int num;
		do {
			System.out.println("请输入您想要的车型：(填写上述表中的序号即可)");
			num = input.nextInt();
		} while (num <= 0 || num > v.length);
		System.out.println(
				"您选择的是车型是: " + v[num - 1].getType() + v[num - 1].getName() + " 单日租金为: " + v[num - 1].getPrice());
		System.out.println("请输入您要租用的天数：");
		days = input.nextInt();
		totalPrice = v[num - 1].countPrice(days);
		System.out.println("您的租车费用为: " + totalPrice);
		System.out.println("确定付费并租用该车？（Y/N）");
		String yn = input.next();
		if (yn.equalsIgnoreCase("y")) {
			System.out.println("您租用的牌号为： " + v[num - 1].getCarID() + " 请收好您的车钥匙！");
		}

		System.out.println("再见！");
	}

}
