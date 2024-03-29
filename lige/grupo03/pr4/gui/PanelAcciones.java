package lige.grupo03.pr4.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import lige.grupo03.pr4.Directions;

/**
 * Clase que representa el panel donde se ubican las acciones del jugador
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class PanelAcciones extends JPanel{

	private static final long serialVersionUID = 1L;
	private PanelInformacionJugador panel;
	private JComboBox<Directions> cbxDireccion;
	private JTextField txtId;
	
	/**
	 * Constructor con 1 parametro
	 * 
	 * @param panel Representa el panel con la informacion del jugador
	 */
	public PanelAcciones(PanelInformacionJugador panel){	
		super();
		this.panel = panel;
		inicializar();
	}
	
	private void inicializar(){
		Border border = BorderFactory.createTitledBorder("Acciones");
		this.setBorder(border);
		
		this.setLayout(new GridLayout(3,2,2,2));
		JButton btnIr, btnCoger, btnUsar;

		
		btnIr = new JButton("IR");
		btnCoger = new JButton("COGER");
		btnUsar = new JButton("USAR");
		
		btnIr.setToolTipText("Presione para ir a la direccion indicada");
		btnCoger.setToolTipText("Presione para Coger el objeto indicado");
		btnUsar.setToolTipText("Presione para usar el objeto seleccionado");
		
		Directions[] direcciones = Directions.values();
		
		cbxDireccion = new JComboBox<Directions>(direcciones);
		txtId = new JTextField();
		
		cbxDireccion.setToolTipText("Seleccion la direccion adonde quiere ir");
		txtId.setToolTipText("Escriba el id a coger");
		
		this.add(btnIr);
		this.add(cbxDireccion);
		this.add(btnCoger);
		this.add(txtId);
		this.add(btnUsar);
		
		OyenteBotonAccion btnAccionListener = new OyenteBotonAccion(panel);
		
		btnCoger.addActionListener(btnAccionListener);
		btnIr.addActionListener(btnAccionListener);
		btnUsar.addActionListener(btnAccionListener);		
		
	}
	
	private String getSelectedItem(){
		return (cbxDireccion.getSelectedItem()).toString();
	}
	
	public String getText(){
		return txtId.getText();
	}
	
	class OyenteBotonAccion implements ActionListener{

		
		private PanelInformacionJugador panel;
		public OyenteBotonAccion(PanelInformacionJugador panel){
			this.panel = panel;
		}
		
		/**
		 * Metodo sobrecargado que de la accion que realizael boton
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String nombreBoton = (String)e.getActionCommand();
			String direccion = getSelectedItem();
			String id = getText();
			
			if(nombreBoton.equals("COGER")){
				if(!id.equals(""))
					JOptionPane.showMessageDialog(new JFrame(), "COGER " + id );
				
				else
					JOptionPane.showMessageDialog(new JFrame(), "Por favor ingresa el id del objeto" );
			}
			
			if(nombreBoton.equals("IR"))
				JOptionPane.showMessageDialog(new JFrame(), "Has seleccionado el comando IR " + direccion );
			
			if(nombreBoton.equals("USAR")){
				try {
					String data = panel.getSelectedITem();
					JOptionPane.showMessageDialog(new JFrame(), "USAR " + data );
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(new JFrame(), "Selecciona un Objeto de tu inventario" );
				}
				
			}
		}

	}

}
