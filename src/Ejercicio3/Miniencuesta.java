package Ejercicio3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class Miniencuesta extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	//Constructor por defecto
	
	public Miniencuesta() {
		
		//Creamos el panel principal con su título
		
		setTitle("Miniencuesta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Creamos los 3 botones y los metemos en el mismo grupo para que solo uno pueda ser seleccionado
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Windows");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(69, 75, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Linux");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(69, 112, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Mac");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(69, 146, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		//Creamos los textos que encabezan los otros elementos
		
		JTextArea txtrElijaUnSistema = new JTextArea();
		txtrElijaUnSistema.setBackground(new Color(240, 240, 240));
		txtrElijaUnSistema.setText("Elija un sistema operativo");
		txtrElijaUnSistema.setBounds(26, 31, 213, 21);
		contentPane.add(txtrElijaUnSistema);
		
		JTextArea txtrElijaSuEspecialidad = new JTextArea();
		txtrElijaSuEspecialidad.setBackground(new Color(240, 240, 240));
		txtrElijaSuEspecialidad.setText("Elija su especialidad");
		txtrElijaSuEspecialidad.setBounds(356, 31, 203, 21);
		contentPane.add(txtrElijaSuEspecialidad);
		
		JTextArea txtrHorasDedicadasEn = new JTextArea();
		txtrHorasDedicadasEn.setBackground(new Color(240, 240, 240));
		txtrHorasDedicadasEn.setText("Horas dedicadas en el ordenador");
		txtrHorasDedicadasEn.setBounds(156, 227, 264, 22);
		contentPane.add(txtrHorasDedicadasEn);
		
		
		//Creamos los 3 botones que pueden estar vacíos o seleccionados.
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Programación");
		chckbxNewCheckBox.setBounds(395, 75, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Diseño gráfico");
		chckbxNewCheckBox_1.setBounds(395, 112, 93, 21);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Administración");
		chckbxNewCheckBox_2.setBounds(395, 146, 93, 21);
		contentPane.add(chckbxNewCheckBox_2);
		

		//Creamos el slider del 0 al 10
		
		JSlider slider = new JSlider();
		slider.setMaximum(10);
		slider.setBounds(183, 264, 200, 22);
		contentPane.add(slider);
		
		//Para acabar un botón que dará el resultado de la encuesta
		
		JButton btnNewButton = new JButton("Terminar encuesta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarInfo(chckbxNewCheckBox,chckbxNewCheckBox_1,chckbxNewCheckBox_2,slider);
			}
		});
		btnNewButton.setBounds(409, 329, 150, 21);
		contentPane.add(btnNewButton);
	}
	
	//Método que verifica que cajas están seleccionadas y muestra toda la información
	
	public void mostrarInfo(JCheckBox boton1, JCheckBox boton2, JCheckBox boton3,JSlider slider) {
		String programacion="";
		String diseñograf="";
		String administracion="";
		if(boton1.isSelected()) {
			programacion=boton1.getText();
		}if(boton2.isSelected()) {
			diseñograf=boton2.getText();
		}if(boton3.isSelected()) {
			administracion=boton3.getText();
		}
		
		JOptionPane.showMessageDialog(null, "Sistema operativo: " +botonSeleccionado(buttonGroup)+
				"\nEspecialidades: "+programacion+" "+diseñograf+" "+administracion+
				"\nHoras dedicadas: "+slider.getValue());
		
	}
	
	//Método para comprobar cual de todos los botones del grupo ha de devolver el texto.
	
	public String botonSeleccionado(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
