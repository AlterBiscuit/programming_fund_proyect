package project_2;

public class NormalBug extends Bug{

	public NormalBug() {
		this.setHealth(10);
	}

	public String toString() {
		return "BN-" + this.getHealth();
	}
	
}
