package interview.jdbc.lessons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionIsolationLevels {

	// Solving dirty-read problem
	static void levelReadCommited(Connection connection) throws SQLException, InterruptedException {
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

		Statement statement = connection.createStatement();
		statement.executeUpdate("update books set name = 'new value' where id = 1");

		Thread.sleep(100);
		new OtherTransaction().start();
		Thread.sleep(400);
		connection.rollback();
	}

	// Solving non-repeatable read problem
	static void levelRepeatableRead(Connection connection) throws SQLException, InterruptedException {
		connection.setAutoCommit(false);
//		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from books;");
		while (resultSet.next()) {
			System.out.println("book id = " + resultSet.getInt("id"));
			System.out.println("book name = " + resultSet.getString("name"));
			System.out.println("-----------------------");
		}

		System.out.println("***********************************************************");
		new OtherTransaction2().start();
		Thread.sleep(1000);

		ResultSet resultSet2 = statement.executeQuery("select * from books;");
		while (resultSet2.next()) {
			System.out.println("book id = " + resultSet2.getInt("id"));
			System.out.println("book name = " + resultSet2.getString("name"));
			System.out.println("-----------------------");
		}

	}

	// Solving phantom reads problem
	static void levelSerializable(Connection connection) throws SQLException, InterruptedException {
		connection.setAutoCommit(false);
//		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select count(*) from books;");
		while (resultSet.next()) {
			System.out.println("books count = " + resultSet.getInt(1));
		}

		System.out.println("***********************************************************");
		new OtherTransaction3().start();
		Thread.sleep(1000);

		ResultSet resultSet2 = statement.executeQuery("select count(*) from books;");
		while (resultSet2.next()) {
			System.out.println("books count = " + resultSet2.getInt(1));
		}

	}

}

class OtherTransaction extends Thread {

	@Override
	public void run() {
		try {
			Connection connection = DriverManager.getConnection(FirstConnection.url, FirstConnection.username,
					FirstConnection.password);
			connection.setAutoCommit(false);
			connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
//			connection.commit();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from books");
			while (resultSet.next()) {
				System.out.println("book id = " + resultSet.getInt("id"));
				System.out.println("book name = " + resultSet.getString("name"));
				System.out.println("-----------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

class OtherTransaction2 extends Thread {

	@Override
	public void run() {
		try {
			Connection connection = DriverManager.getConnection(FirstConnection.url, FirstConnection.username,
					FirstConnection.password);
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement();
			statement.executeUpdate("update books set name = 'new value' where id = 1");
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

class OtherTransaction3 extends Thread {

	@Override
	public void run() {
		try {
			Connection connection = DriverManager.getConnection(FirstConnection.url, FirstConnection.username,
					FirstConnection.password);
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into books (name) values ('new value')");
			connection.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
