package aval3.state;

import java.util.Map;

import aval3.Disciplina;
import aval3.state.AbstractCursoState;
import aval3.state.CursoState;
import aval3.state.OperacaoInvalida;

public class ConcluidoState extends AbstractCursoState implements CursoState {

	@Override
	public String getNome() {
		return "CONCLUIDO";
	}
	
	
	public String emitirCertificado(String cod, String nome, Map<String, Disciplina> disciplinas) throws OperacaoInvalida{
		String rep = "CERTIFICADO\n";
		rep =  rep + "[Curso] "  + cod + "-" + nome + "\n"; 
			for(Disciplina disciplina : disciplinas.values())
				rep = rep + "\t[" + disciplina.getCodigo() + "] - "+ disciplina.getNome() + "\n";
			return rep;	
	};
	
	

}
