package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import modelo.Cliente;
import modelo.Zapatos;

public class ZapatosDAOImpl implements ZapatosDAO {

	private Connection miConnection = null;

	public ZapatosDAOImpl() {

		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_escritorio", "root",
					"jeveris");
		} catch (ClassNotFoundException e) {
			System.out.println("no encuentro el driver-libreria de mysql");
		} catch (SQLException e) {
			System.out.println("error de conexion o la sql esta mal");
		}

	}

	@Override
	public void registrarZapatos(Zapatos c) {
		PreparedStatement ps;
	
		try {
			ps = miConnection.prepareStatement(ConstantesSQL.sqlInsercionZapatos);
			ps.setString(1, c.getCategoria());
			ps.setString(2, c.getTemporada());
			ps.setString(3, c.getTalla());
			ps.setString(4, c.getMaterial());
			ps.setString(5, c.getTipo());
			ps.setString(6, c.getColor());
			ps.setString(7, c.getMarcas());
			ps.execute();
			ps.close();
			System.out.println("Zapato insertado perfectamente");
		} catch (SQLException e) {
			System.out.println("fallo en la sql");
			
		}

	}

	@Override
	public void borrarZapatos(int id) {
		try {
		PreparedStatement ps =miConnection.prepareStatement(ConstantesSQL.sqlBorradoZapatos);
	ps.setInt(1, id);
	ps.execute();
	ps.close();
	
	}catch (SQLException e){
		System.out.println("La SQL de borrardo esta mal");
		System.out.println(e.getMessage());
	}
		
		
	}

	@Override
	public Zapatos[] obtenerZapatos() {
		Zapatos[] zapatos = null;
		try {
			PreparedStatement ps = miConnection
					.prepareStatement(ConstantesSQL.sqlSeleccionZapatos);

			
			ResultSet resultado = ps.executeQuery();
			List<Zapatos> listZapatos = new ArrayList<Zapatos>();
			
			while (resultado.next()) {
				Zapatos c = new Zapatos();
				c.setCategoria(resultado.getString("categoria"));
				c.setTemporada(resultado.getString("temporada"));
				c.setTalla(resultado.getString("talla"));
				c.setMaterial(resultado.getString("material"));
				c.setTipo(resultado.getString("tipo"));
				c.setColor(resultado.getString("color"));
				c.setMarcas(resultado.getString("marcas"));
				
				listZapatos.add(c);
			}
				zapatos = listZapatos.toArray(new Zapatos[listZapatos.size()]);

			} catch (SQLException e) {
				System.out.println("fallo en la sql de seleccion zapatos");
			}
			return zapatos;
		
		}//end obtenerZapatos
	}



