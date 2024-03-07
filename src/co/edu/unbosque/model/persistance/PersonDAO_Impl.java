package co.edu.unbosque.model.persistance;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.*;
/**
 * Clase encargada de las acciones del CRUD, implementa una interdaz que modela el comportamiento
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class PersonDAO_Impl implements PersonDAO{
    /**
     * Atributo que permite acceder a los metodos de la clase Archivo y poder manupular las acciones del CRUD con los archivos
     */
	private Archivo archivo;

    /**
     * Metodo constructor
     * @param archivo Objeto tipo Archivo
     */
	public PersonDAO_Impl(Archivo archivo) {
		this.archivo = archivo;
	}
	
    /**
     * Metodo constructor, sobre carga
     * @param archivo Objeto tipo Archivo
     */
	public PersonDAO_Impl(){}

    /**
     * Método para insertar una nueva persona al archivo
     * @param personas ArrayList de personas
     * @param file Archivo binario donde se quiere guardar la persona 
     * @param newPerson La nueva persona que se va a guardar
     */
	@Override
	public void insert(ArrayList<Person> personas, File file,Person newPerson) {
		
		if(search(newPerson.getName(), personas) == null) {
			personas.add(newPerson);
			archivo.escribirArchivo(personas, file);
			
		}else { 
			JOptionPane.showMessageDialog(null, "Hubo un problema agregando la persona");
		}
	}

    /**
     * Método para buscar una persona 
     * @param personas ArrayList de personas
     * @param nombre El nombre de la persona que se quiere buscar
     * @return Person retorna la persona encontrada
     */
	@Override
	public Person search(String nombre, ArrayList<Person> personas) {
		Person find = null;

		if (!personas.isEmpty()) {
			for (Person persona : personas) {
				if (nombre.equals(persona.getName().toLowerCase())) 
					find = persona;	
			}
		}
		return find;
	}

    /**
     * Método para buscar una persona 
     * @param nombre El nombre de la persona que se quiere buscar
     * @param personas ArrayList de personas
     * @param file Archivo de donde que quiere eliminar la persona
     */
	@Override
	public void delete(String nombre, ArrayList<Person> personas, File file) {
		try {
			Person p = search(nombre, personas);
			if (p != null) {
				personas.remove(p);
				file.delete();
				file.createNewFile();
				archivo.escribirArchivo(personas, file);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Hubo un error eliminando la persona");
		}
		
	}

    /**
     * Método para buscar una persona 
     * @param nombre El nombre de la persona que se quiere modificar
     * @param nombre2 El nuevo nombre de la persona
     * @param telefono El nuevo  telefono de la persona
     * @param correo El nuevo correo de la persona
     * @param pais El nuevo pais de la persona
     * @param personas Lista de personas 
     * @param file Archivo de donde que quiere modificar la persona
     */

	@Override
	public void modify(String nombre,String nombre2,String telefono,String correo,String pais, ArrayList<Person> personas,File file) {
		Person find = search(nombre,personas);
		try {
			if (find != null) {
				delete(nombre, personas, file);
				find.setPhone(telefono);
				find.setName(nombre2);
				find.setMail(correo);
				find.setCountry(pais);
				personas.add(find);
                file.delete();
                file.createNewFile();
				archivo.escribirArchivo(personas, file);
			} else
				JOptionPane.showMessageDialog(null, "Ups, esta persona no está en tu lista");
			
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Hubo un problema intentando eliminar la persona");
		}
	}


    /**
     * Método para mostrar el toString() de los obejots que estan en el archivo
     * @param file Archivo binario donde se queire mostrar los objetos
     * @return String retorna un string con el toString() de las personas del archivo
     */
	@Override
	public String showList(File file) {
		ArrayList <Person> personas = archivo.leerArchivo(file);
		String lista ="";
		for (Person persona : personas) {
			lista = lista.concat(persona.toString() + "\n");
		}
		return lista;
	}

    /**
     * Método para verificar si una persona esta agregada
     * @param name Nombre de la perosna a verificar si  esta  en la lista
     * @param file Archivo binario donde se queire mostrar los objetos
     * @return boolean retorna un string con el toString() de las personas del archivo
     */
	@Override
	public boolean isPersonAdded(String name,ArrayList<Person> personas) {
		Person p=search(name,personas);
		return(p != null? true:false);
	}
	

}
