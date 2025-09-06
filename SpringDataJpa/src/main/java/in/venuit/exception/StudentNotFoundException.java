package in.venuit.exception;

public class StudentNotFoundException extends RuntimeException{
	
	public StudentNotFoundException(Long id)
	{
		super("Student with id " +id+ "not Found");
	}

	
	public StudentNotFoundException(String msg)
	{
		super(msg);
	}
}
