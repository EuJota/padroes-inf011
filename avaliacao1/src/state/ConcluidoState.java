package state;

import model.Curso;

public class ConcluidoState extends AbstractControladorState implements ControladorState {
    Curso curso;

    ConcluidoState(Curso curso) { this.curso = curso; }

    @Override
    public void getCertificado() {
        if(this.curso.getCHTotal() == this.curso.getPctTotalCumprido()) {
            System.out.println("Certificado de conclusao do this.curso " + this.curso.nome);
            this.curso.desativarObserver();
        } else System.out.println("Curso incompleto\n");
    }
}
