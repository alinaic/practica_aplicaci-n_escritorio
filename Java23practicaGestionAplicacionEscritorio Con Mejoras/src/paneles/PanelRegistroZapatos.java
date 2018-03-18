package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import daos.ClientesDAOImpl;
import daos.ZapatosDAOImpl;
import modelo.Zapatos;

public class PanelRegistroZapatos extends JPanel implements ActionListener {

	JComboBox lista_categoria = new JComboBox();
	ButtonGroup group = new ButtonGroup();
	JRadioButton verano = new JRadioButton("Verano");
	JRadioButton invierno = new JRadioButton("Invierno");
	JRadioButton otono_primavera = new JRadioButton("Otoño-Primavera");
	JPanel radioPanel = new JPanel(new GridLayout(1, 0));
	JTextField campoTalla = new JTextField(30);
	JTextField campoMaterial = new JTextField(30);
	JTextField campoTipo = new JTextField(30);
	JTextField campoColor = new JTextField(30);
	JTextField campoMarcas = new JTextField(30);
	JCheckBox sin_temporada = new JCheckBox();

	public PanelRegistroZapatos() {
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// primer elemento
		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 2;
		gbc.gridwidth = 2;
		this.add(new JLabel("Introduce los datos de tus zapatos perfectos"),
				gbc);
		gbc.gridwidth = 1;
		gbc.weightx = 1;
		
		// segunda fila
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Categoria: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		lista_categoria.addItem("Hombre");
		lista_categoria.addItem("Mujer");
		lista_categoria.addItem("Niños");
		this.add(lista_categoria, gbc);

		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Temporada: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		
		verano.setActionCommand("Verano");
		invierno.setActionCommand("Invierno");
		otono_primavera.setActionCommand("Otoño-Primavera");
		verano.setSelected(true);
        group.add(verano);
        group.add(invierno);
        group.add(otono_primavera);
        radioPanel.add(verano);
        radioPanel.add(invierno);
        radioPanel.add(otono_primavera);
        this.add(radioPanel, gbc);

		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Talla: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoTalla, gbc);

		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("Material: "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoMaterial, gbc);

		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Tipo: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTipo, gbc);

		// septima fila
		gbc.gridy = 6;
		gbc.gridx = 0;
		this.add(new JLabel("Color: "), gbc);
		gbc.gridy = 6;
		gbc.gridx = 1;
		this.add(campoColor, gbc);

		// octava fila
		gbc.gridy = 7;
		gbc.gridx = 0;
		this.add(new JLabel("Marcas: "), gbc);
		gbc.gridy = 7;
		gbc.gridx = 1;
		this.add(campoMarcas, gbc);
		
		// novena fila;
		gbc.gridy = 8;
		gbc.gridx = 0;
		this.add(new JLabel("Fuera de temporada: "), gbc);
		gbc.gridy = 8;
		gbc.gridx = 1;
		this.add(sin_temporada, gbc);

		// decima fila:
		JButton botonRegistroZapatos = new JButton("Registrar");
		botonRegistroZapatos.addActionListener(this);
		gbc.gridy = 9;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroZapatos, gbc);

	}// end PanelRegistroZapatos()

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quiere registrar el zapato?");
		
		if(confirmacion == 0){
			
			System.out.println("actionPerformed del PanelRegistroZapatos");
			String categoria = lista_categoria.getSelectedItem().toString();
			String temporada = "";
			if(sin_temporada.isSelected()){
				temporada = "Fuera de Temporada";
			} else {
				
				if(verano.isSelected()){
					temporada = "Verano";
		        }
		        else if(invierno.isSelected()){
		        	temporada = "Invierno";
		        } else if(otono_primavera.isSelected()){
		        	temporada = "Otoño-Primavera";
		        }
			}
			
			String talla = campoTalla.getText();
			String material = campoMaterial.getText();
			String tipo = campoTipo.getText();
			String color = campoColor.getText();
			String marcas = campoMarcas.getText();

			Zapatos zapatosAregistrar = new Zapatos(categoria, temporada, talla,
					material, tipo, color, marcas);

			System.out.println("voy a registrar: " + zapatosAregistrar.toString());
			
			ZapatosDAOImpl zapatosDAO = new ZapatosDAOImpl();
			zapatosDAO.registrarZapatos(zapatosAregistrar);
			
			lista_categoria.setSelectedItem("Hombre");
			verano.setSelected(true);
			campoTalla.setText("");
			campoMaterial.setText("");
			campoTipo.setText("");
			campoColor.setText("");
			campoMarcas.setText("");			
		}
	}
}// end class

