package model;

import observer.Evento;
import observer.StateCheckpointObserver;
import prototype.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto implements Prototype {
    private final String EVENTO_RESTAURACAO = "restauracao";
    private final String EVENTO_OCORRENCIA = "ocorrencia";

    /**
     * Inner class com responsabilidade de memento
     * classe com a responsabilidade de gerenciar os estados do curso: Restaurar estado e retornar estado
     */
    public class Checkpoint {
        private Curso curso;

        private Checkpoint(Curso curso) {
            this.curso = curso;
        }


        //TODO -> CORRIGIR RESTAURACAO DE ESTADO PARA MEMENTO
        private void restore() {
            listener(EVENTO_RESTAURACAO);
        }
    }

    public Checkpoint getCheckpoint() {
        listener(EVENTO_OCORRENCIA);
        return new Checkpoint(this);
    }

    private List<Disciplina> disciplinas;
    private List<Livro> livros;
    private int chTotal;
    private boolean notificacoesOn = false;
    private List<TipoNotificacao> tiposNotificacao;

    public Curso() {
        this.livros = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.chTotal = 0;
    }

    public Curso(Curso curso) {
        this.nome = curso.nome;
        this.codigo  = curso.codigo;
        this.chTotal = curso.chTotal;
        this.preco = curso.preco;
        this.disciplinas = curso.disciplinas;
        this.livros = curso.livros;
    }


    // TODO -> criar metodo get disciplina em disciplina pra remover esse if daqui
    public void avançarDisciplina(String nomeDisciplina, Double pctCumprido) {
        for (Disciplina disciplina : disciplinas) {
            if(disciplina.getNome().equals(nomeDisciplina) && disciplina.getPctCumprido() < pctCumprido){
                disciplina.setPctCumprido(pctCumprido);
                break;
            }
        }
    }

    public void restore(Checkpoint checkpoint) {
        checkpoint.restore();
    }

    public void ativarObserver(List<TipoNotificacao> tiposNotificacao) {
        this.notificacoesOn = true;
        this.tiposNotificacao = tiposNotificacao;
    }

    public void desativarObserver() {
        this.notificacoesOn = false;
        this.tiposNotificacao.clear();
    }

    private void listener(String descricao) {
        if(!this.tiposNotificacao.isEmpty() && notificacoesOn) {
            StateCheckpointObserver stateCheckpoint = new StateCheckpointObserver();
            stateCheckpoint.notifyStateChanged(new Evento(descricao, this.tiposNotificacao, this.disciplinas));
        }
    }

    public void addTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tiposNotificacao.add(tipoNotificacao);
    }


    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getCHTotal() {
        for (Disciplina disciplina : disciplinas)
            this.chTotal += disciplina.getChTotal();

        return this.chTotal;
    }

    public double getPctTotalCumprido() {
        double pctCumprido = 0;

        for (Disciplina disciplina : disciplinas)
            pctCumprido += disciplina.getPctCumprido();

        return pctCumprido;
    }

    public void setDisciplina(Disciplina disciplinas) {
        this.disciplinas.add(disciplinas);
    }

    public void setLivro(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public String toString() {
        String disciplinas = "";
        String livros = "";

        if (this.disciplinas != null)
            for (Disciplina disciplina : this.disciplinas) {
                disciplinas += (disciplina.toString() + "\n\t");
            }

        if (this.livros != null)
            for (Livro livro : this.livros) {
                livros += (livro.toString() + "\n\t");
            }

        return "Curso {\n" +
                "chTotal = " + chTotal +
                ", codigo = '" + codigo + '\'' +
                ", nome = '" + nome + '\'' +
                ", preco = " + preco + "\n" +
                "disciplinas = \n\t" + disciplinas +
                "livros = \n" + livros +
                '}';
    }

    @Override
    public Produto clonar() {
        return new Curso(this);
    }
}