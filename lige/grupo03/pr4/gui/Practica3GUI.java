package lige.grupo03.pr4.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;

public class Practica3GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Practica3GUI(){
		
		super("Aventura Conversacional GUI");
		
		this.setLayout(new BorderLayout());
		
		PanelAcciones p1 = new PanelAcciones();
		PanelInformacionJugador p2 = new PanelInformacionJugador();
		PanelMapa mapa = new PanelMapa();
		PanelHabitacion habitacion = new PanelHabitacion();
		
		JSplitPane jspControl = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		
		this.add(jspControl,BorderLayout.NORTH);
		this.add(mapa,BorderLayout.CENTER);
		this.add(habitacion,BorderLayout.SOUTH);
		
		JMenuBar bar = new JMenuBar();
		
		this.setJMenuBar(bar);
		
		JMenu menu = new JMenu("Menu");
		bar.add(menu);
		
		this.setSize(400, 400);
		this.setVisible(true);
	}
	
	
	
	
	/*Para pruebas*/
	public static void main(String[] args) {
		Practica3GUI ventana = new Practica3GUI();
	}

}
