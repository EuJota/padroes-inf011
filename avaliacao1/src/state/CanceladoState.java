package state;

import model.Curso;

public class CanceladoState extends AbstractControladorState implements ControladorState {
    Curso curso;

    CanceladoState(Curso curso) { this.curso = curso;}


    @Override
    public ControladorState cancelar() {
        curso.desativarObserver();
        curso = null;

        return this;
    }
}
