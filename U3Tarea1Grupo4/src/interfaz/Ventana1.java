package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import programacionDinamica.Fibonacci;
import programacionDinamica.Main;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private JTextField ingresoBoxCiclica;
	private JTextField impresionBoxCiclica;
	private JTextField ingresoBoxRecursiva;
	private JTextField impresionBoxRecursiva;
	private JTextField TiempoBoxCiclica;
	private JTextField TiempoBoxRecursiva;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
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
	public Ventana1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 741, 509);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(204, 255, 204));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setLocationRelativeTo(null);
		setTitle("Programacion Dinamica");
		setResizable(false);
		addFocusListener(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIBONACCI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 30));
		lblNewLabel.setBounds(268, 10, 211, 52);
		contentPane.add(lblNewLabel);
		
		ingresoBoxCiclica = new JTextField();
		ingresoBoxCiclica.setHorizontalAlignment(SwingConstants.CENTER);
		ingresoBoxCiclica.addKeyListener(new KeyAdapter() {
			@Override
			//Es un evento de teclado 
			public void keyTyped(KeyEvent e) {
				//getKeyChar es para oobtener la tecla que hemos ingresado
				char caracter = e.getKeyChar();
				
				//Lo que hace el if es ignorar cualquier otra cosa que no sea numeros para evitar errores o congelamientos en la interfaz
				//si no se encuentra dentro de los rangos de los numeros 0 a 9 se ignorara y no escribira
				if ((caracter < '0' || caracter > '9') && (caracter != KeyEvent.VK_BACK_SPACE)) {
					e.consume();// si se cumple lo anterior lo que hace es que se ignore y no ingrese los caracteres que no estan validados
				}
			}
		});
		ingresoBoxCiclica.setForeground(new Color(0, 0, 0));
		ingresoBoxCiclica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ingresoBoxCiclica.setBounds(73, 129, 174, 31);
		contentPane.add(ingresoBoxCiclica);
		ingresoBoxCiclica.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese un numero:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(72, 94, 187, 25);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCalcularCiclica = new JButton("CALCULAR");
		btnCalcularCiclica.setBackground(new Color(204, 204, 255));
		btnCalcularCiclica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = 0;
				int ingresoNum = Integer.parseInt(ingresoBoxCiclica.getText());
				
				Fibonacci fibonacci = new Fibonacci();
				
				//recursivo
				/*fibonacci.validarNumero(ingresoNum);
				
				resultado = fibonacci.fibonacciRecursivo(ingresoNum);*/
				
				//ciclico
				fibonacci.validacionNegativo(ingresoNum);
				
				resultado = fibonacci.fibonacciCiclico(ingresoNum);
		    	System.out.println("El resultado Fibonacci (Ciclico) es: "+ resultado);
		    	String resultadoString = Integer.toString(resultado);
		    	impresionBoxCiclica.setText(resultadoString);
		    	
		    	System.out.println("------ CALCULO DEL TIEMPO DE EJECUCION -------");
		        long startTime, endTime, elapsedTime;
		        // Prueba de tiempo para el método fibonacciCiclico
		        startTime = System.nanoTime();
		        int resultadoCiclico = fibonacci.fibonacciCiclico(ingresoNum);
		        endTime = System.nanoTime();
		        elapsedTime = endTime - startTime;
		        System.out.println("El resultado Fibonacci (Método Cíclico) es: " + resultadoCiclico);
		        System.out.println("Tiempo de ejecución (Método Cíclico): " + elapsedTime + " nanosegundos");
				
		        String tiempoNanosegundo = Long.toString(elapsedTime);
		        TiempoBoxCiclica.setText(tiempoNanosegundo);
			}
		});
		btnCalcularCiclica.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnCalcularCiclica.setBounds(39, 181, 116, 40);
		contentPane.add(btnCalcularCiclica);
		
		impresionBoxCiclica = new JTextField();
		impresionBoxCiclica.setHorizontalAlignment(SwingConstants.CENTER);
		impresionBoxCiclica.setForeground(new Color(0, 0, 0));
		impresionBoxCiclica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		impresionBoxCiclica.setEditable(false);
		impresionBoxCiclica.setColumns(10);
		impresionBoxCiclica.setBounds(73, 276, 174, 31);
		contentPane.add(impresionBoxCiclica);
		
		JButton btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.setBackground(new Color(204, 204, 255));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresoBoxCiclica.setText("");
				impresionBoxCiclica.setText("");
			}
		});
		btnLimpiar.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnLimpiar.setBounds(165, 181, 116, 40);
		contentPane.add(btnLimpiar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Resultado:");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(113, 243, 107, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("\"Calcula el n-ésimo número en la serie de Fibonacci");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.ITALIC, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(240, 416, 251, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("donde cada número después del segundo es la suma");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Arial Narrow", Font.ITALIC, 12));
		lblNewLabel_2_1.setBounds(240, 431, 251, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("de los dos números anteriores.\"");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Arial Narrow", Font.ITALIC, 12));
		lblNewLabel_2_1_1.setBounds(240, 447, 251, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblCiclica = new JLabel("CICLICA");
		lblCiclica.setHorizontalAlignment(SwingConstants.CENTER);
		lblCiclica.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblCiclica.setBounds(84, 50, 143, 40);
		contentPane.add(lblCiclica);
		
		JLabel lblRecursiva = new JLabel("RECURSIVA");
		lblRecursiva.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecursiva.setFont(new Font("Bahnschrift", Font.BOLD, 25));
		lblRecursiva.setBounds(487, 50, 143, 40);
		contentPane.add(lblRecursiva);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ingrese un numero:");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(475, 94, 187, 25);
		contentPane.add(lblNewLabel_1_2);
		
		ingresoBoxRecursiva = new JTextField();
		ingresoBoxRecursiva.setHorizontalAlignment(SwingConstants.CENTER);
		ingresoBoxRecursiva.setForeground(Color.BLACK);
		ingresoBoxRecursiva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ingresoBoxRecursiva.setColumns(10);
		ingresoBoxRecursiva.setBounds(476, 129, 174, 31);
		contentPane.add(ingresoBoxRecursiva);
		
		JButton btnCalcularRecursiva = new JButton("CALCULAR");
		btnCalcularRecursiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resultado = 0;
				int ingresoNum = Integer.parseInt(ingresoBoxRecursiva.getText());
				
				Fibonacci fibonacci = new Fibonacci();
				
				//recursivo
				int numeroValidado = fibonacci.validarNumero(ingresoNum);
				
				if (numeroValidado >= 0) {
		            // Cálculo del resultado Fibonacci solo si el número es no negativo
		            resultado = fibonacci.fibonacciRecursivo(numeroValidado);
		            System.out.println("El resultado Fibonacci (Recursivo) es: " + resultado); // Concatenación
		        }
				
		    	System.out.println("El resultado Fibonacci es: "+ resultado);
		    	String resultadoString = Integer.toString(resultado);
		    	impresionBoxRecursiva.setText(resultadoString);
		    	
		    	// Prueba de tiempo para el método fibonacciRecursivo
		    	long startTime, endTime, elapsedTime;
		        System.out.println("----------------------------------------------------");
		        startTime = System.nanoTime();
		        int resultadoRecursivo = fibonacci.fibonacciRecursivo(numeroValidado);
		        endTime = System.nanoTime();
		        elapsedTime = endTime - startTime;
		        System.out.println("El resultado Fibonacci (Método Recursivo) es: " + resultadoRecursivo);
		        System.out.println("Tiempo de ejecución (Método Recursivo): " + elapsedTime + " nanosegundos");
		    	
		        String tiempoNanosegundo = Long.toString(elapsedTime);
		        TiempoBoxRecursiva.setText(tiempoNanosegundo);
			}
		});
		btnCalcularRecursiva.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnCalcularRecursiva.setBackground(new Color(204, 204, 255));
		btnCalcularRecursiva.setBounds(442, 181, 116, 40);
		contentPane.add(btnCalcularRecursiva);
		
		JButton btnLimpiar_1 = new JButton("LIMPIAR");
		btnLimpiar_1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnLimpiar_1.setBackground(new Color(204, 204, 255));
		btnLimpiar_1.setBounds(568, 181, 116, 40);
		contentPane.add(btnLimpiar_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Resultado:");
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(516, 243, 107, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		impresionBoxRecursiva = new JTextField();
		impresionBoxRecursiva.setHorizontalAlignment(SwingConstants.CENTER);
		impresionBoxRecursiva.setForeground(Color.BLACK);
		impresionBoxRecursiva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		impresionBoxRecursiva.setEditable(false);
		impresionBoxRecursiva.setColumns(10);
		impresionBoxRecursiva.setBounds(476, 276, 174, 31);
		contentPane.add(impresionBoxRecursiva);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Tiempo:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(113, 327, 107, 25);
		contentPane.add(lblNewLabel_1_1_2);
		
		TiempoBoxCiclica = new JTextField();
		TiempoBoxCiclica.setHorizontalAlignment(SwingConstants.CENTER);
		TiempoBoxCiclica.setForeground(Color.BLACK);
		TiempoBoxCiclica.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TiempoBoxCiclica.setEditable(false);
		TiempoBoxCiclica.setColumns(10);
		TiempoBoxCiclica.setBounds(73, 360, 174, 31);
		contentPane.add(TiempoBoxCiclica);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Tiempo:");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_1_1_2_1.setBounds(515, 327, 107, 25);
		contentPane.add(lblNewLabel_1_1_2_1);
		
		TiempoBoxRecursiva = new JTextField();
		TiempoBoxRecursiva.setHorizontalAlignment(SwingConstants.CENTER);
		TiempoBoxRecursiva.setForeground(Color.BLACK);
		TiempoBoxRecursiva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		TiempoBoxRecursiva.setEditable(false);
		TiempoBoxRecursiva.setColumns(10);
		TiempoBoxRecursiva.setBounds(475, 360, 174, 31);
		contentPane.add(TiempoBoxRecursiva);
		
		
	}
}
