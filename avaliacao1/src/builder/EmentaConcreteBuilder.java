package builder;

import model.Disciplina;
import model.Ementa;
import model.Livro;

public class EmentaConcreteBuilder implements BuilderClass {

    Ementa ementa;

    @Override
    public void reset() {
        this.ementa = new Ementa();
    }

    @Override
    public void setNomeCurso(String nomeCurso) {
        this.ementa.setNome(nomeCurso);
    }

    @Override
    public void setCodigoCurso(String codigoCurso) {
        this.ementa.setCodigo(codigoCurso);
    }

    @Override
    public void setDisciplina(Disciplina disciplina) {
        this.ementa.setDisciplina(disciplina);
    }


    @Override
    public void setLivro(Livro livro) {
        this.ementa.setLivro(livro);
    }

    public Ementa getResultado() {
        if(this.ementa == null)
            reset();

        return this.ementa;
    }
}
