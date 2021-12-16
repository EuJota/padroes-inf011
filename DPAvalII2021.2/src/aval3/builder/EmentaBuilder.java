package aval3.builder;

import aval3.Ementa;
import aval3.builder.AbstractCursoBuilder;

public class EmentaBuilder extends AbstractCursoBuilder<Ementa>{
	
	public static aval3.builder.EmentaBuilder factory() {
		return new aval3.builder.EmentaBuilder();
	}
	
	public Ementa build() {
		return new Ementa(this.codigo, this.nome, this.disciplinas, this.livros);
	}

}
