package Clases;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Clase de datos de una persona
*******************************************************************************/

public class Persona 
{
    private String strCedula;
    private String strNombres;
    
    public Persona(){}

    public Persona(String _strName, String _strCedula)
    {
        strNombres = _strName;
        strCedula = _strCedula;
    }

    public Persona(String _strCedula)
    {
        strCedula = _strCedula;
    }
    
    public String getName()
    {
        return strNombres;
    }
    
    public String getCedula()
    {
        return strCedula;
    }
}
