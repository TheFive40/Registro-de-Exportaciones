/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_adolfo;
import java.sql.*;

/**
 *
 * @author Jean Franco
 */
public class Conector {
  public static Connection getConnection() throws SQLException{
     return DriverManager.getConnection("jdbc:mysql://db4free.net:3306/adolfobdd", "adolfobdd", "adolfobdd123");
  }
    
}
