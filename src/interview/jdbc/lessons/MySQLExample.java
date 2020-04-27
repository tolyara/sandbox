package interview.jdbc.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample {
	
	private static final String url = "jdbc:mysql://localhost:3306/myorm?useUnicode=true&serverTimezone=UTC&useSSL=false";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "/!a<ujrN";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		testMySQLdatabase();
	}
	
	private static void testMySQLdatabase() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, username, password);
        
        Statement statement = connection.createStatement();
        
        statement.executeUpdate("insert into worker (worker_id, worker_surname) values (1, 'first')");
        
//        ResultSet resultSet = statement.executeQuery("select * from worker");
//        while (resultSet.next()) {
//            System.out.println("id = " + resultSet.getString("worker_id"));
//            System.out.println("surname = " + resultSet.getString("worker_surname"));
//            System.out.println();
//        }
        
	}

}
