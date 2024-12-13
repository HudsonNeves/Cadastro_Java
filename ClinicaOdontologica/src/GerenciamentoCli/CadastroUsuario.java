package GerenciamentoCli;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroUsuario {

    public static void cadastrar(String nome, String email, String senha) {
        Connection conn = Conexao.conectar();
        
        if (conn != null) {
            try {
                // SQL para inserir dados na tabela usuarios
                String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nome);
                stmt.setString(2, email);
                stmt.setString(3, senha);
                
                // Executando o comando SQL
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Cadastro realizado com sucesso!");
                } else {
                    System.out.println("Erro ao realizar cadastro.");
                }
                
                stmt.close();
                conn.close();
                
            } catch (SQLException e) {
                System.err.println("Erro ao inserir dados: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Exemplo de cadastro
        cadastrar("Gabriel Ribeiro", "gabriel@exemplo.com", "123456");
    }
}

