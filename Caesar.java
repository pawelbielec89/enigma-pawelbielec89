public class Caesar{
    public void encryption(String message, int key){

        String formatMessage = "";
        formatMessage = String.join("", message.split(" "));
        int messageLenght = formatMessage.length(); 
        

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

    public void decodeCipher(String message, int key){      

        int messageLenght = message.length(); 
        
        for(int i = 0; i < messageLenght ; i++){   
            char character = message.charAt(i); 
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
