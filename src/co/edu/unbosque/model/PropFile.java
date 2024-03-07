package co.edu.unbosque.model;

import java.io.File;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;
/**
 * Clase donde se maneja los archivos de propiedades
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class PropFile {
    /**
     * Atributo que me ayuda a identificar si un archivo se subio dos veces
     */
	private File file;
    /**
     * Metodo Constructor de la clase
     */
	public PropFile() {}
	
	  /**
     * Metodo me inicializa la propiedades  del archivo y me retorna una lista depersonas, este se usa para los amigos
     * @param file Archivo de propiedades
     * @return ArrayList  
     */
	public ArrayList<Person> InitializePropertiesFriends(File file) {
		Properties prop = new Properties();
		ArrayList<Person>amigos =new ArrayList<Person>();
		Person amigo;

		try {
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
			in.close();


			
			for (int i = 0; i < 15; i++) {	
				String nombreF = prop.getProperty("amigo.nombre" + i);
				String paisF = prop.getProperty("amigo.pais" + i);
				String correoF = prop.getProperty("amigo.correo" + i);
				String telefonoF = prop.getProperty("amigo.telefono" + i);
				if(nombreF!=null&&paisF!=null&&correoF!=null&&telefonoF!=null) {
					amigo = new Friend(nombreF, paisF, correoF, telefonoF);
					amigos.add(amigo);
				}else
					continue;
			}

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error con el archivo");
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Error cargando el archivo");
		}
		 for(Person i: amigos) {
			 System.out.println(i.toString());
		 }
		return amigos;
	}
	
	  /**
     * Metodo me inicializa la propiedades  del archivo y me retorna una lista depersonas, este se usa para los contactos
     * @param file Archivo de propiedades
     * @return ArrayList  
     */
	public ArrayList<Person> initializePropertiesContact(File f) {
		Properties prop = new Properties();
		ArrayList<Person> contactos = new ArrayList<Person>();
		Person contacto;
		try {
			FileInputStream in = new FileInputStream(f);
			prop.load(in);
			in.close();
			for (int i = 0; i < 20; i++) {
				String nombre = prop.getProperty("contacto.nombre" + i);
				String pais = prop.getProperty("contacto.pais" + i);
				String correo = prop.getProperty("contacto.correo" + i);
				String empresa = prop.getProperty("contacto.empresa" + i);
				String telefono = prop.getProperty("contacto.telefonoManager" + i);
				if(nombre!=null&&pais!=null&&correo!=null&&empresa!=null&&telefono!=null) {
					contacto = new Contact(nombre, pais, correo,empresa, telefono);
					contactos.add(contacto);
				}else
					continue;
			}

			 for(Person i: contactos) {
				 System.out.println(i.toString());
			 }
			 
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error con el archivo");
		}catch(IOException ex) {
			JOptionPane.showMessageDialog(null, "Error cargando el archivo");
		}catch(NullPointerException ex) {
			JOptionPane.showMessageDialog(null, "Un error con el  contenido del archivo");
		}
		
		return contactos;
	}
	  /**
     * Metodo indica si  el archivo ha sido cargado
     * @param file Archivo de propiedades
     * @return boolean  
     */
	public boolean isFileLoaded(File file) {
		return (file!=null?true:false);
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	
}
