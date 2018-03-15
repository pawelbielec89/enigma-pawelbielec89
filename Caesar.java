public class Caesar{
    public static void selectMode(String mode, String message, String strKey){

        int key = 0;
        String formatMessage = "";
        formatMessage = String.join("", message.split(" "));

        int messageLenght = formatMessage.length();  
        try{
            key = Integer.parseInt(strKey);
        }
        catch(NumberFormatException ex){
            System.out.println("Need intiger");
            System.exit(0);         
        }
        if(mode.equals("-e")){
            encryption(key, formatMessage, messageLenght);
        }
        else{
            decodeCipher(key, formatMessage, messageLenght);
        }  
    }
    public static void encryption(int key, String formatMessage, int messageLenght){

       
        for(int i = 0; i < messageLenght ; i++){   
            char character = formatMessage.charAt(i); 
            int ascii = (int) character;
            if (ascii + key > 122){
                ascii -= 26;
                char mychar = (char) (ascii + key) ;
                System.out.println(mychar); 
            } 
            else {
                char mychar = (char) (ascii + key) ;
                System.out.println(mychar);
            }       
        }
    }

    public static void decodeCipher(int key,String formatMessage, int messageLenght){      

        
        for(int i = 0; i < messageLenght ; i++){   
            char character = formatMessage.charAt(i); 
            int ascii = (int) character; 
            if (ascii - key < 97){
                ascii += 26;
                char mychar = (char) (ascii - key) ;
                System.out.println(mychar); 
            } 
            else {
                char mychar = (char) (ascii - key) ;
                System.out.println(mychar);
            }
        }
    }
}
