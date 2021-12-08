package state;

import model.Curso;

public class SuspensoState extends AbstractControladorState implements ControladorState {
    Curso curso;

    SuspensoState(Curso curso) {this.curso = curso;}
    /**
     * Os cursos suspensos também não podem avançar, nem restaurar
     * checkpoints, mas ainda podem gerar checkpoints e voltar a ser cursados.
     */

    @Override
    public Curso.Checkpoint getCheckpoint(Curso curso1) {
        curso1.listener(curso1.EVENTO_OCORRENCIA);
        return new Curso.Checkpoint(curso1);
    }

    @Override
    public ControladorState cancelar() {
        return new CanceladoState(curso);
    }

    @Override
    public ControladorState andamento() {
        return new AndamentoState(curso);
    }
}
