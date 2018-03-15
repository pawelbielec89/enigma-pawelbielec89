import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Trifid{
    static int arrayLength = 3;
    static char[][][] coordCube = new char[arrayLength][arrayLength][arrayLength];
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i',
                              'j','k','l','m','n','o','p','q','r',
                              's','t','u','v','w','x','y','z','.'};

    public Trifid(){

      int index = 0;
        for(int i = 0; i < arrayLength; i++){
          for(int j = 0; j < arrayLength; j++){
            for(int k = 0; k < arrayLength; k++){
              coordCube[i][j][k] = alphabet[index];
              index++;
            }
          }
        }
      }


     public static void selectMode(String mode, String message, int key){
       String formatMessage = "";
       formatMessage = message.replace(" ", "");
       char[] arrayMessage = formatMessage.toCharArray();
       int messageLenght = formatMessage.length();
       if(mode.equals("-e")){
           encryption(key, arrayMessage, messageLenght);
       }
       else if (mode.equals("-d")){
           decodeCipher(key, formatMessage, messageLenght);
       }
      }


     public static void encryption(int key, char[] arrayMessage, int messageLenght){
      int messageIndex = 0;
      int[] arrayX = new int[messageLenght];
      int[] arrayY = new int[messageLenght];
      int[] arrayZ = new int[messageLenght];
      while(messageIndex < messageLenght){
        outerloop:
        for(int i = 0; i < arrayLength; i++){
          for(int j = 0; j < arrayLength; j++){
            for(int k = 0; k < arrayLength; k++){
              if (arrayMessage[messageIndex] == (coordCube[i][j][k])){
                arrayX[messageIndex] = i;
                arrayY[messageIndex] = j;
                arrayZ[messageIndex] = k;
                messageIndex++;
                break outerloop;
                }
              }
            }
          }
        }
      int start = 0;
      int end = arrayX.length;
      List<String> result = new ArrayList<>();
      while (start < end){
      StringBuilder matrix = new StringBuilder();
      for (int i = start; i < start + key && i < end; i++) {
       matrix.append(arrayX[i]);
      }
      for (int i = start; i < start + key && i < end; i++) {
         matrix.append(arrayY[i]);
      }
      for (int i = start; i < start + key && i < end; i++) {
         matrix.append(arrayZ[i]);
      }
      start += key;
      result.add(matrix.toString());
      }
      String value = "";
      StringBuilder finalCipher = new StringBuilder();
      for (int i = 0; i < (result.size()) ; i++){
        value = result.get(i);
        char[] valueArray = value.toCharArray();
        //System.out.println(valueArray);
        int amountPerMatrix = value.length()/3;
        int numericIndex = 0;
        Character.toString ((char) i);
        for(int j = 0; j < amountPerMatrix; j++){
          int xValue = Character.getNumericValue(valueArray[numericIndex]);
          int yValue = Character.getNumericValue(valueArray[numericIndex+1]);
          int zValue = Character.getNumericValue(valueArray[numericIndex+2]);
          finalCipher.append(coordCube[xValue][yValue][zValue]);
         numericIndex += 3;
      }

    }
    System.out.println(finalCipher);
  }
     public static void decodeCipher(int key,String formatMessage, int messageLenght){
       System.out.print("Dziala Decrypt");
     }
}
