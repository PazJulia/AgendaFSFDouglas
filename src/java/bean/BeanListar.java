
package bean;

import dao.ConexaoPostgreSQL;
import dao.crud.ExecSQL;
import dao.model.Agenda;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "listar")
@SessionScoped
public class BeanListar {
    
    public BeanListar(){
        
    }
    
    public List<Agenda> getListaAgenda(){
       ExecSQL sql = new ExecSQL(); 
       return sql.listaAgenda();
    }
    
    public void deletaItem(int id){
        ExecSQL sql = new ExecSQL();
        sql.executaUpd("delete from agenda_telefonica where id = "+id+";");
    }
    
    public String editar(BeanCadastrar bc, String nome, String telefone, int id){
        bc.setAlert(false);
        bc.setNome(nome);
        bc.setTelefone(telefone);
        bc.setNovo(false);
        bc.setId(id);
        return "go-to-cadastrar";
    }
    
}
