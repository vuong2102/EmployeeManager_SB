package Employee.management.repository.error;

public class ArgumentException extends RuntimeException{
    public ArgumentException(String message){
        super(message);
    }
}
