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

import java.util.Objects;

public class list
	{
		NODE head;
		
		class NODE
		{
			card deck;
			NODE next;
		
		public NODE(card a){
			deck = a;
			next = null;
	
			}
		}
		
		public list(){
			head = null;
		}
		
		void insertlist(card A)
		{
			NODE temp = new NODE(A);
			temp.next = head;
			head = temp;
		}
		
		boolean isEmpty()
		{
			if(head == null)
				return true;
			
			return false;
		}
		
		void pop_top()
		{
			if(head != null)
			head = head.next;
		}
		
		boolean find_card(String name)
		{
			NODE temp = head;
			
			while(temp != null)
			{
				//if(temp.deck.name == name)
				if(Objects.equals(name, temp.deck.name()))
					return true;
			
				temp = temp.next;
			
			}
			
			return false;
		}
		
		card find_card2(String name)
		{
			NODE temp = head;
			
			while(temp != null)
			{
				if(Objects.equals(name, temp.deck.name()))
					return temp.deck;
				
				temp = temp.next;
			}
			
			return null;
		}
		
		int last_num()
		{
			NODE temp = head;
			
			if(temp == null)
				return 999;
			
			while(temp.next != null)
				temp = temp.next;
			
			return temp.deck.number();
		}
		
		boolean find_card_num(int num)
		{
			NODE temp = head;
			
			while(temp != null)
			{
				//if(temp.deck.name == name)
				if(num == temp.deck.number())
					return true;
			
				temp = temp.next;
			
			}
			
			return false;
		}
		
		
		card find_card_num2(int num)
		{
			NODE temp = head;
			
			while(temp != null)
			{
				//if(temp.deck.name == name)
				if(Objects.equals(num, temp.deck.number()))
					return temp.deck;
			
				temp = temp.next;
			
			}
			
			return null;
		}
		
		
		void poplist(card a)  //bug--->solved
		{
			NODE temp = head;
			NODE temp2 = null;
			
			
			if(!isEmpty())
			{
				
				if(temp.deck == a)
					head = head.next;
				
				while(temp.next != null)
				{
					if(temp.next.deck == a)
					{
						temp2 = temp.next.next;
						temp.next = temp2;	
						//head = temp;
						return;
					}
				
				temp = temp.next;
				
				}
			}
			//head = temp;

		}
		
		card toplist()
		{
			if(!isEmpty())
					return head.deck;
			
			return null;
		}
		
		int topcard()
		{
			if(!isEmpty())
					return head.deck.number();
			
			return 999;
		}
		
		
	}
	