/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author Juampi
 */
import java.sql.*;

public class Validate {
    public static boolean checkUser(String user,String pass) 
    {
        Connection con = null;
        boolean st =false;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            //loading drivers for mysql
            con = Conexion.getConnection();
     

            //creating connection with the database
            String q = "Select * from carro where user_usr = ? AND pass_usr = ?";
            ps = con.prepareStatement(q);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            st = rs.next();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;                 
    }   
}
