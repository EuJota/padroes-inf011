package model;

public abstract class Produto {
    public String codigo;
    public String nome;
    public Double preco;

    public abstract void setCodigo(String codigo);
    public abstract void setNome(String nome);
    public abstract void setPreco(Double preco);
}
