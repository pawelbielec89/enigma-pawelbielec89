import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Xor{
    public static void encript(String message){

      
        // String message = "UUUU";
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int num = 10;
                
        for (int i=0; i<message.length();i++){
            String letter = "" + message.charAt(i);
            int index = Baconian.getLetterIndex(letter);
            int j = num ^ index;
            if (j > 25)
                j = index;
            System.out.print(alphabetString.charAt(j));
        }
        }
    }