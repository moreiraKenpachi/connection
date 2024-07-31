package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionBanco {
	
	private static String banco = "jdbc:postgresql://ec2-35-171-171-27.compute-1.amazonaws.com:5432/database?autoReconnect=true";
	private static String user = "hkajjyphjbtpta";
	private static String senha = "";
	private static Connection connection = null;
	
	public static Connection getConnection() {
		return connection;
	}
	
	
	/* pra garantir conexao*/
	static {
		conectar();
	}
	
	/* pra garantir conexao*/
	public SingleConnectionBanco() { // quando tiver uma instancia vai conectar 
		conectar();
	}
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");  // carregar o drive de conexao do banco
				connection = DriverManager.getConnection(banco, user, senha);
				connection.setAutoCommit(false); //nao efetuar alteracoes no banco sem nosso comando
			}
		}catch(Exception e){
			e.printStackTrace(); // mostrar qualquer erro no momento de conexao
		}
	}

}
