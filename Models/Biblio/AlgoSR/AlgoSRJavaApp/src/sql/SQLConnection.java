/**
 * 
 */
package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @author Raimbault Juste <br/> <a href="mailto:juste.raimbault@polytechnique.edu">juste.raimbault@polytechnique.edu</a>
 *
 */
public class SQLConnection {
	
	
	private static String sqlUser;
	
	private static String sqlPassword;
	
	public static Connection sqlDB;
	
	
	
	/**
	 * Setup sql credentials
	 * 
	 * @param user
	 * @param pass
	 */
	public static void setupSQLCredentials(String user,String pass){
		System.out.println("credentials : "+user+","+pass);
		sqlUser = user;sqlPassword = pass;
	}
	
	
	/**
	 * Connects to the database ; assumed on localhost, at standard port 3306.
	 */
	public static void setupSQL(String database){
		try{
		  System.setProperty("socksProxyHost","");	
		  System.setProperty("socksProxyPort","");
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("credentials : "+sqlUser+","+sqlPassword);
		  sqlDB = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+database,sqlUser,sqlPassword);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes a sql query
	 * 
	 * @param query
	 * @return
	 */
	public static ResultSet executeQuery(String query){
		try{
			return SQLConnection.sqlDB.createStatement().executeQuery(query);
		}catch(Exception e){e.printStackTrace();return null;}
	}
	
	
	
	
}
