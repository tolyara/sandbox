package interview.jdbc.lessons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class FirstConnection {

	static final String url = "jdbc:postgresql://127.0.0.1:5432/test";
	static final String username = "postgres";
	static final String password = "123321";
	static final String driver = "org.postgresql.Driver";

	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		connectToDB();
	}

	static void connectToDB() throws ClassNotFoundException, IOException, InterruptedException {
		Class.forName(driver);
		try (Connection connection = DriverManager.getConnection(url, username, password);
				Statement statement = connection.createStatement()) {
			statement.executeUpdate("drop table if exists books");
			statement.executeUpdate(
					"create table if not exists books (id serial primary key, name varchar(255) not null, release_date date)");
			statement.executeUpdate("insert into books (name) values ('Inferno')");
			statement.executeUpdate("insert into books (name) values ('Solomon key')");
			statement.executeUpdate("insert into books (name) values ('Neznayka on the moon')");

//			getAllBooks(statement);
//			getBookNameById(statement);

			TransactionIsolationLevels.levelReadCommited(connection);

		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
	}

	// Simple commands
	private static void getBookNameById(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("select name from books where id = 1");
		while (resultSet.next()) {
			System.out.println(resultSet.getString("name"));
		}

		resultSet.close();
	}

	private static void getAllBooks(Statement statement) throws SQLException {
		try (ResultSet resultSet = statement.executeQuery("select * from books");) {
			while (resultSet.next()) {
//			System.out.println(resultSet.getInt(1));
//			System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getString("name"));
				System.out.println("-----------------------");
			}
		}
	}

	// SQL Injection and PreparedStatement
	private static void getBookById_Unsafe(Statement statement) throws SQLException {
//		String bookId = "1";
		String bookId = "1' or 1 = '1";
		ResultSet resultSet = statement.executeQuery("select * from books where id = '" + bookId + "'");

		while (resultSet.next()) {
			System.out.println("book id = " + resultSet.getString("id"));
			System.out.println("book name = " + resultSet.getString("name"));
		}

		resultSet.close();
	}

	private static void getBookById_WithPreparedStatement(Connection connection) throws SQLException {
		String bookName = "1' or 1 = '1";
//		String bookName = "Inferno";

		PreparedStatement preparedStatement = connection.prepareStatement("select * from books where name = ?");
		preparedStatement.setString(1, bookName);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("book id = " + resultSet.getString("id"));
			System.out.println("book name = " + resultSet.getString("name"));
		}

		resultSet.close();
	}

	// Binary Large Objects
	// Will be exception, not implemented in Postgres
	private static void addBookWithImage(Connection connection) throws IOException, SQLException {
		BufferedImage image = ImageIO.read(new File("smile.jpg"));
		Blob blob = connection.createBlob();
		OutputStream outputStream = blob.setBinaryStream(1);
		ImageIO.write(image, "jpg", outputStream);

		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into books (name, img) values (?, ?)");
		preparedStatement.setString(1, "1984");
		preparedStatement.setBlob(2, blob);
		preparedStatement.execute();
	}

	// Dates and SQL sequences
	private static void addBookWithDate(Connection connection) throws SQLException {

		PreparedStatement preparedStatement = connection
				.prepareStatement("insert into books (name, release_date) values (?, ?)");
		preparedStatement.setString(1, "1984");
		preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
		preparedStatement.execute();

		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into books (name, release_date) values ('1984', {d '2020-04-12'})");

		try (ResultSet resultSet = statement.executeQuery("select * from books");) {
			while (resultSet.next()) {
				System.out.println("book id = " + resultSet.getString("id"));
				System.out.println("book name = " + resultSet.getString("name"));
				System.out.println("book release date = " + resultSet.getDate("release_date"));
				System.out.println("-----------------------");
			}
		}

//		System.out.println(preparedStatement);
	}

	// Stored procedures
	private static void getBooksCount(Connection connection) throws SQLException {
//		CallableStatement callableStatement = connection.prepareCall("{call insert_data(?, ?)}");
//		callableStatement.setString(1, "java1");
//		callableStatement.setString(2, "java2");
//		callableStatement.execute();

//		CallableStatement callableStatement = connection.prepareCall("{call get_books_count(?)}");
//		callableStatement.registerOutParameter(1, Types.INTEGER);
//		callableStatement.execute();
//		System.out.println("books count = " + callableStatement.getInt(1));

		CallableStatement callableStatement = connection.prepareCall("{call get_book_by_id(?)}");
		callableStatement.setInt(1, 2);
		System.out.println(callableStatement);
		if (callableStatement.execute()) {
			try (ResultSet resultSet = callableStatement.getResultSet()) {
				while (resultSet.next()) {
					System.out.println("book id = " + resultSet.getString("id"));
					System.out.println("book name = " + resultSet.getString("name"));
				}
			}
		}
	}

	// Scrollable RowSet
	private static void scroll(Connection connection) throws SQLException {
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		// Prepared Statement is similar

		ResultSet resultSet = statement.executeQuery("select * from books");

//		if (resultSet.next()) {
//			System.out.println(resultSet.getString("name"));
//		}
//		if (resultSet.next()) {
//			System.out.println(resultSet.getString("name"));
//		}
//		if (resultSet.previous()) {
//			System.out.println(resultSet.getString("name"));
//		}

//		if (resultSet.relative(2)) {
//			System.out.println(resultSet.getString("name"));
//		}
//		if (resultSet.relative(-2)) {
//			System.out.println(resultSet.getString("name"));
//		}

		if (resultSet.absolute(3)) {
			System.out.println(resultSet.getString("name"));
		}

		if (resultSet.first()) {
			System.out.println(resultSet.getString("name"));
		}

		if (resultSet.last()) {
			System.out.println(resultSet.getString("name"));
		}

	}

	// Update Result Set
	private static void updateResultSet(Connection connection) throws SQLException {
		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet resultSet = statement.executeQuery("select * from books");

		while (resultSet.next()) {
			System.out.println("book id = " + resultSet.getInt("id"));
			System.out.println("book name = " + resultSet.getString("name"));
			System.out.println("-----------------------");
		}

		resultSet.last();
		resultSet.updateString("name", "new value");
		resultSet.updateRow();

		resultSet.moveToInsertRow();
		resultSet.updateString("name", "inserted row");
		resultSet.insertRow();
//		resultSet.updateRow();

		resultSet.absolute(2);
		resultSet.deleteRow();

		System.out.println("***********************************************************");
		resultSet.beforeFirst();
		while (resultSet.next()) {
			System.out.println("book id = " + resultSet.getInt("id"));
			System.out.println("book name = " + resultSet.getString("name"));
			System.out.println("-----------------------");
		}
	}

	// CachedRowSet
	private static void showCachedRowSet(Connection connection) throws SQLException {
		ResultSet resultSet = getCachedRowSet(connection);
//		while (resultSet.next()) {
//			System.out.println("book id = " + resultSet.getInt("id"));
//			System.out.println("book name = " + resultSet.getString("name"));
//			System.out.println("-----------------------");
//		}		
		
//		CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
//		cachedRowSet.setUrl(url);
//		cachedRowSet.setUsername(username);
//		cachedRowSet.setPassword(password);
//		cachedRowSet.setCommand("select * from books where id = ? or id = ?");
//		cachedRowSet.setInt(1, 1);
//		cachedRowSet.setInt(2, 3);
//		cachedRowSet.setPageSize(20);
//		cachedRowSet.execute();		
//		do {
//			while (cachedRowSet.next()) {
//				System.out.println("book id = " + cachedRowSet.getInt("id"));
//				System.out.println("book name = " + cachedRowSet.getString("name"));
//				System.out.println("-----------------------");
//			}
//		} while (cachedRowSet.nextPage());
		
		CachedRowSet cachedRowSet2 = (CachedRowSet) resultSet;
		cachedRowSet2.setTableName("books");
		cachedRowSet2.absolute(1);
		cachedRowSet2.deleteRow();
		cachedRowSet2.beforeFirst();
		while (cachedRowSet2.next()) {
			System.out.println("book id = " + cachedRowSet2.getInt("id"));
			System.out.println("book name = " + cachedRowSet2.getString("name"));
			System.out.println("-----------------------");
		}
		connection.setAutoCommit(false); 
		cachedRowSet2.acceptChanges(connection);
	}

	private static ResultSet getCachedRowSet(Connection connection) throws SQLException {
		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		CachedRowSet cachedRowSet = rowSetFactory.createCachedRowSet();

		Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet resultSet = statement.executeQuery("select * from books");
		cachedRowSet.populate(resultSet);
		return cachedRowSet;
	}
	
	private static void getMetaData(Connection connection) throws SQLException {
		DatabaseMetaData databaseMetaData = connection.getMetaData();
//		System.out.println();
		
//		databaseMetaData.nullPlusNonNullIsNull(); // haha
		ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});
		while (resultSet.next()) {;
			System.out.println(resultSet.getString(3));
		}
		
		System.out.println("-----------------------");
		
		Statement statement = connection.createStatement();
		ResultSet resultSet2 = statement.executeQuery("select * from books");
		ResultSetMetaData resultSetMetaData = resultSet2.getMetaData();
		for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
			System.out.print(resultSetMetaData.getColumnLabel(i) + " - ");
			System.out.println(resultSetMetaData.getColumnTypeName(i));
		}
	}
	
	// Transactions
	private static void transactions(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
		
//		connection.rollback(); // insert will rollback, create table - not
		
		Statement statement = connection.createStatement();
		statement.executeUpdate("insert into books (name) values ('This wonderful new world')");
		Savepoint savepoint = connection.setSavepoint();
		statement.executeUpdate("insert into books (name) values ('Invalid book')");
//		connection.commit();
//		connection.rollback();
		
		connection.rollback(savepoint);
//		connection.releaseSavepoint(savepoint); // works with and without
		connection.commit();
	}
	
	private static void transactions2(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
		try {
			connection.commit();
		} catch (Throwable t) {
			connection.rollback();
		}
	}
	
	// How to execute group of SQL queries
	private static void sqlBatch(Connection connection) throws SQLException {
		connection.setAutoCommit(false);
		Statement statement = connection.createStatement();
		statement.addBatch("insert into books (name) values ('Book1')");
		statement.addBatch("insert into books (name) values ('Book2')");
		statement.addBatch("insert into books (name) values ('Book3')");
		statement.executeBatch();
		connection.commit();
	}
	
	//Transaction isolation levels
	private static void transactionIsolationLevels(Connection connection) throws SQLException, InterruptedException {
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		
		Statement statement = connection.createStatement();
		statement.executeUpdate("update books set name = 'new value' where id = 1");
		
		Thread.sleep(100);
		new OtherTransaction().start();
		Thread.sleep(400);
		connection.rollback();
	}
	
	static class OtherTransaction extends Thread {
		
		public OtherTransaction() {
			
		}

		@Override
		public void run() {			
			try {
				Connection connection = DriverManager.getConnection(url, username, password);
//				connection.setAutoCommit(false);
				connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
//				connection.commit();
				
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

}

//
//
//
//
//
//
//
//
//