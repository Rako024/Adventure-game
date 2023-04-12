import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner in = new Scanner(System.in);

	public void login() {

		System.out.println("Welcome the game");
		System.out.print("Please enter your name : ");
		String playerName = in.nextLine();
		this.player = new Player(playerName);
		player.selectChar();
		start();

	}

	public void start() {
		while(true) {
			System.out.println("\n==================================\n");
			System.out.println("Pleas select map !");
			System.out.println("1 - Safe House  => not enemy!");
			System.out.println("2 - Cave       => enemy zombies.");
			System.out.println("3 - Forest     => enemy vampire.");
			System.out.println("4 - River      => enemy bear.");
			System.out.println("5 - Tool Store => not enemy!");
			System.out.print("Your choise : ");
			int selLoc = in.nextInt();
			while (selLoc < 1 || selLoc > 5) {
				System.out.println("Pleas correct select character in between 1-5");
				System.out.print("Your choice : ");
				selLoc = in.nextInt();
			}
			switch(selLoc) {
			case 1:
				location = new SafeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5:
				location = new ToolStore(player);
				break;
			default:
				location = new SafeHouse(player);	
			}
			
			if(location.getName().equals("Safe House")) {
				if(player.getInv().isFireWood() && player.getInv().isFood() && player.getInv().isWater()) {
					System.out.println("Congratulations You Winn !!! <3");
					break;
				}
			}
				
			
			if(!location.getLocation()) {
				System.out.println("Game over !!!");
				break;
			}
		}
	}
}
