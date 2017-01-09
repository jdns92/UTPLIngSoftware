package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Ejecuta el proceso de conductores
*******************************************************************************/

public class ConductorProcess{
    
    private static final String INSERT  = "INSERT";
    private static final String DELETE  = "DELETE";
    private static final String SELECT  = "SELECT";
    private static final String TABLE = "CONDUCTOR";
    private static final String[] arrWhereField = {"CEDULA"}; //e manda quemado where
                                            //para no hacer muy complicado el programa,
                                            //además es la llave primaria y encontrrará el registro requerido                                            
    private static final String[] arrSetFields = {"CEDULA", "CORREO", "TELEFONO", "NOMBRE", };                                                            
    
    private final String strCedula;
    private final String strNombre;
    private final String strCorreo; 
    private final String strTelefono;          
    private final String strStatement;
    
    private PreparedStatement stmt;    
    private List<String> rowsList = new ArrayList<String>();
    
    public ConductorProcess(Conductor _conductor, String _strStatement){//HashMap<Integer,Object> _mapConductor, String _strStatement){        
        
        strCedula   = _conductor.getCedula();
        strNombre   = _conductor.getName();
        strCorreo   = _conductor.getCorreo();
        strTelefono  = _conductor.getTelefono();
        strStatement = _strStatement;
    }
        
    public void run(){        
        
        if (sqlProcess())
            System.out.println("Proceso completado exitosamente.");        
        else
            System.out.println("Error");        
    }
    
    public boolean sqlProcess(){
        SqlStatement sqlStm = new SqlStatement();
        SQLClass sqlClass = new SQLClass();
        String prepStatement = "";
        
        if (strCedula == ""){
            System.out.println("No se ha ingresado ninguna cédula.");
            return false;
        }
            
        try {
            switch(strStatement){
                case INSERT:
                    prepStatement = sqlStm.getInsertStatement(TABLE, arrSetFields);

                    stmt = sqlClass.getConnection().prepareStatement(prepStatement);
                    stmt.setString(1, strCedula);
                    stmt.setString(2, strCorreo);
                    stmt.setString(3, strTelefono);
                    stmt.setString(4, strNombre);

                    sqlClass.setPreparedStatement(stmt);
                    sqlClass.executeProcess();
                    break;

                case DELETE:
                    prepStatement = sqlStm.getDeleteStatement(TABLE, arrWhereField);

                    stmt = sqlClass.getConnection().prepareStatement(prepStatement);
                    stmt.setString(1, strCedula);                

                    sqlClass.setPreparedStatement(stmt);      
                    sqlClass.executeProcess();
                    break;

                case SELECT:
                    prepStatement = sqlStm.getSelectStatement(TABLE, arrSetFields, 
                        arrWhereField);

                    stmt = sqlClass.getConnection().prepareStatement(prepStatement);                
                    stmt.setString(1, strCedula); 

                    sqlClass.setPreparedStatement(stmt);                
                    break;

                default: break;
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(ConductorProcess.class.getName()).log(
                    Level.SEVERE, null, ex);
            return false;
        }                
        
        if (strStatement == SELECT)
        {
            setRows(sqlClass);
        }
        sqlClass.closeConnection();
        return true;
    }
    
    
    
    public void setRows(SQLClass _sqlClass){
        try 
        {
            _sqlClass.getPreparedStatement().executeQuery();
            ResultSet rs = _sqlClass.getPreparedStatement().getResultSet();

            while(rs.next()){                
                for(int i=0; i < arrSetFields.length; i++){
                    rowsList.add(rs.getString(arrSetFields[i]));
                }
            }            
        } catch (SQLException ex) {
            Logger.getLogger(ConductorProcess.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    public List<String> getRow(){
        return rowsList;
    }    
}
