import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Test{
    static int cipherKey = 4;
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i',
                              'j','k','l','m','n','o','p','q','r',
                              's','t','u','v','w','x','y','z','.'};
    static String displayParameter = "-e";
    static String message = "lubie placki na goraco";

    public static void main(String[] args){
      Trifid obj = new Trifid(alphabet);
      obj.selectMode(displayParameter, message, cipherKey, alphabet);
    }
}
