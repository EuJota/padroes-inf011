package state;

import model.Curso;

public class AbstractControladorState implements ControladorState {
    @Override
    public void avancar(Curso curso, String nomeDisciplina, Double pctCumprido) {
        System.out.println("Acao nao pode ser executada");
    }

    @Override
    public Curso.Checkpoint getCheckpoint(Curso curso) {
        System.out.println("Acao nao pode ser executada");
        return null;
    }

    @Override
    public void restore(Curso.Checkpoint checkpoint) {
        System.out.println("Acao nao pode ser executada");
    }

    @Override
    public void getCertificado() {
        System.out.println("Curso nao esta no estado concluido");
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
