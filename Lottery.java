/*Ryan S Hutton
 * 04/04/13
 * Create a lottery game application. Generate four random numbers, each between 0 and 9 (inclusive). 
 * Allow the user to guess four numbers. Compare each of the user’s guesses to the four random numbers and 
 * display a message that includes the user’s guess, the randomly determined four-digit number, and the amount 
 * of points the user has won as follows: */

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery 
{
	  private int num1;
      private int num2;
      private int num3;
      private int num4;
      ArrayList<Integer> my_list = new ArrayList<Integer>();
      private int totalMatch;
      private int totalWinnings = 0;
      int[] userLottoGuesses = {0,0,0,0};
     
      
      //empty constructor
	  public Lottery()
	  {    
	       
		  
	  }
	  /*Lotto was an exciting method for me on this assignment. It started as a way to generate the random lotto numbers and take
	   * the users guesses.. and it still is! But the way it does so has changed dramatically since the first draft.
	   * At first lotto was about a page and a half of if statements. It quickly got out of hand, I turned to stackexchange and
	   * other sites for help. They all said, use a arraylist. So I got to learn how to use array lists. Entered all of the
	   * user input into an array list, if a duplicate is found the counter resets and the user is prompted again for the input.*/
	  public void lotto()
	  {
		  Scanner inputDevice = new Scanner(System.in);
		  Random random = new Random();
		  num1 = random.nextInt(10);
		  num2 = random.nextInt(10);
		  num3 = random.nextInt(10);
		  num4 = random.nextInt(10);
		
		  for (int z = 0; z<4; z++){
		      System.out.println("Enter a number between 0-9. No duplicates please!");
		      int input = inputDevice.nextInt();
		      if(my_list.contains(input)){
		          System.out.println("Duplicate found! Please enter a non-repeating digit");
		          z--;
		      }
		      else{
		          my_list.add(input);
		      }
		  }
		  		
		  		
		 
	  }  		
	  
		
     
	  
	 
	  
	  
	  
	  /*Check guesses, well does what it says. It checks the users guesses against the 4 randomly generated numbers. If a match is found,
	   * totalMatch is increased by 1. The 4 guesses are turned into their own array. ArrayList was giving me fits here.. so I simply
	   * copied its contents into userLottoGuesses.*/
	  public void checkGuesses()
	     {
		  
		  
		  int[] myRandomLotto = {num1, num2, num3, num4};
	      
	      
	      for (int i = 0; i < userLottoGuesses.length; i++) {
	          userLottoGuesses[i] = (int)my_list.get(i);
	      }
	       
	      
	      for (int i=0; i<userLottoGuesses.length; i++){
	    	  for (int k=0; k<myRandomLotto.length; k++) 
	    	  { 
	    	  if (myRandomLotto[k]==userLottoGuesses[i]) 
	    	  { 
	    	  
	    	  totalMatch++;
	    	  
	    	  System.out.println("test: " + myRandomLotto[k]);
	    	  
	    	  } 
	    	  
	    	  } 
	      }
           					
	      			
           				
           					
	       
	  }
		/*Check winnings uses a switch statement to assign the total winnings amount awarded for correct guesses. */
		public int checkWinnings()
	     {
	    	switch(totalMatch){
	    	case 0:
	    		totalWinnings = 0;
	    		break;
	    	case 1:
	    		totalWinnings = 5;
	    		break;
	    	case 2:
	    		totalWinnings = 100;
	    		break;
	    	case 3:
	    		totalWinnings = 2000;
	    		break;
	    	case 4: 
	    		totalWinnings = 1000000;
	    		break;
	    	default:
	    		System.out.println("Something went wrong...");
	    	}
			return totalWinnings;
	    	
	    
	      }
		//Show data displays the users guesses, the random lotto numbers, displays the total matches, and finally
		//it then calls check winnings to see how much the user has won!
		public void showdata()
		{
		
			
		
			System.out.println("The original number was; " + num1 +
					 num2 + num3 + num4);
			System.out.println("Your guess was: " + Arrays.toString(userLottoGuesses) );
			System.out.println("You have made a match: " + totalMatch);
			System.out.println("You have won:  " + checkWinnings());
			
		}
	    	 
	     
		             
		

			/**this is a main method
			 * Create a lottery object, use that object to call Lottery's methods
			 */
			public static void main(String[] args) 
			{
				   Lottery guess1 = new Lottery();
		           guess1.lotto();
				   guess1.checkGuesses();
		         
		           guess1.checkWinnings();
		           guess1.showdata();
		           
		           
			}
		
}
