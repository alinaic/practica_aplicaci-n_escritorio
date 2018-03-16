package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import paneles.PanelListadoClientes;
import paneles.PanelListadoZapatos;
import paneles.PanelRegistroCliente;
import paneles.PanelRegistroZapatos;

public class VentanaPrincipal extends JFrame implements ActionListener {

	// paneles de la ventana:

	private PanelRegistroCliente panelRegistroCliente = new PanelRegistroCliente();
	private PanelListadoClientes panelListadoClientes = new PanelListadoClientes();
	private PanelRegistroZapatos panelRegistroZapatos = new PanelRegistroZapatos();
	private PanelListadoZapatos panelListadoZapatos = new PanelListadoZapatos();

	// barra de menu:
	private JMenuBar barraDeMenu = new JMenuBar();
	private JMenu menuClientes = new JMenu("Clientes");
	private JMenu menuAyuda = new JMenu("Ayuda");
	private JMenu menuZapatos = new JMenu("Zapatos");

	public VentanaPrincipal() {

		// preparar la barra de menu:

		JMenuItem clientesInsertar = new JMenuItem("Insertar Cliente");
		JMenuItem clientesListar = new JMenuItem("Listar Clientes");
		JMenuItem zapatosInsertar = new JMenuItem("Insertar zapatos");
		JMenuItem zapatosListar = new JMenuItem("Listar zapatos");

		menuClientes.add(clientesInsertar);
		menuClientes.add(clientesListar);
		menuZapatos.add(zapatosInsertar);
		menuZapatos.add(zapatosListar);

		barraDeMenu.add(menuClientes);
		barraDeMenu.add(menuAyuda);
		barraDeMenu.add(menuZapatos);

		this.setJMenuBar(barraDeMenu);

		// voy a decir a las opciones de menu, quien las va a atender
		// cuando se las haga un click

		clientesInsertar.addActionListener(this);
		clientesListar.addActionListener(this);
		zapatosInsertar.addActionListener(this);
		zapatosListar.addActionListener(this);

		// preparacion de la ventana principal

		this.setSize(800, 600);
		this.setLocation(50, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// vamos a decir que cuanod arranque esta ventana
		// se muestre el panel de registro cliente
		
		
		PanelRegistroZapatos panelVentana = panelRegistroZapatos;
		this.add(panelVentana);

		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		System.out.println("atiendo a: " + e.getActionCommand());

		if (e.getActionCommand().equals("Insertar zapatos")) {

			setContentPane(panelRegistroZapatos);

		} else if (e.getActionCommand().equals("Listar zapatos")) {

			setContentPane(panelListadoZapatos);
			panelListadoZapatos.refrescarZapatos();
		}
		SwingUtilities.updateComponentTreeUI(this);
	}

}
