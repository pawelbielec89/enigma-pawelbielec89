public class Baconian{

    private static String[] getAlphabet(){
        String [] alphabet = {"A", "Ą", "B", "C", "Ć",
                              "D", "E", "Ę", "F", "G",
                              "H", "I", "J", "K", "L",
                              "M", "N", "Ń", "O", "Ó",
                              "P", "Q", "R", "S", "T",
                              "U", "V", "W", "X", "Y", "Z"};
        return alphabet;
    }
    
    private static void decodeChain(String chain){
        
        int alphabetIndex = 0;

        for (int i=4, j=1; i>=0 && j>=0; i--, j*=2){

            int letterIndex = chain.offsetByCodePoints(0, i);
            String letter = chain.substring(letterIndex, letterIndex + 1);
            
            if (letter.equalsIgnoreCase("A")){
                alphabetIndex += 0;
            }
            else if (letter.equalsIgnoreCase("B")){
                alphabetIndex += j;
            }

        }

        String[] alphabet = getAlphabet();
        System.out.print(alphabet[alphabetIndex - 1]);
    }

    private static void decodeCipher(String[] message){

        for (String chain : message){
            try{
                Validation.validate(chain);
            }
            catch (InvalidInputException e){
                System.out.println(e.getMessage());
                System.exit(0);
            }
            decodeChain(chain);
        }
    }

    public void encription(String displayParameter, String message){
        String[] cipher = {"baaba", "bbbbb"};
        if (displayParameter.equalsIgnoreCase("-d")){            
            decodeCipher(cipher);
        }
    }
}