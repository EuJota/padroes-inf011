package aval3.state;


import aval3.state.AbstractCursoState;
import aval3.state.CursoState;

public class CanceladoState extends AbstractCursoState implements CursoState {

	@Override
	public String getNome() {
		return "CANCELADO";
	}


}
