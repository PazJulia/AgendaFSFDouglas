/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.crud;

import dao.ConexaoPostgreSQL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecSQL {
    
    private ConexaoPostgreSQL con = null;
    
    public ExecSQL(){
        this.con = new ConexaoPostgreSQL();
    }
    
    public int executaSQL(String sql){
        
        int res = -1;
        
        if(this.con != null){
            
            try {
                Statement stm = this.con.getConnection().createStatement();
                res = stm.executeUpdate(sql);
                this.con.getConnection().close();
                this.con.close();
                return res;
            } catch (SQLException ex) {
                Logger.getLogger(ExecSQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        return res;
    }
    
}
