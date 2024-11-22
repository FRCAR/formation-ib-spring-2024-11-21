package fr.formation.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * L'entité que l'on pourrait persister avec JDBC
 */
class Company {
	Long id;
	String name;
	String address;

	public Company(){

	}

	public Company(String name){
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

public class JdbcInit {

	public void launchQueries(Connection con) {
		String dropTableQuery = "drop table COMPANY";
		String createTableQuery = "create table COMPANY ("
				+ "       ID bigint not null,"
				+ "        NAME varchar(255),"
				+ "        ADDRESS varchar(255),"
				+ "        primary key (ID) "
				+ "    )";
		String insertQuery = "insert into COMPANY(ID, NAME, ADDRESS) VALUES (1, 'bigCorp', 'défaut')";
		String selectQuery = "select ID, NAME, ADDRESS from COMPANY";
		String deleteQuery = "delete from COMPANY where id = :id";
		String updateQuery = "update COMPANY set name = :name, address = :address where id = :id";
		try (Statement stmt = con.createStatement()) {
			try {
				stmt.executeUpdate(dropTableQuery);
			} catch (SQLException e) {
				System.out.println("Could not drop table");
			}
			try {
				stmt.executeUpdate(createTableQuery);
			} catch (SQLException e) {
				System.out.println("Could not create table");
			}
			stmt.executeUpdate(insertQuery);
			ResultSet rs = stmt.executeQuery(selectQuery);
			while (rs.next()) {
				long id = rs.getLong("ID");
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				System.out.println("id : " + id + " , name : " + name + " address : " + address);
			}
		} catch (SQLException e) {
			throw new RuntimeException("SQL Error", e);
		}
	}

	public static void main(String[] args) {
		Properties connectionProps = new Properties();
		connectionProps.put("user", "javav");
		connectionProps.put("password", "javav");
		try {
			Connection connection = DriverManager.getConnection(
					"jdbc:h2:~/h2-data/formation-ib;AUTO_SERVER=TRUE",
					connectionProps);
			JdbcInit jdbcInit = new JdbcInit();
			jdbcInit.launchQueries(connection);
			System.out.println("J'ai fini");
		} catch (SQLException e) {
			throw new RuntimeException("Could not connect to database ", e);
		}

	}

}