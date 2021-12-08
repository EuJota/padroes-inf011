package state;

import model.Curso;

public class AbstractControladorState implements ControladorState {
    @Override
    public void avancar(Curso curso, String nomeDisciplina, Double pctCumprido) {
        return;
    }

    @Override
    public void getCheckpoint(Curso curso) {
        return ;
    }

    @Override
    public void restore(Curso.Checkpoint checkpoint) {
        return;
    }

    @Override
    public void getCertificado() {
        return;
    }

    @Override
    public ControladorState concluir() {
        return this;
    }

    @Override
    public ControladorState cancelar() { return this; }

    @Override
    public ControladorState suspender() {
        return this;
    }

    @Override
    public ControladorState andamento() {
        return this;
    }
}
