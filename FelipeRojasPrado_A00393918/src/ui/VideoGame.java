package ui;
import model.*;
import java.util.Scanner;


public class VideoGame {
    private Scanner reader;
	private GameController controller;

	public VideoGame() {
		reader = new Scanner(System.in); 
		controller = new GameController();

	}

	public static void main(String[] args) {
			VideoGame main = new VideoGame(); 

			int option = -1; 
			do{
				option = main.getOptionShowMenu(); 
				main.executeOption(option);

			}while(option != 0);

		}

	public Scanner getReader() {
		return this.reader;
	}

	public void setReader(Scanner reader) {
		this.reader = reader;
	}

	public int getOptionShowMenu(){
			int option = 0; 
			printMenu();

			option = validateIntegerOption(); 

			return option; 
	}

	public void printMenu(){
			System.out.print(
                "\n<<<<< Welcome to the Game >>>>>\n"+	
                "1. Registro de jugador a un nivel\n"+
                "2. Registro de enemigos a un nivel\n"+
                "3. Registro de tesoros a un nivel\n"+
                "4. Modificar puntaje de un jugador\n"+
                "5. Incrementar nivel de jugaddor\n"+
                "6. Informar tesoros y de enemigos de un nivel\n"+
                "7. Informar cantidad de un tesoro en todo el juego\n"+
                "8. Informar cantidad de enemigos de un tipo en todo el juegol\n"+ 
				"9. Informar el tesoro mas repetido de todos los niveles\n"+
                "10. Informar el enemigo que otorga mayor puntaje y en el nivel que se ubica\n"+
                "11. Informar la cantidad de consonantes en los nombres de los enemigos\n"+
                "12. Informar top 5 jugadores\n"+
				"0. Exit. \n"+
				"Opcion: ");  
	}

		public void executeOption(int option){

				switch(option){
					case 1:
						if(controller.playersAvailability().equals("Limite Jugadores alcanzado")){
							System.out.println(controller.playersAvailability());
							
						}else{
							reader.nextLine();
							System.out.print("Por favor dime un nickName: ");
							String nickName = reader.nextLine();
							if(controller.searchPlayer(nickName) != null){
								
								System.out.println("Error, nickName ya existente");

							}else{
								System.out.print("Ingrese un nombre: ");
								String name = reader.nextLine();
								System.out.println(controller.addPlayer(nickName, name));
							}
						}

                        break;

					case 2:
						if(controller.enemyAvailability().equals("Limite de enemigos alcanzado")){
							System.out.println(controller.enemyAvailability());
						}else{
							reader.nextLine();
							System.out.println("Dime un nombre: ");
							String nameEnemy = reader.nextLine();
							if(controller.searchEnemy(nameEnemy) != null){
								System.out.println("Error, este enemigos ya existe");
							}else{
								System.out.print("Dime de que tipo es este enemigo\n"+
								"\n1. Ogro"+
								"\n2. Abstracto"+
								"\n3. Jefe"+
								"\n4. Magico"+
								"\nOpcion: ");
								int type = reader.nextInt();
								System.out.print("Dime el puntaje que otorgara si es derrotado: ");
								int scorePlus = reader.nextInt();
								System.out.print("Dime el puntaje que quita si golpea al jugador: ");
								int scoreLess = reader.nextInt();
								System.out.print("Dime a que nivel al que deseas agregar este enemigo: ");
								int level = reader.nextInt();
								if(level > 10 || level < 1){
									System.out.println("Nivel no valido");
								}else{
									System.out.println(controller.addEnemy(nameEnemy,scorePlus,scoreLess,type,level));
								}

							}
						}
						break;

					case 3:
						if(controller.treasureAvailability().equals("Limite de tesoros alcanzado")){
							System.out.println(controller.treasureAvailability());
						}else{
							reader.nextLine();
							System.out.print("Dime un nombre para este tesoro: ");
							String nameTreasure = reader.nextLine();
							System.out.print("Dime una Url de imagen para este tesoro: ");
							String UrlImage = reader.nextLine();
							System.out.print("Dime cuantos puntos otorgara este tesoro: ");
							int scorePlusTreasure = reader.nextInt();
							System.out.print("Dime a que nivel deseas agregar este tesoro: ");
							int level = reader.nextInt();
							if(level > 10 || level < 1){
								System.out.println("Nivel no valido");
							}else{
								System.out.print(controller.addTreasure(nameTreasure,UrlImage,scorePlusTreasure,level));
							}
							
						}
						break;

                    case 4:
						if(controller.playersAvailability().equals("No hay jugadores ")){
							System.out.println(controller.playersAvailability());
						
						}else{
							reader.nextLine();
							System.out.print("Dime el nickName del jugador: ");
							String nickName = reader.nextLine();
							if(controller.searchPlayer(nickName) == null){
									
								System.out.println("Error, nickName no existe");
	
							}else{
								System.out.print("Cual es el nuevo puntaje para el jugador: ");

								System.out.println(controller.changePoints(reader.nextInt(),nickName));
							}
						}

                        break;

                    case 5:
						if(controller.playersAvailability().equals("No hay jugadores ")){
							System.out.println(controller.playersAvailability());
						}else{
							reader.nextLine();
							System.out.print("Dime el nickName del jugador: ");
							String nickName = reader.nextLine();
							if(controller.searchPlayer(nickName) == null){
									
								System.out.println("Error, nickName no existe");

							}else{
								System.out.println(controller.increasePlayerLevel(nickName));
							}
						}
                        break;

                    case 6:
						if(controller.treasureAvailability().equals("No hay tesoros")){
							System.out.println(controller.treasureAvailability());
						}else{
							System.out.println("Por favor dime el nivel al cual deseas consultar");
							int level = reader.nextInt();
							System.out.println(controller.listTreasure(level));
						}
						
						if(controller.enemyAvailability().equals("No hay Enemigos ")){
							System.out.println(controller.enemyAvailability());
						}else{
							System.out.println("Por favor dime el nivel al cual deseas consultar");
							int level = reader.nextInt();
							System.out.println(controller.listEnemies(level));
						}
                        break;
                        
                    case 7:
						if(controller.treasureAvailability().equals("No hay tesoros")){
							System.out.println(controller.treasureAvailability());
						}else{
							System.out.println("Por favor dime el nombre del tesoro que deseas consultar");
							reader.nextLine();
							System.out.println(controller.listTreasureInAllGame(reader.nextLine()));
						}
                        break;

                    case 8:
						if(controller.enemyAvailability().equals("No hay Enemigos ")){
							System.out.println(controller.enemyAvailability());
						}else{

							System.out.print("\nQue enemigo deseas consultar"+
							"\n1.Ogro"+
							"\n2.Abstracto"+
							"\n3.Jefe"+
							"\n4.Magico"+
							"\nOpcion: ");
							int type = reader.nextInt();
							if(type > 4 || type < 1){
								System.out.println("Opcion invalida");
							}else{
								System.out.println(controller.amountEnemiesType(type));
							}
						}
                        break;
                        
                    case 9:
						if(controller.treasureAvailability().equals("No hay tesoros")){
							System.out.println(controller.treasureAvailability());
						}else{
							System.out.println(controller.countTreasuresName());
						}
                        break;

                    case 10:
						if(controller.enemyAvailability().equals("No hay Enemigos ")){
							System.out.println(controller.enemyAvailability());
						}else{
							System.out.println(controller.getBestEnemyLocation());
						}
                        break;
                    
                    case 11:
						if(controller.enemyAvailability().equals("No hay Enemigos ")){
							System.out.println(controller.enemyAvailability());
						}else{
							System.out.println(controller.consonantsEnemy());
						}
                        break;
                        
                    case 12:
						if(controller.playersAvailability().equals("No hay jugadores ")){
							System.out.println(controller.playersAvailability());
						}else{
							System.out.println(controller.topFive());
						}
                        break;    

					case 0: 
						System.out.println("Exit program.");
						break; 

					default: 
						System.out.println("Invalid Option");
						break; 
				}
		}
	
	/**
	 * @param: Option that gives the user
	 * @return: Validates the option and if the user gives a number that doesnt exist will give (Invalid Option) or even with letters (Invalid Option)
	 */	
	public int validateIntegerOption(){
			int option = 0; 

			if(reader.hasNextInt()){
				option = reader.nextInt(); 
			}
			else{
				// clear reader. 
				reader.nextLine(); 
				option = -1; 
			}

			return option; 
		}
}
