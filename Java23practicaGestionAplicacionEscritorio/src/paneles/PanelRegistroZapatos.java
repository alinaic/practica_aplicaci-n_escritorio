package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import daos.ZapatosDAOImpl;
import modelo.Zapatos;

public class PanelRegistroZapatos extends JPanel implements ActionListener {

	JTextField campoCategoria = new JTextField(30);
	JTextField campoTemporada = new JTextField(30);
	JTextField campoTalla = new JTextField(30);
	JTextField campoMaterial = new JTextField(30);
	JTextField campoTipo = new JTextField(30);
	JTextField campoColor = new JTextField(30);
	JTextField campoMarcas = new JTextField(30);

	public PanelRegistroZapatos() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// primer elemento:

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 2;
		this.add(new JLabel("Introduce los datos de tus zapatos perfectos"),
				gbc);
		gbc.weightx = 1;

		// segunda fila
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Categoria: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoCategoria, gbc);

		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Temporada: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoTemporada, gbc);

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

		// septima fila:
		JButton botonRegistroZapatos = new JButton("Registrar");
		botonRegistroZapatos.addActionListener(this);
		gbc.gridy = 8;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroZapatos, gbc);

	}// end PanelRegistroZapatos()

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("actionPerformed del PanelRegistroZapatos");
		String categoria = campoCategoria.getText();
		String temporada = campoTemporada.getText();
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
	}
}// end class

