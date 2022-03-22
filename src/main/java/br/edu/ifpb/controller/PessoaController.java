package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Dependente;
import br.edu.ifpb.domain.DependenteInterface;
import br.edu.ifpb.domain.Pessoa;
import br.edu.ifpb.domain.PessoasInterface;
import br.edu.ifpb.infra.DependenteJDBC;
import br.edu.ifpb.infra.PessoaJDBC;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("pessoaController")
@SessionScoped
public class PessoaController implements Serializable {

    private PessoasInterface pessoasInterface;
    private Pessoa pessoa = new Pessoa();
    private Dependente dependente = new Dependente();
    private List<Pessoa> pessoaList = new ArrayList<>();
    private String cpf = "";
    private static final Logger logger = Logger.getLogger(PessoaJDBC.class.getName());

    public PessoaController(){
        this.pessoasInterface = (PessoasInterface) new PessoaJDBC();

    }

    public List<Pessoa> listar(){
        List<Pessoa> pessoasList = this.pessoasInterface.todas();
        return pessoasList;
    }

    public List<Dependente> listarDependentesPorId(Long id){
        List<Dependente> dependenteList = pessoasInterface.localizarDependenteComId(id);
        return dependenteList;
    }

    public String salvarPessoa(){
        logger.log(Level.INFO, "dependente:" + this.dependente);
        if(Objects.isNull(this.pessoa.getId())){
            this.pessoasInterface.nova(this.pessoa);
        } else{
            this.pessoasInterface.atualizar(this.pessoa);
        }
        this.pessoa = new Pessoa();
        return "/pessoa/list?faces-redirect=true";
    }

    public String deletePessoa(Pessoa pessoa){
        pessoasInterface.excluir(pessoa);
        return "/pessoa/list?faces-redirect=true";
    }

    public String edit(Pessoa pessoa){
        this.pessoa = pessoa;
        return "/pessoa/edit?faces-redirect=true";
    }

    public List<Pessoa> procurarCpf() {
        this.pessoaList = this.pessoasInterface.localizarPessoaComCPF(cpf);
        return pessoaList;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Dependente getDependente() {
        return dependente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }
}
