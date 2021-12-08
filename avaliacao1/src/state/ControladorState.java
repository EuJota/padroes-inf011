package state;

import model.Curso;

public interface ControladorState {
    void avancar(Curso curso, String nomeDisciplina, Double pctCumprido);
    Curso.Checkpoint getCheckpoint(Curso curso);
    void restore(Curso.Checkpoint checkpoint);
    void getCertificado();
    ControladorState concluir();
    ControladorState cancelar();
    ControladorState suspender();
    ControladorState andamento();
}
