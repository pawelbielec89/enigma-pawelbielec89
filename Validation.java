public class Validation{

    public static void isValidChain(String str) throws InvalidInputException{
                
        for (char c : str.toUpperCase().toCharArray()){
            if ( c != 'A' && c != 'B') {
                throw new InvalidInputException("dd1");
            }
        }
    }

    public static void isValidLength(String str) throws InvalidInputException{
        
        if (str.codePointCount(0, str.length()) != 5){
            throw new InvalidInputException("ddd");
        }
    }

    public static void validate(String chain) throws InvalidInputException{
        isValidChain(chain);
        isValidLength(chain);
    }
}