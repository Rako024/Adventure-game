
public class Inventory {
	private boolean water, fireWood, food;
	private String wName, aName;
	private int damage, armor;

	Inventory() {
		this.water = false;
		this.fireWood = false;
		this.food = false;
		this.armor = 0;
		this.damage = 0;
		this.wName = null;
		this.aName = null;

	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isFireWood() {
		return fireWood;
	}

	public void setFireWood(boolean fireWood) {
		this.fireWood = fireWood;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public String getwName() {
		return wName;
	}

	public void setwName(String wName) {
		this.wName = wName;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}
