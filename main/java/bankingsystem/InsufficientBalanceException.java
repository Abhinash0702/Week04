package bankingsystem;

public class InsufficientBalanceException extends  Exception{
    String message;
    InsufficientBalanceException(String message){
        super(message);
    }
}
