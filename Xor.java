import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Xor {
    public static void encription(String message) {

        StringBuilder builder = new StringBuilder();
        String alphabetString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < message.length(); i++) {
            int num = 10;
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