// ----------------------------------------------------- 
// Activity #6 
// Written by: Palash Patel 
// Student id: 2094607
// Question 1 class is for first question. In this class we have to take string from user and we have to replace a,e,i with * and we have to convert string in lower case.
// Question 2 class is for second question. In this class we have to take string from user and we have to make string reverse and then print it.
// -----------------------------------------------------
import java.util.*;
import java.util.Scanner;

class Question1{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a string:- ");
		String str = s.nextLine(); // get input from user
		int length = str.length();	// this is for getting length of str variable
			
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i')/*check for a or e or i */{
				int pos = str.indexOf(str.charAt(i));
				str = str.substring(0,pos)+"*"+str.substring(pos+1,length);// to set * in position where a or e or i and then save in str
			}
		}
		System.out.println(str);
	}
}

class Question2{
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a string:- ");
		String str = s.nextLine();	// get input from user
		String[] strarray = str.split(" ");	// making array of string by splitting from " " 
		int length = strarray.length;	// to find length of strarray array
		for(length = length - 1; length >=0 ; length--)// print string in reverse
		{
			System.out.print(strarray[length]);
			System.out.print(" ");
		}
	}
}