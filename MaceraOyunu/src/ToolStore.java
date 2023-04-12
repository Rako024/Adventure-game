import java.util.Scanner;

public class ToolStore extends NormalLoc {
	Scanner in = new Scanner(System.in);

	ToolStore(Player player) {
		super(player, "Tool Store");
	}

	public boolean getLocation() {
		System.out.println("Money : " + getPlayer().getMoney());
		System.out.println("1. Weaponry");
		System.out.println("2. Armory");
		System.out.println("3. Exit");
		System.out.print("Your chois : ");
		int selTool = in.nextInt();
		int selitemID;
		while (selTool > 3 || selTool < 1) {
			System.out.println("Pleas correct select character in between 1-3");
			System.out.print("Your choice : ");
			selTool = in.nextInt();
		}
		switch (selTool) {
		case 1:
			selitemID = weaponMenu();
			buyWeapon(selitemID);
			break;
		case 2:
			selitemID = armorMenu();
			buyArmor(selitemID);
			break;
		default:
			break;
		}
		return true;
	}

	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String wName = null;
		switch (itemID) {
		case 1:
			damage = 2;
			price = 25;
			wName = "Pistol";
			break;
		case 2:
			damage = 3;
			price = 35;
			wName = "Sword";
			break;
		case 3:
			damage = 7;
			price = 45;
			wName = "Mashine Gun";
			break;
		case 4:
			System.out.println("Exting");
		}
		if(price>0) {
		if (player.getMoney() >= price) {
			player.getInv().setDamage(damage);
			player.getInv().setwName(wName);
			player.setMoney(player.getMoney() - price);
			System.out.println("Transaction successful, after damage : " + player.getDamage() + " New Damage : "
					+ player.getTotalDamage());
			System.out.println("Money : " + player.getMoney());
		} else {
			System.out.println("Amount is low");
			System.out.println("Transaction failed Damage : " + player.getDamage());
		}
		}
	}

	public int weaponMenu() {
		System.out.println("1. Pistol \tDamage = 2 \t<Cost = 25>");
		System.out.println("2. Sword  \tDamage = 3 \t<Cost = 35>");
		System.out.println("3. Mashine Gun \tDamage = 7 \t<Cost = 45>");
		System.out.println("4. Exit");
		System.out.print("Your chois : ");
		int selWeapon = in.nextInt();
		while (selWeapon > 4 || selWeapon < 1) {
			System.out.println("Pleas correct select character in between 1-4");
			System.out.print("Your choice : ");
			selWeapon = in.nextInt();
		}

		return selWeapon;
	}

	public int armorMenu() {
		System.out.println("1. Light \tBlock = 1 \t<Cost = 15>");
		System.out.println("2. Medium  \tBlock = 3 \t<Cost = 25>");
		System.out.println("3. Heavy Gun \tBlock = 5 \t<Cost = 40>");
		System.out.println("4. Exit");
		System.out.print("Your chois : ");
		int selArmor = in.nextInt();
		while (selArmor > 4 || selArmor < 1) {
			System.out.println("Pleas correct select character in between 1-4");
			System.out.print("Your choice : ");
			selArmor = in.nextInt();
		}

		return selArmor;
	}

	public void buyArmor(int itemID) {
		int block = 0, price = 0;
		String aName = null;
		switch (itemID) {
		case 1:
			block = 1;
			price = 15;
			aName = "Light";
			break;
		case 2:
			block = 3;
			price = 25;
			aName = "Medium";
			break;
		case 3:
			block = 5;
			price = 40;
			aName = "Heavy";
			break;
		case 4:
			System.out.println("Exting");
		}
		if(price>0) {
		if (player.getMoney() >= price) {
			player.getInv().setArmor(block);
			player.getInv().setaName(aName);
			player.setMoney(player.getMoney() - price);
			System.out.println("Transaction successful,  New Armor : "+player.getInv().getArmor());
			System.out.println("Money : " + player.getMoney());
		} else {
			System.out.println("Amount is low");
			System.out.println("Transaction failed");
		}
		}
	}
}
