package project_1;

import java.util.Scanner;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Main.showMenu();
	}
	
	public static void showMenu() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("INSTRUCCI�NES DE USO: \n"
				+ "\nPresione (1) para crear un veh�culo."
				+ "\nPresione (2) para ver los veh�culos creados y sus sensores."
				+ "\nPresione (3) para ver la cantidad de veh�culos creados."
				+ "\nPresione (4) para ver los veh�culos verdes."
				+ "\nPresione (5) para buscar un veh�culo espec�fico por ID."
				+ "\nPresione (6) para a�adir un sensor a un veh�culo."
				+ "\nPresione (7) para ver los sensores de un veh�culo espec�fico por ID."
				+ "\nPresione (8) para ver los sensores de tipo temperatura."
				+ "\nPresione (9) para mostrar el veh�culo con m�s sensores."
				+ "\nPresione (10) para crear cinco veh�culos pre-dise�ados."
				+ "\nPresione (666) para una funcionalidad sorpresa.\n");
		
		while(Math.PI == Math.PI) {
			System.out.print("Ingrese un n�mero: ");
			int num = sc.nextInt();
			if (num == 0) break;
			
			switch (num) {	
			case 1: // Se piden los datos y se crea una instancia de vehiculos
				System.out.print("\nIngrese modelo: "); 
				int model = sc.nextInt();
				System.out.print("Ingrese marca: ");
				String mark = sc.next();
				System.out.print("Ingrese el valor comercial: ");
				double comercialvalue = sc.nextDouble();
				System.out.print("Ingrese color: ");
				String color = sc.next();
				
				new Vehicle(model, mark, comercialvalue, color); System.out.println();
				break;
				
			case 2: // Devuelve los veh�culos creados
				System.out.println("\n" + Vehicle.toStringVehicles() + "\n");
				break;
				
			case 3: // Devuelve la cantidad de veh�culos creados
				System.out.println("\n" + Vehicle.amountVehicles() + " veh�culos fueron creados.\n");
				break;
				
			case 4: // Devuelve los veh�culos verdes
				System.out.println(Vehicle.toStringGreenVehicles());
				break;
			
			case 5: // Se pide al usuario un ID y se muestra el veh�culo correspondiente
				System.out.print("\nIngrese ID: ");
				int id = sc.nextInt();
				
				if (Vehicle.searchVehicles(id) != null) {
					System.out.println(Vehicle.searchVehicles(id) + "\n");
				} else {
					System.out.println("El vehiculo cuya ID se est� buscando no existe. \n");
				}
				break;
			
			case 6: // Se pide al usuario un ID y se a�ade un sensor a ese veh�culo
				System.out.print("\nIngrese ID: ");
				id = sc.nextInt();
				
				if (Vehicle.searchVehicles(id) != null) {
					System.out.print("Ingrese tipo: ");
					String type = sc.next();
					System.out.print("Ingrese valor: ");
					double value = sc.nextDouble();
					
					Vehicle.searchVehicles(id).addSensor(new Sensor(type, value)); System.out.println();
					break;
					
				} else {
					System.out.println("El vehiculo cuya ID se est� buscando no existe. \n");
				}
			
			case 7: // Se pide al usuario un ID y se muestran los sensores de ese veh�culo
				System.out.print("\nIngrese ID: ");
				id = sc.nextInt();
				
				if (Vehicle.searchVehicles(id) != null) {
					System.out.println("\n" + Vehicle.searchVehicles(id).getSensors() + "\n");
				} else {
					System.out.println("El vehiculo cuya ID se est� buscando no existe. \n");
				}
				break;
			
			case 8: // Se muestran los sensores de tipo temperatura
				System.out.println(Vehicle.toStringTemperatureSensors() + "\n");
				break;
				
			case 9: // Muestra el veh�culo con mas sensores
				if (Vehicle.vehicles.size() == 1) {
					System.out.println(Vehicle.vehicles.get(0) + "\n");
				} else {
					Vehicle maxvalue = Vehicle.vehicles.get(0);
					
					for (int i = 1; i < Vehicle.vehicles.size(); i++) {
						if (maxvalue.getSensors().size() < Vehicle.vehicles.get(i).getSensors().size()) {
							maxvalue = Vehicle.vehicles.get(i);
						}
					}
					System.out.println(maxvalue + "\n");
				}
				break;
			
			case 10: // Carga 5 coches desde un archivo de texto
				try (Scanner input = new Scanner(new File("C:\\Users\\USUARIO\\Desktop\\Java\\project-1\\src\\project\\text.txt"))) {
					String s = "";
					while (input.hasNext()) {
						s += input.next() + "\n";
					}
					
					Scanner sc2 = new Scanner(s.replaceAll(",", " "));
					
					for (int i = 0; i < 5; i++) {
						
						model = Integer.parseInt(sc2.next());
						mark = sc2.next();
						comercialvalue = Double.parseDouble(sc2.next());
						color = sc2.next();
						
						new Vehicle(model, mark, comercialvalue, color);
					}
					System.out.println("\nSe han a�adido 5 veh�culos desde la base de datos.");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
			case 666: // Se ordenan los sensores de tipo temperatura de menor a mayor valor
				for (Sensor i: Vehicle.sortTemperatureSensors()) {
					System.out.println(i);
				}
				System.out.println();
			}
		}
		
	}
}