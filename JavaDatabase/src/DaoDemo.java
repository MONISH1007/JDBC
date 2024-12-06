import java.sql.*;

public class DaoDemo {
	
	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();
		Student s1 = new Student();
		//System.out.println(s1.sname);
		s1.rollno = 15;
		s1.sname = "Maran";
		dao.connect();
		dao.addStudent(s1);
	}
} 

class StudentDAO{

	Connection con = null;
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/krish", "root", "password");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public  Student getStudent(int rollno) {
		
		try {
			String query = "select sname from jdbc where rollno="+rollno;
			Student s = new Student();
			s.rollno = rollno;
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			s.sname = name;
			return s;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void addStudent(Student s) {
		String query = "insert into jdbc values (?,?)";
		PreparedStatement pst;
		try {
			pst = con.prepareStatement(query);
			pst.setInt(1, s.rollno);
			pst.setString(2, s.sname);
			pst.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class Student{
	int rollno;
	String sname;
}