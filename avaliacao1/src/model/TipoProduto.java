package model;

public enum TipoProduto {
    LIVRO("livro"), DISCIPLINA("disciplina"), CURSO("curso");

    private String nomeTipo;

    private TipoProduto(String nomeTipo) {
        nomeTipo = nomeTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }
}
