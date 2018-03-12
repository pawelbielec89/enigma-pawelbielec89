public class Enigma{

    private static void startProgram(String[] commandLineArgs) {
		String displayParameter = "";
        String cipherType = "";
        try{
            displayParameter = commandLineArgs[0];
            if (displayParameter.equalsIgnoreCase("-h")){
                System.out.println("Print help");
                System.exit(0);
            }
            cipherType = commandLineArgs[1];

        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Not enough parameters! Try: java Enigma -h");
            System.exit(0);
        }
       
        if (displayParameter.equalsIgnoreCase("-l")){
            System.out.print
            (
            "Possible Ciphers:\n"+
            "Atbash\n"+
            "#2 DRUGIEE\n"+
            "#3 AUTOKEYYYY\n"+
            "#4 I CZWARTE\n"
            );
        }
        else if (cipherType.equalsIgnoreCase("Atbash")){
            Atbash atbash = new Atbash();
            atbash.atbashCipher();
        }
	}


    public static void main(String[] args){
        startProgram(args);       
    }
}

	