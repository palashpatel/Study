import java.util.*;
import java.util.Scanner;

class Question2{
	public static void main(String args[]){
		int total_seconds,hours,minutes,seconds,remenders;
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("Number of seconds:- ");
		total_seconds = s.nextInt();
		
		hours = total_seconds / 3600;
		remenders = total_seconds % 3600;
		minutes = remenders / 60;
		remenders = remenders % 60;
		seconds = remenders;
		
		System.out.println("Hours : " + hours + " Minutes : " + minutes + " Seconds : " + seconds);
	}
}