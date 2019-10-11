package Components;
import userInterface.UI;

public class Cache {
	public int cache_array[][] = new int[16][6];
	private int tag;
	private int line;
	private int column;
	
	public void decodeAddress(int address)
	{
		tag = address/64;
		line = address%64/4;
		column = address%4;
	}
	public void searchData(int address){
		if (cache_array[line][0] == 1){
			// VD=1
			if (cache_array[line][1] != tag){
				// cache miss
				setBacktoMemory(cache_array[line][1]*64+line*4);
				cache_array[line][1] = tag;
				getValueFromMemory(address-column);
			}
		}		
		else{//VD=0,cache miss
			cache_array[line][0] = 1;
			getValueFromMemory(address-column);
		}
	}

	public void setValue (int address,int svalue){
		searchData(address);
		cache_array[line][column+2] = svalue;
	}
	
	public int returnValue(int address)
	{
		searchData(address);
		return cache_array[line][column+2];
	}
	public void getValueFromMemory(int address){
		for (int i=0;i<4;i++){
			cache_array[line][i+2] = UI.memory[address+i];
		}		
	}
	
	public void setBacktoMemory(int back_address){
		for (int i=0;i<4;i++){
			UI.memory[back_address+i] = cache_array[line][i+2];
		}		
	}
}
