package aval3.fm;

public enum TipoProduto {
	
	LIVRO("aval3.fm.LivroFactory"),
	DISCIPLINA("aval3.fm.DisciplinaFactory"),
	CURSO("aval3.fm.CursoFactory");
	
	String className;
	
	private TipoProduto(String className) {
		this.className = className;
	}
	
	public String getFactoryName() {
		return this.className;
	}	
	

}
