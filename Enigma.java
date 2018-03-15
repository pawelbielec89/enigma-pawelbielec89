import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sun.security.pkcs11.wrapper.CK_MECHANISM;

public class Enigma{

    private static void startProgram(String[] commandLineArgs, String message) {
		String displayParameter = "";
        String cipherType = "";
        int cipherKey = 0;
        
        try{
            
            displayParameter = commandLineArgs[0];
            if (displayParameter.equalsIgnoreCase("-h")){
                System.out.println("Enter -h to encryption or -f to decode cipher");
                System.exit(0);    
            }
            if(displayParameter.equalsIgnoreCase("-l")){
                System.out.print(
                "Possible Ciphers:\n"+
                "Atbash\n"+
                "Caesar\n"+
                "Baconian\n"+
                "Xor\n");
            }             
            if (commandLineArgs.length > 1)
                cipherType = commandLineArgs[1];
            if (commandLineArgs.length > 2)
                try{
                    cipherKey = Integer.parseInt(commandLineArgs[2]);
                }
                catch(NumberFormatException ex){
                    System.out.println("Need intiger");
                    System.exit(0);         
                }
                
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Not enough parameters! Try: java Enigma -h");
            System.exit(0);
        }
        
        if (cipherType.equalsIgnoreCase("Atbash")){
            Atbash atbash = new Atbash();
            String cipheredMessage = atbash.atbashCipher(message);
            saveToFile(cipheredMessage);
        }

        else if (cipherType.equalsIgnoreCase("Baconian")){
            Baconian baconian = new Baconian();
            baconian.encription(displayParameter, message);
        }
        else if (cipherType.equalsIgnoreCase("Caesar")){
           
            String cipheredMessage = Caesar.selectMode(displayParameter, message, cipherKey);
            saveToFile(cipheredMessage);
        }
    }
    public static List<String> fileReader(String sourceFile){
        File file = new File(sourceFile);
        List<String> messageCipher = new ArrayList<>();
    
        try{
            messageCipher = Files.readAllLines(file.toPath());
        }
        catch (IOException ex){
            System.out.println("Error occour " + ex);
        }
        if (messageCipher.isEmpty()){
            System.out.println("File is empty: ");
        }
    
        return messageCipher;
    }

    public static void saveToFile(String dateToSave) {

        try{
            FileWriter file = new FileWriter("decodedCipher.txt");           
                        
            file.write(dateToSave + "\n");
            file.close();
        }
        catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static String formatMessage(List<String> messageLoaded){

        String message = "";

        for (int i = 0; i < messageLoaded.size(); i++ ){
            message += String.join("", messageLoaded.get(i));
        }
        return message;
    }


    public static void main(String[] args){

        List<String> messageLoaded = fileReader("code.txt");
        String message = formatMessage(messageLoaded);
        String option = "-h, -l, -e, -d";

        try{
            if (option.contains(args[0])){
                startProgram(args, message);  
            }
            else{
                System.out.println("Enter -h to help or -l to display list of ciphers");
            } 
        }  
        catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Enter -h to help or -l to display list of ciphers");
        }      
    }
}

	