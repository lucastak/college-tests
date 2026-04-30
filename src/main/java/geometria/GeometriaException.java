package geometria;

public class GeometriaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public GeometriaException( String mensagem, Throwable causa ) {
		super( mensagem, causa );
	}

	public GeometriaException( String mensagem ) {
		super( mensagem );
	}

	public GeometriaException( Throwable causa ) {
		super( causa );
	}
	
}
