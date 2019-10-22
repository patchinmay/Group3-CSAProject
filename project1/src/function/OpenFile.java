package function;

import java.awt.print.PrinterAbortException;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

import userInterface.UI;

public class OpenFile {
	JFileChooser fileChooser = new JFileChooser();
	StringBuilder sb = new StringBuilder();
	
	public void PickMe() throws Exception{
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
		        for (int j = 0; j < chars.length; j++) {
		        	System.out.println(i+" "+chars[j]);
		        	UI.cache.setValue(i++,(int)chars[j]);
				}
			}
			
			UI.printerTextArea.append("please input one word into keyboard used to search.");
			
			input.close();
		}
		else {
			sb.append("No file has been selected");
		}
	}
}
