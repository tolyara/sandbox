package interview.jdbc.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteExample {
	
	private static final String urlViber = "jdbc:sqlite:viber.db";
	private static final String driver = "org.sqlite.JDBC";
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		connectToViberContacts();
	}
	
	private static void test() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
        Statement stat = conn.createStatement();
        stat.executeUpdate("drop table if exists people;");
        stat.executeUpdate("create table people (name, occupation);");
        PreparedStatement prep = conn.prepareStatement(
            "insert into people values (?, ?);");

        prep.setString(1, "Gandhi");
        prep.setString(2, "politics");
        prep.addBatch();
        prep.setString(1, "Turing");
        prep.setString(2, "computers");
        prep.addBatch();
        prep.setString(1, "Wittgenstein");
        prep.setString(2, "smartypants");
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        ResultSet rs = stat.executeQuery("select * from people;");
        while (rs.next()) {
            System.out.println("name = " + rs.getString("name"));
            System.out.println("job = " + rs.getString("occupation"));
        }
        rs.close();
        conn.close();
	}
	
	private static void connectToViberContacts() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
        Connection connection = DriverManager.getConnection(urlViber);
        
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Contact order by Name");
        while (resultSet.next()) {
            System.out.println("name = " + resultSet.getString("Name"));
            System.out.println("number = " + resultSet.getString("Number"));
            System.out.println("EncryptedMID = " + resultSet.getString("EncryptedMID"));
            System.out.println();
        }
        
	}

}
