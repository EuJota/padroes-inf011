package aval3.builder;

import aval3.Curso;
import aval3.Disciplina;
import aval3.Livro;

public interface CursoBuilderIF<T> {
	public aval3.builder.CursoBuilderIF<T> reset();
	public aval3.builder.CursoBuilderIF<T> setNome(String nome);
	public aval3.builder.CursoBuilderIF<T> setCodigo(String codigo);
	public aval3.builder.CursoBuilderIF<T> addDisciplina(Disciplina disciplina);
	public aval3.builder.CursoBuilderIF<T> addLivro(Livro livro);
	public aval3.builder.CursoBuilderIF<T> addCurso(Curso curso);
	public T build();
}
