import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.*;

public class Demo2 {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/krish";
		String uname = "root";
		String pass = "password";
		int student_id = 7;
		String name = "Logu";
		String major = "English";
		String query = "insert into student values(?,?,?)"; 
		
		Class.forName("com.mysql.cj.jdbc.Driver");  // not necessary in recent version
		Connection con = DriverManager.getConnection(url, uname, pass);  
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,  student_id);
		st.setString(2,  name);
		st.setString(3,  major);
		int count = st.executeUpdate();
		
		System.out.println(count + " row/s affected");
		
		
		st.close();
		con.close();
	}
}
