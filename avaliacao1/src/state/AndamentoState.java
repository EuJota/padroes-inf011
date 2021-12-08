package state;

import model.Curso;
import model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class AndamentoState extends AbstractControladorState implements ControladorState {
    Curso curso;

    public AndamentoState(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void avancar(Curso curso1, String nomeDisciplina, Double pctCumprido) {
        List<Disciplina> disciplinaList = new ArrayList<>();

        for (Disciplina disciplina : curso.getDisciplinas()) {
            if (disciplina.getNome().equals(nomeDisciplina) && disciplina.getPctCumprido() < pctCumprido) {
                Disciplina disciplina1 = new Disciplina(disciplina);
                disciplina1.setPctCumprido(pctCumprido);
                disciplinaList.add(disciplina1);
            } else disciplinaList.add(disciplina);
        }

        curso.setDisciplinas(disciplinaList);
    }

    @Override
    public void getCheckpoint(Curso curso1) {
        curso1.listener(curso1.EVENTO_OCORRENCIA);
        return;
    }

    @Override
    public void restore(Curso.Checkpoint checkpoint) {
        if(checkpoint != null) {
            checkpoint.restore();
            //curso.listener(curso.EVENTO_RESTAURACAO);
        }
    }

    @Override
    public ControladorState concluir() {
        boolean todasDiscCompletas = false;

        for (Disciplina disciplina : this.curso.getDisciplinas()) {
            if (disciplina.getPctCumprido() == disciplina.getChTotal())
                todasDiscCompletas = true;
        }

        if (todasDiscCompletas) {
            System.out.println("Curso completo");
            return new ConcluidoState(this.curso);
        } else {
            System.out.println("Curso nao completo ainda");
            return this;
        }
    }

    @Override
    public ControladorState suspender() {
        return new SuspensoState(curso);
    }
}
