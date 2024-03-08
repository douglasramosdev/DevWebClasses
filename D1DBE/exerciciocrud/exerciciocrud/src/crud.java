import escola.*;
import java.sql.*;

public class crud {
    public static void main(String[] args) throws Exception {
        mysqlconnection conn = new mysqlconnection();
        String sql = "INSERT INTO aluno(nome, idade, endereco, datamatricula) VALUES (?,?,?,?)";
        try {
            conn.OpenDatabase();
            PreparedStatement prepstat = conn.getPreparedStatement(sql);

            prepstat.setString(1, "João Silva");
            prepstat.setInt(2, 20);
            prepstat.setString(3, "Rua Exemplo, 123");
            prepstat.setDate(4, new java.sql.Date(System.currentTimeMillis())); // Data atual como exemplo

            int rowsAffected = prepstat.executeUpdate();
            System.out.println(rowsAffected + " linha(s) inserida(s).");

            conn.CloseDatabase();
        } catch (Exception e) {
            System.out.println("Erro durante a execução: " + e.getMessage());
        }
    }
}
