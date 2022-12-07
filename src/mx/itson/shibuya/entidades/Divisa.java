/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.shibuya.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.shibuya.persistencia.Conexion;

/**
 *
 * @author shiri
 */
public class Divisa {
    
    private int idDivisa;
    private String nombre;
    private String abreviacion;
    private String simbolo;
    private float precioEnUsd;
    private float precio;

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

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
            ResultSet resultSet = statement.executeQuery("SELECT * FROM divisa");
            
            while(resultSet.next() == true){
                
                Divisa divisa = new Divisa();
                
                divisa.setIdDivisa(resultSet.getInt(1));
                divisa.setNombre(resultSet.getString(2));
                divisa.setAbreviacion(resultSet.getString(3));
                divisa.setSimbolo(resultSet.getString(4));
                
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
     * @param abreviacion La abreviatura de la divisa en codigo ISO
     * @param simbolo El simbolo de la divisa que se quiere guardar
     * @return Retotorna un parametro de tipo boolean para verificar mas adelante si tuvo exito al pasar los datos a la base de datos
     */
    public boolean guardar(String nombre, String abreviacion, String simbolo){

        boolean resultado = false;
        
        try{
            
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO divisa (nombre, abreviacion, simbolo) VALUES (?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, abreviacion);
            statement.setString(3, simbolo);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return resultado;

    }
    
    /**
     * Sirve para buscar el valor en USD de una divisa por su codigo ISO
     * @param abreviatura El codigo ISO de la divisa
     * @return El precio ebn USD de la divisa
     */
    /*public static float obtenerPorAbreviatura(String abreviatura){
        
        float div  = 0;
        
        try{
            
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT precioEnUsd FROM divisa WHERE abreviacion = ?");
            statement.setString(1, abreviatura);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next() == true){
            
                div = resultSet.getFloat(1);
               
            }
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return div;
        
    }*/
    
    /**
     * Con este metodo eliminamos un registro en la divisa
     * @param idDivisa El id de la divisa que se quiere eliminar
     */
 
     public void eliminar (int idDivisa){
        
        boolean resultado = false;
        
        String[] options = {"Si", "No"};
        int x = JOptionPane.showOptionDialog(null, "El registro sera eliminado ¿Esta seguro de esto?", "Atencion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if(x == 0){

            try{

                Connection conexion = Conexion.obtener();
                String consulta = "DELETE FROM divisa WHERE idDivisa = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setInt(1, idDivisa);
                statement.execute();

                resultado = statement.getUpdateCount() == 1;
                conexion.close();

            }catch(Exception ex){

                System.err.println("Ocurrio un error: " + ex.getMessage());

            }
            
        }
        
        if(resultado){
            
            JOptionPane.showMessageDialog(null, "El registro se elimiino exitosamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            
        }else{
            
            JOptionPane.showMessageDialog(null, "El registro no se ha podido eliminar", "Error", JOptionPane.ERROR_MESSAGE);
            
        }
        
    }
     

     /**
     * Con este metodo editamos un registro en la divisa
     * @param idDivisa El id de la divisa que se quiere editar
     * @param nombre El nombre de la divisa a editar
     * @param abreviacion La abreviacion de moneda del pais de la divisa a editar
     * * @param simbolo El simbolo de la divisa que se quiere editar
     * @return un tipo boolean que nos dice si se completo la eliminacion de la divisa
     */

      public boolean editar (int idDivisa, String nombre, String abreviacion, String simbolo){
        
        boolean resultado = false;
        
        try{
            
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE divisa SET nombre = ?, abreviacion = ?, simbolo = ? WHERE idDivisa = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, abreviacion);
            statement.setString(3, simbolo);
            statement.setInt(4, idDivisa);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return resultado;
      }
    
     /**
     * Con este metodo obtenemos una divisa por su id
     * @param idDivisa El id de la divisa que se quiere buscar 
     * @return los datos de la divisa obtenida
     */
    public static Divisa obtenerPorId(int idDivisa){
        
        Divisa divisa = new Divisa();
        
        try{
        
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT idDivisa, nombre, abreviacion, simbolo FROM divisa WHERE idDivisa = ?");
            statement.setInt(1, idDivisa);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next() == true){
                
                divisa.setIdDivisa(resultSet.getInt(1));
                divisa.setNombre(resultSet.getString(2));
                divisa.setAbreviacion(resultSet.getString(3)); 
                divisa.setSimbolo(resultSet.getString(4)); 
                
            }
            
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return divisa;
        
    }
    
}
