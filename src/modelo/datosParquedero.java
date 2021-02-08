/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author OSCAR
 */
public class datosParquedero {
    
    
    
    private cliente uncliente;
    private final Connection miconexion;
    private String mensaje;

    public datosParquedero() {
        //ASIGNAMOS EL OBJETO DE CONNETION ALA CLASE CONEXION E INVOCAMOS EL GETCONNETION
        miconexion = conexion.getConnection();

    }

    public String getMensaje() {
        return mensaje;
    }
    

    
    public boolean agregarPersona(cliente cl) {
        boolean agregado = false;
        PreparedStatement ps;
        String sql = "INSERT INTO parqueadero values (null,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) miconexion.prepareStatement(sql);
            ps.setString(1, cl.getIdentificacion());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getPlaca());
            ps.setInt(4, cl.getTiempo());
            ps.setDouble(5, cl.getCosto());
            if (ps.executeUpdate() > 0) {
                agregado = true;
            }
        } catch (SQLException ex) {
            mensaje = "problemas al agregar el vehiculo" + ex.getMessage();
        }

        return agregado;
    }

    public cliente consultarxNombre(String nombre) {

        cliente unp = null;
        PreparedStatement ps;
        String sql = "SELECT * FROM parqueadero WHERE parCedula=?";
        try {
            ps = (PreparedStatement) miconexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                unp = new cliente();
                unp.setIdCliete(rs.getInt("idCliente"));
                unp.setNombre(rs.getString("parNombre"));
                unp.setPlaca(rs.getString("parPlaca"));
                unp.setTiempo(rs.getInt("parTiempo"));
                unp.setCosto(rs.getDouble("perCostoTotal"));

            } else {
                this.mensaje = "no existe persona con ese identificacion";
            }
        } catch (SQLException ex) {

            this.mensaje = "PROBLEMAS AL CONSULTAR PERSONA " + ex.getMessage();
        }
        return unp;

    }

    public boolean actualizarCliente(cliente unp) {
        this.mensaje = "";

        boolean actualizado = false;

        PreparedStatement ps;
        String sql = "UPDATE parqueadero SET parCedula=?, parNombre=?,parPlaca=?,parTiempo=?, parCostoTotal=?  WHERE idCliente=? ";

        try {
            ps = (PreparedStatement) miconexion.prepareStatement(sql);
            ps.setString(1, unp.getIdentificacion());
            ps.setString(2, unp.getNombre());
            ps.setString(3, unp.getPlaca());
            ps.setInt(4, unp.getTiempo());
            ps.setDouble(5, unp.getCosto());
            ps.setInt(6, unp.getIdCliete());

            if (ps.executeUpdate() > 0) {
                actualizado = true;
            }

        } catch (SQLException ex) {
            this.mensaje = "problemas al actualizar el cliente " + ex.getMessage();
        }
        return actualizado;

    }

    //CREA UN ARRAYLIST   
    public ArrayList<cliente> listar() {
        ArrayList<cliente> listar = new ArrayList<>();
        String sql = "SELECT *FROM parqueadero";

        try {
            Statement st = miconexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                cliente unp = new cliente();
                unp.setIdentificacion(rs.getString("parCedula"));
                unp.setNombre(rs.getString("parNombre"));
                unp.setPlaca(rs.getString("parPlaca"));
                unp.setTiempo(rs.getInt("parTiempo"));
                unp.setCosto(rs.getDouble("parCostoTotal"));
                unp.setIdCliete(rs.getInt("IdCliente"));
                listar.add(unp);
            }
        } catch (SQLException ex) {
            mensaje = "problema al obtener los datos de los clientes " + ex.getMessage();
        }
        return listar;
    }
}
