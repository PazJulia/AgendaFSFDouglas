
package bean;

import dao.ConexaoPostgreSQL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "listar")
@SessionScoped
public class BeanListar {
    
    private ConexaoPostgreSQL conexao = null;
    
    private String constuctor = "não iniciado";
    
    public BeanListar(){
        this.conexao = new ConexaoPostgreSQL();
        this.constuctor = this.conexao.getLog();
    }
    
    public String getConstuctor(){
        return this.constuctor;
    }
    
}
