import Factory.Factory;
import model.Produto;

public class App {

    public void criarCursoSemDiretor() {

    }

    static Produto criarProduto(String nomeProduto, String codigo) {
        Factory factory = new Factory();

        return factory.criarProduto(nomeProduto, codigo, "disciplina");
    }

    public static void main(String[] args) {
        Produto produto = criarProduto("disciplina teste","1234");

        System.out.println(produto.toString());
    }
}
