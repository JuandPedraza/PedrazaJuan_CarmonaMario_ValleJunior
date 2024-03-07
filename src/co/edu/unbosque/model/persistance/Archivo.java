package co.edu.unbosque.model.persistance;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Person;
/**
 * Clase encargada de la serializacion y deserializacion de los archivos binarios
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class Archivo {
    /**
     * Atributo que permite la deserealizacion del archivo binario
     */
	private ObjectInputStream input;
    /**
     * Atributo que permite la serealizacion del archivo binario
     */
	private ObjectOutputStream output;
	
	
    /**
     * Metodo Contructructor de la clase
     */
	public Archivo() {}
	
    /**
     * Método para escribir objetos en el archivo binario
     * @param personas ArrayList de personas
     * @param file Archivo binario donde se quieren escribir los objetos 
     */
	public void escribirArchivo(ArrayList<Person> personas, File file){
			try {
				if (!file.exists())
					file.createNewFile();
				
					output = new ObjectOutputStream(new FileOutputStream(file));
					output.writeObject(personas);
					output.close();
				

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(null, "No se pudo escribir el archivo");
			}
	}
    /**
     * Método para escribir objetos en el archivo binario
     * @param file Archivo binario donde se quiere leer los objetos
     * @return ArrayList Retorna una ArryList de personas 
     */
	public ArrayList<Person> leerArchivo(File file) {
		ArrayList<Person> personas = new ArrayList<Person>();
		if (file.length() != 0) {
			try {
				input = new ObjectInputStream(new FileInputStream(file));
				personas = (ArrayList<Person>) input.readObject();
				input.close();
			} catch (FileNotFoundException ex) {
				JOptionPane.showMessageDialog(null, "Hubo un problema leyendo el archivo");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return personas;
	}

	public ObjectInputStream getInput() {
		return input;
	}

	public void setInput(ObjectInputStream in) {
		this.input = in;
	}

	public ObjectOutputStream getOutput() {
		return output;
	}

	public void setOutput(ObjectOutputStream out) {
		this.output = out;
	}

}
