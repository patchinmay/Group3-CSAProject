package userInterface;



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
					break;
				//PC
				case 1:
					//change the value
					//UI.pc.setValue(NewValue[1]);
					//change the TextField
					UI.PC_textField.setText(Integer.toString(NewValue[1]));
					//append the logArea
					UI.LogtextArea.append("PC:"+ OldValue[1] + "->" + NewValue[1]+"\n");
					break;
				//MBR
				case 2:
					//change the value
					//UI.mbr.setValue(NewValue[2]);
					//change the TextField
					UI.MBR_textField.setText(Integer.toString(NewValue[2]));
					//append the logArea
					UI.LogtextArea.append("MBR:"+ OldValue[2] + "->" + NewValue[2]+"\n");
					break;
				//MFR
				case 3:
					//change the value
					//UI.mfr.setValue(NewValue[3]);
					//change the TextField
					UI.MFR_textField.setText(Integer.toString(NewValue[3]));
					//append the logArea
					UI.LogtextArea.append("MFR:"+ OldValue[3] + "->" + NewValue[3]+"\n");
					break;
				//IR
				case 4:
					//change the value
					//UI.ir.setValue(NewValue[4]);
					//change the TextField
					UI.IR_textField.setText(Integer.toString(NewValue[4]));
					//append the logArea
					UI.LogtextArea.append("IR:"+ OldValue[4] + "->" + NewValue[4]+"\n");
					break;
				//CC
				case 5:
					//change the value
					//UI.cc.setValue(NewValue[5]);
					//change the TextField
					UI.CC_textField.setText(Integer.toString(NewValue[5]));
					//append the logArea
					UI.LogtextArea.append("CC:"+ OldValue[5] + "->" + NewValue[5]+"\n");
					break;
				//R0
				case 6:
					//change the value
					//UI.r[0].setValue(NewValue[6]);
					//change the TextField
					UI.R0_textField.setText(Integer.toString(NewValue[6]));
					//append the logArea
					UI.LogtextArea.append("R0:"+ OldValue[6] + "->" + NewValue[6]+"\n");
					break;
				//R1
				case 7:
					//change the value
					//UI.r[1].setValue(NewValue[7]);
					//change the TextField
					UI.R1_textField.setText(Integer.toString(NewValue[7]));
					//append the logArea
					UI.LogtextArea.append("R1:"+ OldValue[7] + "->" + NewValue[7]+"\n");
					break;
				//R2
				case 8:
					//change the value
					//UI.r[2].setValue(NewValue[8]);
					//change the TextField
					UI.R2_textField.setText(Integer.toString(NewValue[8]));
					//append the logArea
					UI.LogtextArea.append("R2:"+ OldValue[8] + "->" + NewValue[8]+"\n");
					break;
				//R3
				case 9:
					//change the value
					//UI.r[3].setValue(NewValue[9]);
					//change the TextField
					UI.R3_textField.setText(Integer.toString(NewValue[9]));
					//append the logArea
					UI.LogtextArea.append("R3:"+ OldValue[9] + "->" + NewValue[9]+"\n");
					break;
				//IX1
				case 10:
					//change the value
					//UI.ix[1].setValue(NewValue[10]);
					//change the TextField
					UI.IX1_textField.setText(Integer.toString(NewValue[10]));
					//append the logArea
					UI.LogtextArea.append("IX1:"+ OldValue[10] + "->" + NewValue[10]+"\n");
					break;
				//IX2
				case 11:
					//change the value
					//UI.ix[2].setValue(NewValue[11]);
					//change the TextField
					UI.IX2_textField.setText(Integer.toString(NewValue[11]));
					//append the logArea
					UI.LogtextArea.append("IX2:"+ OldValue[11] + "->" + NewValue[11]+"\n");
					break;
				//IX3
				case 12:
					//change the value
					//UI.ix[3].setValue(NewValue[12]);
					//change the TextField
					UI.IX3_textField.setText(Integer.toString(NewValue[12]));
					//append the logArea
					UI.LogtextArea.append("IX3:"+ OldValue[12] + "->" + NewValue[12]+"\n");
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
		//1. Get the address of data [IR], put the new data into the NewValue[]
		UI.OldValue[4] = UI.ir.getValue();
		UI.NewValue[4] = address;
		//2. Transmit address to [MAR]
		UI.OldValue[0] = UI.mar.getValue();
		UI.NewValue[0] = address;
		//3. Get data from memory and put it to [MBR]
		UI.OldValue[2] = UI.mbr.getValue();
		int value = UI.memory[address];
		UI.NewValue[2] = value;
		//4. Put data to the specified [Register]
		
		UI.OldValue[RegLoc+r] = UI.r[0].getValue();
		UI.NewValue[RegLoc+r] = value;
		//5. Refresh all changed
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
        //Get the address(where to store data) [IR]
		UI.OldValue[4] = UI.ir.getValue();
		UI.NewValue[4] = address;
        //Transmit address to [MAR]
		UI.OldValue[0] = UI.mar.getValue();
		UI.NewValue[0] = address;
        //Get data from [Register] and put it to [MBR]
		int value = UI.r[r].getValue();
		UI.OldValue[2] = UI.mbr.getValue();
		UI.NewValue[2] = value;
		//Put data to the memory
		UI.memory[address] = value;
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
        //Get the address [IR]
		UI.OldValue[4] = UI.ir.getValue();
		UI.NewValue[4] = address;
        //Transmit address to [MBR]
		UI.OldValue[2] = UI.mbr.getValue();
		UI.NewValue[2] = address;
        //Put the data to the specified [Register]
		UI.OldValue[RegLoc+r] = UI.r[r].getValue();
		UI.NewValue[RegLoc+r] = address;
		//do the refresh function
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
		UI.OldValue[4] = UI.ir.getValue();
		UI.NewValue[4] = address;
        //Transmit address to [MAR]
		UI.OldValue[0] = UI.mar.getValue();
		UI.NewValue[0] = address;
        //Get data and put it to [MBR]
		int value = UI.memory[address];
		UI.OldValue[2] = UI.mbr.getValue();
		UI.NewValue[2] = value;
		//put the data to the specific indexRegister
		UI.OldValue[IXLoc+ix] = UI.ix[ix].getValue();
		UI.NewValue[IXLoc+ix]= value;
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
        //Get the address(where to store data) [IR]
		UI.OldValue[4] = UI.ir.getValue();
		UI.NewValue[4] = address;
        //Transmit address to [MAR]
		UI.OldValue[0] = UI.mar.getValue();
		UI.NewValue[0] = address;
        //Get data from [Index Register] and put it to [MBR]
		int value = UI.ix[ix].getValue();
		UI.OldValue[2] = UI.mbr.getValue();
		UI.NewValue[2] = value;
        //Put data to the memory
		UI.memory[address] = value;
		//refresh all changes
		Refresh(UI.NewValue, UI.OldValue);
	}

}
