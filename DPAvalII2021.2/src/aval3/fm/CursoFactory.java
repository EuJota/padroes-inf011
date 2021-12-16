package aval3.fm;

import aval3.Curso;
import aval3.Produto;
import aval3.fm.ProdutoFactory;

public class CursoFactory extends ProdutoFactory{

	@Override
	public Produto createProduto(String codigo, String nome) {
		return new Curso(codigo, nome);
	}

}
