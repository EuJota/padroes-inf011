package model;

public class Disciplina extends Produto {
    private int chTotal;
    private double pctCumprido;

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

    public int getChTotal() {
        return chTotal;
    }

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    public double getPctCumprido() {
        return pctCumprido;
    }

    public void setPctCumprido(double pctCumprido) {
        this.pctCumprido = pctCumprido;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "chTotal=" + chTotal +
                ", pctCumprido=" + pctCumprido +
                ", codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}