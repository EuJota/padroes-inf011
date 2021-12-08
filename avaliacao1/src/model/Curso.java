package model;

import observer.Evento;
import observer.StateCheckpointObserver;
import prototype.Prototype;
import state.AndamentoState;
import state.ControladorState;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto implements Prototype {
    public final String EVENTO_RESTAURACAO = "restauracao";
    public final String EVENTO_OCORRENCIA = "ocorrencia";

    public static class Checkpoint {
        private Curso curso;

        private Checkpoint(Curso curso) {
            this.curso = new Curso(curso);
        }

        public void restore() {
            System.out.println(this.curso);
            this.curso.setChTotal(10);
            this.curso.setDisciplinas(new ArrayList<Disciplina>());
            System.out.println(this.curso);
            //this.curso.setDisciplinas(curso.getDisciplinas());
        }

        @Override
        public String toString() {
            return "Checkpoint { " +
                    curso.chTotal + " " +
                    curso.nome + " " +
                    " curso = " + curso.disciplinas.toString() +
                    '}';
        }
    }

    private List<Disciplina> disciplinas;
    private List<Livro> livros;
    private int chTotal;
    private boolean notificacoesOn = false;
    private List<TipoNotificacao> tiposNotificacao;
    private ControladorState state;

    public Curso() {
        this.livros = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.chTotal = this.getCHTotal();
        this.state = new AndamentoState(this);
    }

    public Curso(Curso curso) {
        this.nome = curso.nome;
        this.codigo  = curso.codigo;
        this.chTotal = curso.getCHTotal();
        this.preco = curso.preco;
        this.disciplinas = curso.disciplinas;
        this.livros = curso.livros;
        this.notificacoesOn = curso.notificacoesOn;
        this.tiposNotificacao = curso.tiposNotificacao;
        this.state = curso.state;
    }

    public void concluirCurso() {
        this.state = this.state.concluir();
    }

    public void retomarAndamentoCurso() {
        this.state = this.state.andamento();
    }

    public void suspenderCurso() {
        this.state = this.state.suspender();
    }

    public void cancelarCurso() {
        this.state = this.state.cancelar();
    }

    public void getCertificado() {
        this.state.getCertificado();
    }

    public void avancarDisciplina(String nomeDisciplina, Double pctCumprido) {
        this.state.avancar(this, nomeDisciplina, pctCumprido);
    }

    public Checkpoint getCheckpoint() {
        return this.state.getCheckpoint(this);
    }

    public void restore(Checkpoint checkpoint) {
        System.out.println("restore "+checkpoint);
        checkpoint.restore();
        //this.state.restore(checkpoint);
    }

    public void ativarObserver(List<TipoNotificacao> tiposNotificacao) {
        this.notificacoesOn = true;
        this.tiposNotificacao = tiposNotificacao;
    }

    public void desativarObserver() {
        this.notificacoesOn = false;
        this.tiposNotificacao.clear();
    }

    public void listener(String descricao) {
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

    public void setChTotal(int chTotal) { this.chTotal = chTotal; }

    public int getCHTotal() {
        int chTotal = 0;
        for (Disciplina disciplina : this.disciplinas)
            chTotal += disciplina.getChTotal();

        this.chTotal = chTotal;
        return this.chTotal;
    }

    public double getPctTotalCumprido() {
        double pctCumprido = 0;

        for (Disciplina disciplina : disciplinas)
            pctCumprido += disciplina.getPctCumprido();

        return pctCumprido;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    public void setLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void updateChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    public void getState() {
        System.out.println("Estado atual "+this.state);
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