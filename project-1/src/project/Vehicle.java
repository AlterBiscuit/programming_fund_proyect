package project;

public class Vehicle {
	
	public static int size = 10;
	public static Vehicle[] vehicles = new Vehicle[size];
	public static int posAdd = 0;
	
    private int model;
    private String mark;
    private double comercialValue;
    private String color;

    public Vehicle() {
    	vehicles[posAdd] = this;
        posAdd++;
    }	
    
    public Vehicle(int model, String mark, double comercialValue) {
        this(model, mark, comercialValue, "verde");
    }
    
    public Vehicle(int model, String mark, double comercialValue, String color) {
        this.setModel(model);
        this.setMark(mark);
        this.setColor(color);
        this.setComercialValue(comercialValue);
        
        vehicles[posAdd] = this;
        posAdd++;
    }
    
    public String toString() {
    	return "MARCA:           " + this.getMark() + "\n" +
		       "MODELO:          " + this.getModel() + "\n" + 
		       "COLOR:           " + this.getColor() + "\n" +
		       "VALOR COMERCIAL: " + this.getComercialValue() + "\n";
    }
    
    public static String toStringVehicles() {
    	String returnv = "";
    	for (int i = 0; i < posAdd; i++) {
    		returnv += Vehicle.vehicles[i].toString() + "\n";
    	}
    	return returnv;
    }
    
    public static String toStringGreenVehicles() {
    	String returnv = "";
    	for (int i = 0; i < posAdd; i++) {
    		if (Vehicle.vehicles[i].getColor().equals("verde")) {
    			returnv += Vehicle.vehicles[i].toString() + "\n";
    		}
    	}
    	return returnv;
    }
    
 // -------------------------------------------------------------------------------------------

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
    
    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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
	
	public static int amountVehicles() {
		return posAdd;
		// ?
	}
	
}

