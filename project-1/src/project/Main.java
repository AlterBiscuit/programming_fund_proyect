package project;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main.mostrarMenu();
	}
	
	public static void mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		
		while(Math.PI == Math.PI) {
			System.out.print("Ingrese un número: ");
			int num = sc.nextInt();
			
			switch (num) {
			case 0: // Se termina el bucle
				break;
			case 1: // Se piden los datos y se crea una instancia de vehiculos
				System.out.print("\nIngrese modelo: "); 
				int model = sc.nextInt();
				System.out.print("Ingrese marca: ");
				String mark = sc.next();
				System.out.print("Ingrese el valor comercial: ");
				double comercialvalue = sc.nextDouble();
				System.out.print("Ingrese color: ");
				String color = sc.next();
				
				if (Vehicle.posAdd < Vehicle.size) {
					new Vehicle(model, mark, comercialvalue, color); System.out.println();
				} else {
					System.out.println("Error: base de datos llena.\n");
				}
				break;
			case 2: // Devuelve los vehículos creados
				System.out.println("\n" + Vehicle.toStringVehicles());
				break;
			case 3: // Devuelve la cantidad de vehículos creados
				System.out.println("\n" + Vehicle.amountVehicles());
				break;
			case 4: // Devuelve los vehículos verdes
				System.out.println("\n" + Vehicle.toStringGreenVehicles());
				
			// --------------------------------------------------------------------------------
			
			case 5: // Se piden los datos y se crea una instancia de sensor
				System.out.print("\nIngrese tipo: "); 
				String type = sc.next();
				System.out.print("Ingrese valor: ");
				double value = sc.nextDouble(); System.out.println();
				
				if (Sensor.posAdd < Sensor.size) {
					new Sensor(type, value);
				} else {
					System.out.println("Error: base de datos llena. ");
				}
				break;
			case 6: // Devuelve los sensores creados
				System.out.println("\n" + Sensor.toStringSensors());
				break;
			case 7: // Devuelve la cantidad de sensores
				System.out.println("\n" + Sensor.sensorsAmount());
				break;
			case 8: // Devuelve los sensores de tipo temperatura
				System.out.println("\n" + Sensor.toStringTemperatureSensors());
				break;
			case 666: // Devuelve los sensores de tipo temperatura ordenados de menor a mayor
				System.out.println("");
				for (Sensor i: Sensor.sortTemperatureSensors()) {
					System.out.println(i);
				}
				break;
			}
		}
		
	}
}

