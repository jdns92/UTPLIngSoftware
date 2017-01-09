package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*******************************************************************************
# Nombre : Juan Diego Naranjo
# Fecha  : 2016/12/20
# JDNaranjo: Clase de conección a la base de datos
*******************************************************************************/

public class SQLClass {
    
    // <JDBC driver y url de base de datos>
    static final String Driver_JDBC = "com.mysql.jdbc.Driver";  
    static final String URL_BaseDeDatos = "jdbc:mysql://localhost:3306/PROGRAMACION";
    // </JDBC driver y url de base de datos>
    
    // <Credenciales de base de datos>
    static final String User = "root";
    static final String Pass = "";
    // </Credenciales de base de datos>
       
    private Connection conn;
    private PreparedStatement stmt;   
    
    // <Constructor>
    public SQLClass(){
        try
        {
            Class.forName(Driver_JDBC);
            conn = DriverManager.getConnection(URL_BaseDeDatos, User, Pass);
        }
        catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    // </Constructor>
    
    
    public Connection getConnection(){ //Obtiene la conexión
        return conn;
    }
    
    public PreparedStatement getPreparedStatement(){ //Guarda la consulta 
        return stmt;
    }
    
    public void setPreparedStatement(PreparedStatement _stmt){ //Guarda la consulta 
        stmt = _stmt;
    }
    
    public void executeProcess(){ //Ejecuta la consulta
        try
        {           
            stmt.executeUpdate();            
        }
        catch(SQLException se) {
            System.out.println(se.getMessage());
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }   
    
    public void closeConnection(){ //Cierra la conexión
        try
        {
            conn.close();
        }
        catch(SQLException se) {
            System.out.println(se.getMessage());
        } 
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
