package lige.grupo03.pr4.logica.commands;

import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.logica.Game;

/**
 * Clase que representa un Comando SOLTAR
 * 
 * @author Ismael Ventura & Ignacio Lopez
 * @version 1.0
 */
public class ComandoSoltar extends Comando{
	
	/*Atributo que representa el id del Item a Soltar*/
	private String id;
	/*Atributo que representa el juego en ejecución*/
	private Game juego;
	
	/**
	 * Constructor parametrizado del Comando SOLTAR
	 * 
	 * @param juego Game que representa el juego en ejecución
	 * @param id String que representa el identificador del Item
	 */
	public ComandoSoltar(Game juego, String id){
		super(VerbCommands.SOLTAR);
		this.id = id;
		this.juego = juego;
	}
	
	/**
	 * Metodo sobrecargado que determina si el Comando es valido
	 * 
	 * @return Booleano verdadero o falso segun sea el caso
	 */
	@Override
	public boolean esValido() {
		return super.esValido() && (!id.equals(""));
	}
	
	/**
	 * Procedimiento especifico del Comando SOLTAR
	 * 
	 */
	@Override
	public boolean ejecutar(){
		juego.soltarId(id);
		return false;
	}

}
