/* 
-----------------------------------------------------
	Date :- 2020/11/04
	Assignment #1 
	Written by: Palash Patel - 2094607
				Kudrat Kaur  - 2092376
	
	This assignment is for printing 4 different patterns.
	To print any of this pattern user have to select between 1 to 4 then user have to enter no of lines for that pattern.
	No of line must be between 1 to 10.
	when user want to exit he/she have to enter 5.
-----------------------------------------------------
*/


import java.util.*;	// to import pacakge
import java.util.Scanner; // to implement scanner method by making object of this class

public class Patterns{
	public static void main(String args[]){
		
		System.out.println("\nWelcome to Palash and Kudrat Triangle/Diamond Printer");	//print in new line
		
		question();	// function call
	}
	
	static void question(){	// function declaration
		int no_of_row;	// declaration of integer variable to get the number of line from user
		int choice;	// declaration of integer variable to get the pattern choice from user
		Scanner s = new Scanner(System.in);	// make an object of scanner class to get input from user 
		
		System.out.println("\nWhich pattern do you want to print?");	//print in new line
		System.out.println("1) 54321  2)     1  3) 12345  4)   1  ");	//print in new line
		System.out.println("   5432         12      2345      123  ");	//print in new line
		System.out.println("   543         123       345     12345  ");	//print in new line
		System.out.println("   54         1234        45      123  ");	//print in new line
		System.out.println("   5         12345         5       1  ");	//print in new line
		
		System.out.print("\nEnter your choice(5 to Quit) : ");	//print line
		choice = s.nextInt();	// to get input from the user
		
		do{
			if( choice < 1 || choice > 5)
			{
				System.out.print("\nWoops! "+ choice +" is an illegal choice. Please select number between 1 to 5 and try again.\n");	//print line
				System.out.print("\nPlease enter a number between 1 and 5 inclusive : ");	//print line
				choice = s.nextInt();	// to get input from the user
			}
			else{
				break;
			}
		}while(choice < 1 || choice > 5);
		
		switch(choice){	// we can check "is double equal to(==)" condition for single variable using switch-case statement and after that compiler will execute the code according to matching case, if no case will match to the value of case, at that time default case will be execute
			case 1:
				do
				{
					System.out.print("\nHow many rows would you like to print? ( More than 1 please) : ");	//print line
					no_of_row = s.nextInt();	// to get input from the user
				
					if(no_of_row < 10 && no_of_row > 0){	// check the value is it greater then 0 and less than 10
						pattern1(no_of_row);	// function call and passing argument or parameter 
					}
					else{
						System.out.print("\nPlease enter value greater than 0 and less than 10.\n");	//print line
					}
				}while(no_of_row > 9 || no_of_row <= 0);	// do while loop used for execute the code for the first time without checking condition then check the condition to execute the same code  
				break;	// break out of the code
			case 2:
				do
				{
					System.out.print("\nHow many rows would you like to print? ( More than 1 please) : ");	//print line
					no_of_row = s.nextInt();	// to get input from the user
				
					if(no_of_row < 10 && no_of_row > 0){	// check the value is it greater then 0 and less than 10
						pattern2(no_of_row);	// function call and passing argument or parameter 
					}
					else{
						System.out.print("\nPlease enter value greater than 0 and less than 10.\n");	//print line
					}
				}while(no_of_row > 9 || no_of_row <= 0);	// do while loop used for execute the code for the first time without checking condition then check the condition to execute the same code  
				break;	// break out of the code
			case 3:
				do
				{
					System.out.print("\nHow many rows would you like to print? ( More than 1 please) : ");	//print line
					no_of_row = s.nextInt();	// to get input from the user
				
					if(no_of_row < 10 && no_of_row > 0){	// check the value is it greater then 0 and less than 10
						pattern3(no_of_row);	// function call and passing argument or parameter 
					}
					else{
						System.out.print("\nPlease enter value greater than 0 and less than 10.\n");	//print line
					}
				}while(no_of_row > 9 || no_of_row <= 0);	// do while loop used for execute the code for the first time without checking condition then check the condition to execute the same code  
				break;	// break out of the code
			case 4:
				do
				{
					System.out.print("\nHow many rows would you like to print? ( More than 1 please) : ");	//print line
					no_of_row = s.nextInt();	// to get input from the user
				
					if(no_of_row < 10 && no_of_row > 0){	// check the value is it greater then 0 and less than 10
						pattern4(no_of_row);	// function call and passing argument or parameter 
					}
					else{
						System.out.print("\nPlease enter value greater than 0 and less than 10.\n");	//print line
					}
				}while(no_of_row > 9 || no_of_row <= 0);	// do while loop used for execute the code for the first time without checking condition then check the condition to execute the same code  
				break;	// break out of the code
			case 5:
				System.out.println("Thank you for visiting.:) Hope you enjoyed the triangles and diamonds.\n");	// print new line
				System.exit(0);	// to terminate the code 
				break;	// break out of the code
		}
	}

	//pattern1
	static void pattern1(int n){	// function declaration with argument of parameter
		int j,i;	// declaration of integer variables to rotate loops
		System.out.println("");	// to print new line
		// Loop
		for(i=1;i<=n;i++){	// this function is used for adding new lines
			for(j=n;j>=i;j--){	// this function is used for printing numbers in line
				System.out.print(j);
			}
			System.out.println("");	// to print new line
		}
		question();	// function call
	}
	//pattern2
	public static void pattern2(int n){	// function declaration with argument of parameter
		int j,i;	// declaration of integer variables to rotate loops
		System.out.println("");	// to print new line
		// Loop
		for(i=1;i<=n;i++){	// this function is used for adding new lines
			
			for(j=1;j<=n-i;j++){	// this function is used for printing balnk space in line
				System.out.print(" ");	// to add blank space
			}
			
			for(j=1;j<=i;j++){	// this function is used for printing numbers in line
				System.out.print(j);
			}
			System.out.println("");	// to print new line
		}
		question();	// function call
	}
	//pattern3
	static void pattern3(int n){	// function declaration with argument of parameter
		int j,i;	// declaration of integer variables to rotate loops
		System.out.println("");	// to print new line
		// Loop
		for(i=1;i<=n;i++){	// this function is used for printing new line
			for(j=1;j<=i-1;j++){	// this function is used for printing blank space in line
				System.out.print(" ");	// to add blank space
			}
			for(j=i;j<=n;j++){	// this function is used for printing numbers in line
				System.out.print(j);
			}
			System.out.println("");	// to print new line
		}
		question();	// function call
	}
	//pattern4
	static void pattern4(int n){	// function declaration with argument of parameter
		int j,i;	// declaration of integer variables to rotate loops
		int space=1;	// declaration of integer variable to manage the blank space
		System.out.println("");	// to print new line
		// to check the number (odd or even)
		if(n%2 != 0){
			// to print diamond for odd number
			space = n - 1;
			for (j = 1; j <= n/2+1; j++) 	// this function is used for printing new line
			{
				for (i = 1; i <= space; i++) 	// this function is used for printing space in line
				{
					System.out.print(" ");	// to add blank space
				}
				space--;
				for (i = 1; i <= 2 * j - 1; i++) 	// this function is used for printing numbers in line
				{
					System.out.print(i);                
				}
				System.out.println("");	// to print new line
			}
			space = n/2+1;
			for (j = 1; j <= n/2; j++) 	// this function is used for printing new line
			{
				for (i = 1; i <= space; i++) 	// this function is used for printing blank space` in line
				{
					System.out.print(" ");	// to add blank space
				}
				space++;
				for (i = 1; i <= n - (2 * j); i++) 	// this function is used for printing numbers in line
				{
					System.out.print(i);
				}
				System.out.println("");	// to print new line
			}
		}
		else{
			// to print diamond for even number
			space = n - 1;
			for (j = 1; j <= n/2; j++) 	// this function is used for printing new line
			{
				for (i = 1; i <= space; i++) 	// this function is used for printing blank space in line
				{
					System.out.print(" ");	// to add blank space
				}
				space--;
				for (i = 1; i <= 2 * j - 1; i++) 	// this function is used for printing numbers in line
				{
					System.out.print(i);                
				}
				System.out.println("");	// to print new line
			}
			space = n/2;
			for (j = 1; j <= n/2; j++) 	// this function is used for printing new line
			{
				for (i = 1; i <= space; i++) 	// this function is used for printing blank space line
				{
					System.out.print(" ");	// to add blank space
				}
				space++;
				for (i = 1; i <= n - (2 * j - 1); i++) 	// this function is used for printing numbers in line
				{
					System.out.print(i);
				}
				System.out.println(""); //to print line
			}
		}
		question();	// function call
	}
}