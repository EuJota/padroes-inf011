package Factory;
import Factory.ConcreteClass.CursoConcreteFactory;
import Factory.ConcreteClass.DisciplinaConcreteFactory;
import Factory.ConcreteClass.LivroConcreteFactory;
import model.Produto;
import model.TipoProduto;

public class Factory {
   public Produto criarProduto(String nome, String codigo, String tipo) {
       switch (tipo) {
          case "disciplina":
             return new DisciplinaConcreteFactory().criarProduto(nome, codigo);
           case "livro":
               return new LivroConcreteFactory().criarProduto(nome, codigo);
           default: return new CursoConcreteFactory().criarProduto(nome, codigo);
       }
   }
}
