package co.edu.unbosque.view;


import javax.swing.JOptionPane;
/**
 * Clase encargada de la vista sobre los paneles de opciones
 * @author Juan Pedraza
 * @author Junior Valle
 * @author Mario Carmona
 * @version 2.0
 */
public class OptionPaneView {
    /**
     * Método para mostrar un pane para saber que persona desea agregar
     * @param vfriend Vista para identificar cual JFrame cerrar
     * @param vcontact Vista para identificar cual JFrame cerrar
     * @param mainView Vista para identificar cual JFrame cerrar
     */
	public void addPersonPane(AddViewFriend vfriend,AddViewContact vcontact,MainView mainView) {
		String botones[] = { "Amigo", "Contacto", "Cancelar" };
		int ventana = JOptionPane.showOptionDialog(null, "¿Qué deseas agregar?", "Agregar persona",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);

		switch (ventana) {
		case 0:
			mainView.setVisible(false);
			vfriend.setVisible(true);
			break;
		case 1:
			mainView.setVisible(false);
			vcontact.setVisible(true);
			break;
		}
	}
	
    /**
     * Método para mostrar un pane para saber que persona desea agregar
     * @param mensaje Mensaje de tipo String con el cual al llamar salo unJOptionPane.showMessageDialog()
     */
	public void showMessage(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
    /**
     * Método para mostrar un pane para saber que persona desea agregar
     * @param mensaje Mensaje de tipo String con el cual al llamar salo un JOptionPane.showInputDialog()
     * @return String con lo  leido del JOptionPane.showInputDialog()
     */
	public String StringPane(String mensaje) {
		String inputString =null;
		try {
			inputString	=JOptionPane.showInputDialog(mensaje).toLowerCase();
		}catch(NullPointerException ex) {
			
			return inputString;
		}
		return inputString;
	}
}
