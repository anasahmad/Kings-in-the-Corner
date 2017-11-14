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

public class card{
	
	private int number;
	private char color;
	private char type;
	private String name;

public card(int num, char type){
	this.number = num;
	//this.color = color;
	this.type = type;
	if(type == 'S' || type == 'C')
		this.color = 'B';
	else
		this.color = 'R';
	
	if(number == 1)
		name = ("A" + "" + type);
	
	else if(number == 10)
		name = ("T" + "" + type);
	
	else if(number == 11)
		name = ("J" + "" + type);
	
	else if(number == 12)
		name = ("Q" + "" + type);
	
	else if(number == 13)
		name = ("K" + "" + type);
	
	else
		name = (number + "" + type);
	
	}

	public int number()
	{
		return this.number;
	}
	
	public char color()
	{
		return this.color;
	}
	
	public char type()
	{
		return this.type;
	}
	
	public String name()
	{
		return this.name;
	}
	

}