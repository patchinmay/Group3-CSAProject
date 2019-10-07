package userInterface;
import function.effectiveAddress;
import userInterface.UI;

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
		//UI.memory[eaddress] = value;
		UI.cache.setValue(eaddress, value);
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
		//get effective address
		int eaddress =0;
		eaddress =  effectiveAddress.EA(address,ix,i);
		//get the value from cache
		int value = UI.cache.returnValue(eaddress);
		//put the value into register
		UI.r[r].setValue(value, UI.R0_index+r);
		//refresh the screen
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
		//get effective address
		int eaddress =0;
		eaddress =  effectiveAddress.EA(address,ix,i);
		//get the value from cache
		int value = UI.cache.returnValue(eaddress);
		//put the value into index register
		UI.ix[ix].setValue(value, UI.IX1_index+ix-1);
		//refresh the screen
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
		//get effective address
		int eaddress =0;
		eaddress =  effectiveAddress.EA(address,ix,i);
		//get the value from index register
		int value = UI.ix[ix].getValue();
		//put value into cache
		UI.cache.setValue(eaddress, value);
		//refresh the screen
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**  Limin
	 * 04 AMR r, x, addrees[, l]   Add memory to the Register, r=0,1,2,3   r<- c(r)+c(EA) 
	 */
	public static void AMR(int r, int ix, int i, int address) {
		//get effective address
		int EA = effectiveAddress.EA(address, ix, i);
		//c(r) + c(EA)
		int rlt = UI.r[r].getValue() + UI.cache.returnValue(EA);
		//set the value of r1
		UI.r[r].setValue(rlt, UI.R0_index+r);
		//refresh the UI
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**  Limin
	 * 05 SMR r, x, addrees[, l]   Subtract memory from the Register, r=0,1,2,3   r<- c(r)-c(EA) 
	 */
	public static void SMR(int r, int ix, int i, int address) {
		//get effective address
		int EA = effectiveAddress.EA(address, ix, i);
		//c(r) - c(EA)
		int rlt = UI.r[r].getValue() - UI.cache.returnValue(EA);
		//set the value of r[r]
		UI.r[r].setValue(rlt, UI.R0_index+r);
		//refresh the UI
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**  Limin
	 * 06 AIR r, immed 
	 * Add Immediate to register, r = 0,1,2,3
	 * r<-c(r)+Immediate 
	 * Note:
	 * 1. if Immed=0, does nothing
	 * 2. if c(r)=0, loads r with Immed
	 * IX and I are ignored in this instruction 
	 */
	public static void AIR(int r, int immed) {
		//add c(r)+Immedd
		int rlt = UI.r[r].getValue() + immed;
		//set the value of r[r]
		UI.r[r].setValue(rlt, UI.R0_index+r);
		//refresh the UI
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/**  Limin
	 * 07 SIR r, immed    Subtract Immediate from register. r=0...3
	 * r<-c(r) - Immed 
	 * Note:
	 * 1. if Immed=0, does nothing
	 * 2. if c(r)=0, loads r with Immed
	 * IX and I are ignored in this instruction 
	 */
	public static void SIR(int r, int immed) {
		//add c(r)-Immedd
		int rlt = UI.r[r].getValue() - immed;
		//set the value of r[r]
		UI.r[r].setValue(rlt, UI.R0_index+r);
		//refresh the UI
		Refresh(UI.NewValue, UI.OldValue);
	}
	 
	/* Limin
	 * 20 MLT rx, ry     
	 * Multiply Register by Register
	 * rx, rx+1 < c(rx)*c(ry)
	 * rx must be 0 or 2
	 *ry must be 0 or 2
	 *rx contains the high order bits, rx+1 contains the low order bits of the result
     *Set OVERFLOW flag, if overflow
	 * */
	public static void MLT(int rx, int ry) {
		//get the result of rx*ry
		int rlt = UI.r[rx].getValue() *  UI.r[ry].getValue();
		//put the high order bits into rx
		UI.r[rx].setValue(rlt/65536, UI.R0_index+rx);
		//put the low order bits into rx+1
		UI.r[rx+1].setValue(rlt%65536, UI.R0_index+rx+1);
		//refresh the UI.
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	
	/*  Limin
	 * 21  DVD rx, ry
	 * Divide Register by Register
	 *rx, rx+1 <- c(rx)/ c(ry)
	 *rx must be 0 or 2
	 *rx contains the quotient; rx+1 contains the remainder
	 *ry must be 0 or 2
	 *If c(ry) = 0, set cc(3) to 1 (set DIVZERO flag)

	 */
	
	public static void DVD(int rx, int ry) {
		//get the result of rx/ry
		int quotient = UI.r[rx].getValue() /  UI.r[ry].getValue();
		int reminder = UI.r[rx].getValue() %  UI.r[ry].getValue();
		//put the high order bits into rx
		UI.r[rx].setValue(quotient, UI.R0_index+rx);
		//put the low order bits into rx+1
		UI.r[rx+1].setValue(reminder, UI.R0_index+rx+1);
		//refresh the UI.
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/* Limin
	 * 22 TRR rx, ry
	 * Test the Equality of Register and Register
     *If c(rx) = c(ry), set cc(4) <- 1; else, cc(4) <- 0

	 */
	public static void TRR(int rx, int ry) {
		if(UI.r[rx].getValue() == UI.r[ry].getValue()) {
			UI.cc.setValue(1, 4, UI.CC_index);
		}
		else UI.cc.setValue(0, 4,UI.CC_index);
		//refresh the UI.
		Refresh(UI.NewValue, UI.OldValue);
	}
	
	/*Limin
	 * 23 AND rx, ry
	 * Logical And of Register and Register
	 *c(rx) <- c(rx) AND c(ry)

	 */
	public static void AND(int rx, int ry) {
		int rxValue = UI.r[rx].getValue();
		int ryValue = UI.r[ry].getValue();
		UI.r[rx].setValue(rxValue&ryValue, UI.R0_index+rx);
	}
	
	/*Limin
	 * 24 ORR rx, ry
	 * Logical OR of Register and Register
	 *c(rx) <- c(rx) OR c(ry)

	 */
	public static void ORR(int rx, int ry) {
		int rxValue = UI.r[rx].getValue();
		int ryValue = UI.r[ry].getValue();
		UI.r[rx].setValue(rxValue|ryValue, UI.R0_index+rx);
	}
	
	/*Limin
	 * 25  NOT rx
	 * Logical NOT of Register
	 *c(rx) <- c(rx) OR c(ry)

	 */
	public static void NOT(int rx) {
		int rxValue = UI.r[rx].getValue();
		UI.r[rx].setValue(~rxValue, UI.R0_index+rx);
	}
}
