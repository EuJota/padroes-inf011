package aval3;

import aval3.adapter.Webinar;
import aval3.adapter.WebinarIFAdapter;
import aval3.builder.CursoBuilder;
import aval3.decorator.CapaDura;
import aval3.decorator.Colorida;
import aval3.decorator.Digital;
import aval3.decorator.Pedido;
import aval3.fm.ProdutoFactory;
import aval3.fm.TipoProduto;
import aval3.state.OperacaoInvalida;

import java.lang.reflect.InvocationTargetException;

public class AplicacaoIII {

    private Curso makeCurso() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Disciplina disc01 = (Disciplina)
                ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
                        "DISC_COMP01",
                        "Chain of Responsibility");

        disc01.setCHTotal(15);
        disc01.setPreco(50.0);

        Disciplina disc02 = (Disciplina)
                ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
                        "DISC_COMP02",
                        "Command");
        disc02.setCHTotal(30);
        disc02.setPreco(25.0);

        Disciplina disc03 = (Disciplina)
                ProdutoFactory.novoProduto(TipoProduto.DISCIPLINA,
                        "DISC_COMP03",
                        "Command");
        disc03.setCHTotal(50);
        disc03.setPreco(50.0);

        Livro livro1 = (Livro) ProdutoFactory.novoProduto(TipoProduto.LIVRO, "livro1", "livro do teste 1");
        livro1.setPreco(40.0);

        Livro livro2 = (Livro) ProdutoFactory.novoProduto(TipoProduto.LIVRO, "livro2", "livro teste 2");
        livro2.setPreco(12.0);

        Livro livro3 = (Livro) ProdutoFactory.novoProduto(TipoProduto.LIVRO, "livro3", "livro teste 3");
        livro3.setPreco(55.0);

        Curso curso0 = CursoBuilder.factory()
                .reset()
                .setNome("Padrões Estruturais")
                .setCodigo("CURSO_CPES")
                .addDisciplina(disc03)
                .addLivro(livro3)
                .build();

        Curso curso = CursoBuilder.factory()
                .reset()
                .setNome("Padrões Comportamentais")
                .setCodigo("CURSO_COMP01")
                .addDisciplina(disc01)
                .addDisciplina(disc02)
                .addLivro(livro1)
                .addLivro(livro2)
                .addCurso(curso0)
                .build();
        return curso;
    }


    private void rodarQ1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
        Curso teste = this.makeCurso();
        System.out.println(teste.getPreco());
    }

    private void rodarQ2() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {

		Pedido livroBase = new Livro("123", "Padroes de Projeto Numa Sentada", "isbn", 100.0);
		Pedido livroDigital = new Digital(livroBase);
		Pedido livroCapaDura = new CapaDura(livroBase);
		Pedido livroColorida = new Colorida(livroBase);

        Pedido livroTodos = new Digital(livroBase);
        livroTodos = new CapaDura(livroTodos);
        livroTodos = new Colorida(livroTodos);

		System.out.println(livroBase.toString()+" Valor: "+livroBase.getPreco());
		System.out.println(livroDigital.toString()+" Valor: "+livroDigital.getPreco());
		System.out.println(livroCapaDura.toString()+" Valor: "+livroCapaDura.getPreco());
		System.out.println(livroColorida.toString()+" Valor: "+livroColorida.getPreco());
		System.out.println(livroTodos.toString()+" Valor: "+livroTodos.getPreco());
    }

    private void rodarQ3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
        Webinar webinar = new Webinar("1", "webnarjava", "hoster",50.0, 140);
        WebinarIFAdapter adapter = new WebinarIFAdapter(webinar);

        Curso curso0 = CursoBuilder.factory()
                .reset()
                .setNome("Padrões Criacionais")
                .setCodigo("WEBINAR JAVA")
                .addDisciplina(adapter)
                .build();

        System.out.println(curso0);
    }


    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, OperacaoInvalida {
        AplicacaoIII app = new AplicacaoIII();
        //app.rodarQ1();
        //app.rodarQ2();
        app.rodarQ3();
    }


}
