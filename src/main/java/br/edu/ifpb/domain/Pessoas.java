package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.List;

public interface Pessoas extends Serializable {

    public void nova(Pessoa pessoa);

    public List<Pessoa> todas();

    public void excluir(Pessoa pessoa);

    public void atualizar(Pessoa pessoa);

    public Pessoa localizarPessoaComId(long id);

    public List<Dependente> todosOsDepentendes();

    public Dependente localizarDependenteComId(String uuid);

    public void novo(Dependente dependente);
}