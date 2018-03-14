import java.io.IOException;

class InvalidInputException extends IOException{

    public InvalidInputException(){}
    public InvalidInputException(String message){
        super(message);
    }
}