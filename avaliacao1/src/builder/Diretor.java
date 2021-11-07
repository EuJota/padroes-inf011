package builder;

import model.Disciplina;
import model.Livro;

import java.util.List;

public class Diretor {

    public void constructorSimplesCurso(String nome, String codigo, BuilderClass builderClass) {
        builderClass.reset();
        builderClass.setNomeCurso(nome);
        builderClass.setCodigoCurso(codigo);
        //livros.forEach(builderClass::setLivro);
        //disciplinas.forEach(builderClass::setDisciplina);
    }

    public void constructorSimplesCurso(String nome, String codigo, BuilderClass builderClass, List<Livro> livros, List<Disciplina> disciplinas) {
        builderClass.reset();
        builderClass.setNomeCurso(nome);
        builderClass.setCodigoCurso(codigo);
        livros.forEach(builderClass::setLivro);
        disciplinas.forEach(builderClass::setDisciplina);
    }

    public void constructorSimplesEmenta(BuilderClass builderClass, List<Livro> livros, List<Disciplina> disciplinas) {
        builderClass.reset();
        builderClass.setNomeCurso("");
        builderClass.setCodigoCurso("");
        livros.forEach(builderClass::setLivro);
        disciplinas.forEach(builderClass::setDisciplina);
    }

}
