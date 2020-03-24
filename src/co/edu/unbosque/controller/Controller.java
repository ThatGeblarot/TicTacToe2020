package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.IA;
import co.edu.unbosque.model.Mundo;
import co.edu.unbosque.view.View;

/**
 * @author Gabriel Blanco Clase Controlador
 *
 */
public class Controller implements ActionListener {

	private Mundo mundo = new Mundo();
	private View view = new View();

	/**
	 * M�todo Constructor del Controlador
	 * 
	 * @throws IOException
	 */
	public Controller() throws Exception {
		Consola();
		// Estoy subiendo un cambio chimbo
	}

	/**
	 * M�todo para probar casos puntuales en consola
	 * 
	 * @throws IOException
	 */
	public void Consola() throws Exception {
		// Se inicializa gui aqui ya que es necesario para probar por via JOptionPane
		/*
		 * TODO: Buscar un m�todo mas eficiente para mostrar TODOS los errores por
		 * JOptionPane
		 */
		boolean activo = true;
		while (activo) {
			try {
				int comando = Integer.parseInt(view.getDialogos().input(System.in, "TicTacToe 2020:Debugger",
						view.getDialogos().ayuda(), JOptionPane.PLAIN_MESSAGE));
				switch (comando) {
				default:
					view.getDialogos().output("Error", "Bad command!", JOptionPane.ERROR_MESSAGE);
					break;
				case 0:
					activo = false;
					break;
				case 1:
					activo = false;
					GUI();
					break;
				}
			} catch (Exception e) {
				StringWriter errors = new StringWriter();
				e.printStackTrace(new PrintWriter(errors));
				mundo.getArchivo().makeLog(errors.toString());
				view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
						+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle espec�fico del error causado.",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * M�todo para iniciar la GUI
	 */
	public void GUI() throws Exception {
		try {
			view.iniciar(this);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			mundo.getArchivo().makeLog(errors.toString());
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle espec�fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/*
	 * TODO: Poner los m�todos a probar aqui
	 */
	public void IA(int holi) {
		IA ia = new IA();
		int jugada=0;		
		int p1=0,p2=0,p3=0,p4=0;
	  //  p1=1;p2=3;p3=8;p4=0;   Este un ejemplo de tres jugadas con las posiciones 1,3,8
	    // El panel debe enviar los valores p1,p2,p3,p4
		ia.defender(jugada,p1,p2,p3,p4);
	}

	/**
	 * @author Luis Ricardo Sanchez
	 * @param ActionEvent e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			// TODO: Ingresar aqu� las interacciones con Mundo

			if (e.getActionCommand() == view.getPanelJuego().getPanelBoton().OPERAR) {
				validarCondicionesCorrectas();
				
			}
		}

		/*
		 * Estas l�neas son para controlar en caso de que por falta de memoria no genere
		 * el log. Esto es vital para el programa ya que me permite llevar una trazabilidad
		 */
		catch (Exception e2) {
			StringWriter errors = new StringWriter();
			e2.printStackTrace(new PrintWriter(errors));
			try {
				mundo.getArchivo().makeLog(errors.toString());
			} catch (IOException e1) {
				view.getDialogos().output("Error Fatal",
						"Ha ocurrido un error inesperado donde se debe salir del programa.\nMotivo: Error creando el log de archivos",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			view.getDialogos().output("Error", "Ha ocurrido un error inesperado\n"
					+ "Se ha creado en <proyecto>/docs/Output un archivo myLog.txt en donde aparece el detalle espec�fico del error causado.",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public void validarletraingresada() {
		if (!view.getPanelJuego().getPanelTablero().getPos11().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos11().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos11().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos12().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos12().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos12().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos13().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos13().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos13().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);

		}

		else if (!view.getPanelJuego().getPanelTablero().getPos21().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos21().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos21().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos22().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos22().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos22().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos23().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos23().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos23().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos31().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos31().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos31().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos32().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos32().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos32().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}

		else if (!view.getPanelJuego().getPanelTablero().getPos33().getText().equals("x")
				&& !view.getPanelJuego().getPanelTablero().getPos33().getText().equals("X")) {
			view.getPanelJuego().getPanelTablero().getPos33().setText("");
			view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void validarCondicionesCorrectas() {
//		validarletraingresada();
		if (view.getPanelJuego().getPanelTablero().getPos11().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos11().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				//Se pone la condicion
//				view.getPanelJuego().getPanelTablero().getPos11().setEditable(false);
//				view.getDialogos().output("Prueba", mundo.getIa().defender(1), JOptionPane.INFORMATION_MESSAGE);
//				 if(mundo.getTictactoe().isTurno()==false) {
//					    mundo.getTictactoe().turnos();
//					    
//	                 } else if(mundo.getTictactoe().isTurno()==true) {
//	                	 view.getDialogos().output("Prueba", mundo.getIa().defender(1), JOptionPane.INFORMATION_MESSAGE);
//	                 }

			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos11().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos12().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos12().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
//	         if(mundo.getTictactoe().isTurno()==false) {
//				    mundo.getTictactoe().turnos();
//				    
//                 } else if(mundo.getTictactoe().isTurno()==true) {
//                	 mundo.getIa().defender(1);
//                 }
//			} else {
//				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
//				view.getPanelJuego().getPanelTablero().getPos12().setText("");
//			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos13().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos13().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
				 

			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos13().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos21().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos21().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
				
			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos21().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos22().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos22().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
				
			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos22().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos23().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos23().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
				
			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos23().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos31().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos31().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
				
			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos31().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos32().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos32().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos33().getText().equals("")) {
				// Se pone la condicion
				
			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos32().setText("");
			}
		}
		if (view.getPanelJuego().getPanelTablero().getPos33().getText().equalsIgnoreCase("x")) {
			view.getPanelJuego().getPanelTablero().getPos33().setText("X");
			if (view.getPanelJuego().getPanelTablero().getPos11().getText().equals("") && 
					view.getPanelJuego().getPanelTablero().getPos12().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos13().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos21().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos22().getText().equals("") &&
					view.getPanelJuego().getPanelTablero().getPos23().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos31().getText().equals("")&&
					view.getPanelJuego().getPanelTablero().getPos32().getText().equals("")) {
				// Se pone la condicion
				
			} else {
				view.getDialogos().output("Error", "Debes colocar una X para jugar conmigo", JOptionPane.ERROR_MESSAGE);
				view.getPanelJuego().getPanelTablero().getPos33().setText("");

			}
		}
	}
  }	
}