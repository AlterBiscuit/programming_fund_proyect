package project_2;

public abstract class Bug {
	private int health;
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
		if (this.health < 0) {
			this.health = 0;
		}
	}
	
	public abstract String toString();
}
