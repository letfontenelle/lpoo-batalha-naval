package application;

import java.util.Scanner;

public class UI {
	public static void printBoard(int[][] matrizBoard) {
<<<<<<< HEAD
		
		for (int i = 0; i < matrizBoard.length; i++) {
			System.out.print((9 - i) + " ");
			for (int j = 0; j < matrizBoard.length; j++) {
=======
		for (int i = 9; i >= 0; i--) {
			System.out.print(i + " ");
			for (int j = 0; j < 10; j++) {
>>>>>>> 6dad724b29277b83c99afad02b38f4da3d9200dd
				if (matrizBoard[i][j] == 1) {
					System.out.print("N");
				} else if(matrizBoard[i][j] == 2){
					System.out.println("o");
				}
				else{
					System.out.print("~");
				}
				System.out.print(" ");
			}
			System.out.println(" ");
		}
		System.out.println("  A B C D E F G H I J");
	}

	public static void printMenu() {
		System.out.println("BATALHA NAVAL");
		System.out.println("");
		System.out.println("1 - JOGAR");
		System.out.println("2 - SAIR");
		System.out.println("");
		System.out.print("DIGITE SUA ESCOLHA: ");
	}

	public static int input() {
		Scanner scanner = new Scanner(System.in);

		return scanner.nextInt();
	}

	public static String inputString() {
		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}
}
