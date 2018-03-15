import java.io.File;
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
                System.out.println("Print help");
                System.exit(0);
            }
            cipherType = commandLineArgs[1];

            try{
                cipherKey = Integer.parseInt(commandLineArgs[2]);
            }
            catch (NumberFormatException ex){
                System.out.println("Number is require ! ");
                System.exit(0);
            }
            
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Not enough parameters! Try: java Enigma -h");
            System.exit(0);
        }
       
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
            Atbash atbash = new Atbash();
            atbash.atbashCipher(message);
        }

        else if (cipherType.equalsIgnoreCase("Baconian")){
            Baconian baconian = new Baconian();
            baconian.encription(displayParameter, message);
        }
        else if (cipherType.equalsIgnoreCase("Caesar")){
            Caesar caesarCipher = new Caesar();
            caesarCipher.encryption(message, cipherKey);
            //caesarCipher.decodeCipher(message, cipherKey);
            
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

        startProgram(args, message);       
    }
}

	