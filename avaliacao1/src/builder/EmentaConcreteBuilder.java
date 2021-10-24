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
    public void setDisciplina(Disciplina disciplina) {
        this.ementa.setDisciplina(disciplina);
    }

    @Override
    public void setDisciplina(String nomeDisciplina) {

    }

    @Override
    public void setLivro(Livro livro) {
        this.ementa.setLivro(livro);
    }

    @Override
    public void setLivro(String nomeLivro) {

    }

    public Ementa getResultado() {
        if(this.ementa == null)
            reset();

        return this.ementa;
    }
}
