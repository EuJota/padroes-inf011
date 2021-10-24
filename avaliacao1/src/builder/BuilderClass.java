package builder;

import model.Disciplina;
import model.Livro;
import model.Produto;

interface BuilderClass {
    void reset();
    void setDisciplina(Disciplina disciplina);
    void setDisciplina(String nomeDisciplina);
    void setLivro(Livro livro);
    void setLivro(String nomeLivro);
}
