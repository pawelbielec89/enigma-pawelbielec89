public class Enigma
{
    // public static void CaesarCipher()   // #1
    // {
    //     System.out.println("CeasarCipher e/dcode");
    // }

    // public static void SecondCipher()   // #2
    // {
    //     System.out.println("SecondCipher e/dcode");
    // }

    // public static void AutokeyCipher()  // #3
    // {
    //     System.out.println("AutokeyCipher e/dcode");
    // }

    // public static void FourthCipher()  // #4
    // {
    //     System.out.println("FourthCipher e/dcode");
    // }


    public static void main(String[] args)
    {
        try
        {
            if (args[0].equalsIgnoreCase("-l"))
            {
                System.out.print
                (
                "Possible Ciphers:\n"+
                "#1 CEZARRRR\n"+
                "#2 DRUGIEE\n"+
                "#3 AUTOKEYYYY\n"+
                "#4 I CZWARTE\n"
                );
            }
        }

        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Not enough parameters! Try: java Enigma -l");
            System.exit(0);
        }
    }
}