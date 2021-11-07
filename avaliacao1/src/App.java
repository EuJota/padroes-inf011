import Factory.Factory;
import model.Produto;

public class App {

    static Produto criarProduto(String nomeProduto, String codigo) {
        Factory factory = new Factory();

        return factory.criarProduto(nomeProduto, codigo, "curso");
    }

    public static void main(String[] args) {
        Produto produto = criarProduto("curso teste","12345");

        System.out.println(produto.toString());
    }
}
