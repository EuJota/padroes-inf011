import factory.Factory;
import Singleton.Catalogo;
import model.Curso;
import model.Produto;

public class App {

    static Produto criarProduto(String nomeProduto, String codigo) {
        Factory factory = new Factory();
        return factory.criarProduto(nomeProduto, codigo, "curso");
    }

    static void criarClonesCursos(String nomeCurso) {
        Catalogo catalogo = Catalogo.getInstance();
        Curso curso = (Curso) catalogo.resgatarCursoBase(nomeCurso).clonar();

        System.out.println(curso.toString());
    }


    public static void main(String[] args) {
        // testando singleton e criacao de produtos a partir da factory (criando apenas cursos para teste)
        Catalogo catalogo = Catalogo.getInstance();

        criarProduto("curso teste","12345");
        criarProduto("curso teste","12345");
        criarProduto("curso teste 2","123454124");
        criarProduto("curso teste 3","12344125");
        criarProduto("curso teste 4","12345517613");

        catalogo.printCatalogo();

        //testando criar clone a partir do prototype
        criarClonesCursos("curso teste");
    }
}
