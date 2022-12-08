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
 * @author Christian
 */
public class Pais {
    
    private int idPais;
    private String nombre;
    private String abreviacion;
    private int idDivisa;
    private String nombreDivisa;
    private String abreviacionDivisa;
    private String simbolo;
    private float precioEnUsd;

    public int getIdDivisa() {
        return idDivisa;
    }

    public void setIdDivisa(int idDivisa) {
        this.idDivisa = idDivisa;
    }

    public String getNombreDivisa() {
        return nombreDivisa;
    }

    public void setNombreDivisa(String nombreDivisa) {
        this.nombreDivisa = nombreDivisa;
    }

    public String getAbreviacionDivisa() {
        return abreviacionDivisa;
    }

    public void setAbreviacionDivisa(String abreviacionDivisa) {
        this.abreviacionDivisa = abreviacionDivisa;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public float getPrecioEnUsd() {
        return precioEnUsd;
    }

    public void setPrecioEnUsd(float precioEnUsd) {
        this.precioEnUsd = precioEnUsd;
    }

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
    
    /**
     * 
     * @return 
     */
    public static List<Pais> obtenerTodos(){
        
        List<Pais> paises = new ArrayList<>();
        
        try{
            
            Connection conexion = Conexion.obtener();
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT pais.id, divisa.idDivisa, pais.nombre, pais.iso, divisa.nombre, divisa.abreviacion, divisa.simbolo, divisa.precioEnUsd "
                    + "FROM pais "
                    + "LEFT JOIN divisa "
                    + "ON divisa.idDivisa = pais.idDivisa");
            
            while(resultSet.next() == true){
                
                Pais pais = new Pais();
                
                pais.setIdPais(resultSet.getInt(1));
                pais.setIdDivisa(resultSet.getInt(2));
                pais.setNombre(resultSet.getString(3));
                pais.setAbreviacion(resultSet.getString(4));
                pais.setNombreDivisa(resultSet.getString(5));
                pais.setAbreviacionDivisa(resultSet.getString(6));
                pais.setPrecioEnUsd(resultSet.getFloat(7));
                                
                paises.add(pais);
                
            }
            
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return paises;
        
    }
    
    /**
     * 
     * @param nombre
     * @param abreviacion
     * @return 
     */
    public boolean guardar(String nombre, String abreviacion){

        boolean resultado = false;
        
        try{
            
            Connection conexion = Conexion.obtener();
            String consulta = "INSERT INTO pais (nombre, iso) VALUES (?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, abreviacion);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return resultado;

    }
    
    /**
     * 
     * @param idPais 
     */
    public void eliminar (int idPais){
        
        boolean resultado = false;
        
        String[] options = {"Si", "No"};
        int x = JOptionPane.showOptionDialog(null, "El registro sera eliminado ¿Esta seguro de esto?", "Atencion", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
        
        if(x == 0){

            try{

                Connection conexion = Conexion.obtener();
                String consulta = "DELETE FROM pais WHERE id = ?";
                PreparedStatement statement = conexion.prepareStatement(consulta);
                statement.setInt(1, idPais);
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
     * 
     * @param idPais
     * @return 
     */
     public static Pais obtenerPorId(int idPais){
        
        Pais pais = new Pais();
        
        try{
        
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT pais.id, divisa.idDivisa, pais.nombre, pais.iso "
                    + "FROM pais "
                    + "LEFT JOIN divisa "
                    + "ON divisa.idDivisa = pais.idDivisa WHERE pais.id = ?");
            statement.setInt(1, idPais);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next() == true){
                
                pais.setIdPais(resultSet.getInt(1));
                pais.setIdDivisa(resultSet.getInt(2));
                pais.setNombre(resultSet.getString(3));
                pais.setAbreviacion(resultSet.getString(4));
                
            }
            
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return pais;
        
    }
     
     /**
      * 
      * @param nombre
      * @param abreviacion
      * @param divisa
      * @return 
      */
     public boolean editar (String nombre, String abreviacion, String divisa){
        
        boolean resultado = false;
        
        try{
            
            int idDivisa = obtenerPorAbreviatura(divisa);
            
            Connection conexion = Conexion.obtener();
            String consulta = "UPDATE pais SET nombre = ?, iso = ?, idDivisa = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nombre);
            statement.setString(2, abreviacion);
            statement.setString(3, simbolo);
            statement.setFloat(4, precioEnUsd);
            statement.setInt(5, idDivisa);
            statement.execute();
            
            resultado = statement.getUpdateCount() == 1;
            conexion.close();
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return resultado;
      }
     
     /**
      * 
      * @param abreviatura
      * @return 
      */
     public static int obtenerPorAbreviatura(String abreviatura){
        
        int idDivisa  = 0;
        
        try{
            
            Connection conexion = Conexion.obtener();
            PreparedStatement statement = conexion.prepareStatement("SELECT idDivisa FROM divisa WHERE abreviacion = ?");
            statement.setString(1, abreviatura);
            
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next() == true){
            
                idDivisa = resultSet.getInt(1);
               
            }
            
        }catch(Exception ex){
            
            System.err.println("Ocurrio un error: " + ex.getMessage());
            
        }
        
        return idDivisa;
        
    }
    
}
