public class Atbash{
    public void atbashCipher(String inputMessage){
     
        String[] userMessage = inputMessage.split("");

        String[] lettersBeginning = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
        String[] lettersEnding = {"Z","Y","X","W","V","U","T","S","R","Q","P","O","N"};
        
        String Message = "";
   
        for(int i = 0; i < userMessage.length; i++){
            for (int j = 0; j < lettersBeginning.length; j++){
                if(lettersBeginning[j].equalsIgnoreCase(userMessage[i])){
                    Message += lettersEnding[j];
                }
            } 
            for (int k = 0; k < lettersEnding.length; k++){
                if(lettersEnding[k].equalsIgnoreCase(userMessage[i])){
                    Message += lettersBeginning[k];
                }
            }
        }
        System.out.println(Message);
    }
}