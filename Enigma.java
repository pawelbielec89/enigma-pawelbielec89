import java.io.File;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import sun.security.pkcs11.wrapper.CK_MECHANISM;

public class Enigma{
    private static void startProgram(String[] commandLineArgs, String message) {
		String displayParameter = "";
        String cipherType = "";
        int cipherKey = 0;
<<<<<<< HEAD
        String cipherAlphabet = "";
=======
        
>>>>>>> 13dd59e36283b6f2e06294267ea5d037810ce4d0
        try{
            displayParameter = commandLineArgs[0];
            if (displayParameter.equalsIgnoreCase("-h")){
<<<<<<< HEAD
                System.out.println("Print help");
                System.exit(0);
            }
            cipherType = commandLineArgs[1];

            try{
                cipherKey = Integer.parseInt(commandLineArgs[2]);
=======
                System.out.println("Enter -e to encryption or -d to decode cipher");
                System.exit(0);    
>>>>>>> 13dd59e36283b6f2e06294267ea5d037810ce4d0
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
<<<<<<< HEAD
                cipherKey = commandLineArgs[2];

=======
                try{
                    cipherKey = Integer.parseInt(commandLineArgs[2]);
                }
                catch(NumberFormatException ex){
                    System.out.println("Need intiger");
                    System.exit(0);         
                }
                
>>>>>>> 13dd59e36283b6f2e06294267ea5d037810ce4d0
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Not enough parameters! Try: java Enigma -h");
            System.exit(0);
        }
<<<<<<< HEAD

        if (displayParameter.equalsIgnoreCase("-l")){
            System.out.print
            (
            "Possible Ciphers:\n"+
            "Atbash\n"+
            "Caesar\n"+
            "#3 AUTOKEYYYY\n"+
            "#4 I CZWARTE\n"
            );
        }
        else if (cipherType.equalsIgnoreCase("Atbash")){
=======
        
        if (cipherType.equalsIgnoreCase("Atbash")){
>>>>>>> 13dd59e36283b6f2e06294267ea5d037810ce4d0
            Atbash atbash = new Atbash();
            String cipheredMessage = atbash.atbashCipher(message);
            saveToFile(cipheredMessage);
        }

        else if (cipherType.equalsIgnoreCase("Baconian")){
            Baconian baconian = new Baconian();
            baconian.encription(displayParameter, message);
        }
        else if (cipherType.equalsIgnoreCase("Caesar")){
<<<<<<< HEAD
            Caesar caesarCipher = new Caesar();
            caesarCipher.encryption(message, cipherKey);
            //caesarCipher.decodeCipher(message, cipherKey);

=======
           
            String cipheredMessage = Caesar.selectMode(displayParameter, message, cipherKey);
            saveToFile(cipheredMessage);
>>>>>>> 13dd59e36283b6f2e06294267ea5d037810ce4d0
        }
        else if (cipherType.equalsIgnoreCase("Trifid")){
            Trifid trifidCipher = new Trifid();
            trifidCipher.selectMode(displayParameter, message, cipherKey);
          }
    }
    public static List<String> fileReader(Scanner file){

        List<String> messageCipher = new ArrayList<>();
        while (file.hasNext()){
            messageCipher.add(file.nextLine());
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

        Scanner sc = new Scanner(System.in);
        List<String> messageLoaded = fileReader(sc);
        String message = formatMessage(messageLoaded);
        System.out.println(message);
        String option = "-h, -l, -e, -d";

<<<<<<< HEAD
        startProgram(args, message);
=======
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
>>>>>>> 13dd59e36283b6f2e06294267ea5d037810ce4d0
    }
}
