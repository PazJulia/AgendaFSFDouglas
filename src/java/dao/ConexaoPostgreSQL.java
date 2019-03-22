
package dao;

import dao.crud.ExecSQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoPostgreSQL {
    
    private static final String database = "postgres";
    private static final String usuario = "root";
    private static final String senha = "";
    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String urlDB =  url + database;
    private static final String sqlCreateTB = "CREATE TABLE IF NOT EXISTS public.agenda_telefonica"+
                                              "("+
                                              "  id SERIAL PRIMARY KEY,"+
                                              "  nome text NOT NULL,"+
                                              "  telefone text NOT NULL"+                                              
                                              ");";

    private Connection con = null;
    private String logCon = "não conectado";
    
    public ConexaoPostgreSQL(){

        createDatabase();
        
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
    
    public String getStatus(){
        return this.logCon;
    }

    private void createDatabase() {
        
        try {
            Class.forName("org.postgresql.Driver");
            this.con = DriverManager.getConnection(urlDB, usuario, senha);
            Statement st = this.con.createStatement();
            st.executeUpdate(sqlCreateTB);
            this.logCon = "conectado";
            
        } catch (ClassNotFoundException | SQLException ex) {
            this.close();
            Logger.getLogger(ConexaoPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
        
}
