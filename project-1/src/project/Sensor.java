package project;

import java.util.ArrayList;

public class Sensor {
	
	public static int size = 8;
	public static Sensor[] sensors = new Sensor[size];
	public static ArrayList <Sensor> temperatureSensors = new ArrayList <Sensor>();
	public static int posAdd = 0;
	
	private String type;
	private double value;
		
	public Sensor() {
		sensors[posAdd] = this;
        posAdd++;
	}
	
	public Sensor(String type, double value) {
		this.setType(type);
		this.setValue(value);
		
		sensors[posAdd] = this;
        posAdd++;
	}
	
	public String toString() {
		return "TIPO:  " + this.getType() + "\n" + 
			   "VALOR: " + this.getValue() + "\n";
	}
	
	public static String toStringSensors() {
		String returnv = "";
    	for (int i = 0; i < posAdd; i++) {
    		returnv += Sensor.sensors[i].toString() + "\n";
    	}
    	return returnv;
	}
	
	public static String toStringTemperatureSensors() {
		String returnv = "";
    	for (int i = 0; i < posAdd; i++) {
    		if (Sensor.sensors[i].getType().equals("temperatura")) {
    			returnv += Sensor.sensors[i].toString() + "\n";
    			Sensor.temperatureSensors.add(Sensor.sensors[i]);
    		}
    	}
    	return returnv;
	}
	
	public static Sensor[] sortTemperatureSensors() {
		for (int i = 0; i < posAdd; i++) {
    		if (Sensor.sensors[i].getType().equals("temperatura")) {
    			Sensor.temperatureSensors.add(Sensor.sensors[i]);
    		}
    	}
		
		Sensor[] returnArray = new Sensor[Sensor.temperatureSensors.size()];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = Sensor.temperatureSensors.get(i);
		}

		 for (int i = 0; i < returnArray.length - 1; i++)  {  
	        int index = i; 
	        for (int j = i + 1; j < returnArray.length; j++) {  
	            if (returnArray[j].getValue() < returnArray[index].getValue()) {  
	                index = j; //searching for lowest index  
	            } 
	        }
	        Sensor smallerNumber = returnArray[index];   
            returnArray[index] = returnArray[i];  
            returnArray[i] = smallerNumber;
		}    
	    return returnArray; 
	}
		
	
	// ----------------------------------------------------------------

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
	
	public static int sensorsAmount() {
		return posAdd;
	}

}