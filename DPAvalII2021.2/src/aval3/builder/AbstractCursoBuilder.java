package aval3.builder;

import java.util.LinkedList;
import java.util.List;

import aval3.Curso;
import aval3.Disciplina;
import aval3.Livro;

public abstract class AbstractCursoBuilder<T> implements CursoBuilderIF<T>{

	protected String codigo;
	protected String nome;
	protected List<Disciplina> disciplinas;
	protected List<Livro> livros;
	protected List<Curso> cursos;


	public AbstractCursoBuilder() {
		this.reset();
	}

	@Override
	public CursoBuilderIF<T> reset() {
		this.codigo = "";
		this.nome = "";
		this.disciplinas= new LinkedList<Disciplina>();
		this.livros= new LinkedList<Livro>();
		this.cursos= new LinkedList<Curso>();
		return this;
	}

	@Override
	public CursoBuilderIF<T> setNome(String nome) {
		this.nome = nome;
		return this;
	}

	@Override
	public CursoBuilderIF<T> setCodigo(String codigo) {
		this.codigo = codigo;
		return this;
	}

	@Override
	public CursoBuilderIF<T> addDisciplina(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
		return this;
	}

	@Override
	public CursoBuilderIF<T> addLivro(Livro livro) {
		this.livros.add(livro);
		return this;
	}

	public CursoBuilderIF<T> addCurso(Curso curso) {
		this.cursos.add(curso);
		return this;
	}

}
