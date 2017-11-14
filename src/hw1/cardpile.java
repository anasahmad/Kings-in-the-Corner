package hw1;

import hw1.list.NODE;

public class cardpile{
	
	
	int ID;
	list cardpile;
	int size;
	

	public cardpile(int ID)
	{
		this.ID = ID;
		size = 0;
		cardpile = new list();
	}
	
	
	
	
	void display_cardpile() throws InterruptedException
	{
		NODE temp = cardpile.head;
		System.out.print(ID + ": ");
		
		if(temp == null)
			System.out.print("Empty");
		
		while(temp != null)
		{
			System.out.print(temp.deck.name() + "  ");
			Thread.sleep(100);
			temp = temp.next;

		}
		System.out.print("\n");
	}
	
}