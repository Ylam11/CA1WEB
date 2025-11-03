import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CA1 {

	public CA1() throws Exception{

		Connection connection;
		connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/CA1?serverTimezone=UTC","root", "root");
		
		PreparedStatement createWord = connection.prepareStatement(
				"INSERT INTO CA1 "
				 + "(GamerTag, password, credits)" +" VALUES (?, ?,?)");
				//pass in the values as parameters
				createWord.setString(1, "user123");
				createWord.setString(2, "secret");
				createWord.setInt(3, 500);
				int rowsUpdated = createWord.executeUpdate();
				createWord.close();
		
				
				//GET SOMETHING OUT OF THE DATABASE	USING A STATEMENT
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM CA1");
				
			while(rs.next()) {
				System.out.println("Column 1 in ResultSet : "+rs.getString(1));
				System.out.println("Column 2 in ResultSet : "+rs.getString(2));
				System.out.println("Column 3 in ResultSet : "+rs.getInt(3));
			}
			
	}
	public static void main(String[] args) throws Exception {
		new CA1();
	}}


