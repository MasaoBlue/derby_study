import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppMain {
  Connection con;

  public static void main(String[] args) {
  }

  /** DB接続 
   * @throws IOException */
  public void connectDB() throws SQLException, ClassNotFoundException, IOException { 
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    con = DriverManager.getConnection("jdbc:derby://localhost:1527/sample");
    con.setAutoCommit(false);
    System.out.println("DB connect success");
  }
  
  /** テストデータを投入し、selectした結果を返す */
  public void executeDB() throws SQLException {
    Statement stmt = con.createStatement();
 
    stmt.executeUpdate("INSERT INTO sample VALUES (1, 'desktop')");
    stmt.executeUpdate("INSERT INTO sample VALUES (2, 'laptop')");
 
    // query
    ResultSet rs = stmt.executeQuery("SELECT * FROM sample");
 
    // print out query result
    while (rs.next()) { 
      System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
    }
  }

  /** 現在のトランザクションをロールバックする */
  public void rollback() throws SQLException {
    con.rollback();
  }
}
