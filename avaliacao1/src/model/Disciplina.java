package model;

import prototype.Prototype;

public class Disciplina extends Produto implements Prototype {
    private int chTotal;
    private double pctCumprido;

    public Disciplina(){
        super();
    }

    public Disciplina(Disciplina disciplina) {
        this.chTotal = disciplina.chTotal;
        this.pctCumprido = disciplina.pctCumprido;
    }

    public Disciplina(String codigo, String nome,
                      int chTotal,
                      double pcCumprido, double preco) {
        this.chTotal = chTotal;
        this.pctCumprido = pcCumprido;
        this.preco = preco;
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

    public String getNome() {
        return this.nome;
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

    @Override
    public Produto clonar() {
        return new Disciplina(this);
    }
}