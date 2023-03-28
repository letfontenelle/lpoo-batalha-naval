package application;

import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

public class Main {

	public static void main(String[] args) throws AtributoInvalido, PosicaoInvalida {	
		
			
			try {Menu menu = new Menu();
			menu.print();
			} 
			
			catch(AtributoInvalido e) {
				
				System.out.println("Erro!: " + e.getMessage());
			}
			
			catch(PosicaoInvalida e) {
				System.out.print("Erro!: " + e.getMessage());
			}
			
			catch(RuntimeException e) {
				System.out.print("Erro inesperado.");
		
			}
	}
}
