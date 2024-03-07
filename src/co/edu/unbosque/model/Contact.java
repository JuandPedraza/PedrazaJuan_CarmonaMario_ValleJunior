package co.edu.unbosque.model;
/**
 * Clase donde se crea el tipo de dato Contact(contacto de  trabajo), hereda de la clase persona
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class Contact extends Person {

    /**
     * Atributo que le da un UID a la clase permitiendo serealizar el tipo de dato en archivos binarios
     */
	private static final long serialVersionUID = 1L;
    /**
     * Atributo que le asigna la empresa o compañia del contacto
     */
	private String company;
    /**
     * Metodo Constructor de la clase
     * @param name Nombre del contacto
     * @param country Pais del contacto
     * @param mail Correo electronico del contacto
     * @param company Nombre de la empresa del contacto
     * @param phone Numero de telefono del contacto
     */
	public Contact(String name, String country, String mail, String company, String phone) {
		super(name, country, mail, phone);

		this.company = company;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
    /**
     * Metodo toString de la clase
     * @return String 
     */
	public String toString() {
		return super.toString() + "\n Empresa: " + company;

	}

}
