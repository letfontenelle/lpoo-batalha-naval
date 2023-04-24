package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import battle.BattleMatch;
import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Battle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Battle frame = new Battle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PosicaoInvalida 
	 * @throws AtributoInvalido 
	 */
	public Battle() throws AtributoInvalido, PosicaoInvalida {
		
        BattleMatch battleMatch = new BattleMatch();
		//battleMatch.start();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("PLOTAR NAVIOS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = textField.getText();
				String textField_2Value = textField_2.getText();
				System.out.println(textField_2Value);
				System.out.println(textFieldValue);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(768, 257, 169, 48);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(253, 112, 432, 342);
		contentPane.add(table);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textField.setBounds(766, 196, 54, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(883, 196, 54, 36);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Eixo X");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(766, 142, 65, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblEixoY = new JLabel("Eixo Y");
		lblEixoY.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEixoY.setBounds(873, 142, 65, 36);
		contentPane.add(lblEixoY);
	}
}
