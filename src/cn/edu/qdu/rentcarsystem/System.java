package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class System {
	private int days;
	private int totalPrice;
	Car[] car = new Car[3];
	Bus[] bus = new Bus[2];
	Scanner input = new Scanner(System.in);

	public void creatGarage() {
		String[] type1 = { "别克商务", "宝马55i", "别克林荫道" };
		String[] type2 = { "大于16座", "少于16座" };
		int[] price1 = { 600, 500, 300 };
		int[] price2 = { 800, 1500 };
		for (int i = 0; i < car.length; i++) {
			car[i] = new Car("轿车", type1[i], price1[i]);
		}

		for (int i = 0; i < bus.length; i++) {
			car[i] = new Car("客车", type1[i], price1[i]);
		}
	}

	public void rentCar(){
    	System.out.println("******************");
    	System.out.println("欢迎使用自动租车系统！");
    	System.out.println("******************");
    	System.out.println("请输入您想租用的车的类别：(1，轿车2，客车)");
		int kind = input.nextInt();
		switch (kind) {
		case 1:
			
			for (int i = 0; i <bus.length; i++) {
				System.out.println("现有轿车信息为：");
				System.out.println("车型\t日租金\t车牌号");
				System.out.println((i+1)+car[i].getType()+"  "+car[i].getPrice()+"   "+car[i].getCarID());
				
			}
			
			System.out.println("请输入您想要的车型：(填写上述表中的序号即可)");
			int num = input.nextInt();
			System.out.println("您选择的是车型是"+car[num-1].getType()+car[num-1].getName());
			System.out.println("请输入您要租用的天数：");
			days = input.nextInt();
			totalPrice = car[num-1].countPrice(days);
			System.out.println("您的租车费用为"+totalPrice);
			System.out.println("确定付费并租用该车？（Y/N）");
			String yn = input.next();
			if(yn.equalsIgnoreCase("y")){
				System.out.println("您租用的牌号为"+car[num-1].getCarID()+"请收好您的车钥匙！");
			}
			break;
		case 2:
			for (int i = 0; i <bus.length; i++) {
				System.out.println("现有客车信息为：");
				System.out.println("车型\t日租金\t车牌号");
				System.out.println((i+1)+bus[i].getType()+"  "+bus[i].getPrice()+"   "+bus[i].getCarID());
			}
			System.out.println("请输入您想要的车型：(填写上述表中的序号即可)");
			int num = input.nextInt();
			System.out.println("您选择的是车型是"+car[num-1].getType()+car[num-1].getName());
			System.out.println("请输入您要租用的天数：");
			days = input.nextInt();
			totalPrice = car[num-1].countPrice(days);
			System.out.println("您的租车费用为"+totalPrice);
			System.out.println("确定付费并租用该车？（Y/N）");
			String yn = input.next();
			if(yn.equalsIgnoreCase("y")){
				System.out.println("您租用的牌号为"+car[num-1].getCarID()+"请收好您的车钥匙！");
			}
			
			break;

		default:
			System.out.println("输入有误！");
			break;
		}
		System.out.println("谢谢惠顾！再见！");
    }

	
}
