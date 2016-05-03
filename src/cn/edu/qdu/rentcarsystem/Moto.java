package cn.edu.qdu.rentcarsystem;

public abstract class Moto {
      private String name;
      private String type; 
      private int price;
      private String carID;
      public Moto() {
    	  
	}
      public Moto(String name,String type,int price){
    	  this.setName(name);
    	  this.setType(type);
    	  this.setPrice(price);
    	  String iD = "³B"+(int)(Math.random()*9000+1000);
    	  this.setCarID(iD);
      }
      public void show(int i){
    	  System.out.println((i+1)+"\t"+getType()+"\t"+getPrice()+"\t"+getCarID());
      }
      
      public int countPrice(int days){
    	  return days*this.price;
      }
     public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCarID() {
		return carID;
	}

	public void setCarID(String carID) {
		this.carID = carID;
	}
      
      
}
