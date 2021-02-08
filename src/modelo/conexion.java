/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author KELLY
 */
public class conexion {
    //clases necesarias para comprobar la conexion
    
    private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver" ;
    private static final String usuario="root";
    private static final String password="";
    private static final String url="jdbc:mysql://localhost:3306/parqueaderoColombia";
    private static String mensaje="";
    
  
    //metodo que retornara si se hizo la conextion 
    
    public static Connection getConnection(){
         if (con!=null){
           return con;
           
       }
         
       try{
           Class.forName(driver);
           con = (Connection)DriverManager.getConnection(url,usuario,password);
           mensaje="CONEXION EXITOSA";
           return con;
           
           
       }catch(ClassNotFoundException | SQLException es){
           mensaje="ERROR EN LA CONEXION CON LA BASE DE DATOS " + es.getMessage();
           return null;
       }
               
       
    }
    
     public static String getMensaje() {
        return mensaje;
    }
    
     //CERRAR LA CONEXION
     
    public static void cerrar(){
        try{
            con.close();
            mensaje="conexion cerrada";
            
        }catch(SQLException ee){
            mensaje="problemas al cerar la base de datos" + ee.getMessage();
            
        } 
    }
    
    
           
    
}
