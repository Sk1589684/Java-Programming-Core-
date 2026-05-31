package Test_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcEx {

	public static void main(String[] args) {

		try {

			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create Connection
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employee?useSSL=false&allowPublicKeyRetrieval=true",
					"root",
					"MySql@123");

			System.out.println("Connection Successful");

			// Create Statement
			Statement st = con.createStatement();

			// Insert Query
			String query = "delete from emp where id=103";
			String query1="update emp set name='Sarvesh' where id=102";
			
//			String query1 = "insert into std1 values('MNO','MNO123')";
//			String query2 = "insert into std1 values('PQR','PQR123')";

			st.executeUpdate(query);

			System.out.println("Data Inserted");

			// Close Connection
			con.close();

		} catch (Exception e) {

			System.out.println(e);

		}

	}

}