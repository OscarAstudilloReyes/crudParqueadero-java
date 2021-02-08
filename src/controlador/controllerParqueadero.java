/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.cliente;
import modelo.datosParquedero;
import vistas.actualizarVehiculo;
import vistas.listarVehiculos;
import vistas.registrarVehiculos;

/**
 *
 * @author OSCAR
 */
public class controllerParqueadero {

    private datosParquedero datosp;
    private cliente cl;
    private String mensaje;
    DecimalFormat df = new DecimalFormat("#");

    public controllerParqueadero() {

        datosp = new datosParquedero();
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean agregarVehiculo(registrarVehiculos fp) {

        boolean agregado = false;

        this.mensaje = "";

        String cc = fp.txtCC.getText();
        String nombre = fp.txtNombre.getText();
        String placa = fp.txtPlaca.getText();
        int tiempo = Integer.valueOf(fp.cbTiempo.getSelectedItem().toString());

        this.cl = new cliente(cc, nombre, placa, tiempo, 0);
        agregado = datosp.agregarPersona(cl);

        if (agregado) {
            this.mensaje = "PERSONA AGREGADA CORRECTAMENTE Felicidades";
            limpiarRegistrar(fp);
        } else {
            this.mensaje = datosp.getMensaje();
        }
        return agregado;
    }

    public void consultarporNombre(actualizarVehiculo fp) {
        this.mensaje = "";

        String cc = fp.txtCC.getText();

        cl = datosp.consultarxNombre(cc);

        if (cl != null) {
            fp.txtNombre.setText(cl.getNombre());
            fp.txtPlaca.setText(cl.getPlaca());
            fp.txtTiempo.setText(String.valueOf(cl.getTiempo()));
            fp.txtID.setText(String.valueOf(cl.getIdCliete()));
            int tiempo = cl.getTiempo();

            switch (tiempo) {
                case 30: {
                    double costoTotal =  500;
                    fp.txtTotalPagar.setText(String.valueOf(costoTotal));
                    break;
                }
                case 60: {
                    double costoTotal = 1000;
                    fp.txtTotalPagar.setText(String.valueOf(costoTotal));
                    break;
                }
                case 120: {
                    double costoTotal =  2000;
                    fp.txtTotalPagar.setText(String.valueOf(costoTotal));
                    break;
                }
                case 180: {
                    //MAS IVA 
                    double costoTotal = 3000;
                    fp.txtTotalPagar.setText(String.valueOf(costoTotal));
                    break;
                }
                case 240: {
                    //MAS IVA 
                    double costoTotal =  4000;
                    fp.txtTotalPagar.setText(String.valueOf(costoTotal));
                    break;
                }
                default:
                    break;
            }

            this.mensaje = "El usuario si esta";
            fp.txtTotalPagar.setEditable(false);
             fp.txtPlaca.setEditable(false);
             fp.txtTiempo.setEditable(false);
             fp.txtNombre.setEditable(false);
        } else {
            limpiar(fp);
            this.mensaje = datosp.getMensaje();
        }

    }
    
    public void limpiar (actualizarVehiculo fp){
        fp.txtCC.setText("");
        fp.txtNombre.setText("");
        fp.txtPlaca.setText("");
        fp.txtTiempo.setText("");
        fp.txtTotalPagar.setText("");
        fp.txtID.setText("");
    }
     public void limpiarRegistrar (registrarVehiculos fp){
        fp.txtCC.setText("");
        fp.txtNombre.setText("");
        fp.txtPlaca.setText("");
        fp.cbTiempo.setSelectedIndex(0);

    }
    
     public void actualizarCiente(actualizarVehiculo fp){
        
        this.mensaje="";
        int idpersona=Integer.parseInt(fp.txtID.getText());
        
        String cc=fp.txtCC.getText();
        String nombre=fp.txtNombre.getText();
        String placa=fp.txtPlaca.getText();
        int tiempo=Integer.parseInt(fp.txtTiempo.getText());
        double costoTotal=Double.parseDouble(fp.txtTotalPagar.getText());
        
        cl=new cliente(cc, nombre, placa, tiempo, costoTotal);
        
        cl.setIdCliete(idpersona);
        
        boolean actualizado=datosp.actualizarCliente(cl);
        if (actualizado) {
            this.mensaje="actualizado correctamente ";    
            limpiar(fp);
        }
        else{
            this.mensaje=datosp.getMensaje();
        }
        
    }
     
     
        public void mostrar(listarVehiculos lv){

        this.mensaje="";
           
        ArrayList<cliente> lista=datosp.listar();
        
        int cantidad=lista.size();
        
        DefaultTableModel modelo=(DefaultTableModel)lv.tblCliente.getModel();
        
        lv.tblCliente.setModel(modelo);
        String datos[]=new String[5];
        for (int i = 0; i < cantidad; i++) {           
            datos[0]=lista.get(i).getIdentificacion();
            datos[1]=lista.get(i).getNombre();
            datos[2]=lista.get(i).getPlaca();
            datos[3]=String.valueOf(lista.get(i).getTiempo());
            datos[4]="$"+String.valueOf(df.format(lista.get(i).getCosto()));         
            modelo.addRow(datos);            
        }
        
    }
    

}
