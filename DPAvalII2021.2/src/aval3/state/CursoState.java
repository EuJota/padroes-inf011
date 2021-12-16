package aval3.state;

import java.util.List;
import java.util.Map;

import aval3.Curso;
import aval3.Curso.Situacao;
import aval3.Disciplina;
import aval3.observer.CheckpointListener;
import aval3.state.OperacaoInvalida;

public interface CursoState {

	public void avancar(Map<String, Disciplina> disciplinas, String cdDisciplina, double pct) throws OperacaoInvalida;
	public Situacao checkpoint(Curso curso, Map<String, Disciplina> disciplinas, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public void restore(Situacao situacao, List<CheckpointListener> checkpointListeners) throws OperacaoInvalida;
	public String emitirCertificado(String cod, String nome, Map<String, Disciplina> disciplinas) throws OperacaoInvalida;
	public aval3.state.CursoState continuar();
	public aval3.state.CursoState suspender();
	public aval3.state.CursoState concluir(Map<String, Disciplina> disciplinas);
	public aval3.state.CursoState cancelar();

}
