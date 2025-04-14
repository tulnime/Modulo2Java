/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllernotas.Modelo;

/**
 *
 * @author Angel Alizo
 * clase que representa a un estudiante
 */
public class Estudiantes {
    
   /* Contiene las evaluaciones */
    private double[] evaluaciones;
    /* Contiene las ponderaciones de las evaluaciones*/
    private static final double[] ponderacion=   {0.07, 0.14, 0.21, 0.07, 0.07, 0.14, 0.30};
    
    
    /*Metodo constructor de la clase*/
    public Estudiantes(){
        this.evaluaciones= new double[7];
    }
    
    /* 
    *Metodo que establece el valor de un concepto.
    *@param index indice de la evaluacion
    *@param valor valor de la evaluacion
    */ 
    
    public void setEvaluaciones(int index, double valor){ 
        if( index >= 0 && index < evaluaciones.length){
            this.evaluaciones[index]= valor; 
        }
    }
    
    public double calcularNota(){ 
        
        double notaFinal= 0;
        for (int i= 0; i< evaluaciones.length; i++){
            notaFinal += evaluaciones[i] * ponderacion[i];
            
        }
        return Math.round(notaFinal * 100)/ 100.0;
    }
    
    public boolean isAprobado(){ /* Este metodo verifica si el estudiante tiene la nota aprobatoria minima*/ 
    
    return calcularNota() > 4.0;   /*Nota aprobatoria minima*/
    }
    
    public void limpiarEvaluaciones(){ 
        for( int i= 0; i< evaluaciones.length; i++){
            evaluaciones[i]= 0;
        }
    }
}
