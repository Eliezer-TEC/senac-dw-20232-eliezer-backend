package senacdw20232eliezerbackend.exemplodw.exception;

public class IdInexistenteExcpetion extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdInexistenteExcpetion(String mensagem, Exception e) {
		super(mensagem, e);
	}

	public IdInexistenteExcpetion(String mensagem) {
		super(mensagem);
	}
}
