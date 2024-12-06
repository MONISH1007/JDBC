import java.sql.*;

public class Demo {

	public static void main(String[] args) throws Exception{
		String url = "jdbc:mysql://localhost:3306/krish";
		String uname = "root";
		String pass = "password";
		String query = "select * from student"; 
		
		Class.forName("com.mysql.cj.jdbc.Driver");  // not necessary in recent version
		Connection con = DriverManager.getConnection(url, uname, pass);  
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		String userdata = "";
		
		while(rs.next()) {
			userdata = rs.getInt(1) + " : " + rs.getString(2);
			System.out.println(userdata);
		}
		
		st.close();
		con.close();
	}
}
