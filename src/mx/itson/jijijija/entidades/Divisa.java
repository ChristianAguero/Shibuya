/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.jijijija.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.jijijija.persistencia.Conexion;

/**
 *
 * @author shiri
 */
public class Divisa {
    
    private int idDivisa;
    private String nombre;
    private String paisOrigen;
    private String abreviacion;
    private float precioEnUsd;

    public int getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(int idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public float getPrecioEnUsd() {
        return precioEnUsd;
    }

    public void setPrecioEnUsd(float precioEnUsd) {
        this.precioEnUsd = precioEnUsd;
    }
    
    /**
     * Sirve para llenar un ArrayList con los datos que se obtienen del metodo obtener()
     * @return El ArrayList divisas con todos los datos de las divisas
     */
    public static List<Divisa> obtenerTodos(){
        
        List<Divisa> divisas = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT idDivisa, nombre, paisOrigen, abreviacion, precioEnUsd FROM divisa");
            
            while(resultSet.next() == true){
                
                Divisa divisa = new Divisa();
                
                divisa.setIdDivisa(resultSet.getInt(1));
                divisa.setNombre(resultSet.getString(2));
                divisa.setPaisOrigen(resultSet.getString(3));
                divisa.setAbreviacion(resultSet.getString(4));
                divisa.setPrecioEnUsd(resultSet.getFloat(5));
                
                divisas.add(divisa);
                
            }
            
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return divisas;
        
    }
    
    /**
     * Sirve para guardar los datos dados en el JFrame Agregar a la base de datos
     * @param nombre El nombre de la divisa
     * @param paisOrigen El pais donde se emite la divisa
     * @param abreviacion La abreviatura de la divisa en codigo ISO
     * @param precioEnUsd El precio en dolares estadounidenses de la divisa
     * @return Retotorna un parametro de tipo boolean para verificar mas adelante si tuvo exito al pasar los datos a la base de datos
     */
    public boolean guardar(String nombre, String paisOrigen, String abreviacion, float precioEnUsd){

        boolean resultado = false;
        
        try{
            
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO divisa (nombre, paisOrigen, abreviacion, precioEnUsd) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, paisOrigen);
            statement.setString(3, abreviacion);
            statement.setFloat(4, precioEnUsd);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return resultado;

    }
    
}
