package Ejercicio2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class ListaPeliculas extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	//Constructor por defecto
	public ListaPeliculas() {
		//Creamos un panel con su título establecido
		setBackground(new Color(192, 192, 192));
		setTitle("Peliculas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos dos areas de texto con sobre los campos en los que trabajaremos
		JTextArea txtrEscribeElTtulo = new JTextArea();
		txtrEscribeElTtulo.setBackground(new Color(192, 192, 192));
		txtrEscribeElTtulo.setText("Escribe el título de una película");
		txtrEscribeElTtulo.setBounds(10, 51, 269, 22);
		contentPane.add(txtrEscribeElTtulo);
		
		JTextArea txtrPeliculas = new JTextArea();
		txtrPeliculas.setBackground(new Color(192, 192, 192));
		txtrPeliculas.setText("Peliculas");
		txtrPeliculas.setBounds(481, 51, 77, 22);
		contentPane.add(txtrPeliculas);
		
		//Casilla dónde introducimos la película
		textField = new JTextField();
		textField.setBounds(58, 83, 221, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//Caja que irá mostrando las películas a medida que las añadimos
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(344, 82, 214, 22);
		contentPane.add(comboBox);
		
		//Botón para realizar los añadidos
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.addItem(textField.getText());
			}
		});
		btnNewButton.setBounds(82, 125, 85, 21);
		contentPane.add(btnNewButton);
		


	}
}
