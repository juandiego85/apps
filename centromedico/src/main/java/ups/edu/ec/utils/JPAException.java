package ups.edu.ec.utils;

public class JPAException extends Exception {
	
	/**
	 * Referencia de serializacion
	 */
	private static final long serialVersionUID = 1L;
	
	//Valor para referencia e identificar el codigo de error producido 
	private int codigo;
	//Valor para referencia e identificar el mensaje de error producido
	private String mensaje;
	
	public JPAException(Exception e) {
		super(e);
		this.codigo = 1;			//Error general
		this.mensaje = this.getLocalizedMessage();		
	}

	

	/**
	 * Retorna la descripcion mas acertada del error
	 * @param e
	 * @return
	 */
	public static String getErrorMessage(Exception e) {
		// Default to general error message that registration failed.
		String errorMessage = "Error no tratado, revisar log de servidor...";
		if (e == null) {
			// This shouldn't happen, but return the default messages
			return errorMessage;
		}

		// Start with the exception and recurse to find the root cause
		Throwable t = e;
		while (t != null) {
			// Get the message from the Throwable class instance
			errorMessage = t.getLocalizedMessage();
			t = t.getCause();
		}
		// This is the root cause message
		if (errorMessage == null)
			errorMessage = e.getMessage();
		return errorMessage;
	}
	
	/**
	 * Encapsulameinto
	 */
	
	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
