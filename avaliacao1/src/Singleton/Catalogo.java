package Singleton;

import model.Curso;

import java.util.HashMap;

public class Catalogo {
    private static Catalogo instance;
    private HashMap<String, Curso> catalogoCursos;

    public static Catalogo getInstance() {
        if (instance == null) {
            instance = new Catalogo();
        }
        return instance;
    }

    public void salvarCurso(String nomeCurso, Curso curso) {
        if(this.catalogoCursos == null)
            catalogoCursos = new HashMap<>();

        if(!catalogoCursos.containsKey(nomeCurso))
            catalogoCursos.put(nomeCurso, curso);
    }

    public Curso resgatarCursoBase(String nomeCurso) {
        return catalogoCursos.get(nomeCurso);
    }

    public void printCatalogo() {
        if(this.catalogoCursos != null) {
            catalogoCursos.forEach((nome, curso) -> System.out.println("Curso "+nome + ": " + curso.toString()));
        }
    }
}
