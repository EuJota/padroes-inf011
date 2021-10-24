package builder;

import model.Curso;
import model.Disciplina;
import model.Livro;

public class CursoConcreteBuilder  implements BuilderClass {
    Curso curso;

    @Override
    public void reset() {
        this.curso = new Curso();
    }

    @Override
    public void setDisciplina(Disciplina disciplina) {
        this.curso.setDisciplina(disciplina);
    }

    @Override
    public void setDisciplina(String nomeDisciplina) {
        //TODO -> METODO DE BUSCAR A DISCIPLINA A PARTIR DO NOME (OPCIONAL)
    }

    @Override
    public void setLivro(Livro livro) {
        this.curso.setLivro(livro);
    }

    @Override
    public void setLivro(String nomeLivro) {
        //TODO -> METODO DE BUSCAR O LIVRO A PARTIR DO NOME (OPCIONAL)
    }

    public Curso getResultado() {
        if(this.curso == null)
            reset();

        return curso;
    }
}
