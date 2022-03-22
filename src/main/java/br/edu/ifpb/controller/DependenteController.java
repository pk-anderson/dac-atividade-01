package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.DependenteInterface;
import br.edu.ifpb.infra.DependenteJDBC;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;

@Named("dependenteController")
@SessionScoped
public class DependenteController implements Serializable {
    private DependenteInterface dependenteInterface;
    private Dependente dependente = new Dependente();
    public DependenteController() {
        this.dependenteInterface = (DependenteInterface) new DependenteJDBC();
    }

    public String gravarDependente(){
        if(Objects.isNull(this.dependente.getId())){
            this.dependenteInterface.novoDependente(this.dependente);
        } else{
            this.dependenteInterface.atualizarDependente(this.dependente);
        }
        this.dependente = new Dependente();
        return "/dependente/list?faces-redirect=true";
    }

    public String atualizarDependente(Dependente dependente){
        this.dependente = dependente;
        return "/dependente/edit?faces-redirect=true";
    }

    public List<Dependente> listarDependentes(){
        List<Dependente> listDependente = this.dependenteInterface.todosDependentes();
        return listDependente;
    }

    public String deletarDependente(Dependente dependente) {
        this.dependenteInterface.excluirDependente(dependente);
        return "/dependente/list?faces-redirect=true";
    }

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
}
