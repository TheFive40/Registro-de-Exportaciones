/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_adolfo;

import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Jean Franco
 */
public class Model {
    public static void sendInformation(int cc, String name, String art, int amount, int price, String country) throws SQLException {
        PreparedStatement statement = Conector.getConnection()
                .prepareStatement("INSERT INTO Exportaciones (Cedula, Nombre, Articulo, Cantidad, Precio, Paises) VALUES (?,?,?,?,?,?)");
        statement.setInt(1, cc);
        statement.setString(2, name);
        statement.setString(3, art);
        statement.setInt(4, amount);
        statement.setInt(5, price);
        statement.setString(6, country);
        statement.execute();
    }

    public static ArrayList<Vector<String>> getInformation() throws SQLException {
        Statement statement = Conector.getConnection().createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Exportaciones");
        ArrayList<Vector<String>> vectorFinal = new ArrayList<>();
        while (rs.next())
        {
            Vector<String> vector = new Vector<>();
            vector.add("" + rs.getInt("Cedula"));
            vector.add(rs.getString("Nombre"));
            vector.add(rs.getString("Articulo"));
            vector.add("" + rs.getInt("Cantidad"));
            vector.add("" + rs.getInt("Precio"));
            vector.add("" + rs.getString("Paises"));
            vector.add("" + (rs.getInt("Cantidad")* rs.getInt("Precio")));
            vectorFinal.add(vector);
        }
        return vectorFinal;
    }
}
