package aval3.fm;

import java.lang.reflect.InvocationTargetException;

import aval3.Produto;
import aval3.fm.TipoProduto;

public abstract class ProdutoFactory {
	
	public static Produto novoProduto(TipoProduto tipo, String codigo, String nome) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		aval3.fm.ProdutoFactory factory =
				(ProdutoFactory) Class.forName(tipo.getFactoryName()).getConstructor().newInstance();
		return factory.createProduto(codigo, nome);
	}

	public abstract  Produto createProduto(String codigo, String nome);
}
