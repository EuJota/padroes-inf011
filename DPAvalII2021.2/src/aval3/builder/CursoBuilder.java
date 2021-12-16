package aval3.builder;

import aval3.Curso;
import aval3.builder.AbstractCursoBuilder;

public class CursoBuilder extends AbstractCursoBuilder<Curso>{
	
	public static aval3.builder.CursoBuilder factory() {
		return new CursoBuilder();
	}
	
	public Curso build() {
		return new Curso(this.codigo, this.nome, this.cursos, this.disciplinas, this.livros);
	}

}
