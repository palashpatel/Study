import java.util.*;
import java.util.Scanner;

class Question3{
	public static void main(String args[]){
		String password;
		String comments;
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.print("\n\nEnter Password:- ");
			password = s.nextLine();
			
			comments = Pwdcheck(password);
			if(!comments.equals("true"))
				System.out.print(comments);
			
		}while(!comments.equals("true"));
	}
	public static String Pwdcheck(String password)
	{
		int i,count_digit = 0,count_upper = 0,count_symbol = 0;
		String s = "Invalid Password.";
		for(i=0; i < password.length(); i++){
					if (Character.isDigit(password.charAt(i)) == true)
						count_digit++;
					if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
						count_upper++;
					if (password.contains("@") || password.contains("#") 
						  || password.contains("!") || password.contains("~") 
						  || password.contains("$") || password.contains("%") 
						  || password.contains("^") || password.contains("&") 
						  || password.contains("*") || password.contains("(") 
						  || password.contains(")") || password.contains("-") 
						  || password.contains("+") || password.contains("/") 
						  || password.contains(":") || password.contains(".") 
						  || password.contains(", ") || password.contains("<") 
						  || password.contains(">") || password.contains("?") 
						  || password.contains("|"))
						count_symbol++;
				}
				
				if(password.length() < 10 )
					s = s.concat("\nPassword must have atleast 10 characters.");
				if(count_digit < 2)
					s = s.concat("\nPassword must have atleast 2 digits.");
				if(count_upper < 1)
					s = s.concat("\nPassword must have atleast 1 uppercase letter.");
				if(count_symbol < 1)
					s = s.concat("\nPassword must have atleast 1 special symbol.");
				if(s.equals("Invalid Password."))
					s = "true";
		return s;
	}
}