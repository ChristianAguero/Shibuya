/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.jijijija.negocio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.jijijija.entidades.Divisa;
import mx.itson.jijijija.persistencia.Conexion;

/**
 *
 * @author shiri
 */
public class Operacion {
    
    public static List<Divisa> obtenerPrecios(String divisaNom, float valor){
        
        float div = Divisa.obtenerPorAbreviatura(divisaNom);
        
        List<Divisa> divisas = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT abreviacion, precioEnUsd FROM divisa");
            
            while(resultSet.next() == true){
                
                Divisa divisa = new Divisa();
                
                divisa.setAbreviacion(resultSet.getString(1));
                divisa.setPrecio((div * valor) / resultSet.getFloat(2));
                
                divisas.add(divisa);
                
            }
            
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return divisas;
        
    }
    
}
