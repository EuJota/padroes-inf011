package aval3.state;

import java.util.List;
import java.util.Map;

import aval3.Curso;
import aval3.Curso.Situacao;
import aval3.Disciplina;
import aval3.observer.CheckpointListener;
import aval3.state.*;
import aval3.state.AbstractCursoState;
import aval3.state.CursoState;
import aval3.state.EmAndamentoState;
import aval3.state.OperacaoInvalida;

public class SuspensoState extends AbstractCursoState implements CursoState {


	@Override
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas,
			List<CheckpointListener> checkpointListeners) throws OperacaoInvalida {
		this.notifyCheckpointEvent(disciplinas, checkpointListeners);
		return  curso.new Situacao(curso, disciplinas);
	}

	@Override
	public CursoState continuar() {
		return new EmAndamentoState();
	}

	@Override
	public CursoState cancelar() {
		return new CanceladoState();
	}

	@Override
	public String getNome() {
		return "SUSPENSO";
	}

}
