public class Validation{
    /**
     * Checks if input is valid
     */
    public static void validateCipher(String chain) throws InvalidInputException{
        /**
         * Goes through validators below
         */
        isValidChain(chain);
        isValidLength(chain);
        checkMaxValue(chain);
    }

    private static void isValidChain(String str) throws InvalidInputException{
        /**
         * Throws exception only if:
         * code has letters different than 'a' and 'b'
         */
        for (char c : str.toUpperCase().toCharArray()){
            if ( c != 'A' && c != 'B')
                throw new InvalidInputException("Invalid input - wrong letters in code!");
        }
    }

    private static void isValidLength(String str) throws InvalidInputException{
        /**
         * Throws exception only if:
         * code has letters different length than 5
         */
        if (str.codePointCount(0, str.length()) != 5)
            throw new InvalidInputException("Invalid input - wrong cipher length(s)!");
    }

    private static void checkMaxValue(String chain) throws InvalidInputException{
        /**
         * Throws exception only if:
         * chain in decimal is greater than alphabet length, so:
         * 
         * #1: Last two bytes are 1 (Largest possible combination)
         * #2: First three bytes are not greater than 1(!! In decimal !!)
         * 
         * Combination of bytes: 11001 gives us 25 <--- alphabet lenght
         */
        if (chain.substring(0, 2).equalsIgnoreCase("BB"))
            if (!chain.substring(2).equalsIgnoreCase("AAA") && !chain.substring(2, 5).equalsIgnoreCase("AAB"))
                throw new InvalidInputException("Invalid input - too big number in bytes!");
    }
    
    public static void validateMessage(String letter, String[] alphabet) throws InvalidInputException{
        /**
         * Throws exception only if:
         * message has different letters than in alphabet
         */
        for (String alphabetLetter : alphabet){
            if (!alphabetLetter.equalsIgnoreCase(letter))
                throw new InvalidInputException("Wrong letters in message!");
        }
    }
}