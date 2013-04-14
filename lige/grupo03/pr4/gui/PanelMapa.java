package lige.grupo03.pr4.gui;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelMapa extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public PanelMapa(){
		
		Border border = BorderFactory.createTitledBorder("Mapa");
		this.setBorder(border);
		
		this.setLayout(new GridLayout(11, 11));
	
		
		for(int i = 1; i <= 11; i++){
			for(int j = 1; j <= 11; j++){
				this.add(new JButton());
			}
			
		}
		
		
	}
	

}
