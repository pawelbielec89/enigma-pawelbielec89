import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/*
List<String> charList = new ArrayList<>();
String[] message = myscanner.nextLine().split(" ");
for (int i = 0; i < message.length; i++){
    charList.addAll(Arrays.asList(message[i].split("")));

    */

public class Rail_fence{
    
    public void railFenceCipher(){

        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter cipher: ");
        String[] inputMessage = myscanner.nextLine().split(" ");

        System.out.println("Enter key: ");
        int key = myscanner.nextInt();

        String message = String.join("", inputMessage);
            
        int messageLenght = message.length(); 

        for(int i = 0; i < messageLenght ; i++){   
            char character = message.charAt(i); 
            int ascii = (int) character; 
            char mychar = (char) (ascii + key) ;
            System.out.println(mychar); 
        }
    }
    public void Cizar(){

        Scanner myscanner = new Scanner(System.in);

        System.out.println("Enter cipher: ");
        String[] inputMessage = myscanner.nextLine().split(" ");

        System.out.println("Enter key: ");
        int key = myscanner.nextInt();

        String message = String.join("", inputMessage);
            
        int messageLenght = message.length(); 

        for(int i = 0; i < messageLenght ; i++){   
            char character = message.charAt(i); 
            int ascii = (int) character; 
            char mychar = (char) (ascii - key) ;
            System.out.println(mychar); 
        }
    }
}
