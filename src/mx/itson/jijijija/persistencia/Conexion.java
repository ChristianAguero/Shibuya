/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.jijijija.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shiri
 */
public class Conexion {
    
    /**
     *  Sirve para crear la conexion entre el programa y la base de datos
     * @return La conexion hacia la base de datos
     */
    public static Connection obtener(){
        
        Connection conexion = null;
        
        try{
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/jijijijadb?user=root&password=");
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return conexion;
        
    }
    
}
