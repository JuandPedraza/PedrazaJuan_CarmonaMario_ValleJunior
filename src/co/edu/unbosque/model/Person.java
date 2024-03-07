package co.edu.unbosque.model;

import java.io.Serializable;
/**
 * Clase donde se crea el tipo de dato base Persona, esta clase implementa una interfaz Serializable
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class Person implements Serializable {
    /**
     * Atributo que le da un UID a la clase permitiendo serealizar el tipo de dato en archivos binarios
     */
	private static final long serialVersionUID = 1L;
    /**
     * Atributo que le asigna nombre a la persona
     */
	protected String name;
    /**
     * Atributo que le asigna un pais a la persona
     */
	protected String country;
    /**
     * Atributo que le asigna un correo a la persona
     */
	protected String mail;
    /**
     * Atributo que le asigna un numero de telefono a la persona
     */
	protected String phone;
    /**
     * Metodo Constructor de la clase
     * @param name Nombre de la persona
     * @param country Pais de la persona
     * @param mail Correo electronico de la persona
     * @param phone Numero de telefono de la persona
     */
	public Person(String name, String country, String mail, String phone) {
		super();
		this.name = name;
		this.country = country;
		this.mail = mail;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    /**
     * Metodo toString de la clase
     * @return String 
     */
	@Override
	public String toString() {
		return  "\nNombre: " + name + "\nPaís: " + country + "\nCorreo: " + mail+"\nTelefono:"+phone;
	}

}
