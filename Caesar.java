import java.util.Scanner;

public class Caesar{

    Scanner myscanner = new Scanner(System.in);
    int key = myscanner.nextInt();

    public void encryption(String message){
        int messageLenght = message.length(); 

        for(int i = 0; i < messageLenght ; i++){   
            char character = message.charAt(i); 
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

    public void decodeCipher(String message){      

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
