package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//altere conforme os seus dados
public class ConnectionFactory {
    private static final String url = "jdbc:mysql://localhost:3306/cadastro_escolar";
    private static final String user = "seu_usuario";
    private static final String password = "sua_senha";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
