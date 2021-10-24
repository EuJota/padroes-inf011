package Factory.ConcreteClass;

import model.Livro;
import model.ProdutoContrato;
import model.Produto;

public class LivroConcreteFactory  implements ProdutoContrato {

    @Override
    public Produto criarProduto(String nome, String codigo) {
        Livro livro = new Livro();

        livro.setCodigo(codigo);
        livro.setNome(nome);
        livro.setIsbn("ISBN");
        livro.setPreco(100.00);

        return livro;
    }
}