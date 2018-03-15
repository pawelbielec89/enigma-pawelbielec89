public class Baconian{

    private static String[] getAlphabet(){
        
        String [] alphabet = {"A", "B", "C", "D", "E",
                              "F", "G", "H", "I", "J",
                              "K", "L", "M", "N", "O",
                              "P", "Q", "R", "S", "T",
                              "U", "V", "W", "X", "Y",
                              "Z"};
        return alphabet;
    }
    
    private static void decodeChain(String chain){
        
        int alphabetIndex = 0;

        for (int i=4, j=1; i>=0; i--, j*=2){
            char c = chain.charAt(i);
            if (c == 'b')
                alphabetIndex += j;
        }

        String[] alphabet = getAlphabet();
        System.out.print(alphabet[alphabetIndex]);
    }

    private static void decodeCipher(String[] message){

        for (String chain : message){
            try{
                Validation.validateCipher(chain);
            }
            catch (InvalidInputException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
            decodeChain(chain);
        }
    }

    private static int getLetterIndex(String letter){
        
        int letterIndex = 0;
        String[] alphabet = getAlphabet();
        
        for ( String eachLetter : alphabet){
            if (letter.equalsIgnoreCase(eachLetter))
                return letterIndex;
            else letterIndex++;
        }
        return letterIndex;
    }

    private static String getLetterCipher(int index){

        String cipher;
        StringBuilder builder = new StringBuilder();

        for (int i=0; i<5; i++){
            if (index % 2 == 0){
                builder.append("a");
                index /= 2;
            }
            else{
                builder.append("b");
                index = (index - 1)/2;
            }
        }

        cipher = builder.reverse().toString();
        return cipher;

    }

    private static void encodeCipher(String message){
        
        int letterIndex;
        String answer;
        StringBuilder builder = new StringBuilder();

        for (char c : message.toCharArray()){
            if (c == ' ')
                builder.append("");
            else {
                String letter = "" + c;
                letterIndex = getLetterIndex(letter);
                builder.append(getLetterCipher(letterIndex));
                builder.append(" ");
            }
        }
        answer = builder.toString();
        System.out.println(answer);
    }

    public void encription(String mode, String message){
        // String[] cipher = message.split(" ");
        String[] cipher = {"aaaaa", "bbaab"};
        if (mode.equalsIgnoreCase("-d"))            
            decodeCipher(cipher);
        else
            encodeCipher("hehu ojre as");
    }
}