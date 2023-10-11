package eu.tasgroup.es1;

public class ImpossibilePrelevareException extends Exception {

	private static final long serialVersionUID = 1L;
	private String motivo;

	public ImpossibilePrelevareException(String motivo) {
		this.motivo = motivo;
	}

	@Override
	public String getMessage() {
		return "Non è possibile prelevare questa somma di denaro perchè: " + motivo;
	}

}
