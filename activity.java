import java.*;
import java.util.*;
import java.util.Scanner;

class Que1{
	public static void main(String args[]){
		int j,i,n;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter No of line of triangle:- ");
		n = s.nextInt();
		for(i=1;i<=n;i++){	
			
			for(j=1;j<=n-i;j++){
				System.out.print(" ");
			}
			for(j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}

class Que2{
	public static void main(String args[]){
		int n,mark,total=0;
		float avg;
		Scanner s = new Scanner(System.in);
		
		System.out.print("How many marks for this student? ");
		n = s.nextInt();
		
		int marks[] = new int[n];
		
		for(int i=0; i < n; i++)
		{
			System.out.print("Marks "+(i+1)+":- ");
			mark = s.nextInt();
			marks[i]=mark;
		}
		for(int i=0; i < n; i++)
		{
			total+=marks[i];
		}
		avg = total/n;
		System.out.print("Avg marks:- "+avg);
	}
}

class Que3{
	public static void main(String args[]){
		int n,val,total=0;
		float avg;
		Scanner s = new Scanner(System.in);
		
		System.out.print("No of arry count:- ");
		n = s.nextInt();
		
		int num[] = new int[n];
		
		for(int i=0; i < n; i++)
		{
			System.out.print("Value of "+(i+1)+":- ");
			val = s.nextInt();
			num[i] = val;
		}
		for(int i=0; i < n; i++)
		{
			if(num[i]%2 == 0 && num[i]%3 != 0)
				total+=num[i];
		}
		avg = (float)total/n;
		System.out.printf("Avg:- %.2f",avg);
	}
}