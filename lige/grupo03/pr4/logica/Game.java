package lige.grupo03.pr4.logica;

import lige.grupo03.pr4.Directions;
import lige.grupo03.pr4.VerbCommands;
import lige.grupo03.pr4.entradaSalida.UIConsola;
import lige.grupo03.pr4.jugador.Player;
import lige.grupo03.pr4.logica.commands.Comando;
import lige.grupo03.pr4.logica.commands.Command;
import lige.grupo03.pr4.logica.items.Item;

/**
Clase que representa el juego 
@author Ignacio Lopez
@version 1.0 
*/
public class Game {
	/*Atributo que almacena las puertas*/
	private Map puertas;
	/*Atributo que representa la habitacion actual*/
	private Room habitacionActual;
	private Player jugador;
	/**
	Constructor por defecto
	*/
	public Game(){
		puertas = new Map();
		habitacionActual = new Room();
		jugador = new Player();
	}
	
	/**
	Constructor con dos parametros
	@param puertas contiene el vector de puertas
	@param habitacionActual contiene la habitación actual
	*/
	public Game(Map puertas, Room habitacionActual){
		this.puertas = puertas;
		this.habitacionActual = habitacionActual;
		this.jugador = new Player();
	}

	/**
	 * Muestra el inventario de la habitacion actual
	 * @return 
	 * 
	 */
	public boolean mostrarInventarioHabitacion(){
		UIConsola.printText(habitacionActual.toString());
		return true;
	}

	/**
	 * Utiliza el objeto con identificador id del inventario del jugador
	 * 
	 * @param id String que representa el identificador del Objeto a usar
	 */
	public void usarObjeto(String id){
		if(jugador.tieneEnInventario(id)){
			Item item = jugador.obtenerObjeto(id);
			
			if(item.use(jugador, habitacionActual)){
				UIConsola.printText("Algo ha cambiado...");
				if(!item.canBeUsed()){
					jugador.borrarItem(id);
					UIConsola.printText("\n" + item.getId() + " ha sido borrado de tu inventario.\n");
					UIConsola.printText(jugador.mostrarVida());
				}
			}
			else
				UIConsola.printText("Como no fuiste a clase de LIGe la semana pasada no " +
									"sabes cómo usar los objetos de forma adecuada...");
			
		}else
			UIConsola.showError("Alguien robo tu " + id + ".");
	}
	
	/**
	 * Metodo que realiza la funcion de coger un id de la habitacion
	 * @param id String que representa el identificador del Item a coger
	 * @return 
	 */
	public boolean cogerId(String id){
		if(habitacionActual.estaObjeto(id)){
			if(!jugador.tieneEnInventario(id)){
				Item item = habitacionActual.cogerObjeto(id);
				jugador.agregaObjeto(item);
				return true;
			}else{
				UIConsola.showError("Ya tienes otro " + id + " en tu inventario.");
				return false;
			}
		}else{
			UIConsola.showError("El objeto " + id + " no está en esta habitación.");
			return false;
		}		
	}
	
	/**
	 * Procedimiento especifico cuando se sale del juego
	 * 
	 */
	public void salir() {
		UIConsola.printText("GAME OVER!!\nGracias por jugar.\n");
		UIConsola.printText( jugador.mostrarVida());	
	}
	

	/**
	 * Procedimiento especifico cuando se escribe el comando soltar
	 * @param id String con el identificador del objeto a soltar
	 */
	public void soltarId(String id) {
		
		if(jugador.tieneEnInventario(id)){
			if(!habitacionActual.estaObjeto(id)){
				Item item = jugador.obtenerObjeto(id);
				jugador.borrarItem(id);
				habitacionActual.agregarItem(item);
				
			}else
				UIConsola.showError("El objeto " + id + " ya existe en esta habitacion.");	
		}else
			UIConsola.showError("No tienes " + id + " en tu inventario.");
		
	}
	
	/**
	 * Procedimiento especifico que indica hacia que habitacion IR
	 * 
	 * @param direccion Directions hacia donde ir
	 * @return 
	 */
	public boolean cambiarHabitacion(Directions direccion){

		String mensaje = "...moviéndonos al " + direccion.toString() + "\n";	
		Door puerta = puertas.devolverPuerta(habitacionActual, direccion);

		if((puerta != null) && puerta.isOpenDoor()){
			habitacionActual = puerta.nextRoom(habitacionActual);
			jugador.restarVida();
			mensaje += habitacionActual.toString() + jugador.toString();
			UIConsola.printText(mensaje);
			return true;
		}else if((puerta != null) && !puerta.isOpenDoor()){
			UIConsola.showError("Hay una puerta en dirección " + direccion.toString() + ", pero está cerrada.");
			return false;
		}else{
			UIConsola.showError("El camino está cortado en dirección " + direccion.toString() + ".");
			return false;
		}
		
	}


	
	/**
	* Metodo que da comienzo al juego
	*/
	public void comenzarJuego(){
		
		Command comando = new Comando();
		String entrada;
		
		UIConsola.printText(habitacionActual.toString());
		UIConsola.printText(jugador.toString());
		while(!(comando.getVerbo().equals(VerbCommands.SALIR) || habitacionActual.getSalida() || !jugador.tieneNivelVida())){	
			entrada = UIConsola.askComand();
			comando = Parser.parsear(this, entrada, habitacionActual, jugador);
			comando.ejecutar();
		}
				
		if(habitacionActual.getSalida())
			UIConsola.printText("\nHa ganado!!!");
	}



}