import java.util.Scanner;

public class Player {
	private int damage, healty, money, rHealty;
	private String name, cName;
	Inventory inv;
	Scanner in = new Scanner(System.in);

	Player(String name) {
		this.name = name;
		this.inv = new Inventory();
	}

	public int charMenu() {
		System.out.println("Please select one charater !");
		System.out.println("1.Samuray -- Damage = 5 , Healt = 21 , Money = 15");
		System.out.println("2.Archer  -- Damage = 7 , Healt = 18 , Money = 20");
		System.out.println("3.Knight  -- Damage = 8 , Healt = 24 , Money = 5");
		System.out.print("Your choice : ");
		int charID = in.nextInt();
		while (charID > 3 || charID < 1) {

			System.out.println("Pleas correct select character in between 1-3");
			System.out.print("Your choice : ");
			charID = in.nextInt();
		}
		return charID;
	}

	public int getTotalDamage() {
		return this.getDamage()+this.getInv().getDamage();
	}
	
	public void selectChar() {
		switch (charMenu()) {
		case 1:
			init("Samuray", 5, 21, 15);
			break;
		case 2:
			init("Archer", 7, 18, 20);
			break;
		case 3:
			init("Knight", 8, 24, 5);
			break;
		default:
			init("Samuray", 5, 21, 15);
			break;
		}
		System.out.println("Character : " + getcName() + "\tDamage : " + getDamage() + "\tHealt : " + getHealty()
				+ "\tMoney : " + getMoney());
	}

	public void init(String cName, int damage, int healty, int money) {
		setcName(cName);
		setDamage(damage);
		setHealty(healty);
		setMoney(money);
		setrHealty(healty);
	}

	public int getrHealty() {
		return rHealty;
	}

	public void setrHealty(int rHealty) {
		this.rHealty = rHealty;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealty() {
		return healty;
	}

	public void setHealty(int healty) {
		this.healty = healty;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

}
