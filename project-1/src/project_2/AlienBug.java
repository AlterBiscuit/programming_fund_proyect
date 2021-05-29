package project_2;

public class AlienBug extends Bug {

	public AlienBug() {
		this.setHealth(20);
	}
	
	public String toString() {
		return "BA-" + this.getHealth();
	}

}
