package com.tiendas.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.tiendas.models.Collar;
import com.tiendas.models.Tienda;

@Repository
public class DataBaseJDBC {
	private Connection connection;
	
	List<Tienda> tiendas = new ArrayList<Tienda>();
	public DataBaseJDBC() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String connect= "jdbc:mysql://localhost:3306/white_collar";
			this.connection= DriverManager.getConnection(connect,"root","");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String crearTienda(Tienda tienda) {
		String query ="INSERT INTO tiendas (name, capacidadMaxima)"+ "VALUES (?, ?)";
		
		PreparedStatement preparedQuery;
		try {
			preparedQuery= connection.prepareStatement(query);
			preparedQuery.setString(1, tienda.getName());
			preparedQuery.setInt(2, tienda.getCapacidadMaxima());
			preparedQuery.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Tienda creada correctamente";
	}
	
	public void crearCollar(Collar collar) {
		String query ="INSERT INTO collares (name, author)"+ "VALUES (?, ?)";
		
		PreparedStatement preparedQuery;
		try {
			preparedQuery= connection.prepareStatement(query);
			preparedQuery.setString(1, collar.getName());
			preparedQuery.setString(2, collar.getAuthor());
			preparedQuery.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void crearCollarConFK(Collar collar, int tienda_id) {
		String query ="INSERT INTO collares (name, author, tienda_id)"+ "VALUES (?, ?, ?)";
		
		PreparedStatement preparedQuery;
		try {
			preparedQuery= connection.prepareStatement(query);
			preparedQuery.setString(1, collar.getName());
			preparedQuery.setString(2, collar.getAuthor());
			preparedQuery.setInt(3, tienda_id);
			preparedQuery.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	public void deleteTienda(int id) {
		String query= "DELETE FROM TIENDAs WHERE id="+id;
		try {
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void incendiarCuadros(int id) {
		String query= "DELETE FROM Collares WHERE tienda_id="+id;
		try {
			PreparedStatement prepared = connection.prepareStatement(query);
			prepared.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public ArrayList<Tienda> getTiendas(){
		ArrayList<Tienda> tiendas = new ArrayList<Tienda>();
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM tiendas";
			s.execute(query);
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Tienda tienda= new Tienda(results.getInt(1), results.getString(2), results.getInt(3));
					
				tiendas.add(tienda);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tiendas;
		
	}
	
	public Tienda getTienda(int id) {
		Tienda tienda = null;
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM Tiendas WHERE ID="+ id;
			s.execute(query);
			ResultSet results = s.getResultSet();
			results.next();
			tienda = new Tienda(results.getInt(1),results.getString(2), results.getInt(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tienda;
		
	}
	
	public Collar getCollar(int id) {
		Collar collar = null;
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM Collares WHERE ID="+ id;
			s.execute(query);
			ResultSet results = s.getResultSet();
			results.next();
			collar = new Collar(results.getInt(1),results.getString(2), results.getString(3), results.getDouble(6), results.getDate(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collar;
		
	}
	
	
	public List<Collar> getCollares() {
		List<Collar> collares = new ArrayList<Collar>();
		
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM Collares";
			s.execute(query);
			ResultSet results = s.getResultSet();
			results.next();
			while (results.next()) {
				Collar collar = new Collar(results.getInt(1),results.getString(2), results.getString(3), results.getDouble(6), results.getDate(4));
					
				collares.add(collar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collares;
		
	}
	
	
	
	
	
	
	
	
	
	public ArrayList<Collar> searchByTiendaId(@PathVariable Integer id) {
		List<Collar> collares = new ArrayList<Collar>();
		try {
			Statement s;
			s = connection.createStatement();
			String query="SELECT * FROM Collares WHERE tienda_id="+id;
			s.execute(query);
			ResultSet results = s.getResultSet();
			while (results.next()) {
				Collar collar= new Collar(results.getInt(1),results.getString(2), results.getString(3), results.getDouble(6), results.getDate(4));
						collares.add(collar);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ArrayList<Collar>) collares;
		
	}
	
	public void modify(Tienda tienda) {
		String query ="UPDATE Tiendas SET name=?, capacidadMaxima=?, "+ " WHERE id=?";
		
		PreparedStatement preparedQuery;
		try {
			preparedQuery= connection.prepareStatement(query);
			
			preparedQuery.setString(2, tienda.getName());
			preparedQuery.setInt(3, tienda.getCapacidadMaxima());
			preparedQuery.setInt(1, tienda.getId());
			System.out.println(preparedQuery);
			preparedQuery.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
