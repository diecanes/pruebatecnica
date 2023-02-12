package prueba.tecnica.superheroe.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4537013201393583132L;

	public NotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
}
