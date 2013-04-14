package lige.grupo03.pr4.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.JTableHeader;

public class PanelInformacionJugador extends JPanel{
	
	private static final long serialVersionUID = 1L;

	public PanelInformacionJugador(){
		
		int vida = 100;
		int puntos = 0;
		JLabel puntuacion;
		JTable tablaObjetos;
		
		Border border = BorderFactory.createTitledBorder("Información del jugador");
		this.setBorder(border);
		String mensaje = "Vida: " + vida + "  Puntuación: " + puntos;
		puntuacion = new JLabel(mensaje, Label.LEFT);
		
		/*Creacion de la Tabla de puntuacion*/
		String cabecera[] = {"Id", "Descripción"};
		Object rowData[][] = {{"Id1", "--item[Id1]=Descripcion1//1"},{"Id1", "--item[Id2]=Descripcion2//2"}};
		
		tablaObjetos = new JTable(rowData, cabecera);
		JTableHeader header = tablaObjetos.getTableHeader();
		
		header.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane pane = new JScrollPane(tablaObjetos);
		
		
		this.setLayout(new BorderLayout());
		
		this.add(puntuacion, BorderLayout.NORTH);
		this.add(tablaObjetos, BorderLayout.CENTER);
		
		
		
	}

}
