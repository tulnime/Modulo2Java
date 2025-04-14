/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllernotas.Controller.ControllerNota;
import com.mycompany.controllernotas.Modelo.Estudiantes;
import com.mycompany.controllernotas.Vista.vistaNotas;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author usuario
 */
public class controllerNotas implements ActionListener {
    private Estudiantes modelo;
    private vistaNotas vista;
    
    public controllerNotas(Estudiantes modelo, vistaNotas vista ){
        /*Atributos de la clase */
        this.modelo= modelo;
        this.vista= vista;
    
        /* asignar listener a los botones de la vista*/
        
        this.vista.getBtnCalcular().addActionListener(this);
        this.vista.getBtnLimpiar().addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource()== vista.getBtnCalcular()){
            calcularNotas();
        }else if(e.getSource()== vista.getBtnLimpiar()){
            limpiarCampos();
        }
    }
        
        /*Metodos para calcular las notas o limpiar los campos*/
        
    private void calcularNotas(){
        try{
            JTextField[] campos= this.vista.getCamposEvaluaciones();
            for(int i=0; i< campos.length; i++){
                String texto = campos[i].getText().trim().replace(".","").replace(",", "");
                if(texto.isEmpty()){
                    throw new NumberFormatException("Todos los campos son requeridos");
                            
                }
                double valor= Double.parseDouble(texto);
                if(valor< 0){
                    throw new IllegalArgumentException("Los valores no pueden ser negativos");
                }
                
                modelo.setEvaluaciones(i ,valor);        
            }
            
         double notaFinal= modelo.calcularNota();
         boolean aprobado= modelo.isAprobado();
         vista.mostrarResultados(notaFinal, aprobado);
            
        }catch(IllegalArgumentException ex){
            
       JOptionPane.showMessageDialog(vista, ex.getMessage(),
                    "Error de entrada",  
                    JOptionPane.ERROR_MESSAGE);     
        }
    }
    
    private void limpiarCampos(){
        modelo.limpiarEvaluaciones();
        vista.limpiarCampos();
        
    }
    
    
    
    
}
