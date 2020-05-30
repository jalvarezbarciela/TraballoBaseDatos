/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosprog;

import javax.swing.JOptionPane;

/**
 *
 * @author jalvarezbarciela
 */
public class BaseDeDatosProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MetodosConexion obx=new MetodosConexion();
        
        
        
         int opcion;
do{ 
opcion = Integer.parseInt(JOptionPane.showInputDialog("***MENÚ***\n"
        + "1-Conectarse a la base\n"
        + "2-Mostrar filas de la tabla\n"
        + "3-Añadir una fila\n"
        + "4-Actualizar una fila\n"
        + "5-Eliminar una fila\n"
        + "6-Desconectarse\n"
        + "7-Salir"));
switch(opcion){
    case 1: 
    obx.conectar();    
    break;
    case 2:
    obx.mostrar();
    break;
    case 3:
    String codj = JOptionPane.showInputDialog("Introduce el codigo de jugador");
    String nombre = JOptionPane.showInputDialog("Introduce el nombre");
    int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la edad"));
    int salario = Integer.parseInt(JOptionPane.showInputDialog("Introduce el salario"));
    String code = JOptionPane.showInputDialog("Introduce el codigo de equipo");
    
    obx.añadir(codj,nombre,edad,salario,code);
    break;
    case 4:
    obx.actualizar();
    break;
    case 5:
    obx.borrar();
    break;
    case 6:
    obx.cerrar();
    break;    


}
}while (opcion<7);
       
    }
    
}
