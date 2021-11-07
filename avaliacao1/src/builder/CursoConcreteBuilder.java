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
    public void setNomeCurso(String nomeCurso) {
        this.curso.setNome(nomeCurso);
    }

    @Override
    public void setCodigoCurso(String codigoCurso) {
        this.curso.setCodigo(codigoCurso);
    }

    @Override
    public void setDisciplina(Disciplina disciplina) {
        this.curso.setDisciplina(disciplina);
    }

    @Override
    public void setLivro(Livro livro) {
        this.curso.setLivro(livro);
    }


    public Curso getResultado() {
        if(this.curso == null)
            reset();

        return curso;
    }
}
