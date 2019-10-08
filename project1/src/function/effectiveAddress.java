package function;
import userInterface.Instr;
import userInterface.UI;
import Components.*;

/**
 * computer effective address and set the value to MAR and MBR
 * @author Siyu
 * @input address, number of index register, indirect or direct index
 * @return effective address
 */
public class effectiveAddress {
	public static int EA(int address, int ix, int i){
	    int value = 0;
	    address = address + UI.ix[ix].getValue();

	    while(i+1 != 0){//get the ea
	        //1.Set MAR=address
	        UI.mar.setValue(address, UI.MAR_index); 
	        //2.get data from the cache
	        value = UI.cache.returnValue(address);
	        //3.set data to MBR
	        UI.mbr.setValue(value, UI.MBR_index);
	        
	        //4.fresh the screen
	        Instr.Refresh(UI.NewValue, UI.OldValue);
	        // if i ==0, end the loop
	        i-=1;
	        address = value;
	    }
	   //return ea
	   return value;

	}
}
