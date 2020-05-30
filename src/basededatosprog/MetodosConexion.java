/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatosprog;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author jalvarezbarciela
 */
public class MetodosConexion {
Connection conexion = null;
Statement statement= null;
ResultSet consulta= null;



public Connection conectar(){

try{
conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/BaseDeDatosProg","root","1234");
    System.out.println("Conectado a la base de datos.");
} catch (SQLException ex) {
    Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null,ex);   
}    
return conexion;

}


public void mostrar(){
    
    try{
        statement = conexion.createStatement();
        consulta = statement.executeQuery("SELECT * FROM JUGADORES");
        if(consulta.next()){
        consulta = statement.executeQuery("SELECT * FROM JUGADORES");
        System.out.println("\nTabla jugadores");
        while (consulta.next()){
        String codigojugador = consulta.getString("CODJ");
        String nombre = consulta.getString("NOMBRE");
        int edad = consulta.getInt("EDAD");
        int salario = consulta.getInt("SALARIO");
        String codigoequipo = consulta.getString("CODE");
        
            System.out.println("Codigo jugador: "+codigojugador+" Nombre: "+nombre+" Edad: "+edad+" Salario: "+salario+" Codigo Equipo: "+codigoequipo+"\n");
        }
        }
        else
        System.out.println("La tabla está vacía.");
        
    } catch (SQLException ex) {
     Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null,ex);
    }
}
    
public void añadir(String codigojugador,String nombre,int edad,  int salario, String codigoequipo){
try{

Statement statement = conexion.createStatement();
statement.executeUpdate("INSERT INTO JUGADORES VALUES('"+codigojugador+"','"+nombre+"', "+edad+", "+salario+", '"+codigoequipo+"')");
    System.out.println("Fila insertada correctamente!");    
} catch (SQLException ex) {
 Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null,ex);    
}

}
public void actualizar(){
try{
consulta = statement.executeQuery("SELECT * FROM JUGADORES");
 if(consulta.next()){
int opcion = Integer.parseInt(JOptionPane.showInputDialog("Presione una tecla:\n"
        + "1- Actualizar el nombre\n"
        + "2- Actualizar la edad\n"
        + "3- Actualizar el salario\n"
        + "4- Actualizar el codigo equipo\n"
        + "5- Actualizar el codigo jugador"));
Statement statement = conexion.createStatement();
String codj=JOptionPane.showInputDialog("Introduce el codigo de jugador de la jugador a actualizar!");
switch(opcion){
    case 1:
String nombre=JOptionPane.showInputDialog("Introduce el nuevo nombre");     
statement.executeUpdate("UPDATE JUGADORES set nombre='"+nombre+"' where codj='"+codj+"'");
break;
    case 2:
int edad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la nueva edad"));        
statement.executeUpdate("UPDATE JUGADORES set edad='"+edad+"' where codj='"+codj+"'");
break;
    case 3:
int salario=Integer.parseInt(JOptionPane.showInputDialog("Introduce el nuevo salario"));        
statement.executeUpdate("UPDATE JUGADORES set salario='"+salario+"' where codj='"+codj+"'");
break;
    case 4:
String codigoequipo=JOptionPane.showInputDialog("Introduce el nuevo codigo equipo");     
statement.executeUpdate("UPDATE JUGADORES set code='"+codigoequipo+"' where codj='"+codj+"'");
break;
    case 5:
String nuevocodj=JOptionPane.showInputDialog("Introduce el nuevo codigo de jugador");     
statement.executeUpdate("UPDATE JUGADORES set codj='"+nuevocodj+"' where codj='"+codj+"'");
break;
}
    System.out.println("Datos modificados correctamente!");
}
else
        System.out.println("No hay filas disponibles para modificar");
} catch (SQLException ex) {
 Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null,ex);    
}

}
public void borrar(){
try{
Statement statement = conexion.createStatement();
String codj=JOptionPane.showInputDialog("Introduce el codigo del jugador  a borrar!");
statement.executeUpdate("DELETE FROM USUARIOS where codj='"+codj+"'");


    System.out.println("Datos eliminados correctamente!");
} catch (SQLException ex) {
 Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null,ex);    
}

}

public void cerrar(){
try{
conexion.close();
    System.out.println("Desconectado de la base de datos.");
} catch (SQLException ex) {
Logger.getLogger(MetodosConexion.class.getName()).log(Level.SEVERE, null,ex);      
}
    
}

}

