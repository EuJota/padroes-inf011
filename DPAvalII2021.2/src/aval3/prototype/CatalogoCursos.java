package aval3.prototype;

import java.util.HashMap;
import java.util.Map;

import aval3.Curso;

public class CatalogoCursos {
	
	private static aval3.prototype.CatalogoCursos catalogo;
	
	private Map<String, Curso> cursos;
	
	public static aval3.prototype.CatalogoCursos getCatalogo() {
		if(aval3.prototype.CatalogoCursos.catalogo == null)
			aval3.prototype.CatalogoCursos.catalogo = new aval3.prototype.CatalogoCursos();
		return aval3.prototype.CatalogoCursos.catalogo;
	}
	
	private CatalogoCursos() {
		this.cursos = new HashMap<String, Curso>();
	}
	
	public void registrar(Curso curso) {
		this.cursos.put(curso.getCodigo(), curso);
	}
	
	public Curso recuperar(String codigo) {
		Curso curso = this.cursos.get(codigo);
		return (Curso) ((curso != null) ? curso.prototipar() : null);
	}
	
	

}
