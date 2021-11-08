package factory;
import factory.ConcreteClass.DisciplinaConcreteFactory;
import factory.ConcreteClass.LivroConcreteFactory;
import model.*;

public class Factory {
   public Produto criarProduto(String nome, String codigo, TipoProduto tipo) {
       if (tipo == TipoProduto.DISCIPLINA) {
           return new DisciplinaConcreteFactory().criarProduto(nome, codigo);
       }
       return new LivroConcreteFactory().criarProduto(nome, codigo);
   }
}
