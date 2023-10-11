package eu.tasgroup.social.backend;

public class OperationException extends Exception {

	private String why;

	private static final long serialVersionUID = 1L;

	public OperationException(String why) {
		this.why = why;
	}

	@Override
	public String getMessage() {
		return why;
	}

}
