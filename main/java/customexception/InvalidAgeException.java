package customexception;

public class InvalidAgeException extends Exception{
    String message;
     int age;
    InvalidAgeException(String message , int age){
        super(message);
        this.age = age;
    }

}
