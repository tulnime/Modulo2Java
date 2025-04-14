/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controllernotas.Vista;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author usuario
 */
public class vistaNotas extends JFrame{
    private JTextField[] camposEvaluaciones;
    private JButton btnCalcular;
    private JButton btnLimpiar;
    private JLabel lblResultado;
    private JLabel lblEstado;
   
    
    /*Constructor de la clase*/
    
    public vistaNotas(){
        /*Configuracion de la ventana*/
        setTitle("Calculadora de promedio");
        setSize(600, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
       /* Panel principal con margen*/
       JPanel mainPanel= new JPanel();
       mainPanel.setLayout(new BorderLayout(10, 10));
       mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20 ));
       mainPanel.setBackground(new Color(240, 240, 240));
       
       /* Panel para las evaluaciones*/
       
       JPanel evaluacionesPanel= new JPanel(new GridLayout(7, 2, 10, 15));
       evaluacionesPanel.setBackground(new Color(240, 240, 240));
       camposEvaluaciones = new JTextField[7];
       
       String[] etiquetas = {  
           "Nota 1: (7%)",
           "Nota 2: (14%)",
           "Nota 3: (21%)",
           "Nota 4: (7%)",
           "Nota 5: (7%)",
           "Nota 6: (14%)",
           "Examen: (30%)"
       
       };
       
       for(int i = 0; i< 7; i++ ){
           JLabel label = new JLabel(etiquetas[i]);
           label.setFont(new Font("arial", Font.PLAIN, 14));
           camposEvaluaciones[i]= new JTextField(12);
           camposEvaluaciones[i].setFont(new Font("arial", Font.PLAIN, 14));
           evaluacionesPanel.add(label);
           evaluacionesPanel.add(camposEvaluaciones[i]);

       }
       
    
       /*Panel para los botones*/
       JPanel botonesPanel =    new JPanel();
       botonesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
       botonesPanel.setBackground(new Color(240, 240, 240));
       
       btnCalcular= new JButton("Calcular la nota");
       btnLimpiar= new JButton("Limpiar los campos");
       
       styleButtonPrimary(btnCalcular);
       styleButtonSecondary(btnLimpiar);
       
       botonesPanel.add(btnCalcular);
       botonesPanel.add(btnLimpiar);
       
       /*Paneles de resultados*/
       JPanel resultadosPanel= new JPanel(new GridLayout(2,1,5,5));
       resultadosPanel.setBackground(new Color(240, 240, 240));
       resultadosPanel.setBorder(new EmptyBorder(20, 0,0,0));
       
       lblResultado= new JLabel("Nota Final- ", SwingConstants.CENTER);
       lblEstado= new JLabel("Estado-",SwingConstants.CENTER);
       
       resultadosPanel.add(lblResultado);
       resultadosPanel.add(lblEstado);
       
         lblResultado.setFont(new Font("arial", Font.BOLD, 14));
         lblEstado.setFont(new Font("arial", Font.PLAIN, 14));
         
       /* Panel sur que combina botones y resultados */
       JPanel panelSur= new JPanel();
       panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.Y_AXIS));
       panelSur.setBackground(new Color(240, 240, 240));
       panelSur.add(botonesPanel);
        panelSur.add(resultadosPanel);
            
          /*Se agrega todo al panel principal */
          JLabel tittleLabel= new JLabel("Ingrese la nota: ", SwingConstants.CENTER);
          tittleLabel.setFont(new Font("arial", Font.BOLD, 14));
          
            mainPanel.add(tittleLabel, BorderLayout.NORTH);
            mainPanel.add(evaluacionesPanel, BorderLayout.CENTER);
            mainPanel.add(panelSur, BorderLayout.SOUTH);
       add(mainPanel);
    }
    
    public void styleButtonPrimary(JButton button){
        button.setPreferredSize(new Dimension(150, 40));
        button.setFont(new Font("arial", Font.BOLD,14));
        button.setBackground(new Color(41,128,185));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        
    }
    public void styleButtonSecondary(JButton button){
       button.setPreferredSize(new Dimension(150, 40));
        button.setFont(new Font("arial", Font.BOLD,14));
        button.setBackground(new Color(231,76,60));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        
    }
    
    /*Metodos Getters*/
    
    public JTextField[] getCamposEvaluaciones(){
    return camposEvaluaciones;
}
    public JButton getBtnCalcular(){
        return btnCalcular;
    }
    public JButton getBtnLimpiar(){
        return btnLimpiar;
    }
    
    /*Metodo que muestra el resultado y el estado de la nota minima*/
    
    public void mostrarResultados(double notaFinal, boolean aprobado){
        
        lblResultado.setText("Nota final: " + notaFinal);
        lblEstado.setText("Estado: " + (aprobado ? "SOBRE EL MINIMO" : "BAJO EL MINIMO"));
        lblEstado.setForeground(aprobado ? new Color(39, 174, 96) : new Color(192, 57, 43));
    }
    
    /* Metodo que limpia los campos de las evaluaciones*/
    public void limpiarCampos(){
        for(JTextField campo : camposEvaluaciones){ 
            campo.setText("");
        }
        lblResultado.setText("Nota final: ");
        lblEstado.setText("Estado: -");
        lblEstado.setForeground(Color.BLACK);
    }
    
}
