/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.shibuya.entidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.shibuya.persistencia.Conexion;

/**
 *
 * @author Christian
 */
public class Pais {
    
    private int idPais;
    private String nombre;
    private String abreviacion;

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }
    
    public static List<Pais> obtenerTodos(){
        
        List<Pais> paises = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM pais");
            
            while(resultSet.next() == true){
                
                Pais pais = new Pais();
                
                pais.setIdPais(resultSet.getInt(1));
                pais.setNombre(resultSet.getString(2));
                pais.setAbreviacion(resultSet.getString(3));
                                
                paises.add(pais);
                
            }
            
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return paises;
        
    }
    
}
