package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;
import modelo.Zapatos;

public class TableModelZapatos extends AbstractTableModel {

	private String[] columnas = { "categoria", "temporada", "talla",
			"material", "tipo", "color", "marcas" };
	private String[][] datos = null;

	public TableModelZapatos(Zapatos[] zapatos) {
		
		datos = new String[zapatos.length][columnas.length];
		for (int i = 0; i < zapatos.length; i++) {
			Zapatos c = zapatos[i];
			datos[i][0] = c.getCategoria();
			datos[i][1] = c.getTemporada();
			datos[i][2] = c.getTalla();
			datos[i][3] = c.getMaterial();
			datos[i][4] = c.getTipo();
			datos[i][5] = c.getColor();
			datos[i][6] = c.getMarcas();
		}
	}// end TableModeloClientes

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int IndiceFila, int IndiceColumna) {
		return datos[IndiceFila][IndiceColumna];
	}

}// end class
