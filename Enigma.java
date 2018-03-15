import java.io.File;
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
        String cipherAlphabet = "";
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
                cipherKey = commandLineArgs[2];

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
        else if (cipherType.equalsIgnoreCase("Trifid")){
          char[] alphabet = {'a','b','c','d','e','f','g','h','i',
                              'j','k','l','m','n','o','p','q','r',
                              's','t','u','v','w','x','y','z','.'};
          char[] period = cipherPeriod.split("");
           if(period != alphabet){
             alphabet = period;
           }
          Trifid.selectMode(displayParameter, message, cipherKey, alphabet);
          }
    }
    public static List<String> fileReader(Scanner file){

        List<String> messageCipher = new ArrayList<>();
        while (file.hasNext()){
            messageCipher.add(file.nextLine());
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

        Scanner sc = new Scanner(System.in);
        List<String> messageLoaded = fileReader(sc);
        String message = formatMessage(messageLoaded);
        String option = "-h, -l, -e, -d";

        startProgram(args, message);
    }
}
