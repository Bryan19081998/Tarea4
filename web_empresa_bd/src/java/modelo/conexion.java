
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author FAMILIA SAPON
 */
public class conexion {
    public Connection conexionDB;
    //jdbc:mysql://localhost:3306/?user=root
    //jdbc:mysql://localhost:%s/%s?serverTimezone=UTC
    private final String puerto = "3306";
    private final String bd = "db_empresa";
    private final String urlconexion = String.format("jdbc:mysql://localhost:%s/%s?serverTimezone=UTC " , puerto, bd);
    private final String usuario = "root";
    private final String contra = "12345678";
    private final String jdbc = "com.mysql.cj.jdbc.Driver";
    public void abrir_conexion(){
        try{
           Class.forName(jdbc);
           conexionDB = DriverManager.getConnection(urlconexion, usuario, contra);
           System.out.println("conexion Exitosa...");
           
        }catch(ClassNotFoundException | SQLException ex){
             System.out.println("Error" + ex.getMessage());           
                        }
                 
    }
    
    public void cerrar_conexion(){
        try{
            conexionDB.close();
        }catch(SQLException ex){
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    
}