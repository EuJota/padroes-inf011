package Factory.ConcreteClass;

import model.ProdutoContrato;
import model.Produto;

public class CursoConcreteFactory implements ProdutoContrato {

    @Override
    public Produto criarProduto(String nome, String codigo) {
        return null;
    }
}
