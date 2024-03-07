package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * Clase encargada de la vista de modificar
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class ModifyView extends JFrame {
    /**
     * Atributo que da un UID al JFrame
     */
	private static final long serialVersionUID = 1L;
    /**
     * Atributo que contiene las opciones para el JComboBox
     */
	String[] box = { "Colombia", "Perú", "Chile", "España", "Mexico" };
    /**
     * Atributo que permite añadir JLabel al  JFrame
     */
	private JLabel titleLbl;
    /**
     * Atributo que permite añadir JButton al JFrame
     */
	private JButton cancelarModifyBtn;
    /**
     * Atributo que permite añadir JButton al JFrame
     */
	private JButton modifyPersonBtn;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel oldNameLbl;
    /**
     * Atributo que permite añadir JTextField al JFrame
     */
	private JTextField oldNameTxt;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel newDatos;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel nameLbl;
    /**
     * Atributo que permite añadir JTextField al JFrame
     */
	private JTextField namePerson;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel numberLbl;
    /**
     * Atributo que permite añadir JTextFieldn al JFrame
     */
	private JTextField number;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel mailLbl;
    /**
     * Atributo que permite añadir JTextField al JFrame
     */
	private JTextField Mail;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel countryLbl;
    /**
     * Atributo que permite añadir JComboBox al JFrame
     */
	private JComboBox<String> country;
    /**
     * Atributo que permite añadir JLabel al JFrame para subir icono
     */
	private JLabel nameImgLbl;
    /**
     * Atributo que permite añadir JLabel al JFrame parasubir icon
     */
	private JLabel phoneImgLbl;
    /**
     * Atributo que permite añadir JLabel al JFrame para subir icono
     */
	private JLabel mailImgLbl;
    /**
     * Atributo que permite añadir JLabel al JFrame para subir icono
     */
	private JLabel countryImgLbl;

    /**
     * Metodo contructor del la vista modificar
     */
	public ModifyView() {

		setTitle("Editar Persona");
		setSize(400, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#F1F7ED"));
		setLayout(null);
		setDefaultCloseOperation(0);

		iniciarComponentes();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
	}
    /**
     * Metoodo que permite iniciar componentes
     */
	private void iniciarComponentes() {

		titleLbl = new JLabel("Editar Persona");
		titleLbl.setForeground(Color.decode("#1D1E18"));
		titleLbl.setBounds(120, 10, 400, 40);
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.add(titleLbl);

		modifyPersonBtn = new JButton("Editar");
		modifyPersonBtn.setBounds(45, 600, 115, 35);
		modifyPersonBtn.setBackground(Color.decode("#91C7B1"));
		modifyPersonBtn.setToolTipText("Agregar contacto");
		modifyPersonBtn.setActionCommand("MODIFICAR");

		this.add(modifyPersonBtn);

		cancelarModifyBtn = new JButton("Cancelar");
		cancelarModifyBtn.setBounds(230, 600, 115, 35);
		cancelarModifyBtn.setBackground(Color.decode("#91C7B1"));
		cancelarModifyBtn.setToolTipText("Volver al inicio");
		cancelarModifyBtn.setActionCommand("VOLVER");
		this.add(cancelarModifyBtn);

		newDatos = new JLabel("Nuevos Datos");
		newDatos.setForeground(Color.decode("#1D1E18"));
		newDatos.setBounds(120, 130, 250, 30);
		newDatos.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(newDatos);

		oldNameLbl = new JLabel("Nombre: ");
		oldNameLbl.setForeground(Color.decode("#1D1E18"));
		oldNameLbl.setBounds(20, 80, 300, 30);
		oldNameLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(oldNameLbl);

		oldNameTxt = new JTextField();
		oldNameTxt.setBackground(Color.decode("#91C7B1"));
		oldNameTxt.setHorizontalAlignment(SwingConstants.LEFT);
		oldNameTxt.setToolTipText("Nombre de la persona");
		oldNameTxt.setBounds(100, 85, 180, 25);
		oldNameTxt.setEditable(false);
		this.add(oldNameTxt);

		nameLbl = new JLabel("Nombre: ");
		nameLbl.setForeground(Color.decode("#1D1E18"));
		nameLbl.setBounds(20, 180, 100, 30);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(nameLbl);

		namePerson = new JTextField();
		namePerson.setBackground(Color.decode("#91C7B1"));
		namePerson.setHorizontalAlignment(SwingConstants.LEFT);
		namePerson.setToolTipText("Nombre de la persona");
		namePerson.setBounds(100, 185, 180, 25);
		this.add(namePerson);

		numberLbl = new JLabel("Numero: ");
		numberLbl.setForeground(Color.decode("#1D1E18"));
		numberLbl.setBounds(20, 250, 100, 30);
		numberLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(numberLbl);

		number = new JTextField();
		number.setBackground(Color.decode("#91C7B1"));
		number.setHorizontalAlignment(SwingConstants.LEFT);
		number.setBounds(100, 255, 180, 25);
		number.setToolTipText("Numero de la persona");
		this.add(number);

		mailLbl = new JLabel("Correo: ");
		mailLbl.setForeground(Color.decode("#1D1E18"));
		mailLbl.setBounds(20, 320, 100, 30);
		mailLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(mailLbl);

		Mail = new JTextField();
		Mail.setBackground(Color.decode("#91C7B1"));
		Mail.setHorizontalAlignment(SwingConstants.LEFT);
		Mail.setBounds(100, 325, 180, 25);
		Mail.setToolTipText("Correo de la persona");
		this.add(Mail);

		countryLbl = new JLabel("Pais: ");
		countryLbl.setForeground(Color.decode("#1D1E18"));
		countryLbl.setBounds(20, 390, 100, 30);
		countryLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		this.add(countryLbl);

		country = new JComboBox<String>(box);
		country.setBackground(Color.decode("#91C7B1"));
		country.setToolTipText("Pais de la persona");
		country.setBounds(100, 395, 180, 25);
		this.add(country);
		
		ImageIcon nameImg = new ImageIcon("icons\\name.png");
		nameImgLbl = new JLabel();
		nameImgLbl.setBounds(300, 160, 100, 30);
		nameImgLbl.setIcon(new ImageIcon(nameImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(nameImgLbl);

		ImageIcon numberImg = new ImageIcon("icons\\phone.png");
		phoneImgLbl = new JLabel();
		phoneImgLbl.setBounds(300, 230, 100, 30);
		phoneImgLbl.setIcon(new ImageIcon(numberImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(phoneImgLbl);

		ImageIcon mailImg = new ImageIcon("icons\\Mail.png");
		mailImgLbl = new JLabel();
		mailImgLbl.setBounds(300, 310, 100, 30);
		mailImgLbl.setIcon(new ImageIcon(mailImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(mailImgLbl);

		ImageIcon countryImg = new ImageIcon("icons\\country.png");
		countryImgLbl = new JLabel();
		countryImgLbl.setBounds(300, 390, 100, 30);
		countryImgLbl.setIcon(new ImageIcon(countryImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(countryImgLbl);
	}

 
	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}

	public JButton getCancelarModifyBtn() {
		return cancelarModifyBtn;
	}

	public void setCancelarModifyBtn(JButton cancelarModifyBtn) {
		this.cancelarModifyBtn = cancelarModifyBtn;
	}


	public JButton getModifyPersonBtn() {
		return modifyPersonBtn;
	}

	public void setModifyPersonBtn(JButton modifyPersonBtn) {
		this.modifyPersonBtn = modifyPersonBtn;
	}

	public JLabel getNameLbl() {
		return nameLbl;
	}
 
	public void setNameLbl(JLabel nameLbl) {
		this.nameLbl = nameLbl;
	}
   
	public JTextField getNamePerson() {
		return this.namePerson;
	}
  
	public void setName(JTextField namePerson) {
		this.namePerson = namePerson;
	}

	public JLabel getNumberLbl() {
		return numberLbl;
	}

	public void setNumberLbl(JLabel numberLbl) {
		this.numberLbl = numberLbl;
	}
  
	public JTextField getNumber() {
		return number;
	}
  
	public void setNumber(JTextField number) {
		this.number = number;
	}    


	public JLabel getMailLbl() {
		return mailLbl;
	}
  
	public void setMailLbl(JLabel mailLbl) {
		this.mailLbl = mailLbl;
	}
 
	public JTextField getMail() {
		return Mail;
	}
 
	public void setMail(JTextField mail) {
		Mail = mail;
	}

	public JLabel getOldNameLbl() {
		return oldNameLbl;
	}
  
	public void setOldNameLbl(JLabel oldNameLbl) {
		this.oldNameLbl = oldNameLbl;
	}
  
	public JTextField getOldNameTxt() {
		return oldNameTxt;
	}
 
	public void setOldNameTxt(JTextField oldNameTxt) {
		this.oldNameTxt = oldNameTxt;
	}
 
	public JLabel getNewDatos() {
		return newDatos;
	}
 
	public void setNewDatos(JLabel newDatos) {
		this.newDatos = newDatos;
	}
 
	public JLabel getCountryLbl() {
		return countryLbl;
	}
  
	public void setCountryLbl(JLabel countryLbl) {
		this.countryLbl = countryLbl;
	}
  
	public JComboBox<String> getCountry() {
		return country;
	}

	public void setCountry(JComboBox<String> country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}