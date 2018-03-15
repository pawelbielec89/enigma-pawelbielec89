import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Xor {
    public static void encription(String message, int key) {
        /**
         * Encodes message
         * Decoding with the same key gives opposite result
         * 
         * Does logical operation XOR on:
         * 
         * #1: index of letter in alphabet
         * #2: key
         */

        StringBuilder builder = new StringBuilder();
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < message.length(); i++) {
            int num = key;
            String letter = "" + message.charAt(i);

            if (letter.equalsIgnoreCase(" "))
                builder.append(letter);
            else {
                int index = Baconian.getLetterIndex(letter);
                int j = num ^ index;

                if (j > 25) {
                    num = 1;
                    j = num ^ index;
                }
                builder.append(alphabetString.charAt(j));
            }

        }
        System.out.println(builder.toString());
    }
}