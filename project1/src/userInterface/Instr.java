package userInterface;
import function.effectiveAddress;


public class Instr {
	
	//record the first register location
	static int RegLoc = 6;
	//record the first indexRegister location
	static int IXLoc = 10;

	/**
	 * At the end of each instr. execute the refresh function
	 * refresh the all change at one times
	 * @author Yukang Li
	 * @param NewValue
	 * @param OldValue
	 */
	public static void Refresh(int[] NewValue, int[] OldValue) {
		for (int i = 0; i < NewValue.length; i++) {
			//if value has changed, refresh the components
			if(NewValue[i] != OldValue[i]) {
				switch (i) {
				//MAR
				case 0:
					//change the value
					//UI.mar.setValue(NewValue[0]);
					//change the TextField
					UI.MAR_textField.setText(Integer.toString(NewValue[0]));
					//append the logArea
					UI.LogtextArea.append("MAR:"+ OldValue[0] + "->" + NewValue[0]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//PC
				case 1:
					//change the value
					//UI.pc.setValue(NewValue[1]);
					//change the TextField
					UI.PC_textField.setText(Integer.toString(NewValue[1]));
					//append the logArea
					UI.LogtextArea.append("PC:"+ OldValue[1] + "->" + NewValue[1]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//MBR
				case 2:
					//change the value
					//UI.mbr.setValue(NewValue[2]);
					//change the TextField
					UI.MBR_textField.setText(Integer.toString(NewValue[2]));
					//append the logArea
					UI.LogtextArea.append("MBR:"+ OldValue[2] + "->" + NewValue[2]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//MFR
				case 3:
					//change the value
					//UI.mfr.setValue(NewValue[3]);
					//change the TextField
					UI.MFR_textField.setText(Integer.toString(NewValue[3]));
					//append the logArea
					UI.LogtextArea.append("MFR:"+ OldValue[3] + "->" + NewValue[3]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//IR
				case 4:
					//change the value
					//UI.ir.setValue(NewValue[4]);
					//change the TextField
					UI.IR_textField.setText(Integer.toString(NewValue[4]));
					//append the logArea
					UI.LogtextArea.append("IR:"+ OldValue[4] + "->" + NewValue[4]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//CC
				case 5:
					//change the value
					//UI.cc.setValue(NewValue[5]);
					//change the TextField
					UI.CC_textField.setText(Integer.toString(NewValue[5]));
					//append the logArea
					UI.LogtextArea.append("CC:"+ OldValue[5] + "->" + NewValue[5]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//R0
				case 6:
					//change the value
					//UI.r[0].setValue(NewValue[6]);
					//change the TextField
					UI.R0_textField.setText(Integer.toString(NewValue[6]));
					//append the logArea
					UI.LogtextArea.append("R0:"+ OldValue[6] + "->" + NewValue[6]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//R1
				case 7:
					//change the value
					//UI.r[1].setValue(NewValue[7]);
					//change the TextField
					UI.R1_textField.setText(Integer.toString(NewValue[7]));
					//append the logArea
					UI.LogtextArea.append("R1:"+ OldValue[7] + "->" + NewValue[7]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//R2
				case 8:
					//change the value
					//UI.r[2].setValue(NewValue[8]);
					//change the TextField
					UI.R2_textField.setText(Integer.toString(NewValue[8]));
					//append the logArea
					UI.LogtextArea.append("R2:"+ OldValue[8] + "->" + NewValue[8]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//R3
				case 9:
					//change the value
					//UI.r[3].setValue(NewValue[9]);
					//change the TextField
					UI.R3_textField.setText(Integer.toString(NewValue[9]));
					//append the logArea
					UI.LogtextArea.append("R3:"+ OldValue[9] + "->" + NewValue[9]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//IX1
				case 10:
					//change the value
					//UI.ix[1].setValue(NewValue[10]);
					//change the TextField
					UI.IX1_textField.setText(Integer.toString(NewValue[10]));
					//append the logArea
					UI.LogtextArea.append("IX1:"+ OldValue[10] + "->" + NewValue[10]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//IX2
				case 11:
					//change the value
					//UI.ix[2].setValue(NewValue[11]);
					//change the TextField
					UI.IX2_textField.setText(Integer.toString(NewValue[11]));
					//append the logArea
					UI.LogtextArea.append("IX2:"+ OldValue[11] + "->" + NewValue[11]+"\n");
					OldValue[i] = NewValue[i];
					break;
				//IX3
				case 12:
					//change the value
					//UI.ix[3].setValue(NewValue[12]);
					//change the TextField
					UI.IX3_textField.setText(Integer.toString(NewValue[12]));
					//append the logArea
					UI.LogtextArea.append("IX3:"+ OldValue[12] + "->" + NewValue[12]+"\n");
					OldValue[i] = NewValue[i];
					break;
				default:
					break;
				}
			}
		}
	}
	
    /**
     * LDR instr. -- Load Register From Memory
     * @author Yukang Li
     * @param r
     * @param ix
     * @param i
     * @param address
     */
	public static void LDR(int r, int ix, int i, int address) {
		//Get OpCode, R, IX, I, Address
		//analysis the Effective function first
		//determine using the indrect addressing
		if(i == 0) {
			//determine using the index register 
			if(ix <=3 && ix>=1) {
				address = UI.ix[ix].getValue() + address;
			}
		}else {
			//indirect addressing
		}

		//2. get ea
		int value = 0;
		value = effectiveAddress.EA(address,ix,i);
		//3. Put data to the specified [Register]
		UI.r[0].setValue(value,UI.R0_index);
		//4. Refresh all changed
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**
	 * STR instr. -- Store Register To Memory
	 * @author Yukang Li
	 * @param r
	 * @param ix
	 * @param i
	 * @param address
	 */
	public static void STR(int r, int ix, int i, int address) {
        //get ea and value from r
		int eaddress = 0;
		eaddress = effectiveAddress.EA(address,ix,i);
		int value = UI.r[r].getValue();

		//Put data to the memory
		UI.memory[eaddress] = value;
		//do refresh function 
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**
	 * LDA instr. -- Load Register with Address
	 * @author Yukang Li
	 * @param r
	 * @param ix
	 * @param i
	 * @param address
	 */
	public static void LDA (int r, int ix, int i, int address) {
		UI.r[r].setValue(UI.memory[effectiveAddress.EA(address,ix,i)], UI.R0_index + r);
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**
	 * LDX instr. -- Load Index Register from Memory
	 * @author Yukang Li
	 * @param ix
	 * @param i
	 * @param address
	 */
	public static void LDX(int ix, int i, int address) {
        //Get the address of data [IR]
		//IR = m[UI.PC]
		UI.ix[ix].setValue(UI.memory[effectiveAddress.EA(address,ix,i)], UI.IX1_index + ix-1);
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**
	 * STX instr. -- Store Index Register to Memory
	 * @author Yukang Li
	 * @param ix
	 * @param i
	 * @param address
	 */
	public static void STX(int ix, int i, int address) {
		UI.memory[effectiveAddress.EA(address,ix,i)] = UI.ix[ix].getValue();
		Refresh(UI.NewValue, UI.OldValue);
	}	
	public static void ORR(int rx,int ry){
	    //or 24
	    int result = 0;
	    result = UI.r[rx].getValue() | UI.r[ry].getValue();
	    UI.r[rx].setValue(result,UI.R0_index+rx);
	    Refresh(UI.NewValue, UI.OldValue);
	}
	
	public static void NOT(int r){
	    // not 25
	    UI.r[r].setValue(~(UI.r[r].getValue()),UI.R0_index+r);
	    Refresh(UI.NewValue, UI.OldValue);
	}
	
	public static void SRC(int r,int count,int lr,int al){
	    // shift 31
	    int result = 0;
	    result = UI.r[r].getValue();
	    if (lr==0){//left shift 
	        result = result << count; 
	        }
	    else{// right
	        if (al==0){//a
	            int bias = 0;
	            bias = (1<<count) - 1;
	            result += bias;
	            result = result >>>count;
	        }
	        else{//l
	            result = result >>count;
	        }        
	    }
	    UI.r[r].setValue(result,UI.R0_index+r);
	    Refresh(UI.NewValue, UI.OldValue);
	}

	public static void RRC(int r,int count,int lr,int al){
	    // rotate 32
		int value = UI.r[r].getValue();
	    String result = String.valueOf(Integer.toBinaryString(value));
	    String result1 = "";
	    String result2 = "";
	    int len = result.length();
	    if (lr==0){//left 
	        result1 = result.substring(1,count+1);
	        result2 = result.substring(count+1,len);
	        result = result2 + result1;
	        }
	    else{// right
	        result1 = result.substring(1,len-count+1);
	        result2 = result.substring(len-count+1,len+1);
	        result = result2 + result1;     
	    }
	    value = Integer.valueOf(result);
	    UI.r[r].setValue(value,UI.R0_index+r);
	    Refresh(UI.NewValue, UI.OldValue);
	}
}

/*
	public static void IN(int r,int devid) {
	    //input 61
	    UI.r[r].getValue(UI.devid[devid].getValue());
	    Refresh(UI.NewValue, UI.OldValue);
	}
	public static void OUT(int r,int devid) {
	    //output 62
	    UI.devid[devid].getValue(UI.r[r].getValue());
	    Refresh(UI.NewValue, UI.OldValue);  
	}
	public static void CHK(int r,int devid) {
	    //check status 63
	    UI.r[r].getValue(UI.devid[devid].getStatus());
	    Refresh(UI.NewValue, UI.OldValue);
	}
*/

