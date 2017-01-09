/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Clase de hilo, cronómetro
*******************************************************************************/

public class Cronometro extends Thread { //una clase que hereda de la clase Thread
    
    private String tiempo;
    
    public Cronometro(){// Contructor porque la clase es heredada 
        super();
    }
    
    @Override
    public void run() {
        int min=0; //El Contador de minutos
        int seg=0; //El Contador de de segundos
        int hora=0; //El Contador de Horas   
        try {//si ocurre un error al dormir el proceso(sleep(999))
            for (; ;){ //inicio del for infinito           
               if(seg!=59) {//si no es el ultimo segundo
                   seg++; //incremento el numero de segundos                                  
                }else{
                    if(min!=59){//si no es el ultimo minuto
                        seg=0;//pongo en cero los segundos 
                        min++;//incremento el numero de minutos
                    }else{//incremento el numero de horas
                            hora++;
                            min=0;//pongo en cero los minutos
                            seg=0;//pongo en cero los segundos           
                    }
                }               
            tiempo = hora+":"+min+":"+seg;//Muestro en pantalla el cronometro
            sleep(999);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }//Fin del for infinito             
        } catch (Exception ex) {
            System.out.println(ex.getMessage());//Imprima el error
        }                 
    } 
 
    public static void main(String[] args) {
        Cronometro c=new Cronometro(); //Intancio la clase
        c.start(); //Ejecuto el metodo run del Thread        
    }
    
    public String getTiempo(){
        return tiempo;
    }
            
}
