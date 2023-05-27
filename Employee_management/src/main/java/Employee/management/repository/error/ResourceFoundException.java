package Employee.management.repository.error;

public class ResourceFoundException extends RuntimeException{
    public ResourceFoundException(String message){
        super(message);
    }
}
