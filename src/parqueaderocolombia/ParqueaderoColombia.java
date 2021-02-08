/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueaderocolombia;

import modelo.conexion;
import vistas.principal;

/**
 *
 * @author OSCAR
 */
public class ParqueaderoColombia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Probar conexion con la base de datos
         conexion.getConnection();
       
        System.out.println(conexion.getMensaje());
         
       principal fp=new principal();
        
        fp.setVisible(true);
               
    }
    
}
