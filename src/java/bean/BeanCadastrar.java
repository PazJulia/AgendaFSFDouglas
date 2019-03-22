
package bean;

import dao.crud.ExecSQL;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "cadastrar")
@SessionScoped
public class BeanCadastrar {
    
    private int id;
    private String nome = "";
    private String instituicao = "";
    private String telefone = "";
    private boolean alert = false;
    private boolean novo = true;
    private String mensagem;
    
    public BeanCadastrar(){
        
    }
    
    public void novocadastro(){
        
        ExecSQL novoCad = new ExecSQL();
        if(isNovo()){
            if(!this.nome.equals("") && !this.telefone.equals("")){
                if(novoCad.executaUpd("insert into agenda_telefonica (nome, instituicao, telefone) values ('"+this.nome+"', '"+this.instituicao+"', '"+this.telefone+"');") > 0){
                    this.setMensagem("Cadastro realizado com sucesso!");
                    this.setAlert(true);
                    this.nome = "";
                    this.telefone = "";    
                    this.instituicao = "";
                } else {
                    this.setAlert(false);
                }
            }
        } else {
            if(!this.nome.equals("") && !this.telefone.equals("")){
                if(novoCad.executaUpd("update agenda_telefonica set nome = '"+this.nome+"', instituicao = '"+this.instituicao+"', telefone = '"+this.telefone+"' where id = "+this.id+";") > 0){
                    this.setMensagem("Registro atualizado com sucesso!");
                    this.setAlert(true);
                    this.nome = "";
                    this.telefone = "";
                    this.instituicao = "";
                    this.novo = true;
                } else {
                    this.setAlert(false);
                }
            }
        }
        
    }

    /**
     * @return the nome
     */
    public String getNome() {
        this.alert = false;
        return nome;     
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
        this.alert = false;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        this.alert = false;
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
        this.alert = false;
    }

    /**
     * @return the alert
     */
    public boolean isAlert() {
        return alert;
    }

    /**
     * @param alert the alert to set
     */
    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the novo
     */
    public boolean isNovo() {
        return novo;
    }

    /**
     * @param novo the novo to set
     */
    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
    
    
    
}
