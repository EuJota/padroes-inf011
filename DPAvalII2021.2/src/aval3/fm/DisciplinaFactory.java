package aval3.fm;

import aval3.Disciplina;
import aval3.Produto;
import aval3.fm.ProdutoFactory;

public class DisciplinaFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Disciplina(codigo, nome);
	}

}
