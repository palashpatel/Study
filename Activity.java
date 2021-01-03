import java.util.*;
import java.lang.Math;

class Activity{
	public static void main(String[] args){
		int i;
		int marks[] = new int[20];
		
		for(i = 0; i < 20; i++){
			marks[i] = (int)(Math.random() * 10)+0;
		}
		for(i = 0; i < 20; i++){
			System.out.print(marks[i]+" ");
		}
		System.out.println("");
		for(i = 0; i < 10; i++){
			System.out.print(i + " : ");
			for(int j = 0; j < 20; j++){
				if(i == marks[j])
					System.out.print("*");
			}
			System.out.println("");
		}
	}
}