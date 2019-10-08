package Components;

import userInterface.UI;

/**
 * 
 * @version 2.0 
 * @author Siyu
 *	 CC setValue only need to input cc_index
 */

public class CC extends Register{
	private int size = 4;
	private int value;
	private int index;
	public static int []cc = new int[5];
	
	public CC(int size, int value) {
		super();
		this.size = size;
		cc[1] = 0; cc[2]=0; cc[3]=0; cc[4]=0;
		this.value = value;
	}
	
	public void setValue(int cc_index) {
		this.value = cc[1]*1000+cc[2]*100+cc[3]*10+cc[4];
		UI.NewValue[this.index] = value;
	}
	
	public CC() {
		super();
		
	}
}