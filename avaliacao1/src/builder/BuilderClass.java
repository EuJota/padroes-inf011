package builder;

import model.Disciplina;
import model.Livro;

interface BuilderClass {
    void reset();
    void setNomeCurso(String nomeCurso);
    void setCodigoCurso(String codigoCurso);
    void setDisciplina(Disciplina disciplina);
    void setLivro(Livro livro);
}
