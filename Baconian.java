public class Baconian{

    private static void isValidChar(String str) {
                
        for (char c : str.toUpperCase().toCharArray()){
            if ( c != 'A' && c != 'B') {
                System.out.println("Wrong letter(s) in message!");
                System.exit(0);
            }
        }
    }

    private static void isValidLength(String str){
        
        if (str.codePointCount(0, str.length()) != 5){
            System.out.println("Wrong length!");
            System.exit(0);
        }
    }

    private static void isValidInput(String input){
        isValidChar(input);
        isValidLength(input);
    }

    private static String[] getAlphabet(){
        String [] alphabet = {"0", "A", "B", "C"};
        return alphabet;
    }
    
    private static void decodeChain(String message){
        
        int alphabetIndex = 0;

        for (int i=4, j=1; i>=0 && j>=0; i--, j*=2){

            int letterIndex = message.offsetByCodePoints(0, i);
            String letter = message.substring(letterIndex, letterIndex + 1);
            
            if (letter.equalsIgnoreCase("A")){
                alphabetIndex += 0;
            }
            else if (letter.equalsIgnoreCase("B")){
                alphabetIndex += j;
            }

        }

        String[] alphabet = getAlphabet();
        System.out.print(alphabet[alphabetIndex]);
    }

    private static void decode(String[] message){
        for (String chain : message){
            decodeChain(chain);
        }
    }

    public void getAttributes(String displayParameter, String message){
        if (displayParameter.equalsIgnoreCase("-d")){
            isValidInput("aaabb");
            String[] d = {"aaaba", "aaaab"};
            decode(d);
        }
    }
}