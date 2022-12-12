package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Coche;
import pojo.Marca;

public class CocheDao extends ObjetoDao implements Dao<Coche> {
	
	private static Connection connection;

	@Override
	public void insertar(Coche t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		String query1="ALTER TABLE coche AUTO_INCREMENT = 1";
		String query2="SET SQL_SAFE_UPDATES = 0";
		String query = "insert into coche (modelo,potenciaHP,anoLanzamiento,nVelocidades,id_marca)"
				+ "values (?,?,?,?,?)";
		try {
			PreparedStatement ps = connection.prepareStatement(query1);
			PreparedStatement ps1 = connection.prepareStatement(query2);
			PreparedStatement ps2 = connection.prepareStatement(query);
			ps2.setString(1, t.getModelo());
			ps2.setInt(2, t.getPotenciaHP());
			ps2.setInt(3, t.getAnoLanzamiento());
			ps2.setInt(4, t.getnVelocidades());
			ps2.setInt(5, t.getId_marca());
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
	public void modificar(Coche t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		String query = "update coche set modelo=?,potenciaHP=?,anoLanzamiento=?,nVelocidades=?,id_marca=? "
		+"where id=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, t.getModelo());	
			ps.setInt(2, t.getPotenciaHP());
			ps.setInt(3, t.getAnoLanzamiento());
			ps.setInt(4, t.getnVelocidades());
			ps.setInt(5, t.getId_marca());
			ps.setInt(6, t.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeConnection();
	}

	@Override
	public void borrar(Coche t) {
		// TODO Auto-generated method stub
		connection = openConnection();
		
		int id = t.getId();
		
		String query = "delete from coche where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ps.execute();
		}catch (SQLException e){
			
		}
		closeConnection();
	}

	@Override
	public ArrayList<Coche> buscarTodos() {
		// TODO Auto-generated method stub
		ArrayList<Coche> coches = new ArrayList<Coche>();
		connection = openConnection();
		String query = "select * from coche";
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ResultSet r = ps.executeQuery();
			
			while(r.next()) {
				Coche coche = new Coche(
						r.getInt("id"),
						r.getString("modelo"),
						r.getInt("potenciaHP"),
						r.getInt("anoLanzamiento"),
						r.getInt("nVelocidades"),
						r.getInt("id_marca"));
				coches.add(coche);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return coches;
		
	}

	@Override
	public Coche buscarPorId(int id) {
		// TODO Auto-generated method stub
		connection = openConnection();
		Coche c= null;
		
		String query = "select * from coche where id = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet r = ps.executeQuery();
			while(r.next()) {
				 c = new Coche(
						r.getInt("id"),
						r.getString("modelo"),
						r.getInt("potenciaHP"),
						r.getInt("anoLanzamiento"),
						r.getInt("nVelocidades"),
						r.getInt("id_marca"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
		return c;
	}
	
	

}
