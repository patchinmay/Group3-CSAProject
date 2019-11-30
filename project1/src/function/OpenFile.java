package function;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

import userInterface.UI;

public class OpenFile {
	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	
	public void PickMe() throws Exception{
		int test = 0;
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			//get the file
			File file = fileChooser.getSelectedFile();
			//create a scanner for the file
			Scanner input = new Scanner(file);
			//sentences store location start from 1000
			int i = 1000;
			//traverse the input by get each line
			while(input.hasNext()) {
				String value = input.nextLine();
				UI.printerTextArea.append(value+"\n");
		        char[] chars = value.toCharArray();
		        //store each char into the memory
		        //a~z is 97~122 and the range of A~Z is 65~90
		        for (int j = 0; j < chars.length; j++) {
		        	System.out.println(i+" "+chars[j]);
		        	if(chars[j] == '.' || chars[j]== '!' || chars[j] == '?' ) {
		        		UI.memory[i++] = -3;
		        	}else if((int)chars[j] < 65 || (int)chars[j] > 122 || 
		        			((int)chars[j] > 90 && (int)chars[j] < 97)){
		        		UI.memory[i++] = -2;
		        	}else if((int)chars[j] <= 90 && (int)chars[j] >= 65){
		        		UI.memory[i++] = chars[j]+32;
		        	}
		        	else {
		        		UI.memory[i++] = chars[j];
		        	}
				}
		        UI.memory[i] = -1;
			}
			
			UI.printerTextArea.append("please input one word into keyboard used to search.");
			
			input.close();
		}
		else {
			sb.append("No file has been selected");
		}
	}
}
