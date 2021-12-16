package aval3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import aval3.observer.CheckpointListener;
import aval3.prototype.Prototipavel;
import aval3.state.CursoState;
import aval3.state.EmAndamentoState;
import aval3.state.OperacaoInvalida;

public class Curso extends Produto{
	
	public class Situacao{
		
		private Curso curso;
		private Map<String, Disciplina> disciplinas;
		
		public Situacao(Curso curso, Map<String, Disciplina> disciplinas) {
			this.curso = curso;
			this.disciplinas = new HashMap<String, Disciplina>();
			for(String codigo : disciplinas.keySet())
				this.disciplinas.put(codigo, 
									 (Disciplina) disciplinas.get(codigo).prototipar());
		}
		
		public void restore() {
			this.curso.disciplinas = this.disciplinas;
		}
		
		public Map<String, Disciplina> getDisciplinas() {
			return this.disciplinas;
		}
		
	}
	

	private List<Curso> cursos;
	private Map<String, Disciplina> disciplinas;
	private List<Livro> livros;
	private List<Produto> produtos;
	private CursoState cursoState;
	private List<CheckpointListener> checkpointListeners;
	
	
	private Curso(Curso curso) {
		super(curso);
		this.cursos = new LinkedList<>();

		for (Curso c : curso.cursos)
			this.cursos.add((Curso) c.prototipar());

		this.disciplinas = new HashMap<String, Disciplina>();

		for(String codigo : curso.disciplinas.keySet())
			this.disciplinas.put(codigo, 
								 (Disciplina) curso.disciplinas.get(codigo).prototipar());

		this.livros = new LinkedList<Livro>();

		for(Livro l : curso.livros)
			this.livros.add((Livro)l.prototipar());

		this.checkpointListeners = new LinkedList<CheckpointListener>();

		for(CheckpointListener listener : curso.checkpointListeners)
			this.checkpointListeners.add(listener);

		this.cursoState = curso.cursoState;
	}
	
	public Curso(String codigo, String nome) {
		super(codigo, nome);
		this.cursos = new LinkedList<>();
		this.disciplinas = new HashMap<String, Disciplina>();
		this.livros = new LinkedList<Livro>();
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		this.cursoState = new EmAndamentoState();
	}

	public Curso(String codigo, String nome,
				 List<Disciplina> disciplinas,
				 List<Livro> livros) {
		super(codigo, nome);
		this.cursos = new LinkedList<Curso>();
		this.disciplinas = new HashMap<String, Disciplina>();
		for(Disciplina d : disciplinas)
			this.disciplinas.put(d.getCodigo(), d);
		this.livros = new LinkedList<Livro>(livros);
		this.checkpointListeners = new LinkedList<CheckpointListener>();
		this.cursoState = new EmAndamentoState();
	}
	
	public Curso(String codigo, String nome, List<Curso> cursos,
				 List<Disciplina> disciplinas,
				 List<Livro> livros) {
		super(codigo, nome);
		this.cursos = new LinkedList<Curso>(cursos);
		this.disciplinas = new HashMap<String, Disciplina>();
		for(Disciplina d : disciplinas)
			this.disciplinas.put(d.getCodigo(), d);
		this.livros = new LinkedList<Livro>(livros);
		this.checkpointListeners = new LinkedList<CheckpointListener>();	
		this.cursoState = new EmAndamentoState();
	}

	@Override
	public double getPreco() {
		double valorComponentes = 0;
		double valorLivros = 0;

		produtos = new LinkedList<>();
		produtos.addAll(this.disciplinas.values());

		if(this.cursos != null)
			produtos.addAll(this.cursos);

		valorComponentes = produtos.stream().mapToDouble(Produto::getPreco).sum();

		if(this.livros != null)
			valorLivros = livros.stream().mapToDouble(Produto::getPreco).sum();

		return (valorComponentes - (valorComponentes * 0.20))+(valorLivros - (valorLivros * 0.10));
	}
	
	public String toString() {
		String rep =  "[Curso] "  + this.getCodigo() + "-" + this.getNome() + "\n"; 
		for(Disciplina disciplina : this.disciplinas.values())
			rep = rep + disciplina + "\n";
		return rep;
	}
	
	public String emitirCertificado()  throws OperacaoInvalida{
		return this.cursoState.emitirCertificado(this.getCodigo(), this.getNome(), this.disciplinas);
	}

	@Override
	public Prototipavel prototipar() {
		return new Curso(this);
	}	
	
	public void avancar(String cdDisciplina, double pct) throws OperacaoInvalida {
		this.cursoState.avancar(this.disciplinas, cdDisciplina,  pct);
	}
	
	public Situacao checkpoint() throws OperacaoInvalida {
		return this.cursoState.checkpoint(this, this.disciplinas, this.checkpointListeners);
	}

	public void restore(Situacao situacao) throws OperacaoInvalida {
		 this.cursoState.restore(situacao, this.checkpointListeners);
	}		
	
	public void addCheckpointListener(CheckpointListener listener) {
		this.checkpointListeners.add(listener);
	}
	
	public void removeCheckpointListener(CheckpointListener listener) {
		this.checkpointListeners.remove(listener);
	}

	public void continuar() {
		this.cursoState = this.cursoState.continuar();
	}

	public void suspender() {
		this.cursoState = this.cursoState.suspender();
	}

	public void concluir() {
		this.cursoState =  this.cursoState.concluir(this.disciplinas);
	}

	public void cancelar() {
		this.cursoState =  this.cursoState.cancelar();	
	}

}
