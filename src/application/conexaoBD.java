package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexaoBD {
	public static final String URL = "jdbc:mysql://localhost:3306/furmularios";
	public static final String USUARIO = "root";
	public static final String SENHA = "jailson14";
	
	public static Connection getConnection()throws Exception{
		return DriverManager.getConnection(URL,USUARIO,SENHA);
	}
	

}
