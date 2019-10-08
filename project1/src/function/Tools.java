package function;

/**
 * 
 * @author Menbers
 *
 */
public class Tools {
		
		/**
		 * @author Limin Wu
		 * @param str
		 * @return
		 */
		public int strHexa2decimal(String str) {
			  int sum=0;

			  for(int i=str.length()-1, j=0; i>=0; i--,j++) {
			   char temp_str=str.charAt(i);

			   if(temp_str>='0' && temp_str<='9') {
			    sum += (temp_str-'0')*Math.pow(16, j);
			   }
			   else {
			    switch (temp_str){
			    case 'A': sum += 10*Math.pow(16, j); break;
			    case 'B': sum += 11*Math.pow(16, j); break;
			    case 'C': sum += 12*Math.pow(16, j); break;
			    case 'D': sum += 13*Math.pow(16, j); break;
			    case 'E': sum += 14*Math.pow(16, j); break;
			    case 'F': sum += 15*Math.pow(16, j); break;
			    case 'a': sum += 10*Math.pow(16, j); break;
			    case 'b': sum += 11*Math.pow(16, j); break;
			    case 'c': sum += 12*Math.pow(16, j); break;
			    case 'd': sum += 13*Math.pow(16, j); break;
			    case 'e': sum += 14*Math.pow(16, j); break;
			    case 'f': sum += 15*Math.pow(16, j); break;
			    }
			   }
			   
			  }
			  System.out.println(sum);
			  return sum;
			 }
		
		/**
		 * @author Limin Wu  
		 * @param instruction
		 * @return array
		 */
		public int[] decodeInstr(int instruction) {
			//The format for LOAD/STORE, Transfer and some arithmetic and logical instructions
			int OpCode = instruction/1024;
			if((OpCode>=1 && OpCode<=3) || (OpCode>=41 && OpCode<=42) || (OpCode>=10 && OpCode<=17)) {
				int[] array = new int[5];
				int R = instruction % 1024 / 256;
				int IX = instruction % 256 / 64;
				int address = instruction % 64 / 2;
				int I = instruction % 2;
				array[0] = OpCode;
				array[1] = R;
				array[2] = IX;
				array[3] = I;
				array[4] = address;
				return array;
			}//Certain arithmetic and logical instructions 
			else if(OpCode>=20 && OpCode<=25) {
				int[] array = new int[3];
				int Rx = instruction%1024/256;
				int Ry = instruction%256/64;
				array[0] = OpCode;
				array[1] = Rx;
				array[2] = Ry;
				return array;
			} //The format for shift and rotate instructions
			else if(OpCode>=31 && OpCode<=32) {
				int[] array = new int[5];
				int R = instruction % 1024 / 256;
				int AL = instruction%1024/128;
				int LR = instruction%128/64;
				int count = instruction % 16;
				array[0] = OpCode;
				array[1] = R;
				array[2] = AL;
				array[3] = LR;
				array[4] = count;
				return array;
			}//The format for I/O instructions
			else if(OpCode>=61 && OpCode<=63) {
				int []array = new int[3];
				int R = instruction%1024/256;
				int DevID = instruction%32;
				array[0] = OpCode;
				array[1] = R;
				array[2] = DevID;
				return array;
			} 
			else if(OpCode==36) {
				int []array = new int[2];
				int trapCode = instruction%16;
				array[0] = OpCode;
				array[1] = trapCode;
				return array;
			}
			else {
				int []array = new int[1];
				array[0] = OpCode;
				return array;
			}
		}
		
		/**
		 * @author Chinmay
		 * @param r
		 * @return
		 */
	    public int StringtoDec(String r) {
	        String ins = r.substring(0, 3);
	        String reg = r.substring(4, 6);
	        String ireg = r.substring(7, 9);
	        String mem = r.substring(10, 15);
	        String indirectAdd = r.substring(16);
	        if (ins.equals("LDR")) {
	            ins = "000000";
	        } else if (ins.equals("STR")) {
	            ins = "000010";
	        } else if (ins.equals("LDA")) {
	            ins = "000011";
	        } else if (ins.equals("LDX")) {
	            ins = "101001";
	        } else {
	            ins = "101010";
	        }

	        if (reg.equals("r0")) {
	            reg = "00";
	        } else if (reg.equals("r1")) {
	            reg = "01";
	        } else if (reg.equals("r2")) {
	            reg = "10";
	        } else if (reg.equals("r11")) {
	            reg = "11";
	        }

	        String str = ins + reg + ireg + mem + indirectAdd;
	        int result = Integer.parseInt(str, 2);
	        return result;
	    }
	    
	    
		
	}

