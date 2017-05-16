package ua.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	 private String jdbcURL;
	    private String jdbcUsername;
	    private String jdbcPassword;
	    private Connection conn;
	    
	    {
	    	jdbcURL = "jdbc:mysql://localhost:3306/test3";
	    	jdbcUsername = "root";
	    	jdbcPassword = "root";
	    }
	     
	    public Connection connect() throws SQLException {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	            } catch (ClassNotFoundException e) {
	                throw new SQLException(e);
	            }
	             conn = DriverManager.getConnection(
	                                        jdbcURL, jdbcUsername, jdbcPassword);
	        }
	        return conn;
	    }
	     
	    public void disconnect() throws SQLException {
	        if (conn != null && !conn.isClosed()) {
	        	conn.close();
	        }
	    }
}
