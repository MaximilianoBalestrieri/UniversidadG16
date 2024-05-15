/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadulp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UniversidadUlp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             try {
            // TODO code application logic here
            Class.forName("org.mariadb.jdbc.Driver");
            String bd="jdbc:mysql://localhost:3306/universidadg16";
            String usuario="root";
            String password="";
            Connection con=  DriverManager.getConnection(bd,usuario,password);

//       //      Ingreso de 3 alumnos
//             String sql="INSERT INTO "
//                    + "alumno(dni, apellido, nombre, fechaNacimiento, estado) "
//                    + "VALUES (25123456,'Balestrieri','Maximiliano','1982-02-17',1), "
//                    + "(35222111,'Ramos Molina','Nahir','1990-11-04',1), "                 
//                    +  "(41555666,'Urquiza','Alan','1988-10-10',1) ";          
//            PreparedStatement ps = con.prepareStatement(sql);
//             int filas=ps.executeUpdate();
//             if(filas >0){
//                       JOptionPane.showMessageDialog(null, "Alumno  Agregado correctamente");
//                }
// 
           
                   
  
//  //Ingreso de 4 materias
//                    String sql="INSERT INTO "
//                    + "materia(nombre, año, estado) "
//                    + "VALUES ('Matematica',2,1), "
//                    + "('Laboratorio',1,1), "     
//                    + "('EDA',2,1), "          
//                    +  "('Web 1',1,1) ";          
//            PreparedStatement ps = con.prepareStatement(sql);
//             int filas=ps.executeUpdate();
//             if(filas >0){
//                       JOptionPane.showMessageDialog(null, "Materia  Agregada correctamente");
//                }
//    
//     
// //Inscribir a los 3 alumnos en 2 materias cada uno.
//    String sql="INSERT INTO "
//                         + "inscripcion(nota, idAlumno,idMateria) "
//                         + "VALUES "
//                         + "(8,1,1), "
//                         + "(9,1,2), "
//                         + "(10,2,1), "
//                         + "(8,2,3), "
//                         + "(7,3,2), "
//                         + "(9,3,3) ";    
//            PreparedStatement ps = con.prepareStatement(sql);
//             int filas=ps.executeUpdate();
//             if(filas >0){
//                       JOptionPane.showMessageDialog(null, "Inscripción  Agregada correctamente");
//                }
 
/*
 
// Listar los datos de los alumnos con calificaciones superiores a 8.
                 String sql = "SELECT * FROM  alumno a join inscripcion i ON (a.idalumno = i.idalumno) WHERE i.nota> 8 ";
                  PreparedStatement ps = con.prepareStatement(sql);
                  ResultSet datos=ps.executeQuery();
            
              while (datos.next()){
                  int idalumno=datos.getInt("idAlumno");
                  int dni=datos.getInt("dni");
                  String apellido=datos.getString("apellido");
                  String nombre=datos.getString("nombre");
                  String fechanac=datos.getString("fechaNacimiento");
                  int nota=datos.getInt("nota");
                  boolean estado=datos.getBoolean("estado");
                  
                  System.out.print("Id del alumno: "+ idalumno + " | ");
                  System.out.print("DNI: "+ dni + " | ");
                  System.out.print("Apellido: " + apellido + " | " );
                  System.out.print("Nombre: " + nombre + " | ");
                  System.out.print("Fecha de Nac: " + fechanac + " | ");
                  System.out.print("Nota: "+ nota + " | ");
                  System.out.print("Estado: "+ estado + " | ");
                  System.out.println(" ");
              }

            
             
 */          

  // Desinscribir un alumno de una de la materias.
              
            String sql="DELETE  FROM inscripcion WHERE idmateria= 2 and idalumno=3";
            PreparedStatement ps = con.prepareStatement(sql);
              int filas = ps.executeUpdate();   // Devuelve un valor entero
              if (filas > 0) {
                  JOptionPane.showMessageDialog(null, "Se ha desincripto correctamente");
              }

        
     } 
        catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargard driver");
        } catch (SQLException ex) {
            int codigoE=ex.getErrorCode();
            if(codigoE==1062){
                  JOptionPane.showMessageDialog(null, "Entrada Duplicada");
            } else if(codigoE==1049){
            JOptionPane.showMessageDialog(null, "BD Desconocida");
            }else{
                  JOptionPane.showMessageDialog(null, "Error ");
            }
            
            ex.printStackTrace();
            System.out.println("codigo de error "+ex.getErrorCode());
        }
    }
    
}
    

