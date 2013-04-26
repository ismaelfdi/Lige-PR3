/**
 * 
 */
package lige.grupo03.pr4.logica.commands;

import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.logica.Room;

/**
 * Clase que representa un Comando EXAMINAR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoExaminar extends Comando{
	
	/*Atributo que contiene el juego en ejecuci�n*/
	private Room habitacionActual;

	/**
	 * Constructor parametrizado del Comando EXAMINAR
	 * 
	 * @param juego Representa el juego que esta en ejecuci�n
	 */
	public ComandoExaminar(Room habitacionActual){
		super(VerbCommands.EXAMINAR);
		this.habitacionActual = habitacionActual;
	}

	/**
	 * Procedimiento especifico del Comando EXAMINAR
	 * 
	 */
	@Override
	public boolean ejecutar() {
		habitacionActual.toString();
		return false;
	}


}
