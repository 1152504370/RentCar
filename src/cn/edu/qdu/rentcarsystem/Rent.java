package cn.edu.qdu.rentcarsystem;

import java.util.Scanner;

public class Rent {
	private int days;
	private int totalPrice;
	Car[] car = new Car[3];
	Bus[] bus = new Bus[2];
	Scanner input = new Scanner(System.in);

	public void creatGarage() {
		String[] type1 = { "�������", "����55i", "��������" };
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

	public void rentCar(){
    	System.out.println("******************");
    	System.out.println("��ӭʹ���Զ��⳵ϵͳ��");
    	System.out.println("******************");
    	System.out.println("�������������õĳ������(1���γ�2���ͳ�)");
		int kind = input.nextInt();
		switch (kind) {
		case 1:
			
			System.out.println("���нγ���ϢΪ��");
			System.out.println("���\t����\t�����\t���ƺ�");
			for (int i = 0; i <car.length; i++) {
				System.out.println((i+1)+"   "+car[i].getType()+"   "+car[i].getPrice()+"    "+car[i].getCarID());
				
			}
			
			System.out.println("����������Ҫ�ĳ��ͣ�(��д�������е���ż���)");
			int num = input.nextInt();
			System.out.println("��ѡ����ǳ�����"+car[num-1].getType()+car[num-1].getName());
			System.out.println("��������Ҫ���õ�������");
			days = input.nextInt();
			totalPrice = car[num-1].countPrice(days);
			System.out.println("�����⳵����Ϊ"+totalPrice);
			System.out.println("ȷ�����Ѳ����øó�����Y/N��");
			String yn = input.next();
			if(yn.equalsIgnoreCase("y")){
				System.out.println("�����õ��ƺ�Ϊ"+car[num-1].getCarID()+"���պ����ĳ�Կ�ף�");
			}
			break;
		case 2:
			System.out.println("���пͳ���ϢΪ��");
			System.out.println("���\t����\t�����\t���ƺ�");
			for (int i = 0; i <bus.length; i++) {
				System.out.println((i+1)+"  "+bus[i].getType()+"   "+bus[i].getPrice()+"   "+bus[i].getCarID());
			}
			System.out.println("����������Ҫ�ĳ��ͣ�(��д�������е���ż���)");
			int num1 = input.nextInt();
			System.out.println("��ѡ����ǳ�����"+bus[num1-1].getType()+bus[num1-1].getName());
			System.out.println("��������Ҫ���õ�������");
			days = input.nextInt();
			totalPrice = bus[num1-1].countPrice(days);
			System.out.println("�����⳵����Ϊ"+totalPrice);
			System.out.println("ȷ�����Ѳ����øó�����Y/N��");
			String yn1 = input.next();
			if(yn1.equalsIgnoreCase("y")){
				System.out.println("�����õ��ƺ�Ϊ"+car[num1-1].getCarID()+"���պ����ĳ�Կ�ף�");
			}
			
			break;

		default:
			System.out.println("��������");
			break;
		}
		System.out.println("лл�ݹˣ��ټ���");
    }

	
}
