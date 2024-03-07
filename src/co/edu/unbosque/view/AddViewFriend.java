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
 * Clase encargada de la vista de agregar amigo
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */

public class AddViewFriend  extends JFrame {

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
	private JButton cancelarFriendBtn;
    /**
     * Atributo que permite añadir un boton al JFrame
     */
	private JButton addFriendBtn;
	
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel nameLbl;
    /**
     * Atributo que permite añadir un JTexField al JFrame
     */
	private JTextField nameFriend;
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
	private JTextField mail;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel countryLbl;
    /**
     * Atributo que permite añadir un JCombobox con las opciones de paises al JFrame
     */
	private JComboBox<String> country;
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
     * Metodo contructor de la clase
     */
	public AddViewFriend () {
		
		setTitle("Agregar Amigo");
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
		
		titleLbl = new JLabel("Agregar amigo");
		titleLbl.setForeground(Color.decode("#1D1E18"));
		titleLbl.setBounds(120, 10, 400, 40);
		titleLbl.setFont(new Font("Tahoma", Font.BOLD,20));
		this.add(titleLbl);
	
	
		addFriendBtn = new JButton("Agregar");
		addFriendBtn.setBounds(45,600 , 115, 35);
		addFriendBtn.setBackground(Color.decode("#91C7B1"));
		addFriendBtn.setToolTipText("Agregar amigo");
		addFriendBtn.setActionCommand("AGREGAR");
		this.add(addFriendBtn);
		
		
		cancelarFriendBtn = new JButton("Cancelar");
		cancelarFriendBtn.setBounds(230,600 , 115, 35);
		cancelarFriendBtn.setBackground(Color.decode("#91C7B1"));
		cancelarFriendBtn.setToolTipText("Volver al inicio");
		cancelarFriendBtn.setActionCommand("VOLVER");
		this.add(cancelarFriendBtn);
		
		
		nameLbl = new JLabel("Nombre: ");
		nameLbl.setForeground(Color.decode("#1D1E18"));
		nameLbl.setBounds(20, 70, 100,30);
		nameLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(nameLbl);
		
		nameFriend = new JTextField();
		nameFriend.setBackground(Color.decode("#91C7B1"));
		nameFriend.setHorizontalAlignment(SwingConstants.LEFT);
		nameFriend.setToolTipText("Nombre de la persona");
		nameFriend.setBounds(100, 75, 180, 25);
		this.add(nameFriend);
		
		
		numberLbl = new JLabel("Numero: ");
		numberLbl.setForeground(Color.decode("#1D1E18"));
		numberLbl.setBounds(20, 140, 100,30);
		numberLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(numberLbl);
		
		number = new JTextField();
		number.setBackground(Color.decode("#91C7B1"));
		number.setHorizontalAlignment(SwingConstants.LEFT);
		number.setToolTipText("Numero de la persona");
		number.setBounds(100, 145, 180, 25);
		this.add(number);
		
		mailLbl = new JLabel("Correo: ");
		mailLbl.setForeground(Color.decode("#1D1E18"));
		mailLbl.setBounds(20, 220, 100,30);
		mailLbl.setFont(new Font("Tahoma", Font.BOLD,17));
		this.add(mailLbl);
	
		mail = new JTextField();
		mail.setBackground(Color.decode("#91C7B1"));
		mail.setHorizontalAlignment(SwingConstants.LEFT);
		mail.setToolTipText("Correo de la persona");
		mail.setBounds(100, 225, 180, 25);
		this.add(mail);
		
		
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
		
	}

	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}

	public JButton getCancelarFriendBtn() {
		return cancelarFriendBtn;
	}

	public void setCancelarFriendBtn(JButton cancelarFriendBtn) {
		this.cancelarFriendBtn = cancelarFriendBtn;
	}

	public JButton getAddFriendBtn() {
		return addFriendBtn;
	}

	public void setAddFriendBtn(JButton addFriendBtn) {
		this.addFriendBtn = addFriendBtn;
	}

	public JLabel getNameLbl() {
		return nameLbl;
	}

	public void setNameLbl(JLabel nameLbl) {
		this.nameLbl = nameLbl;
	}

	public JTextField getNameFriend() {
		return nameFriend;
	}

	public void setName(JTextField nameFriend) {
		this.nameFriend = nameFriend;
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
		return mail;
	}

	public void setMail(JTextField mail) {
		this.mail = mail;
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


	
}