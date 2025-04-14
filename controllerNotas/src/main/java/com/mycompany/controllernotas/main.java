/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controllernotas;
import com.mycompany.controllernotas.Modelo.Estudiantes;
import com.mycompany.controllernotas.Vista.vistaNotas;
import com.mycompany.controllernotas.Controller.ControllerNota.controllerNotas;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author usuario
 */
public class main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            try{
                /*Establecer un look and fell del sistema*/
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch(Exception e){ 
                e.printStackTrace();
            }
            
            /*Crear instancias del patron MVC*/
            Estudiantes modelo= new Estudiantes();
            vistaNotas vista= new vistaNotas();
            controllerNotas controller= new controllerNotas(modelo, vista);
            
            /* mostrar la vista*/
            vista.setVisible(true);
            
        } 
        
        );
    }
}
