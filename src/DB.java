
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DB { 
	
	Connection conndb=null;
	Statement statedb=null;
	
	String ID;
	String PW;
	String dob;
	String sex;
	String email;
	String name;
	String pnum;
	String nick;
	String home;
	String cmail;
	
	void DBLogin() {
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conndb = DriverManager.getConnection("jdbc:mysql://localhost:3306/site?characterEncoding=utf8", "root", "9697aa");
		statedb = conndb.createStatement();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}