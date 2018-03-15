public class Baconian{

    public void encription(String mode, String message){
        /**
         * Casts message to nessesary format
         * Runs method equals to mode
         */
        String[] cipher = message.split(" ");
        if (mode.equalsIgnoreCase("-d"))            
            decodeCipher(cipher);
        else
            encodeCipher(message);
    }

    private static void decodeCipher(String[] message){
        /**
         * Iteares through array
         * Checks if input elemts are valid
         * Runs elements decoding method
         */
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
        System.out.println();
    }

    private static void decodeChain(String chain){
        /**
         * Converts binary to decimal:
         * 
         * 
         * Iterates through 'bytes'(a=0, b=1)
         * at the same time doubles j variable
         * 
         * If byte = 'b'(1), adds 'j' to letterIndex
         */
        int letterIndex = 0;
        
        for (int i=4, j=1; i>=0; i--, j*=2){
            char c = chain.charAt(i);
            if (c == 'b')
                letterIndex += j;
        }

        String[] alphabet = getAlphabet();
        System.out.print(alphabet[letterIndex]);
        // End of decoding
    }

    private static void encodeCipher(String message){
        /**
         * Shows final encoded message
         * 
         * 
         * Iterates through message's chars,
         * adds encoded letters to builder,
         * casts builder to string
         */
        int letterIndex;
        String answer;
        StringBuilder builder = new StringBuilder();

        for (char c : message.toCharArray()){
            if (c == ' ')
                builder.append("");
            else {
                String letter = "" + c;
                letterIndex = getLetterIndex(letter);
                builder.append(getLetterCipher(letterIndex) + " ");
            }
        }
        answer = builder.toString();
        System.out.println(answer);
    }

    public static int getLetterIndex(String letter){
        /**
         * Returns index in alphabet of given letter
         * 
         * 
         * Iterates through letter's chars,
         * returns index if letter is equal to letter in alphabet
         */
        int letterIndex = 0;
        String[] alphabet = getAlphabet();
        
        for (String currentLetter : alphabet){
            if (letter.equalsIgnoreCase(currentLetter))
                return letterIndex;
            letterIndex++;
        }
        return letterIndex;
    }

    private static String getLetterCipher(int index){
        /**
         * Returns index in 'binary'(a=0, b=1)
         * 
         * 
         * Increments i from 0 to 4 (code steps),
         * if index is even: adds a (0), divides index by 2,
         * if index is odd: adds b (1), subtracts index by 1, divides by 2
         */
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

    public static String[] getAlphabet(){
        /**
         * Returns alphabet
         */
        String [] alphabet = {"A", "B", "C", "D", "E",
                              "F", "G", "H", "I", "J",
                              "K", "L", "M", "N", "O",
                              "P", "Q", "R", "S", "T",
                              "U", "V", "W", "X", "Y",
                              "Z"};
        return alphabet;
    }
}