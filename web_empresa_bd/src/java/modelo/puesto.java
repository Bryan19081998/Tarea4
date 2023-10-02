/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 *
 * @author FAMILIA SAPON
 */
public class puesto {
    private int id_puesto;
    private String puesto;
    private conexion cn;
    

    public puesto(){}
    public puesto(int id_puesto, String puesto) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
    }
    
    

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
     public HashMap drop_sangre(){
    HashMap <String,String> drop = new HashMap();
    try{
        cn = new conexion();
        String query = "SELECT id_puesto as id, puesto FROM puestos;";
        cn.abrir_conexion();
        ResultSet consulta = cn.conexionDB.createStatement().executeQuery(query);
        while (consulta.next()){
            drop.put(consulta.getString("id"), consulta.getString("puesto"));
        }
        cn.cerrar_conexion();
    }catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    
    return drop;
    }
}
