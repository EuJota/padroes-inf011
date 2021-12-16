package aval3.state;

import java.util.List;
import java.util.Map;

import aval3.Curso;
import aval3.Curso.Situacao;
import aval3.Disciplina;
import aval3.observer.CheckpointListener;
import aval3.state.AbstractCursoState;
import aval3.state.ConcluidoState;
import aval3.state.CursoState;
import aval3.state.OperacaoInvalida;
import aval3.state.SuspensoState;

public class EmAndamentoState extends AbstractCursoState implements CursoState {

	@Override
	public void avancar(Map<String, Disciplina> disciplinas, String cdDisciplina, double pct) throws OperacaoInvalida{
		Disciplina disciplina = disciplinas.get(cdDisciplina);
		disciplina.avancar(pct);
	}

	@Override
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida{
		this.notifyCheckpointEvent(disciplinas, checkpointListeners);
		return  curso.new Situacao(curso, disciplinas);
	}	
	
	@Override
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida {
		situacao.restore();
		this.notifyRestoreEvent(situacao.getDisciplinas(), checkpointListeners);
	}
	
	public CursoState suspender() {
		return new SuspensoState();
	};
	
	public CursoState concluir(Map<String, Disciplina> disciplinas) {
		if(this.disciplinasConcluidas(disciplinas))
			return new ConcluidoState();
		return this;
	};
	
	@Override
	public String getNome() {
		return "EM ANDAMENTO";
	}
	


}
