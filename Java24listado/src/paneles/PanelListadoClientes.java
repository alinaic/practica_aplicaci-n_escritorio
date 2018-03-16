package paneles;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tableModels.TableModelClientes;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelListadoClientes extends JPanel {

	private ClientesDAO daoClientes = new ClientesDAOImpl();
	private Cliente[] clientes;

	public PanelListadoClientes() {

		this.add(new JLabel("Soy el panel de listado del cliente"));

	}// end PanelListadoClienetes

	public void refrescarClientes() {
		this.clientes = daoClientes.obtenerClientes();
		JTable tabla = new JTable(new TableModelClientes(clientes));
		//en vez de agregar tabla agregar la JScroollBar
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		tabla.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll();//quito todo lo que tuviera antes dentro del panel
		this.add(scrollPane);
		
		

	}// refrescarClientes

}// end class

