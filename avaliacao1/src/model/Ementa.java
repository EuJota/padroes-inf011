package model;

import java.util.List;

public class Ementa {

    private String nome;
    private String codigo;
    private int cargaHoraria;
    private List<Disciplina> disciplinas;
    private List<Livro> livros;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public void setLivro(Livro livro) {
        this.livros.add(livro);
    }

    @Override
    public String toString() {
        return "Ementa{" +
                "cargaHoraria=" + cargaHoraria +
                '}';
    }
}
