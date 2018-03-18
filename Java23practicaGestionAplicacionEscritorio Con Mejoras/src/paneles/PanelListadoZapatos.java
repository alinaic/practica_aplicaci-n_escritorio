package paneles;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import modelo.Cliente;
import modelo.Zapatos;
import daos.ClientesDAO;
import daos.ClientesDAOImpl;
import daos.ZapatosDAO;
import daos.ZapatosDAOImpl;
import tableModels.TableModelZapatos;

public class PanelListadoZapatos extends JPanel implements ActionListener {

	private ZapatosDAO daoZapatos = new ZapatosDAOImpl();
	private Zapatos[] zapatos;
	JTable tabla;
	JButton botonBorrar = new JButton("BORRAR");

	public PanelListadoZapatos() {

		this.add(new JLabel("Soy el panel de listado de zapatos"));
	}

	public void refrescarZapatos() {
		this.zapatos = daoZapatos.obtenerZapatos();
		tabla = new JTable(new TableModelZapatos(zapatos));
		tabla.setPreferredScrollableViewportSize(new Dimension(700, 400));
		tabla.setFillsViewportHeight(true);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(tabla);
		this.removeAll();
		this.add(botonBorrar);
		this.add(scrollPane);
		botonBorrar.addActionListener(this);

	}// refrescarZapatos

	@Override
	public void actionPerformed(ActionEvent e) {

		if (tabla.getSelectedRow() == -1) {
			return;
		}
		
		int confirmacion = JOptionPane.showConfirmDialog(null, 
				"¿Esta seguro de que quiere borrar el zapato?");
		if(confirmacion == 0){
		
			JOptionPane.showMessageDialog(null,
					"borrar: " + zapatos[tabla.getSelectedRow()].toString());
			System.out.println("Linea: " + tabla.getSelectedRow());
			System.out.println("Id: " + zapatos[tabla.getSelectedRow()].getId());
			daoZapatos.borrarZapatos(zapatos[tabla.getSelectedRow()].getId());
			refrescarZapatos();
			SwingUtilities.updateComponentTreeUI(this);
		}
	}

}// end class
