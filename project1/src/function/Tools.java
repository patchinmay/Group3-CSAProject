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
			int[] array = new int[5];
			int OpCode = instruction / 1024;
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
	    
	    public static int complementToTen(String complement) {
	    	int ten = 0;
	    	int len = 0;
	    	int result = 0;
	    	len = complement.length();
	    	for (int i = 0;i<len-1;i++)
	    		if (complement.substring(i,i+1) == "1") {
	    			result += 2^i; 
	    		}
	    	result +=1;
	    	if (complement.substring(len-1, len)=="1") {
	    		result *=-1;
	    	}
	    	return result;
	    }
	    
		
	}

