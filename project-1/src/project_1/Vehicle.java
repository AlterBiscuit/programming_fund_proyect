package project_1;

import java.util.ArrayList;

public class Vehicle {
	
	private ArrayList <Sensor> sensors = new ArrayList <Sensor> ();
	public static ArrayList <Vehicle> vehicles = new ArrayList <Vehicle> ();
	
	public static int currentId = 1;
	private int id;
	
    private int model;
    private String mark;
    private double comercialValue;
    private String color;
	
    public Vehicle() {
    	Vehicle.vehicles.add(this);
    	this.setId(Vehicle.currentId);
        Vehicle.currentId++;
    }	
    
    public Vehicle(int model, String mark, double comercialValue) {
        this(model, mark, comercialValue, "verde");
    }
    
    public Vehicle(int model, String mark, double comercialValue, String color) {
        this.setModel(model);
        this.setMark(mark);
        this.setColor(color);
        this.setComercialValue(comercialValue);
        
        Vehicle.vehicles.add(this);
        this.setId(Vehicle.currentId);
        Vehicle.currentId++;
    }
    
    // -----------------------------------------------------------------------------------
    // ToString's
    
    public String toString() {
    	
    	return "\nMARCA:           " + this.getMark() + "\n" +
		    "MODELO:          " + this.getModel() + "\n" + 
		    "COLOR:           " + this.getColor() + "\n" +
		    "VALOR COMERCIAL: " + this.getComercialValue() + "\n" +
		    "----------------------------------------------" + "\n" +
		    "SENSORES: " + 
		    this.toStringSensors();
		    
    }
    
    public String toStringSensors() {
    	String rv = "";
    	for (Sensor i: sensors) {
    		rv += i;
    	}
    	return rv;
    }
    
    public static String toStringVehicles() {
    	String returnv = "";
    	for (Vehicle i: vehicles) {
    		returnv += i.toString() + "\n";
    	}
    	return returnv;
    }
    
    public static String toStringGreenVehicles() {
    	String returnv = "";
    	for (Vehicle i: vehicles) {
    		if (i.getColor().equals("verde")) {
    			returnv += i.toString() + "\n";
    		}
    	}
    	return returnv;
    }
    
    // -----------------------------------------------------------------------------------
    // Procedimientos con vehículos
   
    public static int amountVehicles() {
    	return vehicles.size();
    }
    
    public static Vehicle searchVehicles(int id) {
    	Vehicle rv =  null;
    	for (Vehicle i: Vehicle.vehicles) {
			if (i.getId() == id) rv = i;
		}
    	return rv;
    }
    
    // -----------------------------------------------------------------------------------
    // Procedimientos con sensores
    
    public void addSensor(Sensor s) {
    	sensors.add(s);
    }
    
    public int sensorsAmount() {
    	return sensors.size();
    }
    
    public static String toStringTemperatureSensors() {
		String returnv = "";
    	for (Vehicle i: vehicles) {
    		for (Sensor j: i.getSensors()) {
    			if (j.getType().equals("temperatura")) {
    				returnv += j;
    			}
    		}
    	}
    	return returnv;
	}
    
    public static Sensor[] sortTemperatureSensors() {
    	ArrayList <Sensor> tempSensors = new ArrayList <Sensor> (); 
    	
    	for (Vehicle i: vehicles) {
    		for (Sensor j: i.getSensors()) {
    			if (j.getType().equals("temperatura")) {
    				tempSensors.add(j);
    			}
    		}
    	}
    	
		Sensor[] returnArray = new Sensor[tempSensors.size()];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = tempSensors.get(i);
		}

		 for (int i = 0; i < returnArray.length - 1; i++)  {  
	        int index = i; 
	        for (int j = i + 1; j < returnArray.length; j++) {  
	            if (returnArray[j].getValue() < returnArray[index].getValue()) {  
	                index = j;
	            } 
	        }
	        Sensor smallerNumber = returnArray[index];   
            returnArray[index] = returnArray[i];  
            returnArray[i] = smallerNumber;
		}
	    return returnArray;
	}
    
    // -----------------------------------------------------------------------------------
    // Getters y setters

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public double getComercialValue() {
		return comercialValue;
	}

	public void setComercialValue(double comercialValue) {
		this.comercialValue = comercialValue;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color.toLowerCase();
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public ArrayList <Sensor> getSensors() {
		return sensors;
	}
	
	public void setSensors(ArrayList <Sensor> s) {
		sensors = s;
	}
	
}
