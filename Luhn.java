package finalproject;

/** Programmed by Kevin Wang
 * Date: January 24, 2015
 * Function: Determines whether or not a credit card number is valid. */

import java.util.Scanner;
public class Luhn {
	
	public static void main(String args[]){
		
		Scanner input = new Scanner(System.in);
		
		//Prompt user to enter required variables.
		System.out.println("Enter a credit card number:");
		long ccNumber = input.nextLong();
		
		if(isValid(ccNumber)){
			
			System.out.println("Number is valid.");
			
		}else{
			
			System.out.println("Number is invalid.");
			
		}
		
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long ccNumber){
		
		if(getSize(ccNumber) < 13 || getSize(ccNumber) > 16){
			
			return false;
			
		}
		
		//Assume the prefix is not valid.
				boolean validPrefix = false;
				
				/*Check if the card's prefix matches the prefix for a MasterCard,
				* Visa, American Express, or Discover card. */
				if(	(prefixMatched(ccNumber,  4) && true) ||
					(prefixMatched(ccNumber,  5) && true) ||
					(prefixMatched(ccNumber,  6) && true) ||
					(prefixMatched(ccNumber, 37) && true) ){
					
					validPrefix = true;
					
				}
				
				//Calculate the first four steps of the Mod 10 check.
				long digitSum = sumOfDoubleEvenPlace(ccNumber) + sumOfOddPlace(ccNumber);
				
				boolean validNum;
				
				//Check if the number is divisible by 10 via the method validNum.				
				if(digitSum % 10 == 0){
					
					validNum = true;
					
				}else{ //If not, then the number is false
					
					validNum = false;
					
				}
				
				if(validNum == true && validPrefix == true){
					
					return true;
					
				}else{
					
					return false;
					
				}
		
	}
	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number){
		
		/* Get the length of the number being evaluated, so that
		 * the digits can be counted. */
		
		int numberLength = getSize(number);
		int returnSum = 0;
		
		/* Assuming there are still digits left to be added on,
		 * continue searching for them. */
		for(int i = 0; i < numberLength / 2; i++){
			
			//Find the correct digit by its placement.
			returnSum = returnSum + getDigit(
				( (int)(
						(number / Math.pow(10, ( (i * 2) + 1) ))
				% 10) ) * 2 );
			
		}
		
		return returnSum;
	}
	/** Return this number if it is a single digit, otherwise,
	* return the sum of the two digits */
	public static int getDigit(int number){
		
		// newDigit inherits the value of the original number
		int newDigit = number;
		int d1, d2;
		
		/* So long as the number is greater than one digit,
		 * the loop will continue adding the two digits together.
		 * This means that in the case of 46, the added digits
		 * will become 10, then loop again to become 1. */
		while(newDigit > 9){
		
			d1 = (int)(newDigit / 10) % 10;
			d2 = newDigit % 10;
			newDigit = d1 + d2;
			
		}
		
		return newDigit;
	}
	/** Return sum of odd-place digits in number */
	public static int sumOfOddPlace(long number){
		
		int numberLength = getSize(number);
		
		int returnSum = 0;
		
		for(int i = 0; i < numberLength / 2; i++){
			
			//Find the value of every odd digit by its placement
			returnSum = returnSum + getDigit(
				( (int)(
						(number / Math.pow(10, ( i * 2 ) ))
				% 10) ) );
			
		}
		
		return returnSum;
		
	}
	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d){
		
		long numPrefix;
		
		if(d > 9){
			
			//For a two-digit prefix, make sure to collect two digits
			numPrefix = getPrefix(number, 2);
			
		}else{
			
			//Otherwise, only collect the first digit from number
			numPrefix = getPrefix(number, 1);
			
		}
		
		//Check if number's prefix matches the expected prefix
		if(numPrefix == d){
			
			return true;
			
		}else{
			
			return false;
			
		}
		
	}
	/** Return the number of digits in d */
	public static int getSize(long d){
		
		int numberLength = 0;
		
		/* Continually dividing the number by powers of 10
		 * until the number is less than 1. The power it takes
		 * is the number of digits in the number. */
		for(int i = 0; i < 20; i++){
			
			if(d / Math.pow(10, i) < 1){
				
				/* When the number becomes less than one, the loop
				 * has executed once for every digit in the number. */
				
				numberLength = i;
				break;
				
			}
			
		}
		
		return numberLength;
	}
	/** Return the first k number of digits from number. If the
	* number of digits in number is less than k, return number. */
	public static long getPrefix(long number, int k){
		
		//Get size of the first parameter
		int numberLength = getSize(number);
		long prefix;
		
		/* If the method is asking for more digits than exist,
		 * the program will simply return the original value. */
		if(k > numberLength){
			
			prefix = number;
			
		}else{
		
			//Otherwise, return the first k digits of the number.
			prefix = ( (long) ( number / Math.pow(10, numberLength - k) ) );
		
		}
		
		return prefix;
		
	}
	
}