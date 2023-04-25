package application;

import java.awt.EventQueue;

import board.Defense;
import board.Attack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AttackUi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	private AttackUi frame;
	private JTable table_1;
	public int qtdAttack = 3;
	
	private DefaultTableModel tableModel1;
	private DefaultTableModel tableModel2;
	private Attack boardAttack;
	Defense boardDefense;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttackUi frame = new AttackUi(null, null, null);
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
	public AttackUi(Attack boardAttack, Defense boardDefense, Defense adversarioDefense) throws AtributoInvalido, PosicaoInvalida {
        AttackUi esse = this;

        this.boardAttack = boardAttack; 
        this.boardDefense = boardDefense;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textField.setBounds(588, 287, 54, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(713, 287, 54, 36);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel = new JLabel("Eixo Y");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(588, 241, 65, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblEixoY = new JLabel("Eixo X");
		lblEixoY.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEixoY.setBounds(702, 241, 65, 36);
		contentPane.add(lblEixoY);
		
		
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(lblNewLabel_3.getFont().deriveFont(15f));
		lblNewLabel_3.setBounds(743, 72, 261, 60);
		contentPane.add(lblNewLabel_3);
		
		this.tableModel1 = new DefaultTableModel(
				new Object[][] {
					{"---", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
					{"0", null, null, null, null, null, null, null, null, null, null},
					{"1", null, null, null, null, null, null, null, null, null, null},
					{"2", null, null, null, null, null, null, null, null, null, null},
					{"3", null, null, null, null, null, null, null, null, null, null},
					{"4", null, null, null, null, null, null, null, null, null, null},
					{"5", null, null, null, null, null, null, null, null, null, null},
					{"6", null, null, null, null, null, null, null, null, null, null},
					{"7", null, null, null, null, null, null, null, null, null, null},
					{"8", null, null, null, null, null, null, null, null, null, null},
					{"9", null, null, null, null, null, null, null, null, null, null},
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
				}
			) {
				private static final long serialVersionUID = 1L;
				boolean[] columnEditables = new boolean[] {
					true, false, false, false, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
			this.tableModel2 = new DefaultTableModel(
					new Object[][] {
						{"---", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"},
						{"0", null, null, null, null, null, null, null, null, null, null},
						{"1", null, null, null, null, null, null, null, null, null, null},
						{"2", null, null, null, null, null, null, null, null, null, null},
						{"3", null, null, null, null, null, null, null, null, null, null},
						{"4", null, null, null, null, null, null, null, null, null, null},
						{"5", null, null, null, null, null, null, null, null, null, null},
						{"6", null, null, null, null, null, null, null, null, null, null},
						{"7", null, null, null, null, null, null, null, null, null, null},
						{"8", null, null, null, null, null, null, null, null, null, null},
						{"9", null, null, null, null, null, null, null, null, null, null},
					},
					new String[] {
						"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
					}
				) {
					private static final long serialVersionUID = 1L;
					boolean[] columnEditables = new boolean[] {
						true, false, false, false, false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				};
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 24));
		table.setModel(tableModel1);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		table.getColumnModel().getColumn(5).setPreferredWidth(40);
		table.getColumnModel().getColumn(6).setPreferredWidth(40);
		table.getColumnModel().getColumn(7).setPreferredWidth(40);
		table.getColumnModel().getColumn(8).setPreferredWidth(40);
		table.getColumnModel().getColumn(9).setPreferredWidth(40);
		table.getColumnModel().getColumn(10).setPreferredWidth(40);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(10, 142, 544, 440);
		table.setRowHeight(40);
		contentPane.add(table);
		
		table_1 = new JTable();
		table_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		table_1.setModel(tableModel2);
		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(6).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(7).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(8).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(9).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(10).setPreferredWidth(40);
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setRowHeight(40);
		table_1.setBounds(798, 142, 544, 440);
		
		contentPane.add(table_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_4.setForeground(new Color(220, 20, 60));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(564, 451, 229, 151);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Grelho inimigo");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(1021, 70, 205, 36);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Sua grelha");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_5_1.setBounds(255, 72, 137, 36);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_1_1_1 = new JLabel("Player " + boardAttack.playerNumber);
		lblNewLabel_5_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5_1_1_1.setBounds(614, 176, 137, 36);
		contentPane.add(lblNewLabel_5_1_1_1);
		
		JButton btnContinuar = new JButton("CONTINUAR");
		
		JButton btnNewButton = new JButton("ATACAAAAAAAAR!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = textField.getText();
				String textField_2Value = textField_2.getText();
				
				try {
					String validationText = boardAttack.setAttacksOnBoard(adversarioDefense, Integer.parseInt(textFieldValue), textField_2Value);
					System.out.println(validationText);
					if (validationText == "valido") {
						boardAttack.printBoardAtt(tableModel2);
						qtdAttack--;
					} else if (validationText == "ganhador") {
						esse.setVisible(false);
						Winner winner = new Winner(boardAttack.playerNumber);
						winner.setVisible(true);
					}
					
					if (qtdAttack == 0) {
						btnContinuar.setVisible(true);
						table.setVisible(false);
						btnNewButton.setVisible(false);
					}
				} catch (NumberFormatException e1) {
					lblNewLabel_4.setText(e1.getMessage());
					e1.printStackTrace();
				} catch (AtributoInvalido e1) {
					lblNewLabel_4.setText(e1.getMessage());
					e1.printStackTrace();
				} catch (PosicaoInvalida e1) {
					lblNewLabel_4.setText(e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(588, 366, 169, 48);
		contentPane.add(btnNewButton);
		
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnContinuar.setVisible(false);
				table.setVisible(true);
				btnNewButton.setVisible(true);
				esse.setVisible(false);
				frame.printBoards();
				frame.setVisible(true);
				qtdAttack = 3;
			}
		});
		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnContinuar.setBounds(588, 54, 169, 48);
		contentPane.add(btnContinuar);
		btnContinuar.setVisible(false);
	}
	
	public void setOtherFrame(AttackUi frame) {
		this.frame = frame;
	}
	
	public void printBoards() {
		this.boardDefense.printBoard(this.tableModel1);
		this.boardAttack.printBoardAtt(this.tableModel2);
	}
}
