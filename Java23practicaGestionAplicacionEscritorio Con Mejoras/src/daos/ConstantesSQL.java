package daos;

public class ConstantesSQL {

	final static String sqlInsercionZapatos = "insert into tienda_zapatos"
			+ "(categoria, temporada, talla, material,tipo, color, marcas )"
			+ "value(?, ?, ?, ?, ?, ?, ?)";

	final static String sqlSeleccionZapatos = "select * from tienda_zapatos";
	final static String sqlBorradoZapatos = "delete from tienda_zapatos where id=? ";
}
