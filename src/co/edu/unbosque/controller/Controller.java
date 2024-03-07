package co.edu.unbosque.controller;

import co.edu.unbosque.model.*;
import co.edu.unbosque.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 * Clase encargada adjuntar los tipos de datos y darle funcionalidad al programa,
 * esta clase heresa tres interfaces:ActionListener, WindowListener, KeyListener
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class Controller implements ActionListener,WindowListener,KeyListener {
    /**
     * Atributo para inicializar la vista principal y poder manipularla
     */
	private MainView mainView;   
    /**
     * Atributo para inicializar la vista de buscar y poder manupularla
     */
	private SearchView searchView;    
    /**
     * Atributo para inicializar la vista agregar amigo y poder manupularla
     */
	private AddViewFriend vfriend;    
    /**
     * Atributo para inicializar la vista agregar contacto y poder manupularla
     */
	private AddViewContact vcontact;   
    /**
     * Atributo para inicializar la vista de OptionPane y poder manupularla
     */
	private OptionPaneView optionView;
    /**
     * Atributo para inicializar la vista de modificar y poder manupularla
     */
	private ModifyView modifyView;
    /**
     * Atributo que me permite inicializar un objeto tipo PropFile y manejar mis archivos de propiedades
     */
	private PropFile propFile;
    /**
     * Atributo que me permite inicializar un objeto tipo PersonDTO y manejar la informacion
     */
	private PersonDTO dto;
	
	
    /**
     * Metodo contructor del controlador
     */
	public Controller() {

		initialize();
	}
    /**
     * Metodo que inicilaliza los listeners y un metodo que me muestra informacion en el mainView
     */
	public void initialize() {
		optionView= new OptionPaneView();
		mainView = new MainView();
		searchView = new SearchView();
		vfriend = new AddViewFriend();
		vcontact = new AddViewContact();
		modifyView=new ModifyView();
		propFile = new PropFile();
		dto= new PersonDTO();
		showAll();
		initializeListeners();
		
	}
    /**
     * Metodo que inicilaliza y asigna los listeners para elementos especificos
     */
	public void initializeListeners() {
		mainView.getExitBtn().addActionListener(this);
		mainView.getAddBtn().addActionListener(this);
		mainView.getDeleteBtn().addActionListener(this);
		mainView.getSearchBtn().addActionListener(this);
		mainView.getBrowseBtn().addActionListener(this);
		mainView.getModifyBtn().addActionListener(this);
		mainView.getEstatsBtn().addActionListener(this);
		mainView.getAllBtn().addActionListener(this);
		
		searchView.getBackBtn().addActionListener(this);
		searchView.getSearchBtn().addActionListener(this);
		vfriend.getCancelarFriendBtn().addActionListener(this);
		vfriend.getAddFriendBtn().addActionListener(this);
		vcontact.getCancelarContactBtn().addActionListener(this);
		vcontact.getAddContactdBtn().addActionListener(this);
		modifyView.getCancelarModifyBtn().addActionListener(this);
		modifyView.getModifyPersonBtn().addActionListener(this);
				
		mainView.addWindowListener(this);
		vfriend.addWindowListener(this);
		vcontact.addWindowListener(this);
		searchView.addWindowListener(this);
		modifyView.addWindowListener(this);
		
		vfriend.getNumber().addKeyListener(this);
		vcontact.getNumber().addKeyListener(this);
		modifyView.getNumber().addKeyListener(this);

	}
	  /**
     * Método para escribir todos los action Listeners del programa
     * @param ActionEvent e
     */
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		switch (command) {
		case "EXAMINAR":
			JFileChooser fc = new JFileChooser(new File("datos"));
			File fileChoosed = chooseFile(fc);

			if(isSameFile(fileChoosed)==true) {
				optionView.showMessage("El archivo es el mismo");
				break;
			}

			if(!propFile.isFileLoaded(fileChoosed))
				break;
			
			if(propFile.InitializePropertiesFriends(fileChoosed).isEmpty()
			   &&propFile.initializePropertiesContact(fileChoosed).isEmpty()){
				optionView.showMessage("El archivo no tiene la informacion necesaria ");
				break;
			}else {
				dto.getArchivoFriend().escribirArchivo(propFile.InitializePropertiesFriends(fileChoosed), dto.getFileFriend());
				dto.getArchivoContact().escribirArchivo(propFile.initializePropertiesContact(fileChoosed), dto.getFileContact());

				dto.setFriends(dto.getArchivoFriend().leerArchivo(dto.getFileFriend()));
				dto.setContacts(dto.getArchivoContact().leerArchivo(dto.getFileContact()));

				propFile.setFile(fileChoosed);
				showAll();
			}
			
			break;

		case "AGREGARVIEW":
			optionView.addPersonPane(vfriend,vcontact,mainView);
			break;
		
		case "AGREGAR":
			if(vfriend.isVisible()) {
				if(dto.getFriends().size()<=14) {
					createFriend();
					showAll();
				}else 
					optionView.showMessage("La agenda esta llema");
			}
				
			if(vcontact.isVisible()) {
				if(dto.getContacts().size()<=19) {
					createContact();
					showAll();
				}else
					optionView.showMessage("La agenda esta llena");
			}
			break;
			
		case "ELIMINAR":
			deletePerson();
			break;

		case "BUSCARVIEW":
			mainView.setVisible(false);
			searchView.setVisible(true);
			break;
		case "BUSCAR":
			searchPerson();
			break;
		case "MODIFICARVIEW":
			modifyView();
			break;
		case "MODIFICAR":
			String name = modifyView.getOldNameTxt().getText();
			
			if(dto.getFriend_dao().search(name, dto.getFriends())!=null) {
				modifyPerson(dto.getFriends(),dto.getFileFriend());
				showAll();
			}
			else if(dto.getContact_dao().search(name, dto.getContacts())!=null) {
				modifyPerson(dto.getContacts(),dto.getFileContact());
				showAll();
			}	
			break;
		case"ESTATS":
			statistics();
			break;
		case "ALL":
			showAll();
			break;
		case "VOLVER":
			closeFrame(searchView,vfriend,vcontact,modifyView);
			break;	
			
		case "EXIT":
			System.exit(0);
			break;
		}

	}
	  /**
     * Método para mostrar las listas de las personas que estan en los archivos binarios
     */
	public void showAll(){
		if(dto.getFileFriend().exists() && dto.getFileContact().exists())
			mainView.setButtonsEnable(true);
		else
			mainView.setButtonsEnable(false);
		
		String friendsList=dto.getFriend_dao().showList(dto.getFileFriend());
		String contactsList=dto.getContact_dao().showList(dto.getFileContact()); 
		mainView.getPropArea().setText(friendsList+contactsList);
	}
	 /**
     * Método para eliminar una persona
     */
	public void deletePerson(){
	try {
			String nameDelete=optionView.StringPane("Digite el nombre de la persona a eliminar");
			nameDelete = nameDelete.trim();
			if(dto.getFriend_dao().isPersonAdded(nameDelete, dto.getFriends())) {
				dto.getFriend_dao().delete(nameDelete, dto.getFriends(), dto.getFileFriend());
				optionView.showMessage("Se ha eliminado el amigo");
				showAll();
			}else if(dto.getContact_dao().isPersonAdded(nameDelete, dto.getContacts())){
				dto.getContact_dao().delete(nameDelete, dto.getContacts(), dto.getFileContact());
				optionView.showMessage("Se ha eliminado el contacto");
				showAll();
			}else
				optionView.showMessage("La persona no existe en la agenda");
		}catch(NullPointerException ex){
			optionView.showMessage("ingrese un nombre");
		}
		
	}
	
	 /**
     * Método para buscar una persona
     */
	public void searchPerson(){
		ArrayList<Person> find = new ArrayList<Person>();
		find.addAll(dto.getContacts());
		find.addAll(dto.getFriends());
		Person f=dto.getPerson_dao().search(searchView.getNameSearch().getText().toLowerCase().trim(), find);
		if(f!=null)
			searchView.getInfoArea().setText(f.toString());
		else {
			searchView.getInfoArea().setText("");
			searchView.getNameSearch().setText("");
			optionView.showMessage("El contacto no existe");
		}
	}
	  /**
     * Método para crear un amigo
     */
	public void createFriend(){
		ArrayList<Person> find = new ArrayList<Person>();
		find.addAll(dto.getContacts());
		find.addAll(dto.getFriends());
		try {
		String name = vfriend.getNameFriend().getText().toLowerCase();
		String country = (String) vfriend.getCountry().getSelectedItem();
		String mail = vfriend.getMail().getText().toLowerCase();
		String phone = vfriend.getNumber().getText();
		String phoneReady= phone.substring(0, 3)+"-"+phone.substring(3,6)+"-"+phone.substring(6);
		
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(mail);
 
		if(dto.getPerson_dao().isPersonAdded(name, find))
			optionView.showMessage("ya hay una persona con ese nombre");
		
		else if(!name.isBlank()&&!country.isBlank()&&!phone.isBlank()&&mather.find()&& phone.length() == 9) {
			dto.getFriend_dao().insert(dto.getFriends(), dto.getFileFriend(), new Friend(name, country, mail, phoneReady));
			optionView.showMessage("Se ha añadido el amigo");
			vfriend.getNameFriend().setText("");
			vfriend.getMail().setText("");
			vfriend.getNumber().setText("");
			
		}else 
			optionView.showMessage("Revise: Si el correo ingresado es valido \n Si no hay camposvacios \n Si el numero es de 9 digitos");
				
		}catch(RuntimeException ex) {optionView.showMessage("El numero no es de 9 digitos");}
		
	}
	  /**
     * Método para eliminar un contacto
     */
	public void createContact() {
		ArrayList<Person> find = new ArrayList<Person>();
		find.addAll(dto.getContacts());
		find.addAll(dto.getFriends());
		try {
		String name = vcontact.getNameContact().getText().toLowerCase();
		String country = (String) vcontact.getCountry().getSelectedItem();
		String mail = vcontact.getMail().getText().toLowerCase();
		String company = vcontact.getBusiness().getText().toLowerCase();
		String phone = vcontact.getNumber().getText();
		String phoneReady= phone.substring(0, 3)+"-"+phone.substring(3,6)+"-"+phone.substring(6);
		
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(mail);
		
		if(dto.getPerson_dao().isPersonAdded(name, find)) 
			optionView.showMessage("ya hay una persona con ese nombre");	

		else if(!name.isBlank()&&!country.isBlank()&&!phone.isBlank()&&!company.isBlank()&&mather.find()&& phone.length() == 9) {
			dto.getContact_dao().insert(dto.getContacts(), dto.getFileContact(), new Contact(name, country, mail,company, phoneReady));
			optionView.showMessage("Se ha añadido el contacto");
			vcontact.getNameContact().setText("");
			vcontact.getMail().setText("");
			vcontact.getNumber().setText("");
			vcontact.getBusiness().setText("");
			
		}else
			optionView.showMessage("Revise que no hayan campos vacios \no si el correo ingresado es valido");
	
		}catch(RuntimeException ex) {optionView.showMessage("El numero no es de 9 digitos");}
	}
	 /**
     * Método para manejar la vista a la hora de modificar una persona
     */
	public void modifyView() {
		try {
			String nameDelete=optionView.StringPane("Digite el nombre de la persona a modificar");
			if(dto.getFriend_dao().isPersonAdded(nameDelete, dto.getFriends())) {
				mainView.setVisible(false);
				modifyView.setVisible(true);
				modifyView.getOldNameTxt().setText(nameDelete);
			}
			else if(dto.getContact_dao().isPersonAdded(nameDelete, dto.getContacts())) {
				mainView.setVisible(false);
				modifyView.setVisible(true);
				modifyView.getOldNameTxt().setText(nameDelete);	
			}else 
				optionView.showMessage("El contacto no esta en la agenda");
		}catch(NullPointerException ex) {
			optionView.showMessage("ingrese un nombre");
		}
		
	}
    /**
     * Método para modificar una persona
     * @param p ArrayList de personas
     * @param file Archivo binario donde se quiere modificar
     */
	public void modifyPerson(ArrayList<Person> p,File f) {
		ArrayList<Person> find = new ArrayList<Person>();
		find.addAll(dto.getContacts());
		find.addAll(dto.getFriends());
		try {
			String name = modifyView.getNamePerson().getText().toLowerCase();
			String country = (String) modifyView.getCountry().getSelectedItem();
			String mail = modifyView.getMail().getText().toLowerCase();
			String phone = modifyView.getNumber().getText();
			String phoneReady= phone.substring(0, 3)+"-"+phone.substring(3,6)+"-"+phone.substring(6);
			
	        Pattern pattern = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	        Matcher mather = pattern.matcher(mail);
			
			if(dto.getPerson_dao().isPersonAdded(name, find)) 
				optionView.showMessage("ya hay una persona con ese nombre");	

			else if(!name.isBlank()&&!country.isBlank()&&!phone.isBlank()&&mather.find()&& phone.length() == 9) {
				dto.getContact_dao().modify(modifyView.getOldNameTxt().getText(),name,phoneReady,mail,country, p, f);
				optionView.showMessage("Se ha modificado el Contacto");
				modifyView.setVisible(false);
				mainView.setVisible(true);
				modifyView.getOldNameTxt().setText("");
				modifyView.getNamePerson().setText("");
				modifyView.getMail().setText("");
				modifyView.getNumber().setText("");
				
			}else
				optionView.showMessage("Revise que no hayan campos vacios \no si el correo ingresado es valido");
		
			}catch(RuntimeException ex) {optionView.showMessage("El numero no es de 9 digitos");}
		}
    /**
     * Método para mostrar las estadisticas
     */
	public void statistics() {
		ArrayList<Person> find = new ArrayList<Person>();
		find.addAll(dto.getContacts());
		find.addAll(dto.getFriends());
		try {
		int all=find.size();
		double amigos= find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")).count();
		double contactos =find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")).count();
		int porcentajeF =(int)((amigos*100)/all);
		int porcentajeC=(int)((contactos*100)/all);
		
		double Colombia = find.stream().filter(x->x.getCountry().equals("Colombia")).count();
		double colombiaF=find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")&&x.getCountry().equals("Colombia")).count();
		double colombiac=find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")&&x.getCountry().equals("Colombia")).count();
		
		double Mexico=find.stream().filter(x->x.getCountry().equals("México")).count();
		double mexicoF=find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")&&x.getCountry().equals("México")).count();
		double mexicoc=find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")&&x.getCountry().equals("México")).count();
		
		double Argentina=find.stream().filter(x->x.getCountry().equals("Argentina")).count();
		double argentinaF=find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")&&x.getCountry().equals("Argentina")).count();
		double argentinac=find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")&&x.getCountry().equals("Argentina")).count();
		
		double Peru=find.stream().filter(x->x.getCountry().equals("Perú")).count();
		double peruF=find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")&&x.getCountry().equals("Perú")).count();
		double peruC=find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")&&x.getCountry().equals("Perú")).count();
		
		double Chile=find.stream().filter(x->x.getCountry().equals("Chile")).count();
		double chileF=find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")&&x.getCountry().equals("Chile")).count();
		double chileC=find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")&&x.getCountry().equals("Chile")).count();
		
		double Espana=find.stream().filter(x->x.getCountry().equals("España")).count();
		double espanaF=find.stream().filter(x->x.getClass().getSimpleName().equals("Friend")&&x.getCountry().equals("España")).count();
		double espanaC=find.stream().filter(x->x.getClass().getSimpleName().equals("Contact")&&x.getCountry().equals("España")).count();
		
		String persons="Todas las personas: "+all+	
					"\n cantidad de amigos: "+amigos+"("+porcentajeF+"%)"
					+ "\n cantidad de contactos: "+contactos+"("+porcentajeC+"%)";
		
		int Acolombia=(int)((colombiaF*100)/all);
		int Ccolombia=(int)((colombiac*100)/all);
		
		int Amexico=(int)((mexicoF*100)/all);
		int cmexico=(int)((mexicoc*100)/all);
		
		int Aargentina=(int)((argentinaF*100)/all);
		int Cargentina=(int)((argentinac*100)/all);
		
		int Aperu=(int)((peruF*100)/all);
		int Cperu=(int)((peruC*100)/all);
		
		int Achile=(int)((chileF*100)/all);
		int Cchile=(int)((chileC*100)/all);
		
		int Aespana=(int)((espanaF*100)/all);
		int Cespana=(int)((espanaC*100)/all);
		
		String paises="\nPersonas de Colombia: "+Colombia+
				"\n Amigos de Colombia: "+colombiaF+"("+Acolombia+"%)"+
				"\n contactos de Colombia: "+colombiac+"("+Ccolombia+"%)"+
				
				"\n "+"\nPersonas de México: "+Mexico+
				"\n Amigos de México: "+mexicoF+"("+Amexico+"%)"+
				"\n contactos de México: "+mexicoc+"("+cmexico+"%)"+
				
				"\n "+"\nPersonas de Perú: "+Peru+
				"\n Amigos de Perú: "+peruF+"("+Aperu+"%)"+
				"\n contactos de Perú: "+peruC+"("+Cperu+"%)"+
				
				"\n "+"\nPersonas de España: "+Espana+
				"\n Amigos de España: "+espanaF+"("+Aespana+"%)"+
				"\n contactos de España: "+espanaC+"("+Cespana+"%)"+
				
				"\n "+"\nPersonas de Argentina: "+Argentina+
				"\n Amigos de Argentina: "+argentinaF+"("+Aargentina+"%)"+
				"\n contactos de Argentina: "+argentinac+"("+Cargentina+"%)"+
				
				"\n "+"\nPersonas de Chile: "+Chile+
				"\n Amigos de Chile: "+chileF+"("+Achile+"%)"+
				"\n contactos de Chile: "+chileC+"("+Cchile+"%)";
		mainView.getPropArea().setText(persons+"\n"+paises);
		}catch(ArithmeticException ex) {
			optionView.showMessage("no hay personas en la agenda");
		}
	}
    /**
     * Metodo para cerrar las vistas cuando se quiera cancelar ua accion y volver a la ventana principal
     * @param frame1 JFrame
     * @param frame2 JFrame
     * @param frame3 JFrame
     * @param frame4 JFrame
     */
	public void closeFrame(JFrame frame1,JFrame frame2,JFrame frame3,JFrame frame4 ) {
		if(frame1.isVisible()){
			frame1.setVisible(false);
			mainView.setVisible(true);
		}else if(frame2.isVisible()){
			frame2.setVisible(false);
			mainView.setVisible(true);
		}else if(frame3.isVisible()){
			frame3.setVisible(false);
			mainView.setVisible(true);
		}else if(frame4.isVisible()) {
			frame4.setVisible(false);
			mainView.setVisible(true);
		}	
	}
    /**
     * Metodo para seleccionar un archivo y poner asignarlo a una variabel tipo File, se crea un Filter para el FileChooser
     * este metodo se llama en el actionPermormed() cuando el actionCommand es igual a "Examinar"
     * @param fc JFileChooser
     */
	public File chooseFile(JFileChooser fc){
		File file=null;

			FileNameExtensionFilter filter = new FileNameExtensionFilter("only .properties", "properties");
			fc.setAcceptAllFileFilterUsed(false);
			fc.setFileFilter(filter);
			fc.showOpenDialog(null);
			file = fc.getSelectedFile();	

		return file;
	}
    /**
     * Metodo para verificar si el archivo seleccionado es repetido, 
     * se verifica con el archivo que este asginado  en el objeto propFile
     * @param fileChoosed Archivo selecionado en el FileChooser
     * @return boolean
     */
	public boolean isSameFile(File fileChoosed) {
		if(!(propFile.getFile()!=null))
			return false;
		else if(fileChoosed!=null &&fileChoosed.compareTo(propFile.getFile())==0)
			return true;
		else
			return false;
	}
    /**
     * Metodo para evitar que el usuario cierre el JFrame con la 'x' y que use el boton "Salir"
     * @param e WindowEvent
     */
	@Override
	public void windowClosing(WindowEvent e) {
		if(mainView.isVisible())
			JOptionPane.showMessageDialog(null,"Para salir oprima el boton 'SALIR' ");
		else if(vfriend.isVisible())
			JOptionPane.showMessageDialog(null,"Para salir vaya a la ventana principal \n"
					+ "ventata principal click 'CANCELAR' ");
		else if(vcontact.isVisible())
			JOptionPane.showMessageDialog(null,"Para salir vaya a la ventana principal \n"
					+ "ventata principal click 'CANCELAR' ");
		else if(searchView.isVisible())
			JOptionPane.showMessageDialog(null,"Para salir vaya a la ventana principal \n"
					+ "ventata principal click 'VOLVER' ");
		else if(modifyView.isValidateRoot())
			JOptionPane.showMessageDialog(null,"Para salir vaya a la ventana principal \n"
					+ "ventata principal click 'VOLVER' ");
	}

    /**
     * Metodo para limitar las letras y caracteres especiales cuando inserto un numero de telefono al agregar
     * @param e KeyEvent
     */
	@Override
	public void keyTyped(KeyEvent e) {
		char validar = e.getKeyChar();

		if(vfriend.isVisible()&&vfriend.getNumber().getText().length() == 9) {
			JOptionPane.showMessageDialog(null, "Ingrese 9 numeros");
			e.consume();
		}
			
		if(vcontact.isVisible()&&vcontact.getNumber().getText().length() == 9) {
			JOptionPane.showMessageDialog(null, "Ingrese 9 numeros");
			e.consume();
		}
		
		if(modifyView.isVisible()&&modifyView.getNumber().getText().length()==9) {
			JOptionPane.showMessageDialog(null, "Ingrese 9 numeros");
			e.consume();
		}
			
		if (!Character.isDigit(validar)) {
			e.consume();
		}

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
