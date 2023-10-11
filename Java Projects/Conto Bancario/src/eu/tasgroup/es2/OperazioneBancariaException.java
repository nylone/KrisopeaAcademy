package eu.tasgroup.es2;

public class OperazioneBancariaException extends Exception {

	private static final long serialVersionUID = 1L;
	private String motivo;

	public OperazioneBancariaException(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String getMessage() {
		return "Non è possibile effettuare questa operazione perchè: " + motivo;
	}
}
