import builder.CursoConcreteBuilder;
import builder.Diretor;
import factory.Factory;
import Singleton.Catalogo;
import model.*;

import java.util.List;

public class App {
    Catalogo catalogo;

    public void run() {
        catalogo = Catalogo.getInstance();

        // testando singleton e criacao de produtos a partir da factory (criando apenas cursos para teste)
        catalogo.printCatalogo();

        //testando criar clone a partir do prototype
        criarClonesCursos("curso teste");
    }

    /**
     * Responsável por criar um Livro ou Disciplina
     * @param nomeProduto
     * @param codigo
     * @param tipoProduto
     * @return Produto -> Livro ou Disciplina
     */
    static Produto criarProduto(String nomeProduto, String codigo, TipoProduto tipoProduto) {
        Factory factory = new Factory();
        return factory.criarProduto(nomeProduto, codigo, tipoProduto);
    }

    /**
     * Cria um produto livre, do tipo curso e adiciona o curso no catalogo
     * Também permite a visualização da ementa de um curso
     * @param nome
     * @param codigo
     * @param livros
     * @param disciplinas
     */
    static void criarCursoBase(String nome, String codigo, List<Livro> livros, List<Disciplina> disciplinas) {
        Catalogo catalogo = Catalogo.getInstance();
        Diretor diretor = new Diretor();
        CursoConcreteBuilder builder = new CursoConcreteBuilder();
        diretor.constructorSimplesCurso(nome, codigo, builder, livros, disciplinas);

        Curso curso = builder.getResultado();
        catalogo.salvarCurso(nome, curso);
    }

    /**
     * Encontra no catalogo um curso e cria clones a partir dele, com seu estado de carga horária zerado
     * @param nomeCurso
     */
    static void criarClonesCursos(String nomeCurso) {
        Catalogo catalogo = Catalogo.getInstance();
        Curso curso = (Curso) catalogo.resgatarCursoBase(nomeCurso).clonar();

        System.out.println(curso.toString());
    }


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
