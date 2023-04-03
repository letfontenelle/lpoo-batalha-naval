package application;

import java.util.Scanner;

import exceptions.PosicaoInvalida;

public class UI {
	
	public static void printBoard(int[][] matrizBoard) {
				
		for (int i = 9; i >= 0; i--) {
			System.out.print(i + " ");
			for (int j = 0; j < 10; j++) {
				if (matrizBoard[i][j] == 1) {
					System.out.print("N");
				} else if(matrizBoard[i][j] == 2){
					System.out.print("o");
				} else if(matrizBoard[i][j] == 3){
					System.out.print("x");
				} else{
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

	public static int input( ) throws PosicaoInvalida {
		
		Scanner scanner = new Scanner(System.in);
		int positionY = scanner.nextInt();
		
		if (positionY > 9 || positionY < 0) {
			throw new PosicaoInvalida("A primeira e segunda posição não existem!");
        } else {
        	return positionY;
        }
		
	}

	public static String inputString() throws PosicaoInvalida {
		Scanner scanner = new Scanner(System.in);

		return scanner.nextLine();
	}
}
