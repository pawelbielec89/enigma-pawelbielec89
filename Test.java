import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Test{
    static int cipherKey = 3;
    static String displayParameter = "-e";
    static String message = "cokolwiek bysmy chcieli";

    public static void main(String[] args){
      Trifid obj = new Trifid();
      obj.selectMode(displayParameter, message, cipherKey);
    }
}
