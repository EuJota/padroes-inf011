package aval3.fm;

import aval3.Livro;
import aval3.Produto;
import aval3.fm.ProdutoFactory;

public class LivroFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Livro(codigo, nome);
	}

}
