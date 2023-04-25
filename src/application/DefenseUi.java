package application;

import java.awt.EventQueue;

import board.Defense;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import board.Ship;
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

public class DefenseUi extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_1;
    private JTable table;
    private DefenseUi frameDef = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DefenseUi frame = new DefenseUi(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     *
     * @throws PosicaoInvalida
     * @throws AtributoInvalido
     */
    public DefenseUi(Defense board) throws AtributoInvalido, PosicaoInvalida {
        int shipsPlaced = 0;
        DefenseUi esse = this;
        // battleMatch.start();

        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[][] {
                        { "---", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" },
                        { "0", null, null, null, null, null, null, null, null, null, null },
                        { "1", null, null, null, null, null, null, null, null, null, null },
                        { "2", null, null, null, null, null, null, null, null, null, null },
                        { "3", null, null, null, null, null, null, null, null, null, null },
                        { "4", null, null, null, null, null, null, null, null, null, null },
                        { "5", null, null, null, null, null, null, null, null, null, null },
                        { "6", null, null, null, null, null, null, null, null, null, null },
                        { "7", null, null, null, null, null, null, null, null, null, null },
                        { "8", null, null, null, null, null, null, null, null, null, null },
                        { "9", null, null, null, null, null, null, null, null, null, null },
                },
                new String[] {
                        "New column", "New column", "New column", "New column", "New column", "New column",
                        "New column", "New column", "New column", "New column", "New column"
                }) {
            private static final long serialVersionUID = 1L;
            boolean[] columnEditables = new boolean[] {
                    true, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int row, int column) {
                return columnEditables[column];
            }
        };
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JLabel lblNewLabel = new JLabel("Eixo Y");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel.setBounds(766, 142, 65, 36);
        contentPane.add(lblNewLabel);

        JLabel lblEixoY = new JLabel("Eixo X");
        lblEixoY.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblEixoY.setBounds(873, 142, 65, 36);
        contentPane.add(lblEixoY);

        textField_1 = new JTextField();
        textField_1.setBounds(790, 323, 120, 36);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Direcao:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
        lblNewLabel_1.setBounds(768, 254, 161, 36);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("(cima, baixo, direita ou esquerda)");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(749, 289, 225, 24);
        contentPane.add(lblNewLabel_2);

        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 52));
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(60);
        table.getColumnModel().getColumn(7).setPreferredWidth(60);
        table.getColumnModel().getColumn(8).setPreferredWidth(60);
        table.getColumnModel().getColumn(9).setPreferredWidth(60);
        table.getColumnModel().getColumn(10).setPreferredWidth(60);
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setBounds(10, 27, 729, 660);
        table.setRowHeight(60);
        contentPane.add(table);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(Color.RED);
        lblNewLabel_3.setFont(lblNewLabel_3.getFont().deriveFont(15f));
        lblNewLabel_3.setBounds(749, 72, 261, 60);
        contentPane.add(lblNewLabel_3);

        JButton btnNewButton_1 = new JButton("FASE DE ATAQUE");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                esse.setVisible(false);
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
        btnNewButton_1.setBounds(756, 549, 244, 110);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_5 = new JLabel("PLAYER 1, SUA VEZ DE ATACAR");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(749, 486, 276, 53);
        contentPane.add(lblNewLabel_5);

        lblNewLabel_5.setVisible(false);
        btnNewButton_1.setVisible(false);

        JButton btnNewButton = new JButton("PLOTAR NAVIOS");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textFieldValue = textField.getText();
                String textField_2Value = textField_2.getText();
                String textField_1Value = textField_1.getText();

                try {
                    int intValue = Integer.parseInt(textFieldValue);

                    String validationText = board.setShipsOnBoard(intValue, textField_2Value, textField_1Value);

                    if (validationText == "valido") {
                        board.printBoard(tableModel);

                        if (board.shipsPlaced == Ship.getShipTotals()) {
                            if (frameDef != null) {
                                esse.setVisible(false);
                                frameDef.setVisible(true);
                            }
                        }
                    } else {
                        lblNewLabel_3.setText(validationText);
                    }
                } catch (AtributoInvalido e1) {
                    lblNewLabel_3.setText(e1.getMessage());
                    e1.printStackTrace();
                } catch (PosicaoInvalida e1) {
                    lblNewLabel_3.setText(e1.getMessage());
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(768, 386, 169, 48);
        contentPane.add(btnNewButton);

        JLabel lblNewLabel_4 = new JLabel("PLAYER " + board.playerNumber);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 45));
        lblNewLabel_4.setBounds(749, 2, 251, 60);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("SELECIONE SUAS PECAS");
        lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 21));
        lblNewLabel_4_1.setBounds(749, 55, 251, 60);
        contentPane.add(lblNewLabel_4_1);
    }

    public void setOtherFrame(DefenseUi frame) {
        this.frameDef = frame;
    }
}