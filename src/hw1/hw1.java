/*Anas Ahmad  aahmad31@uic.edu
 * CS-342
 * 
 * Kings in the Corners:This is a card game, kings in the corner.
 * Description from Wikipedia: "Kings in the Corner (also called King's Corner, Kings Corners or Spider.[1]) 
 * is a multi-player solitaire-style card game using one deck of standard playing cards with between two and 
 * four players participating. The game was thought up by the Grey Family aboard the SS Suevic in the 1910s."
 * 
 * 02/04/16
 * 
 * 
 * P.S Sorry for commenting so much stuff. :(
 * 
 */


package hw1;

import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hw1.card;
import hw1.game;


public class hw1{
	
	
	static boolean gameover = false;
	static int score = 0;
	static int comp_score = 0;
	
	
	public static void main(String args[]) throws InterruptedException{
		Scanner sc = new Scanner ( System.in );
		
		
	while(true)
	{
	
		
	list maindeck = new list();		//creating a maindeck
	
	String input; int dealer = 0;
	player user = new player("User", hw1.score);;
	computer comp = new computer("Comp", hw1.comp_score);;
	
//	if(gameover == false)
//	{
//		user = new player("User");	//declaring the players
//		comp = new computer("Comp");
//	}
//	
//	else if(gameover == true)
//	{
//		user = new player("User", hw1.user.score);	//declaring the players
//		comp = new computer("Comp", comp.hw1.comp_score);	
//	}
	
	cardpile one = new cardpile(1);	//declaring the 8 cardpiles
	cardpile two = new cardpile(2);
	cardpile three = new cardpile(3);
	cardpile four = new cardpile(4);
	cardpile five = new cardpile(5);
	cardpile six = new cardpile(6);
	cardpile seven = new cardpile(7);
	cardpile eight = new cardpile(8);
	

	//game anas = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp); //initializing the game class
	
	

	
	//	int count = 0;
	
//	list.NODE temp = maindeck.head;
//	
//	
//	
//	int i = 1;							//printing out the main deck for debugging purposes
//	System.out.println("Main Deck\n");
//	while(temp != null)
//    {
//    
//    	System.out.print(i + "." + "Card: " + temp.deck.number + "" + temp.deck.type + " ");
//    	temp = temp.next;
//    	i++;
//    }
	//displaying(user, one, two, three, four, five, six, seven, eight);
	
//		while(true)
//		{
			game anas = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp); //initializing the game class
			displaying(user, one, two, three, four, five, six, seven, eight); // display 'stuff' before running the gameplay
			anas.gameplay(sc, maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer); //running the gameplay which has the I/O stuff.
				
//			if(game.dealer != 999)
//			{
//			reinitialize(maindeck, one, two, three, four, five, six, seven, eight, user, comp);
//			}
			
			if(game.dealer == 999)
				break;
			
//			if(comp.score() > 25 ||  user.score() > 25)
//				break;
		}
		
	//	displaying(user, one, two, three, four, five, six, seven, eight);
	}
//	 while(sc.hasNext())
//		{
//		
//		input = sc.next();
//	    
//		if(!input.equals("Q") && !input.equals("H") && !input.equals("A") && !input.equals("D") && !input.equals("L") && !input.equals("M"))
//		{
//			System.out.println("Invalid character entry\n");
//			System.out.println("The Commands for this game are:\n1. Press 'Q' for quit\n2. Press 'H' for help\n" +
//    				"3. Press 'A' for about\n4. Press 'D' to Draw a Card from the Draw Pile\n"
//    				+ "5. Type 'L <Card> <Pile>' to Lay a Card on a Pile \n6. Type 'M <Pile1> <Pile2>' to Move One Pile"
//    				+ " on top of Another Pile");
//		}
//		
//		
//	    if(input.equals("Q") == true)
//	    	break;
//	    
//	    else if(input.equals("H") == true)
//	    	{
//	    		System.out.println("The Commands for this game are:\n1. Press 'Q' for quit\n2. Press 'H' for help\n" +
//	    				"3. Press 'A' for about\n4. Press 'D' to Draw a Card from the Draw Pile\n"
//	    				+ "5. Type 'L <Card> <Pile>' to Lay a Card on a Pile \n6. Type 'M <Pile1> <Pile2>' to Move One Pile on top of Another Pile");
//	    	}
//	    
//	    if(input.equals("A") == true)
//	    	{
//    		System.out.println("Programmer: Anas Ahmad");
//    		System.out.println("Program: Card Game: Kings in the Corner"); //programming information	    	
//	    	}
//	    
//	    if(input.equals("D") == true)
//	    	{
//	    	if(maindeck.isEmpty() ==  true)
//	    	{
//	    		comp.calculate_points();
//	    		user.calculate_points();
//	    		System.out.println("Round Ended");
//	    		dealer++;
//	    		anas = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//	    	}
//	    	
//	    	user.add_from_deck(maindeck);
//	    	comp.algorithm_computer(maindeck, one, two, three, four, five, six, seven, eight);
//	    	displaying(user, one, two, three, four, five, six, seven, eight);
//	    	if(user.playerdeck.isEmpty() == true)
//	    	{
//	    		System.out.println("You Win this round");
//	    		comp.calculate_points();
//	    		dealer++;
//	    		game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//	    	}
//	    	
//	    	
//	    	else if(comp.playerdeck.isEmpty() == true)
//	    	{
//	    		System.out.println("Computer Wins this round");
//	    		user.calculate_points();
//	    		dealer++;
//	    		game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//	    	}
//	    }
//	    	
//	    
//	    
//	    if(input.equals("L") == true)	
//    		{
//	    	String card1; int pile1;
//	    	if ( sc.hasNext() == true )
//	   	     card1 = sc.next();
//	   	   else
//	   	   {
//	   	     System.out.println ("Card expected");
//	   	     return;
//	   	   }
//	    	
//	    	if ( sc.hasNextInt() == true )
//		   	     pile1 = sc.nextInt();
//		   	   else
//		   	   {
//		   	     System.out.println ("Integer value expected");
//		   	     return;
//		   	   }
//	    	cardpile temp = int_to_carpile(pile1, one, two, three, four, five, six, seven, eight);
//	    	user.add_to_cardpile(card1, temp);
//	    	displaying(user, one, two, three, four, five, six, seven, eight);
//	    	if(user.playerdeck.isEmpty() == true)
//	    	{
//	    		System.out.println("You Win");
//	    		dealer++;
//	    		game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//	    	}
//	    	else if(comp.playerdeck.isEmpty() == true)
//	    	{
//	    		System.out.println("Computer Wins");
//	    		dealer++;
//	    		game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//	    	}
//	    }
//	    
//	    
//	    
//	    
//	    if(input.equals("M") == true)	
//    		{
//	    	
//	    	int pile1; int pile2;
//	    	
//	    	if ( sc.hasNextInt() == true )
//		   	     pile1 = sc.nextInt();
//		   	   else
//		   	   {
//		   	     System.out.println ("Integer value expected");
//		   	     return;
//		   	   }
//	    	if ( sc.hasNextInt() == true )
//		   	     pile2 = sc.nextInt();
//		   	   else
//		   	   {
//		   	     System.out.println ("Integer value expected");
//		   	     return;
//		   	   }
//	    	cardpile cardpile1 = int_to_carpile(pile1, one, two, three, four, five, six, seven, eight);
//	    	cardpile cardpile2 = int_to_carpile(pile2, one, two, three, four, five, six, seven, eight);
//	    	
//	    	user.merge_cardpile(cardpile1, cardpile2);
//	    	displaying(user, one, two, three, four, five, six, seven, eight);
//    		}
//	    
//	    if(user.playerdeck.isEmpty() == true)
//	    {
//	    	System.out.println("You Win");
//	    	dealer++;
//    		game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//	    }
//	    	
//	    	
//    	else if(comp.playerdeck.isEmpty() == true)
//    	{
//    		System.out.println("Computer Wins");
//    		dealer++;
//    		game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//    	}
//	    	
//		}
//    			
//   	}

	
//public static void reinitialize(list maindeck, cardpile one, cardpile two, cardpile three, cardpile four, cardpile five, cardpile six, cardpile seven, cardpile eight, player user, computer comp)
//{
//	maindeck = new list();
//	one = new cardpile(1);
//	two = new cardpile(2);
//	three = new cardpile(3);
//	four = new cardpile(4);
//	five = new cardpile(5);
//	six = new cardpile(6);
//	seven = new cardpile(7);
//	eight = new cardpile(8);
//	
//	int user_score = user.score();
//	int comp_score = comp.score();
//
//	
//	if(user_score != 0)
//		user = new player("user", user.score());
//	
//	else
//		user = new player("user");
//	
//	if(comp_score != 0)
//		comp = new computer("comp", comp.score());
//	
//	else
//		comp = new computer("comp");
//
//	
//}
	
static void displaying(player user, cardpile one, cardpile two, cardpile three, cardpile four,
		cardpile five, cardpile six, cardpile seven, cardpile eight) throws InterruptedException
{
	user.print_cards_hand();		//printing cards in hand

	one.display_cardpile();			//printing the cardpiles
    two.display_cardpile();
    three.display_cardpile();
    four.display_cardpile();
    five.display_cardpile();
    six.display_cardpile();
    seven.display_cardpile();
    eight.display_cardpile();
    
    System.out.println("\nYour Turn....");
}
	

static cardpile int_to_carpile(int a, cardpile one, cardpile two, cardpile three, cardpile four,
		cardpile five, cardpile six, cardpile seven, cardpile eight)
{
	if(a < 1 || a > 8)
		System.out.println("Out of range, cardpiles from 1-8 available only"); 
	
	if(a == 1)
		return one;
	
	else if(a == 2)
		return two;
	
	else if(a == 3)
		return three;
	
	else if(a == 4)
		return four;
	
	else if(a == 5)
		return five;
	
	else if(a == 6)
		return six;
	
	else if(a == 7)
		return seven;
	
	else
		return eight;
}


}
