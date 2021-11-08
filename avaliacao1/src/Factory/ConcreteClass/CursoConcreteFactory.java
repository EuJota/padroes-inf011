package factory.ConcreteClass;

import builder.CursoConcreteBuilder;
import builder.Diretor;
import model.*;

import java.util.List;

public class CursoConcreteFactory implements ProdutoContrato {

    @Override
    public Produto criarProduto(String nome, String codigo) {
        Diretor diretor = new Diretor();
        CursoConcreteBuilder builder = new CursoConcreteBuilder();
        diretor.constructorSimplesCurso(nome, codigo, builder);

        return builder.getResultado();
    }


    public Produto criarProduto(String nome, String codigo, List<Livro> livros, List<Disciplina> disciplinas) {
        Diretor diretor = new Diretor();
        CursoConcreteBuilder builder = new CursoConcreteBuilder();
        diretor.constructorSimplesCurso(nome, codigo, builder, livros, disciplinas);

        return builder.getResultado();
    }
}
