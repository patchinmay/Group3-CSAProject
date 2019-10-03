package UserInterface;



public class Instr {
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
		//1. Get the address of data [IR]
		UI.IR_textField.setText(Integer.toString(address));
		UI.ir.setValue(address);
		//2. Transmit address to [MAR]
		UI.MAR_textField.setText(Integer.toString(address));
		UI.mar.setValue(address);
		//3. Get data from memory and put it to [MBR]
		int value = UI.memory[address];
		UI.MBR_textField.setText(Integer.toString(value));
		UI.mbr.setValue(value);
		int MAR1 = UI.mar.getValue();
		int MBR1 = UI.mbr.getValue();
		System.out.println(MAR1);
		UI.LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
		UI.LogtextArea.append("MBR:"+ MBR1 + "->" + value+"\n");
		//4. Put data to the specified [Register]
		switch (r) {
		case 0:
			int aa = UI.r[0].getValue();
			UI.R0_textField.setText(Integer.toString(value));
			UI.r[0].setValue(value);
			UI.LogtextArea.append("R0:"+aa+"->"+value+"\n");
			break;
		case 1:
			int a1 = UI.r[1].getValue();
			UI.R1_textField.setText(Integer.toString(value));
			UI.r[1].setValue(value);
			UI.LogtextArea.append("R1:"+a1+"->"+value+"\n");
			break;
		case 2:
			int a2 = UI.r[2].getValue();
			UI.R2_textField.setText(Integer.toString(value));
			UI.r[2].setValue(value);
			UI.LogtextArea.append("R2:"+a2+"->"+value+"\n");
			break;
		case 3:
			int a3 = UI.r[3].getValue();
			UI.R3_textField.setText(Integer.toString(value));
			UI.r[3].setValue(value);
			UI.LogtextArea.append("R3:"+a3+"->"+value+"\n");
			break;

		default:
			break;
		}
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
		UI.IR_textField.setText(Integer.toString(address));
		UI.ir.setValue(address);
        //Transmit address to [MAR]
		UI.MAR_textField.setText(Integer.toString(address));
		UI.mar.setValue(address);
        //Get data from [Register] and put it to [MBR]
		int value = 0;
		int MAR1 = UI.mar.getValue();
		UI.LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
		int MBR1 = UI.mbr.getValue();
		UI.LogtextArea.append("MBR:"+ MBR1 + "->" + address+"\n");
		switch (r) {
		case 0:
			int OriginDataR0 = UI.r[0].getValue();
			value = UI.r[0].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			UI.LogtextArea.append("R0:"+ OriginDataR0 + "->" + value+"\n");
			break;
		case 1:
			int OriginDataR1 = UI.r[1].getValue();
			value = UI.r[1].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			UI.LogtextArea.append("R1:"+ OriginDataR1 + "->" + value+"\n");
			break;
		case 2:
			int OriginDataR2 = UI.r[2].getValue();
			value = UI.r[2].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			UI.LogtextArea.append("R2:"+ OriginDataR2 + "->" + value+"\n");
			break;
		case 3:
			int OriginDataR3 = UI.r[3].getValue();
			value = UI.r[3].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			UI.LogtextArea.append("R3:"+ OriginDataR3 + "->" + value+"\n");
			break;

		default:
			break;
		}
		//Put data to the memory
		UI.memory[address] = value;
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
		UI.IR_textField.setText(Integer.toString(address));
		UI.ir.setValue(address);
        //Transmit address to [MBR]
		UI.MBR_textField.setText(Integer.toString(address));
		UI.mbr.setValue(address);
        //Put the data to the specified [Register]
		int MBR1 = UI.mbr.getValue();
		UI.LogtextArea.append("MBR:"+ MBR1 + "->" + address+"\n");
		switch (r) {
		case 0:
			UI.r[0].setValue(address);
			UI.R0_textField.setText(Integer.toString(address));
			break;
		case 1:
			UI.r[1].setValue(address);
			UI.R1_textField.setText(Integer.toString(address));
			break;
		case 2:
			UI.r[2].setValue(address);
			UI.R2_textField.setText(Integer.toString(address));
			break;
		case 3:
			UI.r[3].setValue(address);
			UI.R3_textField.setText(Integer.toString(address));
			break;

		default:
			break;
		}
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
		UI.IR_textField.setText(Integer.toString(address));
		UI.ir.setValue(address);
        //Transmit address to [MAR]
		UI.MAR_textField.setText(Integer.toString(address));
		UI.mar.setValue(address);
        //Get data and put it to [MBR]
		int value = UI.memory[address];
		UI.MBR_textField.setText(Integer.toString(value));
		UI.mbr.setValue(value);
		int MAR1 = UI.mar.getValue();
		int MBR1 = UI.mbr.getValue();

		UI.LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
		UI.LogtextArea.append("MBR:"+ MBR1 + "->" + value+"\n");
        //Put data to the specified [Index Register]
		switch (ix) {
		case 1:
			UI.ix[1].setValue(value);
			UI.IX1_textField.setText(Integer.toString(value));
			break;
		case 2:
			UI.ix[2].setValue(value);
			UI.IX2_textField.setText(Integer.toString(value));
			break;
		case 3:
			UI.ix[2].setValue(value);
			UI.IX2_textField.setText(Integer.toString(value));
			break;

		default:
			break;
		}
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
		UI.IR_textField.setText(Integer.toString(address));
		UI.ir.setValue(address);
        //Transmit address to [MAR]
		UI.MAR_textField.setText(Integer.toString(address));
		UI.mar.setValue(address);
		
		int MAR1 = UI.mar.getValue();
		UI.LogtextArea.append("MAR:"+ MAR1 + "->" + address+"\n");
        //Get data from [Index Register] and put it to [MBR]
		int value = 0;
		switch (ix) {
		case 1:
			value = UI.ix[1].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			break;
		case 2:
			value = UI.ix[2].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			break;
		case 3:
			value = UI.ix[3].getValue();
			UI.MBR_textField.setText(Integer.toString(value));
			UI.mbr.setValue(value);
			break;

		default:
			break;
		}
        //Put data to the memory
		UI.memory[address] = value;
	}

}
