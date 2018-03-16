package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Cliente;

public class ClientesDAOImpl implements ClientesDAO {

	private Connection miConnection = null;

	public ClientesDAOImpl() {

		// preparo drive y conexion

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
	public void registrarCliente(Cliente c) {

		String sqlInsercionCliente = "insert into tabla_clientes(nombre, domicilio, poblacion, codigo_postal, telefono) "
				+ "values ( ?, ?, ?,?,?);";
		PreparedStatement ps;
		try {
			ps = miConnection.prepareStatement(sqlInsercionCliente);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getDomicilio());
			ps.setString(3, c.getPoblacion());
			ps.setString(4, c.getCodigoPostal());
			ps.setString(5, c.getTelefono());

			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("erron en la sql");
		}

		System.out.println("cliente insertado correctamente");

	}

	@Override
	public void borrarCliente(int id) {

	}

	@Override
	public Cliente[] obtenerClientes() {

		return null;
	}

}
