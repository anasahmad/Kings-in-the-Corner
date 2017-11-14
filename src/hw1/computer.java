/*Anas Ahmad
 * CS-342
 * Kings in the Corners
 * 02/04/16
 * 
 * 
 * 
 * 
 */

package hw1;

import hw1.list.NODE;

public class computer extends player{ //inherited from player class,

	//String name;
	//list playerdeck;
	//static int comp_score;
	
	public computer(String name) {
		super(name);
		//comp_score = 0;
	}
	
	public computer(String name, int score){
		super(name, score);
	}
//	
//	public computer(String name, boolean gameover){
//		super(name, gameover);
//	}
//	
	
public void algorithm_computer(list maindeck, cardpile one, cardpile two, cardpile three,cardpile four,
		cardpile five, cardpile six, cardpile seven, cardpile eight, int dealer)
{
	
	NODE temp = playerdeck.head;
	

	cardpile [] piles = new cardpile [8];					//adding cardpiles to arrays
	piles[0] = one;
	piles[1] = two;
	piles[2] = three;
	piles[3] = four;
	piles[4] = five;
	piles[5] = six;
	piles[6] = seven;
	piles[7] = eight;
	
	
		while(temp != null)												//Adding a king onto empty piles
		{																//step 1
			if(playerdeck.find_card_num(13) == true)
			{
				card a = playerdeck.find_card_num2(13);
				for(int i = 4; i < 8; i++)
				{
					if(piles[i].cardpile.head == null)
					{
						piles[i].cardpile.insertlist(a);
						playerdeck.poplist(a);
						i = 8;
					}
				}
			}
		temp = temp.next;
		}
		
		for(int j = 0; j < 4; j++)							//moving a pile with a KING to an empty pile from 5-8
		{													//step 1
			NODE temp1 = piles[j].cardpile.head;
			cardpile temp2 = piles[j];
			if(temp == null)
				break;
			
			while(temp1.next != null)
			{
				temp1 = temp1.next;
			}
			if(temp1.deck.number() == 13)
			{
				for(int k = 5; k < 8; k++)
				{
					if(piles[k].cardpile.head == null)
						merge_cardpile(temp2, piles[k]);
				}
			}
		}
		
		
		for(int z = 0; z < 1; z++)
		{
			
			if(playerdeck.head == null)
				calculate_points(dealer);
			
			
			for(int a = 0; a < 8; a++)									//merging piles step 2
			{
				for(int b = 0; b < 8; b++)
				{
					if(can_merge(piles[a], piles[b]) == true)
					{
						merge_cardpile(piles[a], piles[b]);
					}
				}
			}
		
			
			
			
			
		//adding cards from computer deck to the piles. step 3
			NODE temp3 = playerdeck.head; // adding legal cards
			while(temp3 != null)
			{
				for(int c = 0; c < 8; c++)
				{
					if(can_add(temp3.deck, piles[c]) == true)
					{
						add_to_cardpile2(temp3.deck, piles[c]);
						z = 0;
						break;
					}
				}
				temp3 = temp3.next;
			}
			if(z == 0)
				break;
		
			//NODE temp4 = playerdeck.head;	//step 4
			for(int d = 0; d < 4; d++)			//add cards to empty piles from 1-4
			{
				if(piles[d].cardpile.isEmpty())
				{
					add_to_cardpile2(largest_card(), piles[d]);
					z = 0;
					break;
				}
			}
		}
		if(playerdeck.head != null)		//step 5, //add_from_cardile, or draw
		{
			add_from_deck(maindeck);
		}
		
	System.out.println("Computer's turn over");
	return;
}

public void calculate_points_comp(int dealer)
{
	NODE temp = playerdeck.head;
	
	if(temp == null)				// IF empty round finished
	{
	System.out.println(name() + " Wins this round");
	System.out.println(name() + "'s score: " + hw1.comp_score);
	}
	
	
	else
	{
		while(temp != null)		// read all the cards are calculate score
		{
			if(temp.deck.number() == 13)
				hw1.comp_score = hw1.comp_score + 10;
			else
				hw1.comp_score++;
		
			temp = temp.next;
	
		}
		System.out.println(name() + "'s score: " + hw1.comp_score);
	}
	if(hw1.comp_score > 25)		// if anyone's score > 25, end game
	{
		System.out.println(name() + " loses the game :(");
		game.dealer = 999;
		return;
	}
	
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
	if(temp.deck.number() != two.cardpile.topcard() - 1 || temp.deck.color() == two.cardpile.head.deck.color())
		return false;
	
	return true;
	
}


}

