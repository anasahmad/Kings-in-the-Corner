/*Anas Ahmad
 * CS-342
 * Kings in the Corners
 * 
 * 02/04/16
 * 
 */

package hw1;

import hw1.list.NODE;

public class player{
	
	
	private String name;
	list playerdeck;
	//static int score;
	boolean gameover;
	
	public player(String name)
	{
		this.name = name;
		playerdeck = new list();
		//check if score 
		//score = 0;
	}
	
	
	public player(String name, int score)
	{
		this.name = name;
		playerdeck = new list();
		//check if score 
		//this.score = score;
	}
	
//	
//	public player(String name, boolean gameover)
//	{
//		this.name = name;
//		playerdeck = new list();
//		//check if score 
//		//score = 0;
//		gameover = true;
//	}
	
	
	public String name()
	{
		return this.name;
	}
	
	public int score()
	{
		return hw1.score;
	}
	
	
	
	
	public void add_from_deck(list maindeck) // the parameters contain the main deck, the 52 cards one.
	{
		playerdeck.insertlist(maindeck.toplist());	//'maindeck' is the main deck, this.deck is the player deck
		maindeck.pop_top();
	}
	
	public void add_to_cardpile(String b, cardpile d)			//b is the card name in the card class
	{
		
	
		
		if(playerdeck.find_card(b) == false)					//checking if card exists in out pile
		{
			System.out.println("Card not available"); 
			return;
		}
		card c = playerdeck.find_card2(b);		//find_card2, i created in list
		
		if(can_add(c, d) == false)
		{
			System.out.println("Invalid Card");
			return;
		}
		
		if(d.cardpile.head == null && d.ID > 4 && d.ID < 9 && c.number() != 13)
		{
			System.out.println("Invalid entry, you can't place any other card than K in piles 5-8");
		}
		
//		else if(d.cardpile.head == null && c.number == 13 && d.ID > 4 && d.ID < 9)
//		{
//			d.size++;
//			d.cardpile.insertlist(c);	// 'a' is the cardpile in which we add our card
//			playerdeck.poplist(c);
//			return;
//		}
		
		
//		else if(d.cardpile.head == null && d.ID > 0 && d.ID < 4)
//		{
//			d.size++;
//			d.cardpile.insertlist(c);	// 'a' is the cardpile in which we add our card
//			playerdeck.poplist(c);
//			return;
//		}
		
		
		else
		{
		d.size++;
		d.cardpile.insertlist(c);	// 'a' is the cardpile in which we add our card
		playerdeck.poplist(c);			// 'b' is removed from my deck
		}
	}
	
	
	public void add_to_cardpile2(card c, cardpile d)
	{
		if(can_add(c, d) == false)
		{
			System.out.println("Invalid Card");
			return;
		}
		else
		{
			d.size++;
			d.cardpile.insertlist(c);	// 'a' is the cardpile in which we add our card
			playerdeck.poplist(c);			// 'b' is removed from my deck
		}
	}
	
	
	
	
	public boolean can_add(card c, cardpile d)
	{
//		if(c.number == 13 && d.cardpile.head == null && d.ID > 4 && d.ID < 9)
//			return true;
//		
//		
//		if(d.cardpile.head == null) 
//			return false;
//		
//		
//		if(c.color == d.cardpile.head.deck.color || c.number != d.cardpile.topcard() - 1)
//			return false;
//		
//		return true;
		
		if(d.cardpile.head == null)
		{
			if(d.ID > 0 && d.ID < 5 && c.number() == 13)
				return false;
						
			if(d.ID > 4 && d.ID < 9 && c.number() != 13)
				return false;
			
			return true;
		
		}
		
		if(c.color() == d.cardpile.head.deck.color() || c.number() != d.cardpile.topcard() - 1)
			return false;
		
		return true;
	}
	
	
	public void merge_cardpile(cardpile one, cardpile two)
	{
		
		NODE temp = one.cardpile.head;
		
		if(one.cardpile.head == null && two.cardpile.head == null)			// if both decks are empty, nothing happens
		{
			System.out.println("Merge not possible");
			return;
		}
		
		if(one.ID < 1 || one.ID > 4)
			System.out.println("Sorry, this can't be moved on top of any other pile");
		
		
		
		
		
		if(two.cardpile.head == null && one.cardpile.last_num() != 13 && (two.ID < 9 && two.ID > 4))
		{
			System.out.println("Can't be moved");
			return;
		}
		
		
		if(temp.next == null)
		{
//			if(two.cardpile.head != null)
//			{
			if(temp.deck.number() > two.cardpile.topcard() || temp.deck.number() == 999 || temp.deck.number() != two.cardpile.topcard() - 1 || two.cardpile.head.deck.color() == temp.deck.color())

			{
				System.out.println(one.ID + " can't be moved onto " + two.ID);
				return;
			}
			
			two.cardpile.insertlist(temp.deck);
			one.cardpile.poplist(temp.deck);
			one.size = 0;
			return;
//			}
			 	
			
		}
		
		
		while(one.cardpile.isEmpty() == false)//check merge not happening with 2 or more cards in 'one' deck
		{
			temp = one.cardpile.head;
			
			if(temp.next == null)
			{
				two.cardpile.insertlist(temp.deck);
				one.cardpile.poplist(temp.deck);
				return;
			}
			
			while(temp.next != null)
			{
				temp = temp.next;
			}
			
			if(temp.deck.number() >= two.cardpile.topcard() || temp.deck.number() == 0 || temp.deck.number() != two.cardpile.topcard() - 1 || two.cardpile.head.deck.color() == temp.deck.color())
			{
				System.out.println(one.ID + " can't be moved onto " + two.ID);
				return;
			}
			
			else if(two.cardpile.head == null)
			{
				two.cardpile.insertlist(temp.deck);
				one.cardpile.poplist(temp.deck);
				one.size--;	
			}
				
			else
				two.cardpile.insertlist(temp.deck);
				one.cardpile.poplist(temp.deck);
				one.size--;
		}
		
	}
	
	void print_cards_hand() throws InterruptedException
	{
		NODE TEMP = playerdeck.head;
		//list temp = a.deck;
		System.out.print(name +"'s Deck: ");
		if(TEMP == null)
			return;
		
		while(TEMP != null)
		{	
			System.out.print(TEMP.deck.name() + "  ");
			Thread.sleep(100);
			TEMP = TEMP.next;
		}
		System.out.print("\n");
	}
	
	
	public boolean can_merge(cardpile one, cardpile two)
	{
		NODE temp = one.cardpile.head;
		
		if(temp == null)
			return false;
		
		while(temp.next != null)
		{
			temp = temp.next;
		}
		if(temp.deck.number() != two.cardpile.topcard() - 1 || temp.deck.color() == two.cardpile.head.deck.color() || temp.deck.number() == 999)
			return false;
		
		return true;
		
	}
	
	public card largest_card()
	{
		NODE temp = playerdeck.head;
		card largest = playerdeck.head.deck;
		while(temp != null)
		{
			if(temp.deck.number() > largest.number())
				largest = temp.deck;
			
			temp = temp.next;
		}
		return largest;
	}
	
	
	public void calculate_points(int dealer)
	{
		NODE temp = playerdeck.head;
		
		if(temp == null)
		{
		System.out.println(name + " Wins this round");
		System.out.println(name + "'s score: " + hw1.score);
		}
		
		
		else
		{
			while(temp != null)
			{
				if(temp.deck.number() == 13)
					hw1.score = hw1.score + 10;
				else
					hw1.score++;
			
				temp = temp.next;
		
			}
			System.out.println(name + "'s score: " + hw1.score);
		}
		if(hw1.score > 25)
		{
			System.out.println(name + "'s score: " + hw1.score);
			System.out.println(name + " loses the game :(");
			game.dealer = 999;
			return;
		}
		
		}
	
//	public int getScore(){
//		return this.score;
//	}
//	
//	public void algorithm_computer(list maindeck, cardpile one, cardpile two, cardpile three,cardpile four,
//			cardpile five, cardpile six, cardpile seven, cardpile eight)
//	{
//		
//		NODE temp = this.playerdeck.head;
//		
//
//		cardpile [] piles = new cardpile [8];					//adding cardpiles to arrays
//		piles[0] = one;
//		piles[1] = two;
//		piles[2] = three;
//		piles[3] = four;
//		piles[4] = five;
//		piles[5] = six;
//		piles[6] = seven;
//		piles[7] = eight;
//		
//		
//			while(temp != null)												//Adding a king onto empty piles
//			{																//step 1
//				if(playerdeck.find_card_num(13) == true)
//				{
//					card a = playerdeck.find_card_num2(13);
//					for(int i = 4; i < 8; i++)
//					{
//						if(piles[i].cardpile.head == null)
//						{
//							piles[i].cardpile.insertlist(a);
//							playerdeck.poplist(a);
//							i = 8;
//						}
//					}
//				}
//			
//			}
//			
//			for(int j = 0; j < 4; j++)							//moving a pile with a KING to an empty pile from 5-8
//			{													//step 1
//				NODE temp1 = piles[j].cardpile.head;
//				cardpile temp2 = piles[j];
//				while(temp1.next != null)
//				{
//					temp1 = temp1.next;
//				}
//				if(temp1.deck.number == 13)
//				{
//					for(int k = 5; k < 8; k++)
//					{
//						if(piles[k].cardpile.head == null)
//							merge_cardpile(temp2, piles[k]);
//					}
//				}
//			}
//			
//			
//			for(int z = 0; z < 1; z++)
//			{
//			
//				for(int a = 0; a < 8; a++)									//merging piles step 2
//				{
//					for(int b = 0; b < 8; b++)
//					{
//						if(can_merge(piles[a], piles[b]) == true)
//						{
//							merge_cardpile(piles[a], piles[b]);
//						}
//					}
//				}
//			
//			//adding cards from computer deck to the piles. step 3
//				NODE temp3 = playerdeck.head;
//				while(temp3 != null)
//				{
//					for(int c = 0; c < 8; c++)
//					{
//						if(can_add(temp3.deck, piles[c]) == true)
//						{
//							add_to_cardpile2(temp3.deck, piles[c]);
//							z = 0;
//							break;
//						}
//					}
//				}
//				if(z == 0)
//					break;
//			
//				//NODE temp4 = playerdeck.head;	//step 4
//				for(int d = 0; d < 4; d++)
//				{
//					if(piles[d].cardpile.isEmpty())
//					{
//						add_to_cardpile2(largest_card(), piles[d]);
//						z = 0;
//						break;
//					}
//				}
//			}
//			if(playerdeck.head != null)		//step 5
//			{
//				add_from_deck(maindeck);
//			}
//			
//		
//	}
	
	
	
}