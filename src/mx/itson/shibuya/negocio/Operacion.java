/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.shibuya.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.shibuya.entidades.Divisa;
import mx.itson.shibuya.persistencia.Conexion;

/**
 *
 * @author shiri
 */
public class Operacion {
    
    /**
     * Convierte la divisa seleccionada en las demas divisas
     * @param divisaNom El codigo ISO de la moneda seleccionada
     * @param valor El monto que se quiere convertir a las demas monedas 
     * @return Una lista con todos los valores convertidos, y sus respepctivosd codigos ISO
     */
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
    
    public static float obtenerPrecio(String divisaNomUno, String divisaNomDos, float valor){
        
        float divUno = Divisa.obtenerPorAbreviatura(divisaNomUno);
        float divDos = Divisa.obtenerPorAbreviatura(divisaNomDos);
        
        float precio = 0;
        
        try{
                
                precio = ((divUno * valor) / divDos);            
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return precio;
        
    }
    
}
