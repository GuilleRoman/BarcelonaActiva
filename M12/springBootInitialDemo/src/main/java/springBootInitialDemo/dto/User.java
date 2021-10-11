package springBootInitialDemo.dto;

public class User {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public User(String message) {
		super();
		this.message=message;
	}
}
