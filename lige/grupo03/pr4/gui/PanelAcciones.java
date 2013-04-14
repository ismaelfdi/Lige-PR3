package lige.grupo03.pr4.gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class PanelAcciones extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelAcciones(){
		
		Border border = BorderFactory.createTitledBorder("Acciones");
		this.setBorder(border);
		
		this.setLayout(new GridLayout(3,2,2,2));
		JButton btnIr, btnCoger, btnUsar;
		JComboBox cbxDireccion;
		JTextField txtId;
		
		btnIr = new JButton("IR");
		btnCoger = new JButton("COGER");
		btnUsar = new JButton("USAR");
		
		String[] direcciones = {"NORTE", "SUR", "ESTE", "OESTE"};
		cbxDireccion = new JComboBox(direcciones);
		
		txtId = new JTextField();
		
		this.add(btnIr);
		this.add(cbxDireccion);
		this.add(btnCoger);
		this.add(txtId);
		this.add(btnUsar);

		
	}

}
