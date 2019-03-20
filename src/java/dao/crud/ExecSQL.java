/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.crud;

import dao.ConexaoPostgreSQL;
import dao.model.Agenda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecSQL {
    
    private ConexaoPostgreSQL con = null;
    
    public ExecSQL(){
        this.con = new ConexaoPostgreSQL();
    }
    
    public int executaUpd(String sql){
        
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
    
    
    
    public List<Agenda> listaAgenda(){
        
        String sql = "select * from agenda_telefonica;";
        ResultSet rs = null;
        List<Agenda> lstAg = new ArrayList<>();
        Statement st;
        try {
            st = this.con.getConnection().createStatement();
            rs = st.executeQuery(sql);
            this.con.getConnection().close();
            this.con.close();
            
            while(rs.next()){
                Agenda ag = new Agenda();
                ag.setId(rs.getInt("id"));
                ag.setNome(rs.getString("nome"));
                ag.setTelefone(rs.getString("telefone"));
                lstAg.add(ag);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExecSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lstAg;
        
    }
    
}
