package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.mariadb.jdbc.MySQLDataSource;


public class Main {

	private Connection conn;
	
	public static void main(String[] args) {

		Main provaDb= new Main();
		try {
			//System.out.println(provaDb.getConnection().isClosed());
			//provaDb.esSelect("Tom");
			//provaDb.esInsert("John", "Travolta",65);
			provaDb.esUpdate();
			//provaDb.esDelete();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void esInsert(String nomeAtt, String cognomeAtt, Integer etaAtt) throws SQLException {
		
		String sql="INSERT INTO attore (nomeAttore, cognomeAttore, etaAttore)"
				+ " VALUES('"+nomeAtt+"','"+cognomeAtt+"', '"+etaAtt+"')";
		
		PreparedStatement ps= getConnection().prepareStatement(sql);
		
		
		ps.executeUpdate();
		
		getConnection().close();
	}
	
	private void esUpdate() throws SQLException {
		
		String sql="UPDATE attore SET etaAttore= ? WHERE cognomeAttore= ?";
		
		PreparedStatement ps= getConnection().prepareStatement(sql);
		ps.setInt(1, 68);
		ps.setString(2, "Willis");
		
		ps.executeUpdate();
		
		getConnection().close();
	
	}
	
	private void esDelete() throws SQLException {
		
		String sql="DELETE FROM film WHERE idfilm= 10";
		
		PreparedStatement ps= getConnection().prepareStatement(sql);
		
		ps.executeUpdate();
		
		getConnection().close();
	
	}
	
	private void esSelect(String nomeAttore) throws SQLException {
		
		String sql= "SELECT nomeAttore, cognomeAttore FROM attore WHERE nomeAttore = '"+nomeAttore+"'";
		
		//String sql2="SELECT nomeAttore, cognomeAttore FROM attore WHERE nomeAttore = ?";
		
		PreparedStatement ps= getConnection().prepareStatement(sql);
		
		//ps.setString(1, "Tom");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			
			
			System.out.println("nomeAttore= "+ rs.getString(1));
			System.out.println("cognomeAttore= "+ rs.getString(2));
			/*System.out.println("nomeFilm= "+ rs.getString(3));
			System.out.println("nomeRegista= "+ rs.getString(4));
			System.out.println("cognomeRegista= "+ rs.getString(5));
			System.out.println("anno= "+ rs.getInt(6));
			System.out.println("nomeGenere= "+ rs.getString(7));
			System.out.println("-------------------------------");
			*/
			
			getConnection().close();
		}
		
	}
	
	private Connection getConnection() throws SQLException {
		
		if(conn==null) {
			MySQLDataSource dataSource= new MySQLDataSource();
			dataSource.setDatabaseName("cinema");
			dataSource.setPortNumber(3306);
			dataSource.setServerName("127.0.0.1");
			dataSource.setUser("root");
			dataSource.setPassword("");
			
			conn= dataSource.getConnection();
		}
		
		return conn;
	}

}
