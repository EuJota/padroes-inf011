package model;

import prototype.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Produto implements Prototype {
    private List<Disciplina> disciplinas;
    private List<Livro> livros;
    private int chTotal;

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


    /**
     * Inner class com responsabilidade de memento
     * classe com a responsabilidade de gerenciar os estados do curso: Restaurar estado e retornar estado
     */
    public class Checkpoint {
        private Curso curso;

        private Checkpoint(Curso curso) {
            this.curso = curso;
        }


        //TODO -> CORRIGIR RESTAURACAO DE ESTADO
        private void restore() {

        }
    }

    public Checkpoint getCheckpoint() {
        return new Checkpoint(this);
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