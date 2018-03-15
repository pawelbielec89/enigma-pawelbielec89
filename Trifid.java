public class Trifid{
    static int arrayLength = 3;
    static char[][][] coordCube = new char[arrayLength][arrayLength][arrayLength];


    public Trifid(char[] alphabet){
      int index = 0;
        for(int i = 0; i < arrayLength; i++){
          for(int j = 0; j < arrayLength; j++){
            for(int k = 0; k < arrayLength; k++){
              coordCube[i][j][k] = alphabet[index];
              index++;
              //System.out.print(coordCube[2][0][0]);
            }
          }
        }
      }


     public static void selectMode(String mode, String message, int key, char alphabet[]){
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
    //  for(int x = 0; x < messageLenght; x++){
      while(messageIndex < (messageLenght)){

        for(int i = 0; i < arrayLength; i++){
          for(int j = 0; j < arrayLength; j++){
            for(int k = 0; k < arrayLength; k++){
              if (arrayMessage[messageIndex] == (coordCube[i][j][k])){
                arrayX[messageIndex] = i;
                arrayY[messageIndex] = j;
                arrayZ[messageIndex] = k;
                messageIndex++;
                break;
                
                }
              }
            }
          }
        }
      System.out.print(arrayX[0]);
      System.out.print(arrayY[0]);
      System.out.print(arrayZ[0]);
      System.out.print(arrayX[1]);
      System.out.print(arrayY[1]);
      System.out.print(arrayZ[1]);
      System.out.print(arrayX[2]);
      System.out.print(arrayY[2]);
      System.out.print(arrayZ[2]);
      System.out.print(arrayX[3]);
      System.out.print(arrayY[3]);
      System.out.print(arrayZ[3]);
      System.out.print(arrayX[4]);
      System.out.print(arrayY[4]);
      System.out.print(arrayZ[4]);
      System.out.print(arrayX[5]);
      System.out.print(arrayY[5]);
      System.out.print(arrayZ[5]);
      System.out.print(arrayX[6]);
      System.out.print(arrayY[6]);
      System.out.print(arrayZ[6]);
      System.out.print(arrayX[7]);
      System.out.print(arrayY[7]);
      System.out.print(arrayZ[7]);
      System.out.print(arrayX[8]);
      System.out.print(arrayY[8]);
      System.out.print(arrayZ[8]);
     }

     public static void decodeCipher(int key,String formatMessage, int messageLenght){
       System.out.print("Dziala Decrypt");
     }
}
