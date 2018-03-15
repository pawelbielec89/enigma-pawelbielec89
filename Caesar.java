public class Caesar{
    public static String selectMode(String mode, String message, int key){

        String formatMessage = "";
        formatMessage = String.join("", message.split(" "));

        int messageLenght = formatMessage.length();   
      
        if(mode.equals("-e")){
            String cipher = encryption(key, formatMessage, messageLenght);
            return cipher;
        }
        else{
            String cipher = decodeCipher(key, formatMessage, messageLenght);
            return cipher;
        }  
    }
    public static String encryption(int key, String formatMessage, int messageLenght){

        String message = "";
        for(int i = 0; i < messageLenght ; i++){   
            char character = formatMessage.charAt(i); 
            int ascii = (int) character;
            if (ascii + key > 122){
                ascii -= 26;
                message += (char) (ascii + key) ;
            } 
            else {
                message += (char) (ascii + key) ;
            }       
        }
        System.out.println(message);
        return message; 
    }

    public static String decodeCipher(int key,String formatMessage, int messageLenght){      

        String message = "";
        for(int i = 0; i < messageLenght ; i++){   
            char character = formatMessage.charAt(i); 
            int ascii = (int) character; 
            if (ascii - key < 97){
                ascii += 26;
                message += (char) (ascii - key) ;
              
            } 
            else {
                message += (char) (ascii - key) ;
            }
        }
        System.out.println(message); 
        return message;
    }
}
