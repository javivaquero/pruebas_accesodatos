package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Marca;

public class MarcaDao extends ObjetoDao implements Dao<Marca> {
	private static Connection connection;
	
	@Override
	public void insertar(Marca marca) {
		// TODO Auto-generated method stub
		connection = openConnection();
		String query1="ALTER TABLE marca AUTO_INCREMENT = 1";
		String query2="SET SQL_SAFE_UPDATES = 0";
		String query = "insert into marca (nombre)"
				+ "values (?)";
		try {
			
			PreparedStatement ps = connection.prepareStatement(query1);
			PreparedStatement ps1 = connection.prepareStatement(query2);
			PreparedStatement ps2 = connection.prepareStatement(query);
			ps2.setString(1, marca.getNombre());
			ps.executeUpdate();
			ps1.executeUpdate();
			ps2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void modificar(Marca marca) {
		// TODO Auto-generated method stub

		connection = openConnection();
		
		String query = "update marca set nombre=?"
		+"where id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, marca.getNombre());		
			ps.setInt(2, marca.getId());			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}
	
	public void borrarTodo() {
		connection = openConnection();
		
		String query ="delete from marca";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void borrar(Marca marca) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		int id = marca.getId();
		
		String query = "delete from marca where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
		}catch (SQLException e){
			
		}
		closeConnection();
	}

	@Override
	public ArrayList<Marca> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Marca> marcas = new ArrayList<Marca>();
		connection = openConnection();
		String query = "select * from marca";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			
			while(r.next()) {
				Marca marca = new Marca(
						r.getInt("id"),
						r.getString("nombre"));
				marcas.add(marca);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return marcas;
	}

	@Override
	public Marca buscarPorId(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();
		Marca m= null;
		
		String query = "select * from marca where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				m=new Marca(
						r.getInt("id"),
						r.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		return m;
	}

	
	
}
