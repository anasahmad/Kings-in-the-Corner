/*Anas Ahmad
 * CS-342
 * Kings in the Corners
 * 02/04/16
 * 
 */

package hw1;

import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hw1.list;
import hw1.list.NODE;
import hw1.card;


public class game{
	
	static int dealer;
	
	public game(list maindeck, cardpile one, cardpile two, cardpile three, cardpile four,
			cardpile five, cardpile six, cardpile seven, cardpile eight, player user, computer comp)					//this is 'maindeck'
		{
		dealer = 0;
//		int score_user = user.score();
//		int score_comp = comp.score();
		
		
//		maindeck = new list();
//		
//		one = new cardpile(1);	//declaring the 8 cardpiles
//		two = new cardpile(2);
//		three = new cardpile(3);
//		four = new cardpile(4);
//		five = new cardpile(5);
//		six = new cardpile(6);
//		seven = new cardpile(7);
//		eight = new cardpile(8);
//		
//		
//		if(score_user != 0)
//			user = new player("user", score_user);
//		
//		else
//			user = new player("user");
//		
//		if(score_comp != 0)
//			comp = new computer("comp", score_comp);
//		
//		else
//			comp = new computer("comp");
//		
		
		initializedeck(maindeck);
		one.cardpile.insertlist(maindeck.toplist());
		one.size++;
		maindeck.pop_top();
		
		two.cardpile.insertlist(maindeck.toplist());
		two.size++;
		maindeck.pop_top();
		
		three.cardpile.insertlist(maindeck.toplist());
		three.size++;
		maindeck.pop_top();
		
		four.cardpile.insertlist(maindeck.toplist());
		four.size++;
		maindeck.pop_top();
		
//		if(is_even(dealer) == true)
//		{
			for(int i = 0; i < 7; i++)              //distributing 7 cards to user and comp, starting from user
			{										//as computer is distributing.
				user.add_from_deck(maindeck);
				comp.add_from_deck(maindeck);
			}
//		}
//
//		else if(is_even(dealer) == false)
//		{
//			comp.add_from_deck(maindeck);
//			user.add_from_deck(maindeck);
//		}
//		
	}
	
	
	
	
	public void initializedeck(list maindeck)
	{
		//maindeck = new list();
		card [] deck = new card[52];
		for(int i = 0; i < 13; i++)
		{
			deck[i] = new card(i+1, 'S');
		}
		
		for(int i = 0; i < 13; i++)
		{
			deck[i+13] = new card(i+1, 'C');
		}
		
		for(int i = 0; i < 13; i++)
		{
			deck[i+26] = new card(i+1, 'H');
		}
		
		for(int i = 0; i < 13; i++)
		{
			deck[i+39] = new card(i+1, 'D');
		}
		
		shuffle(deck);
		
		for(int i = 0; i < 52; i++)
		{
			maindeck.insertlist(deck[i]);
		}
	
		
//		if(checkifsame(deck) == true)
//			System.out.println("duplicate");
//		
//		else
//			System.out.println("Did not");
		
	}
	
	public void shuffle(card [] deck)
	{
		Random randomGenerator = new Random();
		int randomInt;
		int randomInt2;
		card temp;
		int count = 0;
		while(count != 52)
		{
			randomInt = randomGenerator.nextInt(52);
		    randomInt2 = randomGenerator.nextInt(52);
		    
		    temp = deck[randomInt];
		    deck[randomInt] = deck[randomInt2];
		    deck[randomInt2] = temp;
		
			count++;
		}
	}
	
	public boolean checkifsame(card [] deck){
		
		for(int i = 0; i < 52; i++){
			for(int j = i + 1; j < 52; j++)
			{
				if(deck[i] == deck[j])
					return true;
			}
		
		}
		return false;
	}
	
	public boolean is_even(int num)
	{
		if(num % 2 == 0)
			return true;
		
		return false;
	}
	
	
	public void gameplay(Scanner sc, list maindeck, cardpile one, cardpile two, cardpile three, cardpile four,
			cardpile five, cardpile six, cardpile seven, cardpile eight, player user, computer comp, int dealer) throws InterruptedException
	{
		
		String input;
		
		 while(sc.hasNext())
			{
			
			input = sc.next();
		    
			if(!input.equals("Q") && !input.equals("q") && !input.equals("H")  && !input.equals("h") && !input.equals("A") && !input.equals("a") && !input.equals("D") && !input.equals("d") && !input.equals("L") && !input.equals("l") && !input.equals("M") && !input.equals("m"))
			{
				System.out.println("Invalid character entry\n");
				System.out.println("The Commands for this game are:\n1. Press 'Q' for quit\n2. Press 'H' for help\n" +
	    				"3. Press 'A' for about\n4. Press 'D' to Draw a Card from the Draw Pile\n"
	    				+ "5. Type 'L <Card> <Pile>' to Lay a Card on a Pile \n6. Type 'M <Pile1> <Pile2>' to Move One Pile"
	    				+ " on top of Another Pile");
			}
			
			
		    if(input.equals("Q") == true || input.equals("q") == true)
		    	break;
		    
		    else if(input.equals("H") == true)
		    	{
		    		System.out.println("The Commands for this game are:\n1. Press 'Q' for quit\n2. Press 'H' for help\n" +
		    				"3. Press 'A' for about\n4. Press 'D' to Draw a Card from the Draw Pile\n"
		    				+ "5. Type 'L <Card> <Pile>' to Lay a Card on a Pile \n6. Type 'M <Pile1> <Pile2>' to Move One Pile on top of Another Pile");
		    	}
		    
		    if(input.equals("A") == true || input.equals("a") == true)
		    	{
	    		System.out.println("Programmer: Anas Ahmad");
	    		System.out.println("Program: Card Game: Kings in the Corner"); //programming information	    	
		    	}
		    
		    if(input.equals("D") == true || input.equals("d") == true)
		    	{
		    	if(maindeck.isEmpty() ==  true)
		    	{
		    		comp.calculate_points_comp(game.dealer);
		    		user.calculate_points(game.dealer);
		    		System.out.println("Round Ended\n\n\n\n\n");
		    		hw1.gameover = true;
		    		break;
		    		//dealer++;
		    		//gameplay(sc, maindeck, one, two, three, four, five, six, seven, eight, user, comp);		    	
		    	}
		    	
		    	user.add_from_deck(maindeck);
		    	comp.algorithm_computer(maindeck, one, two, three, four, five, six, seven, eight, game.dealer);
		    	displaying(user, one, two, three, four, five, six, seven, eight);
		    	if(user.playerdeck.isEmpty() == true)			
		    	{
		    		
		    		
		    		System.out.println("You Win");
		    		game.dealer = 999;
//		    		user.calculate_points(game.dealer);
//		    		hw1.gameover = true;
		    		break;
		    		//dealer++;
		    		//game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
		    	}
		    	
		    	
		    	else if(comp.playerdeck.isEmpty() == true)
		    	{
		    		System.out.println("Computer Wins");
		    		game.dealer = 999;
//		    		comp.calculate_points_comp(game.dealer);
//		    		hw1.gameover = true;
		    		break;
		    		//dealer++;
		    		//game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
		    	}
		    }
		    	
		    
		    
		    if(input.equals("L") == true || input.equals("l") == true)	
	    		{
		    	String card1; int pile1;
		    	if ( sc.hasNext() == true )
		   	     card1 = sc.next();
		   	   else
		   	   {
		   	     System.out.println ("Card expected");
		   	     return;
		   	   }
		    	
		    	if ( sc.hasNextInt() == true )
			   	     pile1 = sc.nextInt();
			   	   else
			   	   {
			   	     System.out.println ("Integer value expected");
			   	     return;
			   	   }
		    	cardpile temp = int_to_carpile(pile1, one, two, three, four, five, six, seven, eight);
		    	user.add_to_cardpile(card1, temp);
		    	
		    	if(user.playerdeck.head == null)
		    	{
		    		System.out.println("You Win");
		    		game.dealer = 999;
//		    		user.calculate_points(game.dealer);
//		    		hw1.gameover = true;
//		    		break;
		    	}
		    	
		    	if(comp.playerdeck.head == null)
		    	{
		    		System.out.println("Computer Wins");
		    		game.dealer = 999;
//		    		comp.calculate_points_comp(game.dealer);
//		    		hw1.gameover = true;
//		    		break;
		    	}
		    	
		    	else 
		    		displaying(user, one, two, three, four, five, six, seven, eight);
		    	
		    	
		    	
//		    	if(user.playerdeck.isEmpty() == true)
//		    	{
//		    		System.out.println("You Win");
//		    		//dealer++;
//		    		//game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//		    	}
//		    	else if(comp.playerdeck.isEmpty() == true)
//		    	{
//		    		System.out.println("Computer Wins");
//		    		//dealer++;
//		    		//game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp, dealer);
//		    	}
		    }
		    
		    
		    
		    
		    if(input.equals("M") == true || input.equals("m") == true)	
	    		{
		    	
		    	int pile1; int pile2;
		    	
		    	if ( sc.hasNextInt() == true )
			   	     pile1 = sc.nextInt();
			   	   else
			   	   {
			   	     System.out.println ("Integer value expected");
			   	     return;
			   	   }
		    	if ( sc.hasNextInt() == true )
			   	     pile2 = sc.nextInt();
			   	   else
			   	   {
			   	     System.out.println ("Integer value expected");
			   	     return;
			   	   }
		    	cardpile cardpile1 = int_to_carpile(pile1, one, two, three, four, five, six, seven, eight);
		    	cardpile cardpile2 = int_to_carpile(pile2, one, two, three, four, five, six, seven, eight);
		    	
		    	user.merge_cardpile(cardpile1, cardpile2);
		    	displaying(user, one, two, three, four, five, six, seven, eight);
	    		}
		    
		    if(user.playerdeck.isEmpty() == true)
		    {
		    	System.out.println("You Win");
		    	game.dealer = 999;
//		    	user.calculate_points(game.dealer);
//		    	hw1.gameover = true;
		    	//System.out.println("You Win");
		    	//dealer++;
	    		//game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp);
		    }
		    	
		    	
	    	else if(comp.playerdeck.isEmpty() == true)
	    	{
	    		
	    		System.out.println("Computer Wins");
	    		game.dealer = 999;
//	    		comp.calculate_points_comp(game.dealer);
//	    		hw1.gameover = true;
	    		//System.out.println("Computer Wins");
	    		//dealer++;
	    		//game another = new game(maindeck, one, two, three, four, five, six, seven, eight, user, comp);
	    	}
		    	
			}
	    			
	   	}

	
	static void displaying(player user, cardpile one, cardpile two, cardpile three, cardpile four,
			cardpile five, cardpile six, cardpile seven, cardpile eight) throws InterruptedException
	{
				
		one.display_cardpile();			//printing the cardpiles
	    two.display_cardpile();
	    three.display_cardpile();
	    four.display_cardpile();
	    five.display_cardpile();
	    six.display_cardpile();
	    seven.display_cardpile();
	    eight.display_cardpile();
	 
	    user.print_cards_hand();  //printing cards in hand
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
	
	
	
	
