package Ejercicio4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	//Constructo por defecto
	public Calculadora() {
		
		//Creamos el panel principal con su título
		
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 410);
		getContentPane().setLayout(null);
		
		//Creamos todos los botones
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(177, 205, 85, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setBounds(177, 248, 85, 33);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("*");
		btnNewButton_2.setBounds(50, 248, 85, 33);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.setBounds(50, 205, 85, 33);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("=");
		btnNewButton_4.setBounds(50, 291, 85, 21);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("SALIR");
		btnNewButton_6.setBounds(112, 342, 85, 21);
		getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_4_1 = new JButton("C");
		btnNewButton_4_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4_1.setBounds(177, 291, 85, 21);
		getContentPane().add(btnNewButton_4_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		// Creamos el texto con las indicaciones
		
		textField = new JTextField();
		textField.setBounds(23, 124, 78, 39);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 124, 85, 39);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		// Creamos los label donde mostraremos información como el resultado
		
		JLabel lblNewLabel = new JLabel("Resultado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(212, 18, 73, 13);
		getContentPane().add(lblNewLabel);

		
		JLabel lblNewLabel_2 = new JLabel("_");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_2.setBounds(133, 124, 45, 39);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_3.setBounds(23, 41, 274, 39);
		getContentPane().add(lblNewLabel_3);
		
		//Eventos
		
		// Eventos para introducir que operador usaremos
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("+");
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("-");
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("*");
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("/");
			}
		});
		
		//Evento para salir
		
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Evento para borrar todos los datos
		
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				lblNewLabel_2.setText("_");
				lblNewLabel_2.setText("_");
				lblNewLabel_2.setText("_");
				lblNewLabel_2.setText("_");
				lblNewLabel_3.setText("");
			}
		});
		
		//Evento que sirve para hacer el cálculo final asegurándonos que los datos introducidos son válidos.
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = 0;
				String operador=lblNewLabel_2.getText();
				if (!operador.equals("_")) {
					try {
						int valor1 = Integer.parseInt(textField.getText());
						int valor2 = Integer.parseInt(textField_1.getText());
						
						if(operador.equals("+")) {
							resultado = valor1+valor2;
						}
						
						if(operador.equals("-")) {
							resultado = valor1-valor2;
						}
						
						if(operador.equals("*")) {
							resultado = valor1*valor2;
						}
						
						if(operador.equals("/")) {
							try {
							resultado = valor1/valor2;
							}catch(Exception ex) {
								JOptionPane.showMessageDialog(null, "Números indivisibles",
										"Algo falló", JOptionPane.ERROR_MESSAGE);
							}
						}
						lblNewLabel_3.setText(""+resultado);
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Error en los campos, asegúrate de introducir dos números",
								"Algo falló", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Asegúrate de introducir un operador",
							"Algo falló", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
}
