package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
/**
 * Clase encargada de la vista de agregar contacto
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class AddViewContact extends JFrame{


    /**
     * Atributo que da un UID al JFrame
     */
	private static final long serialVersionUID = 1L;
    /**
     * Atributo que contiene las opciones para el JComboBox
     */
	String[] box = { "Colombia", "Perú", "Chile", "España", "España", "Mexico" };
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel titleLbl;
    /**
     * Atributo que permite añadir un boton al JFrame
     */
	private JButton cancelarContactBtn;
    /**
     * Atributo que permite añadir un boton al JFrame
     */
	private JButton addContactdBtn;
	
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel nameLbl;
    /**
     * Atributo que permite añadir un JTextField al JFrame
     */
	private JTextField nameContact;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel numberLbl;
    /**
     * Atributo que permite añadir un JTextField al JFrame
     */
	private JTextField number;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel mailLbl;
    /**
     * Atributo que permite añadir un JTextField al JFrame
     */
	private JTextField Mail;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel countryLbl;
    /**
     * Atributo que permite añadir un JComboBos con las opciones de los paises al JFrame
     */
	private JComboBox<String> country;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel businessLbl;
    /**
     * Atributo que permite añadir un JTextField al JFrame
     */
	private JTextField business;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel nameImgLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel phoneImgLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel mailImgLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel countryImgLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel businessImgLbl;

    /**
     * Metodo constructor de la clase
     */
	public AddViewContact () {
		
		setTitle("Agregar Contacto");
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
     * Metodo que permite inicializar lo componentes del JFrame
     */
	private void iniciarComponentes() {
		
		titleLbl = new JLabel("Agregar Contacto");
		titleLbl.setForeground(Color.decode("#1D1E18"));
		titleLbl.setBounds(120, 10, 400, 40);
		titleLbl.setFont(new Font("Tahoma", Font.BOLD,20));
		this.add(titleLbl);
	
	
		addContactdBtn = new JButton("Agregar");
		addContactdBtn.setBounds(45,600 , 115, 35);
		addContactdBtn.setBackground(Color.decode("#91C7B1"));
		addContactdBtn.setToolTipText("Agregar contacto");
		addContactdBtn.setActionCommand("AGREGAR");
		
		this.add(addContactdBtn);
		
		
		cancelarContactBtn = new JButton("Cancelar");
		cancelarContactBtn.setBounds(230,600 , 115, 35);
		cancelarContactBtn.setBackground(Color.decode("#91C7B1"));
		cancelarContactBtn.setToolTipText("Volver al inicio");
		cancelarContactBtn.setActionCommand("VOLVER");
		this.add(cancelarContactBtn);
		
		
		nameLbl = new JLabel("Nombre: ");
		nameLbl.setForeground(Color.decode("#1D1E18"));
		nameLbl.setBounds(20, 70, 100,30);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(nameLbl);
		
		nameContact = new JTextField();
		nameContact.setBackground(Color.decode("#91C7B1"));
		nameContact.setHorizontalAlignment(SwingConstants.LEFT);
		nameContact.setToolTipText("Nombre de la persona");
		nameContact.setBounds(100, 75, 180, 25);
		this.add(nameContact);
		
		
		numberLbl = new JLabel("Numero: ");
		numberLbl.setForeground(Color.decode("#1D1E18"));
		numberLbl.setBounds(20, 140, 100,30);
		numberLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(numberLbl);
		
		number = new JTextField();
		number.setBackground(Color.decode("#91C7B1"));
		number.setHorizontalAlignment(SwingConstants.LEFT);
		number.setBounds(100, 145, 180, 25);
		number.setToolTipText("Numero de la persona");
		this.add(number);
		
		mailLbl = new JLabel("Correo: ");
		mailLbl.setForeground(Color.decode("#1D1E18"));
		mailLbl.setBounds(20, 220, 100,30);
		mailLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(mailLbl);
	
		Mail = new JTextField();
		Mail.setBackground(Color.decode("#91C7B1"));
		Mail.setHorizontalAlignment(SwingConstants.LEFT);
		Mail.setBounds(100, 225, 180, 25);
		Mail.setToolTipText("Correo de la persona");
		this.add(Mail);
		
		
		countryLbl = new JLabel("Pais: ");
		countryLbl.setForeground(Color.decode("#1D1E18"));
		countryLbl.setBounds(20, 300, 100,30);
		countryLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(countryLbl);
		
		country = new JComboBox<String>(box);
		country.setBackground(Color.decode("#91C7B1"));
		country.setToolTipText("Pais de la persona");
		country.setBounds(100, 305, 180, 25);
		this.add(country);
		
		
		businessLbl = new JLabel("Empresa: ");
		businessLbl.setForeground(Color.decode("#1D1E18"));
		businessLbl.setBounds(20, 380, 100,30);
		businessLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(businessLbl);
		
		business = new JTextField();
		business.setBackground(Color.decode("#91C7B1"));
		business.setHorizontalAlignment(SwingConstants.LEFT);
		business.setBounds(100, 385, 180, 25);
		business.setToolTipText("Empresa de la persona");
		this.add(business);
		
		ImageIcon nameImg = new ImageIcon("icons\\name.png");
		nameImgLbl = new JLabel ();
		nameImgLbl.setBounds(300, 70, 100,30);
		nameImgLbl.setIcon(new ImageIcon(nameImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(nameImgLbl);
		
		
		ImageIcon numberImg = new ImageIcon("icons\\phone.png");
		phoneImgLbl = new JLabel ();
		phoneImgLbl.setBounds(300, 140, 100,30);
		phoneImgLbl.setIcon(new ImageIcon(numberImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(phoneImgLbl);
		
		
		ImageIcon mailImg = new ImageIcon("icons\\Mail.png");
		mailImgLbl = new JLabel ();
		mailImgLbl.setBounds(300, 220, 100,30);
		mailImgLbl.setIcon(new ImageIcon(mailImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(mailImgLbl);
		
		
		ImageIcon countryImg = new ImageIcon("icons\\country.png");
		countryImgLbl = new JLabel ();
		countryImgLbl.setBounds(300, 300, 100,30);
		countryImgLbl.setIcon(new ImageIcon(countryImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(countryImgLbl);
		
		
		ImageIcon businessImg = new ImageIcon("icons\\business.png");
		businessImgLbl = new JLabel ();
		businessImgLbl.setBounds(300, 380, 100,30);
		businessImgLbl.setIcon(new ImageIcon(businessImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(businessImgLbl);
	}

	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}

	public JButton getCancelarContactBtn() {
		return cancelarContactBtn;
	}

	public void setCancelarContactBtn(JButton cancelarContactBtn) {
		this.cancelarContactBtn = cancelarContactBtn;
	}

	public JButton getAddContactdBtn() {
		return addContactdBtn;
	}

	public void setAddContactdBtn(JButton addContactdBtn) {
		this.addContactdBtn = addContactdBtn;
	}

	public JLabel getNameLbl() {
		return nameLbl;
	}

	public void setNameLbl(JLabel nameLbl) {
		this.nameLbl = nameLbl;
	}

	public JTextField getNameContact() {
		return this.nameContact;
	}

	public void setName(JTextField nameContact) {
		this.nameContact = nameContact;
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

	public JLabel getBusinessLbl() {
		return businessLbl;
	}

	public void setBusinessLbl(JLabel businessLbl) {
		this.businessLbl = businessLbl;
	}

	public JTextField getBusiness() {
		return business;
	}

	public void setBusiness(JTextField business) {
		this.business = business;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
