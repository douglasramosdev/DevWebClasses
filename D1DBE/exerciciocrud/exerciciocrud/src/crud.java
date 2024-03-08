import java.util.Scanner;
import java.sql.SQLException;

public class crud {
    public static void main(String[] args) throws Exception {
        mysqlconnection crud = new mysqlconnection();
        //String sql = "CREATE TABLE teste" + "(id_cidade INT NOT NULL PRIMARY KEY AUTO_INCREMENT," + "nome VARCHAR(200))";
        crud.OpenDatabase();
        //crud.QueryExec(sql);
        String sql = "INSERT INTO teste" + "(nome) VALUES ('New York')";
        crud.QueryExec(sql);
        crud.CloseDatabase();
    }
}
