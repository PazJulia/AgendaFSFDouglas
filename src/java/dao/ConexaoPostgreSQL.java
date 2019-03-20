
package dao;

import dao.crud.ExecSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoPostgreSQL {
    private static final String url = "jdbc:postgresql://localhost:5432/agenda";
    private static final String usuario = "postgres";
    private static final String senha = "";
    private Connection con = null;
    private String logCon = "não conectado";
    
    public ConexaoPostgreSQL(){

        try {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(url, usuario, senha);  
            this.logCon = "conectado";
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConexaoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void close(){
        if(this.con != null){
            try {
                this.con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexaoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Connection getConnection(){
        return this.con;
    }
    
    public String getLog(){
        return this.logCon;
    }
    
    
}
