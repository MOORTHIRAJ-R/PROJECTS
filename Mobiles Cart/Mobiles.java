package collectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Mobiles {
	String MobileName;
	int Price ;
	int ramGb;
	int pixel;
	boolean touchScreen;
	
	Mobiles(String MobileName ,int Price ,int ramGb,int pixel,boolean touchScreen){
		this.MobileName = MobileName;
		 this.Price = Price;
		 this.ramGb = ramGb;
		 this.pixel = pixel;
		 this.touchScreen = touchScreen;
	}
	public String toString() {
		return "  " +this.MobileName + " : "+ this.Price + " : " + this.ramGb +" : " + this.pixel + " :" + this.touchScreen ;
		
	}
	

	
	public static void main(String[] args) {
	
		
		Mobiles Nokia = new Mobiles("Nokia",7000,1,8,false);
		Mobiles Vivo = new Mobiles("Vivo",13000,4,32,true);
		Mobiles Realme = new Mobiles ("Realme",13000,8,64,true);
		Mobiles Mi = new Mobiles ("Mi",7000,6,32,true);
		
		ArrayList MobilesList = new ArrayList();
		ComparatorDemo cd = new ComparatorDemo();
		
//		MobilesList.add(Realme);
//		MobilesList.add(Mi);
//		MobilesList.add(Vivo);
//		MobilesList.add(Nokia);
//		cd.compare(MobilesList, cd);
		cd.compare(Mi, Realme);
		
		Scanner sc = new Scanner(System.in);
	
		
		
		while(true){
			System.out.println("1 . View Mobiles ");
			System.out.println("2 . Choose Mobile ");
			System.out.println("3 . Sorting With Options ");
			System.out.println("4 . Enter Your Choice");
			int choice = sc.nextInt();
			sc.nextLine();
		
		switch(choice) {
		
		case 1 : System.out.println(cd.toString());
		break;
		
		}
		}

	}
	
	

	}
