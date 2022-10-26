package Ejercicio1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Saludos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	//Constructor por defecto
	
	public Saludos() {
	
	//Creamos un panel con su título establecido
		setTitle("Saludador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Botón para realizar el saludo con la accion incluida
		JButton btnNewButton = new JButton("¡Saludar!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Hola "+textField.getText());
			}
		});
		btnNewButton.setBounds(176, 175, 85, 21);
		contentPane.add(btnNewButton);
		
		//Texto superior
		JTextArea txtrEscribeUnNombre = new JTextArea();
		txtrEscribeUnNombre.setBackground(new Color(192, 192, 192));
		txtrEscribeUnNombre.setText("Escribe un nombre para saludar");
		txtrEscribeUnNombre.setBounds(98, 35, 245, 21);
		contentPane.add(txtrEscribeUnNombre);
		
		//Casilla dónde introducimos el nombre
		textField = new JTextField();
		textField.setBounds(98, 113, 245, 19);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}