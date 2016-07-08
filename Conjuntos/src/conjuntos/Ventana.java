package conjuntos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana extends JFrame{
	Conjunto conjunto = new Conjunto();
	
	public void run(){
		JLabel lblAbreA = new JLabel("A = {");
		JLabel lblAbreB = new JLabel("B = {");
		JLabel lblCierraA = new JLabel("}");
		JLabel lblCierraB = new JLabel("}");
		JLabel lblA = new JLabel("A");
		JLabel lblB = new JLabel("B");
		JLabel lblResultado = new JLabel("Resultado:");
		JTextField txtConjuntoA = new JTextField();
		JTextField txtConjuntoB = new JTextField();
		JButton btnGuardarA = new JButton("Guardar A");
		JButton btnGuardarB = new JButton("Guardar B");
		JButton btnUnion = new JButton("A U B");
		JButton btnInterseccion = new JButton("A ∩ B");
		JButton btnDiferencia = new JButton("A - B");
		JButton btnLimpiar = new JButton("Limpiar");
		JTextArea areaA = new JTextArea();
		JTextArea areaB = new JTextArea();
		JTextArea areaResultado = new JTextArea();
		
		lblAbreA.setBounds(10, 10, 30, 20);
		lblAbreB.setBounds(10, 40, 30, 20);
		txtConjuntoA.setBounds(50, 10, 200, 20);
		txtConjuntoB.setBounds(50, 40, 200, 20);
		lblCierraA.setBounds(260, 10, 10, 20);
		lblCierraB.setBounds(260, 40, 10, 20);
		btnGuardarA.setBounds(280, 10, 100, 20);
		btnGuardarB.setBounds(280, 40, 100, 20);
		btnLimpiar.setBounds(390, 10, 80, 20);
		lblA.setBounds(50, 80, 20, 20);
		lblB.setBounds(170, 80, 20, 20);
		lblResultado.setBounds(370, 80, 100, 20);
		areaA.setBounds(10, 110, 100, 150);
		areaB.setBounds(130, 110, 100, 150);
		btnUnion.setBounds(250, 120, 100, 30);
		btnInterseccion.setBounds(250, 170, 100, 30);
		btnDiferencia.setBounds(250, 220, 100, 30);
		areaResultado.setBounds(370, 110, 100, 150);
		
		add(lblAbreA);
		add(lblAbreB);
		add(txtConjuntoA);
		add(txtConjuntoB);
		add(lblCierraA);
		add(lblCierraB);
		add(btnGuardarA);
		add(btnGuardarB);
		add(btnLimpiar);
		add(lblA);
		add(lblB);
		add(lblResultado);
		add(areaA);
		add(areaB);
		add(btnUnion);
		add(btnInterseccion);
		add(btnDiferencia);
		add(areaResultado);
		
		setLayout(null);
		setTitle("Operaciones con Conjuntos");		
		setResizable(false);
		setSize(500, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		btnGuardarA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaA.setText("");
				
				conjunto.llenarA(txtConjuntoA.getText());
				
				for(int i = 0; i < conjunto.getTamA(); i++){
					areaA.append(conjunto.getElementoA(i) + "\n");
				}
			}
		});
		
		btnGuardarB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaB.setText("");
				
				conjunto.llenarB(txtConjuntoB.getText());
				
				for(int i = 0; i < conjunto.getTamB(); i++){
					areaB.append(conjunto.getElementoB(i) + "\n");
				}
			}
		});
		
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtConjuntoA.setText("");
				txtConjuntoB.setText("");
				areaA.setText("");
				areaB.setText("");
				areaResultado.setText("");
				lblResultado.setText("Resultado:");
				conjunto.limpiarConjuntos();
			}
		});
		
		btnUnion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaResultado.setText("");
				
				conjunto.union();
				
				for(int i = 0; i < conjunto.getTamAB(); i++){
					if(!conjunto.getElementoAB(i).equals("null")){
						areaResultado.append(conjunto.getElementoAB(i) + "\n");
					}
				}
				
				lblResultado.setText("Resultado: " + btnUnion.getText());
			}
		});
		
		btnInterseccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaResultado.setText("");
				
				conjunto.interseccion();
				
				for(int i = 0; i < conjunto.getTamAB(); i++){
					if(!conjunto.getElementoAB(i).equals("null")){
						areaResultado.append(conjunto.getElementoAB(i) + "\n");
					}
				}
				
				lblResultado.setText("Resultado: " + btnInterseccion.getText());
			}
		});
		
		btnDiferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				areaResultado.setText("");
				
				conjunto.diferencia();
				
				for(int i = 0; i < conjunto.getTamAB(); i++){
					if(!conjunto.getElementoAB(i).equals("null")){
						areaResultado.append(conjunto.getElementoAB(i) + "\n");
					}
				}
				
				lblResultado.setText("Resultado: " + btnDiferencia.getText());
			}
		});
	}
}