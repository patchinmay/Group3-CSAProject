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
	    int EA;
	    
	    if(i==0) {
	    	EA = UI.ix[ix].getValue()+address;
	    }
	    else {
	    	EA = UI.cache.returnValue(UI.ix[ix].getValue()+address);
	    	
	    }
	    return EA;
	    	    
	    
//	    int value = 0;
//	    value = UI.ix[ix].getValue()+UI.cache.returnValue(address);
//	    System.out.println(value);
//	    while(i+1 !=0){
//	    //1.Set MAR=address
//        UI.mar.setValue(address, UI.MAR_index);
//        //2. get data
//	    value = UI.cache.returnValue(value);
//	    //3.set data to MBR
//	    UI.mbr.setValue(value, UI.MBR_index);
//	    //4.fresh the screen
//        Instr.Refresh(UI.NewValue, UI.OldValue);       
//        i-=1;
//	    }
//	   //return ea
//	   return value;

	}
}
