/**
 * 
 */
package lige.grupo03.pr4.logica.commands;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.logica.Game;

/**
 * Clase que representa un Comando IR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 2.0
 */
public class ComandoIr extends Comando{
	
	/*Atributo que representa una direccion pasada por consola*/
	private Directions direccion;
	/*Atributo que representa el juego que esta ejecuci�n*/
	private Game juego;

	/**
	 * Constructor parametrizado del Comando IR
	 * @param juego Game que representa el juego que esta en ejecuci�n
	 * @param direccion Directions que representa la direcci�n
	 */
	public ComandoIr(Game juego, Directions direccion){
		super(VerbCommands.IR);
		this.direccion = direccion;
		this.juego = juego;
	}
	
	/**
	 * Indica si un Comando es valido
	 * 
	 * @return Booleano verdero o falso segun sea el caso
	 */
	@Override
	public boolean esValido() {
		return super.esValido() && !(direccion.equals(Directions.DESCONOCIDO));
	}
	
	/**
	 * Procedimiento especifico del Comando IR
	 * 
	 */
	@Override
	public boolean ejecutar() {
		juego.cambiarHabitacion(direccion);
		return false;
	}

}
