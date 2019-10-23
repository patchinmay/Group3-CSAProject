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
}
