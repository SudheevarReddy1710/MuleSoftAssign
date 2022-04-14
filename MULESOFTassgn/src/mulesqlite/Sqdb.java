package mulesqlite;
import java.sql.*;
public class Sqdb {
	final String INSERT = "INSERT INTO movieshere(movie_name,actor_name,actress_name,release_year) values (?,?,?,?)";
	final String SELECT = "Select * from movieshere";
	final String CREATE = "create table movieshere(move_id INTEGER PRIMARY KEY AUTOINCREMENT,movie_name varchar(200), actor_name varchar(200), actress_name varchar(200),release_year int(4))";
	final String UPDATE = "update movieshere set release_year=? where move_id=?";
	
	//Method that returns the Connection of database to the MainFrame
	public Connection Connection() throws Exception {
		// TODO Auto-generated method stub
			Connection c =null;
			try
			{
				Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sudhe\\databases\\MovieList.db");
				System.out.println("Done Connection");
				return c;
			}
			catch(Exception e)
			{
				System.out.println(e);
				return c;
			}
	}
	
	//Method to create a table inside the Database
	
	
	public void CreateTable(Connection c)
	{
		try {
			Statement st = c.createStatement();
			st.executeUpdate(CREATE);
			System.out.println("Table Created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + " INVALID");
		}
	}
	
	
	
	//Method to Insert Values into the table
	
	public void Insert(String Name,String actor,String actress, int year,Connection c)
	{
		try {
			PreparedStatement stm = c.prepareStatement(INSERT);
			stm.setString(1, Name);
			stm.setString(2, actor);
			stm.setString(3, actress);
			stm.setInt(4, year);
			stm.executeUpdate();
			System.out.println("Values inserted");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e + " INVALID");
		}
	}
	
	
	
	//Method to retrieving the whole data in the tables
	
	public void show(Connection c)
	{
		
		try {
			Statement stm = c.createStatement();
			ResultSet set = stm.executeQuery(SELECT);
			System.out.println("id \tmovie_name\t actor_name\t actress_name \tyear");
			
			while(set.next()) {
				int id = set.getInt(1);
				String  movie_name = set.getString(2);
				String actor_name = set.getString(3);
				String actress_name = set.getString(4);
				
				int year = set.getInt(5);
				
				System.out.println(id+"\t"+movie_name+"\t"+actor_name+"\t"+actress_name+"\t"+"\t"+year);
			
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Method to update values
	
	public void UpdateTable(Connection c,int year,int id)
	{
		PreparedStatement stm;
		try {
			stm = c.prepareStatement(UPDATE);
			stm.setInt(1, year);
			stm.setInt(2, id);
			stm.executeUpdate();
			System.out.println("Values Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
}
	
	
	
	
	
	
	
	
	
	

