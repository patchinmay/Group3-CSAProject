package function;
import userInterface.UI;
import java.io.*;
public class ReadFileP2 {

	public void Read() {
		// The name of the file to open.
        String fileName = "src/function/program2.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            	//Here there will be a function call for writing into card writer.
            	//UI.Instr_textArea.setText(line);
            	UI.Instr_textArea.append(line+"\n");
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
	}
	
	public void ReadP2() {
		UI.Instr_textArea.setText("LDR r0,01,0,00000\n" + 
				"STR r0,01,0,00101\n" + 
				"LDR r0,01,0,00100\n" + 
				"STR r0,01,0,00011\n" + 
				"LDR r0,01,1,00101\n" + 
				"JGE r0,11,1,00001\n" + 
				"LDR r1,01,1,00011\n" + 
				"STR r1,01,0,00010\n" + 
				"LDR r0,01,0,00010\n" + 
				"JGE r0,11,1,00010\n" + 
				"LDR r1,01,0,11100\n" + 
				"OUT r1,000,00001\n" + 
				"LDR r1,01,0,11101\n" + 
				"OUT r1,000,00001\n" + 
				"JMA r0,11,1,00011\n" + 
				"LDR r1,01,1,00011\n" + 
				"STR r1,01,0,00010\n" + 
				"JGE r0,11,1,00100\n" + 
				"JMA r0,11,1,00101\n" + 
				"SMR r0,01,0,00010\n" + 
				"JNE r0,11,1,00110\n" + 
				"LDR r0,01,0,00101\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,00101\n" + 
				"LDR r0,01,0,00011\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,00011\n" + 
				"JMA r0,11,1,01000\n" + 
				"LDR r0,01,0,00100\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,00100\n" + 
				"LDR r0,01,1,00100\n" + 
				"JGE r0,11,1,01001\n" + 
				"LDR r0,01,1,00100\n" + 
				"SMR r0,01,0,11010\n" + 
				"JNE r0,11,1,01010\n" + 
				"JMA r0,11,1,01011\n" + 
				"LDR r0,01,1,00100\n" + 
				"SMR r0,01,0,11110\n" + 
				"JNE r0,11,1,01100\n" + 
				"LDR r0,01,0,00100\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,00100\n" + 
				"JMA r0,11,1,01101\n" + 
				"LDR r0,01,1,00100\n" + 
				"SMR r0,01,0,11111\n" + 
				"JNE r0,11,1,01110\n" + 
				"LDR r0,01,0,11100\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,11100\n" + 
				"LDR r0,01,0,11011\n" + 
				"STR r0,01,0,11101\n" + 
				"LDR r0,01,0,00100\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,00100\n" + 
				"JMA r0,11,1,01111\n" + 
				"LDR r0,01,0,11101\n" + 
				"AIR r0,00000001\n" + 
				"STR r0,01,0,11101\n" + 
				"JMA r0,11,1,10000\n" + 
				"HLT r0,00,0,00000\n" + 
				"");
	}
}
