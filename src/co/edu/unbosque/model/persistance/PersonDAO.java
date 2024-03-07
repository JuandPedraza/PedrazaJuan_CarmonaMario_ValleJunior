package co.edu.unbosque.model.persistance;

import java.io.File;
import java.util.ArrayList;

import co.edu.unbosque.model.Person;

public interface PersonDAO {
	void insert(ArrayList<Person> personas, File file,Person person);
	Person search(String nombre, ArrayList<Person> personas);
	void delete(String nombre, ArrayList<Person> personas, File file);
	void modify(String nombre,String nombre2,String telefono,String correo,String pais, ArrayList<Person> personas, File file);
	String showList(File file);
	boolean isPersonAdded(String name,ArrayList<Person> personas);
}
