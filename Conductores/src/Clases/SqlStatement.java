/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clases;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Genera las sentencias 
*******************************************************************************/

public class SqlStatement {
    
    public SqlStatement(){        
    }
    
    public String getInsertStatement(String tabla, String[] setFields){
        String statement;        
        
        statement = "INSERT INTO " + tabla + " VALUES (";
        
        for(int i=0; i < setFields.length; i++){
            if(setFields.length != i+1){
                statement += "?, ";
            }
            else{
                statement += "?";
            }
        }
        statement += ")";
               
        
        return statement.trim();
    }              
    
    public String getSelectStatement(String tabla, String[] setFields
            , String[] whereFields){
        String statement;        
        
        statement = "SELECT ";
        
        for(int i=0; i < setFields.length; i++){
            if(setFields.length != i+1){
                statement += setFields[i] + ", ";
            }
            else{
                statement += setFields[i];
            }            
        }
        
        statement += " FROM " + tabla + " WHERE ";        
        
        for(int i=0; i < whereFields.length; i++){
            statement += whereFields[i] + "=? ";
        }
        
                
        return statement.trim();
    }
    
    public String getDeleteStatement(String tabla, String[] whereFields){
        String statement;        
        
        statement = "DELETE FROM " + tabla + " WHERE ";
        
        for(int i=0; i < whereFields.length; i++){
            statement += whereFields[i] + "=? ";
        }
        
        return statement.trim();
    }
    
    /* //No aplica para el ejercicio
    public String getUpdateStatement(String tabla, String[] setFields, 
            String[] whereFields){
        String statement;        
        
        statement = "UPDATE " + tabla + " set ";
        
        for(int i=0; i < setFields.length; i++){
            statement += setFields[i] + "=? ";
        }
        statement += "WHERE ";
        for(int i=0; i < whereFields.length; i++){
            statement += whereFields[i] + "=? ";
        }        
        
        return statement.trim();
    }  
    */
}
