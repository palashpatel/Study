import java.util.*;
import java.util.Scanner;

class Store{
	public static void main(String args[]){
		int amount,app = 3,music = 7,total_apps,total_music,remain;
		Scanner s = new Scanner(System.in);
		Return:
		System.out.println("How much money do you wish to prepay?");
		amount = s.nextInt();
		if(amount > 0){
		
			total_apps = amount / app;
			remain = amount % app;
			
			System.out.println("\nWith this amount, you will be able to purchase "+ total_apps + " app(s). You will then have "+ remain +"$ left as a credit on your account.");
			
			total_music = amount / music;
			remain = amount % music;
			total_apps = remain / app;
			remain = remain % app;
			
			System.out.println("\nAlternatively, for this amount, you will be able to purchase "+ total_music + " song(s) and "+ total_apps + " app(s). You will then have "+remain+"$ left as a credit on your account.");
			System.out.println("\nThanks for Shopping at Best Music Store!");
		}
		else{
			System.out.println("\nSorry :( you can not buy any app or song.");
		}
	}
}