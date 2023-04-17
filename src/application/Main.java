package application;

import java.util.InputMismatchException;

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
				
			} catch (InputMismatchException e) {
				System.out.print("Erro, atributo invalido.");
			}
			
			catch(RuntimeException e) {
				System.out.print("Erro inesperado.");
		
			}
	}
}
