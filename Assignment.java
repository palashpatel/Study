/* 
-----------------------------------------------------
	Date :- 2020/11/04
	Assignment #1 
	Written by: Palash Patel - 2094607
				Kudrat Kaur  - 2092376
				
	This assignment is simulate the rolling two dice.In this assignment,dice will be rolled by two different methods which are Math.ramdom and util.Random. And then it will show the simulation of expected occurrence and actual occurrence by tow methods. If user want to repeat rolling of same dice aging then he/she has to press y and then he/she will get the question again. If user want to terminate this code then press any character or number except y which is instructed in this program.
-----------------------------------------------------
*/
import java.util.*;
import java.util.Scanner;
import java.lang.Math;

class Assignment{
	public static void main(String args[]){
		int side = 0; // to store value for sides of dice
		String input = ""; // to get value from user
		boolean check = false;	// to check input is integer or not
		
		Scanner s = new Scanner(System.in);	// object of Scanner to get input from user
		
		System.out.print("\n********************************\n* Welcome to the Random Number *\n********************************\n");
		do{
			try
			{
				System.out.print("What is the number of slides of each die : ");
				input = s.nextLine();
				for(int i=0; i < input.length(); i++)
				{
					if (Character.isDigit(input.charAt(i)) == true){
						check = true;
					}
					else{
						check = false;
						throw new InputMismatchException("\nInvalid Input. Please enter numeric values.\n"); //throw execption for invalid input of dice slides
					}
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println(e.getMessage()); // print exception message
			}
		}while(check != true);
		side = Integer.parseInt(input);
		repeat(side);
	}
	
	static void repeat(int side){
		int  i, j;	// i and j are used for rotating loops 
		long roll;	// to store value of roll for dice
		String input=""; // to get value from user
		boolean check = false;	// to check input is integer or not
		int random;	// this is used for saving random number temporary
		int no_of_output = side * 2; // this is for number of outcomes
		int	total_of_combination = side * side;	// this is for total no of combination
		float ratio,ratio_util,ratio_math;	// to save ration of occured outcomes
		int count[] = new int[no_of_output];	// to count no of expected coutcomes
		int total_count[][] = new int[no_of_output][3];
		int count_util[] = new int[no_of_output];	// to count no of actual coutcomes by using util.Ramdom
		int count_math[] = new int[no_of_output];	// to count no of actual coutcomes by using Math.random
		char reply; // take input of repeat this program with same no of sides
		
		Random r = new Random();	// making object of Random class to generate random number
		Scanner s = new Scanner(System.in);	// object of Scanner to get input from user
		
		do{
			try
			{
				System.out.print("\nHow many times do you want to roll dice? ");
				input = s.nextLine();	// get input for rolling dice
				for(i=0; i < input.length(); i++)
				{
					if (Character.isDigit(input.charAt(i)) == true){
						check = true;
					}
					else{
						check = false;
						throw new InputMismatchException("\nInvalid Input. Please enter numeric values\n");//throw execption for invalid input of roll for dice
					}
				}
			}
			catch (InputMismatchException e)
			{
				System.out.println(e.getMessage());	// print exception message
			}
		}while(check != true);
		
		roll = Integer.parseInt(input);	// storing rolls value in roll variable
		
		for (i = 0; i < no_of_output; i++) {	// to assign value {0} in these three array
			count[i] = 0;
			count_util[i] = 0;
			count_math[i] = 0;
		}
		
		int[][] values = new int[side][side];	// to store sum of actual outcome
		
		for (i = 0; i < side; i++) { // both loops used for count sum of actual occurrence as well as saving occured outcome in 2d-array while rolling dice
            for (j = 0; j < side; j++) {
				values[i][j] = i + j + 2;
				count[i+j]+=1;
            }
		}
		
		for (i = 0; i < roll; i++) {	// to generate random number 
			do{
				random = r.nextInt(no_of_output+1); 
			}while(random == 0 || random == 1);
			count_util[random-2]+=1;
			
			random = (int)(Math.random() * no_of_output-1)+2;
			count_math[random-2]+=1;			
		}
		
		System.out.println("\n\nSum	Should Occur	% Occurred	% Occurred");
		System.out.println("			(util.Random)	(Math.Random)");
		System.out.println("------------------------------------------------------");
		
		for (i = 0; i < no_of_output-1; i++) { // calculate ration of each outcome and print 
			ratio = (float)(count[i]*100)/(total_of_combination);
			ratio_util = (float)(count_util[i]*100)/(roll);
			ratio_math = (float)(count_math[i]*100)/(roll);
			System.out.printf("\n%d	(%d)%.2f%%	(%d)%.2f%%	(%d)%.2f%%",i+2,count[i],ratio,count_util[i],ratio_util,count_math[i],ratio_math);
		}			
		
		
		
		System.out.print("\n\nDo you want to repeat with a different number of rolls? (press any character or number except small 'y' for exit) :- ");
		reply = s.next().charAt(0);
		
		if(reply == 'y' )
			repeat(side);
		else
		{
			System.out.println("\nThank you for using Random Number Generator Tester Application:).");
			System.exit(0);
		}
	}
}