public class Validation{

    private static void isValidChain(String str) throws InvalidInputException{
                
        for (char c : str.toUpperCase().toCharArray()){
            if ( c != 'A' && c != 'B')
                throw new InvalidInputException("Invalid input - wrong letters in code!");
        }
    }

    private static void isValidLength(String str) throws InvalidInputException{
        
        if (str.codePointCount(0, str.length()) != 5)
            throw new InvalidInputException("Invalid input - wrong cipher length(s)!");
    }

    private static void checkMaxValue(String chain) throws InvalidInputException{
        if (chain.substring(0, 2).equalsIgnoreCase("bb"))
            if (!chain.substring(2).equalsIgnoreCase("aab"))
                throw new InvalidInputException("Invalid input - too big number in bytes!");
    }

    public static void validateMessage(String letter, String[] alphabet) throws InvalidInputException{
        
        for (String alphabetLetter : alphabet){
            if (!alphabetLetter.equalsIgnoreCase(letter))
                throw new InvalidInputException("Wrong letters in message!");
        }
    }

    public static void validateCipher(String chain) throws InvalidInputException{
        isValidChain(chain);
        isValidLength(chain);
        checkMaxValue(chain);
    }
}