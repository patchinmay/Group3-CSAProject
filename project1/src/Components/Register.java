package Components;
import userInterface.UI;
/**
 * this is package include many different components for the simulate
 * 
 * @version 1.0
 * @author Yukang Li
 *
 */

public class Register {
	
	//size of register is 16 bits
	private int size = 16;
	private int value;
	//get the size of register
	public int getSize() {
		return size;
	}
	//get the value of register
	public int getValue() {
		return value;
	}
	//set the value of register
	public void setValue(int value, int index) {
		this.value = value;
		UI.NewValue[index] = value;
	}
	//Constructor 
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

