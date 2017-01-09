/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import GUI.ConductorForm;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Clase principal, llama al formulario
*******************************************************************************/

public class ClassMain {

      
    public static void main(String[] args) {
        /*Conductor c1 = new Conductor("1718163825", "Juan Diego Naranjo", 
                "jdns_92@live.com", "0995480527");
        Conductor c2 = new Conductor("1719392085", "Diego Naranjo", 
                "dinar@yahoo.com", "0993406827");
        */
        /*HashMap<Integer,String> conductorMap1 = new HashMap<Integer,String>();
        conductorMap1.put(1, c1.getCedula());
        conductorMap1.put(2, c1.getCorreo());
        conductorMap1.put(3, c1.getCelular());
        HashMap<Integer,String> conductorMap2 = new HashMap<Integer,String>();
        conductorMap2.put(1, c2.getCedula());
        conductorMap2.put(2, c2.getCorreo());
        conductorMap2.put(3, c2.getCelular());*/
        
        //ConductorThread ct1 = new ConductorThread(c1, "INSERT");
        //ct1.setMinPriority();
        //ConductorThread ct2 = new ConductorThread(c2, "SELECT");
        //ct2.setMaxPriority();
        
        //ct1.start();
        //ct2.start();
        ConductorForm condForm = new ConductorForm();
        condForm.show();
    }
    
}
