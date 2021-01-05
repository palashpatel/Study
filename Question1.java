import java.util.*;
import java.util.Scanner;

class Question1{
	public static void main(String args[]){
		int number,i,j;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter Number :- ");
		number = s.nextInt();
		System.out.print("       ");
		for(i = 1; i <= number; i++){
			System.out.printf("   %d",i);
		}
		System.out.println("  ");
		for(i = 1; i <= number; i++){
			System.out.print("------");
		}
		System.out.println("  ");
		for(i = 1; i <= number; i++){
			System.out.print("    " + i + "| ");
			for(j = 1; j <= number; j++){
				if(i == j)
					System.out.print("   *");
				else{
					if(i*j < 10)
						System.out.printf("   %d",i*j);
					else
						System.out.printf("  %d",i*j);
				}
			}
			System.out.println("");
		}
		
	}
}