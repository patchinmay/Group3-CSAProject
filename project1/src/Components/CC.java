package Components;

import userInterface.UI;

/**
 * 
 * @version 1.0 
 * @author Yukang Li
 *
 */

//Comment added for checking the push request on git
//liminsadawdawdaw
//limin test terminal 
public class CC extends Register{
	private int size = 4;
	private int value;
	private int []number = new int[5];
	
	public CC(int size, int value) {
		super();
		this.size = size;
		number[1] = 1; number[2]=0; number[3]=0; number[4]=0;
		this.value = value;
	}
	
	public void setValue(int value, int index, int cc_index]) {
		number[index] = value;
		//ensure cc[1] is different with cc[2]
		if(index==1) {
			if(value == 1) number[2] = 0;
			else number[2] = 1;
		}
		if(index == 2) {
			if(value == 1) number[1] = 0;
			else number[1] = 1;
		}
		//transfer array to int 
		int rlt = 0;
		for(int i=1; i<5; i++)
			rlt = rlt*10+this.number[i];
		
		UI.NewValue[cc_index] = rlt;
	}
	
	public CC() {
		super();
		
	}
}