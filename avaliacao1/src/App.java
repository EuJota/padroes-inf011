import builder.CursoConcreteBuilder;
import builder.Diretor;
import factory.Factory;
import Singleton.Catalogo;
import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class App {
    Catalogo catalogo;

    public void run() {
//        catalogo = Catalogo.getInstance();
//
//        // testando singleton e criacao de produtos a partir da factory (criando apenas cursos para teste)
//        catalogo.printCatalogo();
//
//        //testando criar clone a partir do prototype
//        criarClonesCursos("curso teste");

        q2AV2();
    }

    public void q1AV2() {
        Stack<Curso.Checkpoint> pilha = new Stack<>();

        Disciplina d1 = (Disciplina) criarProduto("Padroes", "1234", TipoProduto.DISCIPLINA);
        Disciplina d2 = (Disciplina) criarProduto("Banco", "12345", TipoProduto.DISCIPLINA);

        ArrayList<Disciplina> discs = new ArrayList<Disciplina>();
        ArrayList<Livro> livros = new ArrayList<Livro>();

        discs.add(d1);
        discs.add(d2);

        Curso curso = criaCurso("ADS", "001", livros , discs);

        pilha.push(curso.getCheckpoint());
        curso.avançarDisciplina("Padroes", 10.0);
        pilha.push(curso.getCheckpoint());
        curso.avançarDisciplina("Padroes", 25.0);
        curso.restore(pilha.pop());

        System.out.println(curso.toString());
    }

    public void q2AV2() {
        Stack<Curso.Checkpoint> pilha = new Stack<>();

        Disciplina d1 = (Disciplina) criarProduto("Padroes", "1234", TipoProduto.DISCIPLINA);
        Disciplina d2 = (Disciplina) criarProduto("Banco", "12345", TipoProduto.DISCIPLINA);

        ArrayList<Disciplina> discs = new ArrayList<Disciplina>();
        ArrayList<Livro> livros = new ArrayList<Livro>();
        ArrayList<TipoNotificacao> tipos = new ArrayList<TipoNotificacao>();

        discs.add(d1);
        discs.add(d2);

        tipos.add(TipoNotificacao.EMAIL);

        Curso curso = criaCurso("ADS", "001", livros , discs);
        curso.ativarObserver(tipos);

        pilha.push(curso.getCheckpoint());
        curso.avançarDisciplina("Padroes", 10.0);

        curso.addTipoNotificacao(TipoNotificacao.WHATSAPP);

        pilha.push(curso.getCheckpoint());
        curso.avançarDisciplina("Padroes", 25.0);
        curso.restore(pilha.pop());

        curso.desativarObserver();
        System.out.println(curso.toString());

        curso.avançarDisciplina("Padroes", 45.0);
        pilha.push(curso.getCheckpoint());
        System.out.println(curso.toString());
    }


    /**
     * Responsável por criar um Livro ou Disciplina
     * @param nomeProduto
     * @param codigo
     * @param tipoProduto
     * @return Produto -> Livro ou Disciplina
     */
    static Produto criarProduto(String nomeProduto, String codigo, TipoProduto tipoProduto) {
        Factory factory = new Factory();
        return factory.criarProduto(nomeProduto, codigo, tipoProduto);
    }

    Curso criaCurso(String nome, String codigo, List<Livro> livros, List<Disciplina> disciplinas) {
        Diretor diretor = new Diretor();
        CursoConcreteBuilder builder = new CursoConcreteBuilder();
        diretor.constructorSimplesCurso(nome, codigo, builder, livros, disciplinas);

        return builder.getResultado();
    }

    /**
     * Cria um produto livre, do tipo curso e adiciona o curso no catalogo
     * Também permite a visualização da ementa de um curso
     * @param nome
     * @param codigo
     * @param livros
     * @param disciplinas
     */
    static void criarCursoBase(String nome, String codigo, List<Livro> livros, List<Disciplina> disciplinas) {
        Catalogo catalogo = Catalogo.getInstance();
        Diretor diretor = new Diretor();
        CursoConcreteBuilder builder = new CursoConcreteBuilder();
        diretor.constructorSimplesCurso(nome, codigo, builder, livros, disciplinas);

        Curso curso = builder.getResultado();
        catalogo.salvarCurso(nome, curso);
    }

    /**
     * Encontra no catalogo um curso e cria clones a partir dele, com seu estado de carga horária zerado
     * @param nomeCurso
     */
    static void criarClonesCursos(String nomeCurso) {
        Catalogo catalogo = Catalogo.getInstance();
        Curso curso = (Curso) catalogo.resgatarCursoBase(nomeCurso).clonar();

        System.out.println(curso.toString());
    }


    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
