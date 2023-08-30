package bank.management.system;

import java.sql.*;
public class Conn {
	Connection c;
	Statement s;
	Conn(){
		//Class.forName(com.mysql.cj.jdbc.Driver);  ----->No need to register driver Bydefaul it will pick jar file 
														//from classpath
		try {
		c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Mukesh@1234");
		s=c.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
