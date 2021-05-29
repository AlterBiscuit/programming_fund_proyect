package project_2;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static Bug[][] bugsList = new Bug[2][2];
	
	
	public static void main(String[] args) {
		Main.showMenu();
	}
	
	
	public static void showMenu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		// Creación de los bichos de manera y en posiciónes aleatorias
		Random r = new Random();
		int numberOfBugs = r.nextInt(4) + 1;
		
		int a, b, c;
		a = b = c = 0;
		
		for (int i = 0; i < numberOfBugs; i++) {
			int r2 = r.nextInt(2) + 1;
			
			if (r2 == 1) {
				Main.bugsList[a][b] = new NormalBug();
			} else if (r2 == 2) {
				Main.bugsList[a][b] = new AlienBug();
			}
			
			c++; a++;
			if (c == 2) {
				a = 0;
				b = 1;
			}	
		}
		
		// ----------------------------------------------------------------
		int bugsDead = 0;
		
		while (Math.PI == Math.PI) {
			Main.showTable();
			
			// Se confirma si los bichos están vivos o muertos. De lo contrario, termina el juego.
			for (Bug[] i: Main.bugsList) {
				for (Bug j: i) {
					if (j == null) {
						continue;
					} else if (j.getHealth() <= 0) {
						bugsDead++;
					}
				}	
			}
			
			if (bugsDead == numberOfBugs) { 
				System.out.println("\nFelicidades, mataste a un monton de bichos inocentes. Eres un total psicopata.");
				break;
			} else {
				bugsDead = 0;
			}
			
			System.out.print("\nElegir una opción: " + "\n"
					+ "(1) Disparar una bala\n"
					+ "(2) Activar bomba atómica\n"
					+ "(3) Activar bicho mutante\n\n");
			
			System.out.print("- ");
			int option = input.nextInt();
			
			switch (option) {
			case 1: // Disparar una bala
				System.out.print("\nElegir fila: ");
				int row = input.nextInt();
				System.out.print("Elegir columna: ");
				int column = input.nextInt();
				
				Main.bugsList[row - 1][column - 1].setHealth(Main.bugsList[row - 1][column - 1].getHealth() - 5);
				break;
			
			case 2: // Activar bomba atómica
				boolean wasExploded = false;
				while (wasExploded != true) {
					row = (int) Math.round(Math.random() * 1.5);
					column = (int) Math.round(Math.random() * 1.5);
					
					wasExploded = (Main.bugsList[row][column] == null || Main.bugsList[row][column].getHealth() <= 0) ? false : true;
					if (wasExploded == true) { 
						Main.bugsList[row][column].setHealth(0);
					}
				}
				break;
		
				
			case 3: // Activar bicho mutante. Si todos los bichos tienen la misma salud, se aplica al primer bicho.
				Bug minorBug = Main.bugsList[0][0];
				
				for (int i = 0; i < Main.bugsList.length ; i++) {
					for (int j = 0; j < Main.bugsList.length; j++) {
						if (Main.bugsList[i][j]  == null) {
							break;
						} else if (Main.bugsList[i][j].getHealth() <= 0) {
							break;
						} else if (Main.bugsList[i][j].getHealth() < minorBug.getHealth()) {
							minorBug = bugsList[i][j];
						}
					}
				}
				
				minorBug.setHealth(minorBug.getHealth() * 2);
			}
		} 
	}
	
	
	public static void showTable() {
		
		System.out.print("______________");
		for (Bug[] i: Main.bugsList) {
			System.out.println(" ");
			for (Bug j: i) {
				if (j == null) {
					System.out.print("    " + "  |");
				} else if (j.getHealth() < 10) {
					System.out.print(j + "  |");
				} else {
					System.out.print(j + " |");
				}
				
			}
		}
		System.out.println("\n--------------");
	}
	
}
