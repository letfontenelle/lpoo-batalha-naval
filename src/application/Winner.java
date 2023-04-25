package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Winner extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Winner frame = new Winner(0);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Winner(int ganhador) {
        Winner esse = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1024, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Winner!");
        lblNewLabel.setForeground(new Color(255, 215, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
        lblNewLabel.setBounds(289, 106, 415, 105);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Player " + ganhador);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel_1.setBounds(349, 260, 297, 67);
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Jogar Novamente");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                esse.setVisible(false);
                try {
                    Main.main(null);
                } catch (AtributoInvalido e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (PosicaoInvalida e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });
        btnNewButton.setBounds(364, 367, 282, 119);
        contentPane.add(btnNewButton);

        JButton btnSair = new JButton("Sair");
        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnSair.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnSair.setBounds(366, 521, 280, 110);
        contentPane.add(btnSair);
    }

}