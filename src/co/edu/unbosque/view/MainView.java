package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;
/**
 * Clase encargada de la vista principal
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class MainView extends JFrame {
    /**
     * Atributo que da un UID al JFrame
     */
	private static final long serialVersionUID = 1L;
    /**
     * Atributo que permite añadir un boton al JFrame
     */
	private JButton addBtn;
    /**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton deleteBtn;
    /**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton searchBtn;
    /**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton modifyBtn;
    /**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton exitBtn;    
	/**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton browseBtn;
    /**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton estatsBtn;
    /**
     *  Atributo que permite añadir un boton al JFrame
     */
	private JButton allBtn;
    /**
     * Atributo que añade un JTextArea en JFrame
     */
	private JTextArea propArea;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel titleLbl;
    /**
     * Atributo que permite añadir JScrollPane al JTextArea
     */
	private JScrollPane scroll;
    /**
      *Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel diaryLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel archiveLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel addLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel deleteLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel searchLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel modifyLbl;
    /**
     * Atributo que permite añadir un JLabel al JFrame
     */
	private JLabel leaveLbl;
	

	
    /**
     * Metodo constructor de la clase
     */
	public MainView() {

		setTitle("Agenda de Rosita 2.0");
		setSize(400, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.decode("#F1F7ED")); // #c98859
		setLayout(null);
		setDefaultCloseOperation(0);

		initializeComponents();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
    /**
     * Método que permite inicializar los compnentes del JFrame de la vista principal
     */
	public void initializeComponents() {
		
		allBtn =new JButton("Todos");
		allBtn.setBounds(90, 90, 80, 20);
		allBtn.setBackground(Color.decode("#91C7B1"));
		allBtn.setToolTipText("Mostrar todo");
		allBtn.setActionCommand("ALL");
		allBtn.setEnabled(false);
		this.add(allBtn);
		
		estatsBtn =new JButton("%");
		estatsBtn.setBounds(45, 90, 40, 20);
		estatsBtn.setBackground(Color.decode("#91C7B1"));
		estatsBtn.setToolTipText("Mostrar estadisticas");
		estatsBtn.setActionCommand("ESTATS");
		estatsBtn.setEnabled(false);
		this.add(estatsBtn);
		
		addBtn = new JButton("Agregar");
		addBtn.setBounds(50, 500, 100, 30);
		addBtn.setBackground(Color.decode("#91C7B1"));
		addBtn.setToolTipText("Agregar una nueva persona");
		addBtn.setActionCommand("AGREGARVIEW");
		addBtn.setEnabled(false);
		this.add(addBtn);

		browseBtn = new JButton("Examinar");
		browseBtn.setBounds(245, 90, 100, 20);
		browseBtn.setBackground(Color.decode("#91C7B1"));
		browseBtn.setToolTipText("Buscar un archivo");
		browseBtn.setActionCommand("EXAMINAR");
		this.add(browseBtn);

		deleteBtn = new JButton("Eliminar");
		deleteBtn.setBounds(240, 500, 100, 30);
		deleteBtn.setBackground(Color.decode("#91C7B1"));
		deleteBtn.setToolTipText("Eliminar un persona ");
		deleteBtn.setActionCommand("ELIMINAR");
		deleteBtn.setEnabled(false);
		this.add(deleteBtn);

		searchBtn = new JButton("Buscar");
		searchBtn.setBounds(50, 560, 100, 30);
		searchBtn.setBackground(Color.decode("#91C7B1"));
		searchBtn.setToolTipText("Buscar una persona");
		searchBtn.setActionCommand("BUSCARVIEW");
		searchBtn.setEnabled(false);
		this.add(searchBtn);

		modifyBtn = new JButton("Modificar");
		modifyBtn.setBounds(240, 560, 100, 30);
		modifyBtn.setBackground(Color.decode("#91C7B1"));
		modifyBtn.setToolTipText("Modificar una persona");
		modifyBtn.setActionCommand("MODIFICARVIEW");
		modifyBtn.setEnabled(false);
		this.add(modifyBtn);

		exitBtn = new JButton("Salir");
		exitBtn.setBounds(145, 610, 100, 30);
		exitBtn.setActionCommand("EXIT");
		exitBtn.setBackground(Color.decode("#91C7B1"));
		exitBtn.setToolTipText("Cerrar el programa");
		this.add(exitBtn);

		scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		propArea = new JTextArea();
		propArea.setBounds(45, 120, 300, 350);
		propArea.setFont(new Font("Tahoma", Font.ITALIC, 13));
		propArea.setBackground(Color.decode("#91C7B1"));
		propArea.setEditable(false);
		this.add(propArea);
		
		scroll.setBounds(45, 120, 300, 350);
		scroll.getViewport().setBackground(Color.decode("#91C7B1"));
		scroll.getViewport().add(propArea);
		this.add(scroll);

		titleLbl = new JLabel("Agenda de Rosita 2.0");
		titleLbl.setForeground(Color.decode("#090809"));
		titleLbl.setBounds(60, 5, 300, 80);
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 28));
		this.add(titleLbl);
		
		ImageIcon diaryImg = new ImageIcon("icons\\Agenda.png");
		diaryLbl = new JLabel ();
		diaryLbl.setBounds(5, 30, 100, 35);
		diaryLbl.setIcon(new ImageIcon(diaryImg.getImage().getScaledInstance(40, 30, Image.SCALE_SMOOTH)));
		this.add(diaryLbl);
		
		
		ImageIcon archiveImg = new ImageIcon("icons\\Archivo.png");
		archiveLbl = new JLabel ();
		archiveLbl.setBounds(205, 88, 100, 25);
		archiveLbl.setIcon(new ImageIcon(archiveImg.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		this.add(archiveLbl);
		
		
		ImageIcon addImg = new ImageIcon("icons\\Agregar.png");
		addLbl = new JLabel ();
		addLbl.setBounds(10, 500, 100, 30);
		addLbl.setIcon(new ImageIcon(addImg.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		this.add(addLbl);
		
		
		ImageIcon deleteImg = new ImageIcon("icons\\Eliminar.png");
		deleteLbl = new JLabel ();
		deleteLbl.setBounds(205, 500, 100, 30);
		deleteLbl.setIcon(new ImageIcon(deleteImg.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		this.add(deleteLbl);

		
		ImageIcon searchImg = new ImageIcon("icons\\Buscar.png");
		searchLbl = new JLabel ();
		searchLbl.setBounds(10, 560, 100, 30);
		searchLbl.setIcon(new ImageIcon(searchImg.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		this.add(searchLbl);
		
		
		ImageIcon modifyImg = new ImageIcon("icons\\Modificar.png");
		modifyLbl = new JLabel ();
		modifyLbl.setBounds(205, 560, 100, 30);
		modifyLbl.setIcon(new ImageIcon(modifyImg.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		this.add(modifyLbl);
		
		
		ImageIcon leaveImg = new ImageIcon("icons\\Salir.png");
		leaveLbl = new JLabel ();
		leaveLbl.setBounds(110, 610, 100, 30);
		leaveLbl.setIcon(new ImageIcon(leaveImg.getImage().getScaledInstance(30, 25, Image.SCALE_SMOOTH)));
		this.add(leaveLbl);
		
	}
	public void setButtonsEnable(boolean bool){
		this.getAllBtn().setEnabled(bool);
		this.getEstatsBtn().setEnabled(bool);
		this.getAddBtn().setEnabled(bool);
		this.getDeleteBtn().setEnabled(bool);
		this.getSearchBtn().setEnabled(bool);
		this.getModifyBtn().setEnabled(bool);
	}
	

	public JButton getAllBtn() {
		return allBtn;
	}

	public void setAllBtn(JButton allBtn) {
		this.allBtn = allBtn;
	}

	public JButton getEstatsBtn() {
		return estatsBtn;
	}
 
	public void setEstatsBtn(JButton estatsBtn) {
		this.estatsBtn = estatsBtn;
	}

	public JLabel getDiaryLbl() {
		return diaryLbl;
	}
  
	public void setDiaryLbl(JLabel diaryLbl) {
		this.diaryLbl = diaryLbl;
	}

	public JLabel getArchiveLbl() {
		return archiveLbl;
	}

	public void setArchiveLbl(JLabel archiveLbl) {
		this.archiveLbl = archiveLbl;
	}
 

	public JLabel getAddLbl() {
		return addLbl;
	}

	public void setAddLbl(JLabel addLbl) {
		this.addLbl = addLbl;
	}

	public JLabel getDeleteLbl() {
		return deleteLbl;
	}

	public void setDeleteLbl(JLabel deleteLbl) {
		this.deleteLbl = deleteLbl;
	}

	public JLabel getSearchLbl() {
		return searchLbl;
	}

	public void setSearchLbl(JLabel searchLbl) {
		this.searchLbl = searchLbl;
	}

	public JLabel getModifyLbl() {
		return modifyLbl;
	}

	public void setModifyLbl(JLabel modifyLbl) {
		this.modifyLbl = modifyLbl;
	}

	public JLabel getLeaveLbl() {
		return leaveLbl;
	}

	public void setLeaveLbl(JLabel leaveLbl) {
		this.leaveLbl = leaveLbl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public JButton getAddBtn() {
		return addBtn;
	}
 
	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}
 
	public JButton getDeleteBtn() {
		return deleteBtn;
	}
 
	public void setDeleteBtn(JButton deleteBtn) {
		this.deleteBtn = deleteBtn;
	}

	public JButton getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(JButton searchBtn) {
		this.searchBtn = searchBtn;
	}

	public JButton getModifyBtn() {
		return modifyBtn;
	}
 

	public void setModifyBtn(JButton modifyBtn) {
		this.modifyBtn = modifyBtn;
	}

	public JTextArea getPropArea() {
		return propArea;
	}

	public void setPropArea(JTextArea propArea) {
		this.propArea = propArea;
	}

	public JLabel getTitleLbl() {
		return titleLbl;
	}

	public void setTitleLbl(JLabel titleLbl) {
		this.titleLbl = titleLbl;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
   
	public JButton getExitBtn() {
		return exitBtn;
	}

	public void setExitBtn(JButton exitBtn) {
		this.exitBtn = exitBtn;
	}

	public JButton getBrowseBtn() {
		return browseBtn;
	}

	public void setBrowseBtn(JButton browseBtn) {
		this.browseBtn = browseBtn;
	}


}
