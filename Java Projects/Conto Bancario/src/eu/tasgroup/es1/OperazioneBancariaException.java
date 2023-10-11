package eu.tasgroup.es1;

public class OperazioneBancariaException extends Exception {

	private static final long serialVersionUID = 2L;
	private String motivo;

	public OperazioneBancariaException(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String getMessage() {
		return "Non è possibile depositare questa somma di denaro perchè: " + motivo;
	}

}
