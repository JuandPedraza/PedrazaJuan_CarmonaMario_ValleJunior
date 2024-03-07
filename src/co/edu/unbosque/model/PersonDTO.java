package co.edu.unbosque.model;

import java.io.File;
import java.util.*;

import co.edu.unbosque.model.persistance.*;
/**
 * Clase donde se maneja la iformacion del programa y se llaman los metodos del paquete persistence
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class PersonDTO {
    /**
     * Atributo que representa los amigos contenidos dentro del amigos.dat
     */
	private ArrayList<Person> friends;
    /**
     * Atributo que representa los contactos contenidos dentro del amigos.dat
     */
	private ArrayList<Person> contacts;

	
    /**
     * Atributo que representa el dao para menejar los amigos
     */
	private PersonDAO_Impl friend_dao;
	  /**
     * Atributo que representa el dao para menejar los contactos
     */
	private PersonDAO_Impl contact_dao;
	  /**
     * Atributo que representa el dao para menejar las personas en general
     */
	private PersonDAO_Impl person_dao;
	 /**
     * Atributo que representa el archivo binario para los amigos
     */
	private File fileContact;
	 /**
     * Atributo que representa el archivo binario para los contactos
     */
	private File fileFriend;
	 /**
     * Atributo que representa el manejo del archivo binario para los amigos
     */
	private Archivo archivoContact;	 
	/**
     * Atributo que representa el manejo del archivo binario para los contactos
     */
	private Archivo archivoFriend;
	
	/**
     * Metodo contructor de la claseS
     */
	public PersonDTO() {
		friends = new ArrayList<Person>();
		contacts= new ArrayList<Person>();
	
		
		fileContact= new File("datos\\contactos.dat");
		fileFriend=new File("datos\\amigos.dat");
		
		archivoFriend = new Archivo();
		friend_dao = new PersonDAO_Impl(archivoFriend);
		friends = archivoFriend.leerArchivo(fileFriend);
		
		archivoContact = new Archivo();
		contact_dao = new PersonDAO_Impl(archivoContact);
		contacts = archivoContact.leerArchivo(fileContact);
		
		person_dao= new PersonDAO_Impl();



	}

	
	
	public ArrayList<Person> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<Person> friends) {
		this.friends = friends;
	}

	public ArrayList<Person> getContacts() {
		return contacts;
	}

	public void setContacts(ArrayList<Person> contacts) {
		this.contacts = contacts;
	}

	public PersonDAO_Impl getFriend_dao() {
		return friend_dao;
	}

	public void setFriend_dao(PersonDAO_Impl friend_dao) {
		this.friend_dao = friend_dao;
	}

	public PersonDAO_Impl getContact_dao() {
		return contact_dao;
	}

	public void setContact_dao(PersonDAO_Impl contact_dao) {
		this.contact_dao = contact_dao;
	}

	public File getFileContact() {
		return fileContact;
	}

	public void setFileContact(File fileContact) {
		this.fileContact = fileContact;
	}

	public File getFileFriend() {
		return fileFriend;
	}

	public void setFileFriend(File fileFriend) {
		this.fileFriend = fileFriend;
	}

	public Archivo getArchivoContact() {
		return archivoContact;
	}

	public void setArchivoContact(Archivo archivoContact) {
		this.archivoContact = archivoContact;
	}

	public Archivo getArchivoFriend() {
		return archivoFriend;
	}

	public void setArchivoFriend(Archivo archivoFriend) {
		this.archivoFriend = archivoFriend;
	}

	public PersonDAO_Impl getPerson_dao() {
		return person_dao;
	}

	public void setPerson_dao(PersonDAO_Impl person) {
		this.person_dao = person;
	}
	
	

}
