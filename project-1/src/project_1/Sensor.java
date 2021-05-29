package project_1;

public class Sensor {
	
	private String type;
	private double value;
		
	public Sensor() {}
	
	public Sensor(String type, double value) {
		this.setType(type);
		this.setValue(value);
	}
	
	public String toString() {
		return "\nTIPO:  " + this.getType() + "\n" + 
			   "VALOR: " + this.getValue();
	}
	
	// ----------------------------------------------------------
	// Getters y Setters

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type.toLowerCase();
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}