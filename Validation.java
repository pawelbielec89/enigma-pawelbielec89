public class Validation{

    public static void isValidChain(String str) throws InvalidInputException{
                
        for (char c : str.toUpperCase().toCharArray()){
            if ( c != 'A' && c != 'B') {
                throw new InvalidInputException("Invalid input - wrong letters in code!");
            }
        }
    }

    public static void isValidLength(String str) throws InvalidInputException{
        
        if (str.codePointCount(0, str.length()) != 5){
            throw new InvalidInputException("Invalid input - wrong cipher length(s)!");
        }
    }

    public static void validateMessage(String letter, String[] alphabet) throws InvalidInputException{
        
        for (String alphabetLetter : alphabet){
            if (!alphabetLetter.equalsIgnoreCase(letter)){
                throw new InvalidInputException("Wrong letters in message!");
            }
        }
    }

    public static void validateCipher(String chain) throws InvalidInputException{
        isValidChain(chain);
        isValidLength(chain);
    }
}