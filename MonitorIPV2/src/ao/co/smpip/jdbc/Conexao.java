package ao.co.smpip.jdbc;
import java.sql.*;
 
	public class Conexao 
	{
//		private static Connection conn;
		private static String url  = "jdbc:mysql://localhost/monitor_bd";
		private static String user = "root";
		private static String pass = "sistema47";
		private static Connection conn;
		public static Connection getConexao(){
		 
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
				 
				conn = DriverManager.getConnection(url,user,pass);
//				System.out.print("Conexao efectuada com sucesso...");
			} catch (SQLException e) {
				
				System.out.print("Conexao nao efectuada com sucesso..."+e.getMessage());
			} catch (ClassNotFoundException e) {
				 
				e.printStackTrace();
			}
		 
			return conn;
		}
}
