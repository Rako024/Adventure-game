
public class SafeHouse extends NormalLoc {

	SafeHouse(Player player) {
		super(player, "Safe House");
	}

	public boolean getLocation() {
		player.setHealty(player.getrHealty());
		System.out.println("your health is full....");
		System.out.println("you are in the safe house now. ");
		return true;
	}

}
