package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
/**
 * Clase encargada de la vista para buscar personas
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class SearchView extends JFrame {
    /**
     * Atributo que da un UID al JFrame
     */
	private static final long serialVersionUID = 1L;
    /**
     * Atributo que permite añadir JButton al JFrame
     */
	private JButton backBtn;
    /**
     * Atributo que permite añadir JButton al JFrame
     */
	private JButton searchBtn;
    /**
     * Atributo que permite añadir JTextArea al JFrame
     */
	private JTextArea infoArea;
    /**
     * Atributo que permite añadir JTextField al JFrame
     */
	private JTextField nameSearch;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel titleLbl;
    /**
     * Atributo que permite añadir JLabel al JFrame
     */
	private JLabel searchLbl;
    /**
     * Método constructor que inicializa el atributo de lectura por consola
     */
	public SearchView() {

		setTitle("Buscar Contacto");
		setSize(400, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#F1F7ED"));
		setLayout(null);
		setDefaultCloseOperation(0);

		initializeComponents();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);

	}
    /**
     * Método que permite inicializar los compnentes del JFrame
     */
	private void initializeComponents() {

		backBtn = new JButton("Volver");
		backBtn.setBounds(133, 590, 115, 35);
		backBtn.setBackground(Color.decode("#91C7B1"));
		backBtn.setToolTipText("Volver al inicio");
		backBtn.setActionCommand("VOLVER");
		this.add(backBtn);

		searchBtn = new JButton("Buscar");
		searchBtn.setBounds(270, 140, 100, 30);
		searchBtn.setBackground(Color.decode("#91C7B1"));
		searchBtn.setToolTipText("Buscar una persona en la agenda");
		searchBtn.setActionCommand("BUSCAR");
		this.add(searchBtn);

		infoArea = new JTextArea();
		infoArea.setEditable(false);
		infoArea.setBackground(Color.decode("#91C7B1"));
		infoArea.setBounds(50, 200, 300, 300);
		infoArea.setFont(new Font("Tahoma", Font.ITALIC, 14));
		this.add(infoArea);

		nameSearch = new JTextField();
		nameSearch.setBackground(Color.decode("#91C7B1"));
		nameSearch.setBounds(50, 140, 200, 30);
		nameSearch.setToolTipText("Ingrese un nombre a buscar");
		nameSearch.setFont(new Font("Tahoma", Font.ITALIC, 15));
		this.add(nameSearch);

		titleLbl = new JLabel("Buscar contacto");
		titleLbl.setForeground(Color.decode("#1D1E18"));
		titleLbl.setBounds(85, 5, 300, 80);
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(titleLbl);
		
		
		ImageIcon searchImg = new ImageIcon("icons\\buscaruwu.png");
		searchLbl = new JLabel ();
		searchLbl.setBounds(5, 140, 100, 30);
		searchLbl.setIcon(new ImageIcon(searchImg.getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH)));
		this.add(searchLbl);

	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(JButton backBtn) {
		this.backBtn = backBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}

	public JTextArea getInfoArea() {
		return infoArea;
	}

	public void setInfoArea(JTextArea infoArea) {
		this.infoArea = infoArea;
	}

	public JTextField getNameSearch() {
		return nameSearch;
	}

	public void setNameSearch(JTextField nameSearch) {
		this.nameSearch = nameSearch;
	}

	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
