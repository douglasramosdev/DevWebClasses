import java.sql.*;

public class mysqlconnection {
  public static String URL = "jdbc:mysql://localhost:3306/crud";
  public static String USER = "root";
  public static String PWD = "0000" ;

  private Connection dbConn = null;
  private Statement sqlmgr = null;
  private ResultSet resultSql = null;

  public void OpenDatabase (){
    try {
      dbConn = DriverManager.getConnection(URL, USER, PWD);
    System.out.println("Conectado ao BD com Sucesso!!" + URL);
    sqlmgr = dbConn.createStatement();
    } catch(Exception error){
      System.out.println("Error on connect:" + error.getMessage());
    }
  }
  public void CloseDatabase() throws SQLException{
    sqlmgr.close();
    dbConn.close();
  }
  public int QueryExec(String sql){
    try{
      return sqlmgr.executeUpdate(sql);
    } catch (Exception Error){
      System.out.println(Error.getMessage());
    }
    return -1;
  }
}
