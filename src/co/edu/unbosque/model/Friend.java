package co.edu.unbosque.model;
/**
 * Clase donde se crea el tipo de dato Friend(amigo)
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class Friend extends Person {

	  /**
     * Atributo que le da un UID a la clase permitiendo serealizar el tipo de dato en archivos binarios
     */
	private static final long serialVersionUID = 1L;
    /**
     * Metodo Constructor de la clase
     * @param name Nombre del amigo
     * @param country Pais del amigo
     * @param mail Correo electronico del amigo
     * @param phone Numero de telefono del amigo
     */
	public Friend(String name, String country, String mail, String phone) {
		super(name, country, mail, phone);
	}
	
    /**
     * Metodo toString de la clase
     * @return String 
     */
	public String toString() {
		return super.toString();
	}

}
