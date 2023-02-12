package prueba.tecnica.superheroe.exception;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 2463084600789040856L;

	public DatabaseException(String error) {
		super(error);
	}
}
