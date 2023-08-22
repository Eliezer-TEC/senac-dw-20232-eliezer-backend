package senacdw20232eliezerbackend.exemplodw.exception;

public class CampoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CampoInvalidoException(String mensagem, Exception e) {
		super(mensagem, e);
	}
	
	public CampoInvalidoException(String mensagem) {
		super(mensagem);
	}
}