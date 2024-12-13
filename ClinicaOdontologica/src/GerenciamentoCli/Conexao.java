package GerenciamentoCli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_db";  // URL de conexão com o banco
    private static final String USUARIO = "root";  // Usuário padrão do MySQL (no XAMPP)
    private static final String SENHA = "";  // Senha (normalmente em branco no XAMPP)

    public static Connection conectar() {
        try {
            // Estabelecendo a conexão
            Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conexão bem-sucedida!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }
}
