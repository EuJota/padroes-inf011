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

    public double getPctCumprido() {
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
                disciplinas += (disciplina.toString() + " ");
            }

        if (this.livros != null)
            for (Livro livro : this.livros) {
                livros += (livro.toString() + " ");
            }

        return "Curso{" +
                "disciplinas=" + disciplinas +
                ", livros=" + livros +
                ", chTotal=" + chTotal +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }

    @Override
    public Produto clonar() {
        return new Curso(this);
    }
}