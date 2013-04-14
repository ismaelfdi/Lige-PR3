package lige.grupo03.pr4.gui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;

public class PanelHabitacion extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public PanelHabitacion(){
		
		JTextArea informacion;
		
		Border border = BorderFactory.createTitledBorder("Habitación");
		informacion = new JTextArea("freferferf erfer ervferfcev ev ev erv e ver vcrecv ec ve ce ce cev");
		informacion.setEditable(false);

		JScrollPane pane = new JScrollPane(informacion);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		this.add(pane);
		this.setBorder(border);
		
	}

}
