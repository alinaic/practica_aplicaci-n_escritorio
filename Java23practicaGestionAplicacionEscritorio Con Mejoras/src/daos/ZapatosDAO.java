package daos;

import modelo.Zapatos;

public interface ZapatosDAO {

	void registrarZapatos(Zapatos c);

	void borrarZapatos(int id);

	Zapatos[] obtenerZapatos();

	

}// end class
