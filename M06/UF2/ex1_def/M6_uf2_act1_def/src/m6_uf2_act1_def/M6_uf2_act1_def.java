/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf2_act1_def;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alumne
 */
public class M6_uf2_act1_def {

    /**
     * @param args the command line arguments
     */
    public Connection conexion() throws ClassNotFoundException, SQLException{
        Connection connection = null; 
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/m06_uf2_act1",
                "root", "");
        
        return connection;
    }
    
}
