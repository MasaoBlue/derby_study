package com.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class AppMain {
  Connection con;

  public static void main(String[] args) {
    AppMain app = new AppMain();
    try {
      app.connectDB();
      app.executeDB();
    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
  }

  /** データベースに接続 */
  private void connectDB() throws SQLException, ClassNotFoundException {
    Class.forName("org.apache.derby.jdbc.ClientDriver");

    //Properties p=System.getProperties();
    //p.put("derby.connection.requireAuthentication", "true");
    
    Properties prop = new Properties();
    prop.put("create", "true"); // 指定したデータベースが存在しない場合、作成する
    prop.put("username", "admin");
    prop.put("password", "admin");

    con = DriverManager.getConnection("jdbc:derby:sample2", prop);
    System.out.println("接続ＯＫ");
  }
  
  private void executeDB() throws SQLException {
    Statement stmt = con.createStatement();
    
    // drop table
    stmt.executeUpdate("Drop Table users");
 
    // create table
    stmt.executeUpdate("Create table users (id int primary key, name varchar(30))");
 
    // insert 2 rows
    stmt.executeUpdate("insert into users values (1,'tom')");
    stmt.executeUpdate("insert into users values (2,'peter')");
 
    // query
    ResultSet rs = stmt.executeQuery("SELECT * FROM users");
 
    // print out query result
    while (rs.next()) { 
      System.out.printf("%d\t%s\n", rs.getInt("id"), rs.getString("name"));
    }
  }
}
