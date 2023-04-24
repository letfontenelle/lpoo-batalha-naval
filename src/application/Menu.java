package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;

import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

public class Menu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws PosicaoInvalida 
	 * @throws AtributoInvalido 
	 */
	public Menu() throws AtributoInvalido, PosicaoInvalida {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws PosicaoInvalida 
	 * @throws AtributoInvalido 
	 */
	private void initialize() throws AtributoInvalido, PosicaoInvalida {
		
		
		frame = new JFrame();
		Battle frame2 = new Battle();
		
		frame.setBounds(100, 100, 1024, 768);
		frame2.setBounds(100, 100, 1024, 768);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton("JOGAR");
		btnNewButton.setForeground(UIManager.getColor("Button.foreground"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 38));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false); //hides it temporarily
				frame2.setVisible(true); //shows it
				System.out.println("Botao");
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("BATALHA NAVAL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("SAIR");
		
		btnNewButton_1.setBackground(UIManager.getColor("Button.darkShadow"));
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);
	}

}
