package Clases;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Clase de Conductor
*******************************************************************************/

public class Conductor extends Persona{
    
    private String correo; 
    private String telefono;
    
    // <Contructor>
    public Conductor(String _cedula, String _nombre ,String _correo, String _telefono) {
        super(_nombre, _cedula);
        correo = _correo;
        telefono = _telefono;
    }
    
    public Conductor(String _cedula) {
        super(_cedula);        
    }
    // </Contructor>
    
    // <Métodos get/set de Variables globales>
    public String getCorreo(){
        return correo;
    }
    
    public String getTelefono(){
        return telefono;
    }
    // </Métodos get/set de Variables globales>
}
