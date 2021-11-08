package factory;
import factory.ConcreteClass.CursoConcreteFactory;
import factory.ConcreteClass.DisciplinaConcreteFactory;
import factory.ConcreteClass.LivroConcreteFactory;
import Singleton.Catalogo;
import model.Curso;
import model.Produto;

public class Factory {
   public Produto criarProduto(String nome, String codigo, String tipo) {
       switch (tipo) {
          case "disciplina":
             return new DisciplinaConcreteFactory().criarProduto(nome, codigo);
           case "livro":
               return new LivroConcreteFactory().criarProduto(nome, codigo);
           default:
               Catalogo catalogo = Catalogo.getInstance();
               Produto produto = new CursoConcreteFactory().criarProduto(nome, codigo);


               catalogo.salvarCurso(nome, (Curso) produto);
               return produto;
       }
   }
}
