package application;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class connexion {
	static Connection con = null ;
	static {
		try{
		String db_url="jdbc:mysql://localhost:3306/projet_java";
		
		String userName="root";
		String password="";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(db_url,userName,password);
		System.out.println("Connexion terminer");
		
		}catch(ClassNotFoundException | SQLException e){
			System.out.println("Error opening SQL connection:"+ e.getMessage());
		}
	}
	public static Connection getCon(){
		return con ;
		}
}
