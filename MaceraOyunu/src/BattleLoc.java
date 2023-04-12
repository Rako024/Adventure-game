import java.util.Scanner;

public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	Scanner in = new Scanner(System.in);

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	public boolean getLocation() {
		int oCount = obstacle.obsCount();
		System.out.println("You are here now : " + this.getName());
		System.out.println("Be careful." +oCount  + " " + obstacle.getName() + " lives here !!!");
		System.out.println("<W>-War or <E>-Escape ?");
		String selCase = in.next();
		selCase = selCase.toUpperCase();
		if (selCase.equals("W")) {
			if (combat(oCount)) {
				System.out.println("You defeated all the enemies");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println("You won " + this.award);
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println("You won " + this.award);
					player.getInv().setWater(true);
				} else if (this.award.equals("FireWood") && player.getInv().isFireWood() == false) {
					System.out.println("You won " + this.award);
					player.getInv().setFireWood(true);
				}
				return true;
			} if(player.getHealty()<=0) {
				System.out.println("You Dead :(");
				return false;
			}
		}
		return true;
	}

	public boolean combat(int oCount) {
		int defObsHealth = obstacle.getHealth();
		for (int i = 0; i < oCount; i++) {
			playerStats();
			enemyStats();
			while (player.getHealty() > 0 && obstacle.getHealth() > 0) {
				System.out.println("<H> - Hit or <E> - Escape ?");
				String selCase = in.next();
				selCase = selCase.toUpperCase();
				if (selCase.equals("H")) {
					System.out.println("You Hit");
					obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					System.out.println(obstacle.getName() + "Health : " + obstacle.getHealth());
					System.out.println();
					if (obstacle.getHealth() > 0) {
						System.out.println("Enemy Hit");
						if (obstacle.getDamage() > player.getInv().getArmor())
							player.setHealty(player.getHealty() - (obstacle.getDamage() - player.getInv().getArmor()));
						System.out.println("Your Health : " + player.getHealty());
					}
				} else {
					break;

				}
			}
			if (obstacle.getHealth() <= 0 && player.getHealty() > 0) {
				System.out.println("You killed the enemies!!!");
				player.setMoney(player.getMoney() + obstacle.getAward());
				System.out.println("Current money : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
		}

		return true;
	}

	public void playerStats() {
		System.out.println("Player Stats\n------------------------");
		System.out.println("Health : " + player.getHealty());
		System.out.println("Damage : " + player.getTotalDamage());
		System.out.println("Money : " + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Weapon : " + player.getInv().getwName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Armor : " + player.getInv().getaName());
		}
		System.out.println();
	}

	public void enemyStats() {
		System.out.println(obstacle.getName() + " Stats\n------------------------");
		System.out.println("Health : " + obstacle.getHealth());
		System.out.println("Damage : " + obstacle.getDamage());
		System.out.println("Award : " + obstacle.getAward());
		System.out.println();
	}
}
