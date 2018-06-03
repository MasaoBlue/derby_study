import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class AppMain {
  Connection con;
  Properties prop;

  public static void main(String[] args) {
  }

  public AppMain() throws IOException {
    prop = new Properties();
    prop.load(this.getClass().getResourceAsStream("/derby.properties"));
  }
  
  /** DB接続 
   * @throws IOException */
  public void connectDB() throws SQLException, ClassNotFoundException, IOException { 
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    String dbname = prop.getProperty("derby.dbname");
    con = DriverManager.getConnection("jdbc:derby://localhost/" + dbname);
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
