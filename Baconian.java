public class Baconian{
    
    private void decode(String message){
        System.out.println("decoding " + message + "...");
        
        try{

            for (int i=4; i>=0; i--){
                
                int letterIndex = message.offsetByCodePoints(0, i);
                String letter = message.substring(letterIndex, letterIndex + 1);
                
                if (letter.equalsIgnoreCase("A")){
                    
                }

                System.out.print(letter);
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("bad input!");
            System.exit(0);
        }
    }

    public void getAttributes(String displayParameter, String message){
        if (displayParameter.equalsIgnoreCase("-d")){
            decode("dupah");
        }
    }
}